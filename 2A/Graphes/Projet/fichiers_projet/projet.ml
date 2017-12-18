

(* Fonction getListeVertex : Renvoi la liste des sommets d'un DAG dans un ordre arbitraire
** Paramètres :
**       - dag : Le DAG dont on doit récupérer les sommets
** Retourne :
**       - Une liste de vertex
** Type : Dag.Dag.t -> Dag.Dag.vertex list
**)
let getListVertex dag = Dag.fold_vertex (fun currVertex oldListe -> currVertex::oldListe) dag [];;





(* Fonction isVertexExecutable : Teste si un vertex est éxécutable c'est à dire que tous ses prédecesseurs sont 
**                               finis d'être exécutés et ne sont pas en cours d'exécution
** Paramètres :
**       - dag              : Le DAG concerné
**       - vertex           : Le vertex dont on doit tester la possibilité d'éxécution
**       - executionList    : La liste d'exécution courante afin de tester si les prédecesseurs n'y sont pas présent
** Retourne :
**       - Unn booleen qui indique si oui ou non il peut être exécuté
** Type : Dag.Dag.t -> Dag.Dag.vertex -> Dag.Dag.vertex list -> bool
**)
let isVertexExecutable dag vertex executionList =
    (* Récupère la liste des prédecesseurs *) 
    let listPred = (Dag.pred dag vertex) in
              match listPred with
              | []    -> true
              | liste -> 
                        (* Vérifie qu'aucun des prédecesseurs n'est présent dans la liste d'éxécution courante *)
                        let isInExecution = List.exists (fun e -> List.mem e executionList) listPred in 
                            (* Vérifie que tous les prédecesseurs sont finis d'éxécutés et ne sont pas en exécution *)
                            (List.fold_right (fun curr old -> (Dag.computedv curr) && old) liste true) && (not isInExecution);;


(* Fonction ordonnanceur_multi : Affiche la trace d'éxécution des tâches selon un nombre de ressources disponible
** Paramètres :
**       - dag              : Le DAG concerné
**       - nbRessourcesMax  : Le nombre de ressources max dispo
** Retourne :
**       - Une liste de liste contenant les tâches exécutées selon les étapes
** Type : Dag.Dag.t -> int -> Dag.Dag.V.t list list 
**)
let ordonnanceur_multi nbRessourcesMax dag = 
    (* Paramètres :
    **       - listVertices     : La liste de sommets non exécutés pour le moment ou pas totalement
    **       - returnedListe    : La liste de liste retournée à la fin
    **       - verticesEnAttente: La liste de sommets non exécutables pour le moment et en attente d'exécution
    **       - nbRessourcesDispo: Le nombre de ressources disponibles actuellement 
    **       - tmpListe         : La liste contenant l'éxécution à l'étape courante
    ** PS : tâches = Sommets
    *)
  let rec ordonnanceur_multi_aux listVertices returnedListe verticesEnAttente nbRessourcesDispo tmpListe = 
    
    if nbRessourcesDispo == 0 then
    
      match listVertices,verticesEnAttente with
      (* Si l'on a finit tous les sommets à exécuter *)  
      |[],[]  -> begin
                  match tmpListe with 
                  |[]   -> (List.rev returnedListe)
                  |t::q -> ordonnanceur_multi_aux      []      (tmpListe::returnedListe) [] 0 [] 
                end
      (* Si il reste des sommets ou des sommets en attente *)
      |t::q,_ -> ordonnanceur_multi_aux listVertices (tmpListe::returnedListe) verticesEnAttente nbRessourcesMax []
      |_,t::q -> ordonnanceur_multi_aux listVertices (tmpListe::returnedListe) verticesEnAttente nbRessourcesMax []
      
    else

      match listVertices with 
      |[]   ->  begin
                  match verticesEnAttente with 
                  | []   ->   begin
                                  match tmpListe with 
                                  |[]   -> (List.rev returnedListe) 
                                  |t::q -> ordonnanceur_multi_aux      []      (tmpListe::returnedListe) [] nbRessourcesDispo [] 
                              end

                  | t::q ->   match tmpListe with 
                              |[]   -> ordonnanceur_multi_aux verticesEnAttente returnedListe [] nbRessourcesMax  []

                              (* Si l'on a plus de tâches non exécutées mais on a des tâches en attente alors on les met 
                               * dans la liste des tâches à exécuter et on réinit le nb de ressources *)
                              |t::q -> ordonnanceur_multi_aux verticesEnAttente (tmpListe::returnedListe) [] nbRessourcesMax  []
                end
      |t::q -> 
            (* Si le sommet peut être exécuté *)
            if (isVertexExecutable dag t tmpListe) then
                begin
                        (* DEBUG *)
                        (*print_list tmpListe;*)

                        (* Exécution de 1 tâche *)
                        Dag.decreasev t 1. ;
                              
                        if (Dag.computedv t) then 
                            (* Si la tâche est fini d'être exécutée, on l'enlève des tâches non exécutée (ou non fini d'exécutée),
                               l'on diminue le nombre de ressources dispo et l'on rajoute son exécution à l'étape courante *)
                            ordonnanceur_multi_aux q      returnedListe verticesEnAttente (nbRessourcesDispo-1) (t::tmpListe)
                        else 
                            (* Si la tâche n'est pas fini d'être exécutée, on la laisse dans les tâches non exécutée (ou non fini d'exécutée),
                               l'on diminue le nombre de ressources dispo et l'on rajoute son exécution à l'étape courante *)
                            ordonnanceur_multi_aux (t::q) returnedListe verticesEnAttente (nbRessourcesDispo-1) (t::tmpListe)
                 end
            else
                (* Si l'on ne peut pas exécuter la tâche on la rajoute aux tâches en attente *)
                ordonnanceur_multi_aux q    returnedListe (t::verticesEnAttente) nbRessourcesDispo tmpListe

    in ordonnanceur_multi_aux (getListVertex dag) [] [] nbRessourcesMax [];;




(* --------------------------------------------------------------------------------------------------------------------------------*)


(* Fonction ordonnanceur_heterogene : Affiche la trace d'éxécution des tâches en tenant compte de leur type pour leur vitesse et selon un nombre de ressources disponible
** Paramètres :
**       - dag              : Le DAG concerné
**       - nbRessourcesType1: Le nombre de ressources de type 1 dispo
**       - nbRessourcesType2: Le nombre de ressources de type 2 dispo
**       - alpha            : Le coefficient de variation de vitesse, si type de ressource
**                            ne concorde pas avec type de tâche alors vitesse = 1/alpha
** Retourne :
**       - Une liste de liste contenant les tâches exécutées selon les étapes
** Type : float -> int -> int-> Dag.Dag.t -> trace
**)
let ordonnanceur_heterogene alpha nbRessourcesType1 nbRessourcesType2 dag  =
    (* Paramètres :
    **       - listVertices     : La liste de sommets non exécutés pour le moment ou pas totalement
    **       - returnedListe    : La liste de liste retournée à la fin
    **       - verticesEnAttente: La liste de sommets non exécutables pour le moment et en attente d'exécution
    **       - nbRessourcesDispo: Le nombre de ressources disponibles actuellement 
    **       - tmpListe         : La liste contenant l'éxécution à l'étape courante
    ** PS : tâches = Sommets
    *)
  let rec ordonnanceur_heterogene_aux listVertices returnedListe verticesEnAttente nbRessourcesDispo tmpListe = 
     
    if nbRessourcesDispo == 0 then
    
      match listVertices,verticesEnAttente with
      (* Si l'on a finit tous les sommets à exécuter *)  
      |[],[]  -> begin
                  match tmpListe with 
                  |[]   -> (List.rev returnedListe)
                  |t::q -> ordonnanceur_heterogene_aux      []      (tmpListe::returnedListe) [] 0 [] 
                end
      (* Si il reste des sommets ou des sommets en attente *)
      |t::q,_ -> ordonnanceur_heterogene_aux listVertices (tmpListe::returnedListe) verticesEnAttente (nbRessourcesType1+nbRessourcesType2) []
      |_,t::q -> ordonnanceur_heterogene_aux listVertices (tmpListe::returnedListe) verticesEnAttente (nbRessourcesType1+nbRessourcesType2) []
      
    else

      match listVertices with 
      |[]   ->  begin
                  match verticesEnAttente with 
                  | []   ->   begin
                                  match tmpListe with 
                                  |[]   -> (List.rev returnedListe) 
                                  |t::q -> ordonnanceur_heterogene_aux      []      (tmpListe::returnedListe) [] nbRessourcesDispo [] 
                              end

                  | t::q ->   match tmpListe with 
                              |[]   -> ordonnanceur_heterogene_aux verticesEnAttente returnedListe [] (nbRessourcesType1+nbRessourcesType2)  []

                              (* Si l'on a plus de tâches non exécutées mais on a des tâches en attente alors on les met 
                               * dans la liste des tâches à exécuter et on réinit le nb de ressources *)
                              |t::q -> ordonnanceur_heterogene_aux verticesEnAttente (tmpListe::returnedListe) [] (nbRessourcesType1+nbRessourcesType2)  []
                end
      |t::q -> 
            (* Si le sommet peut être exécuté *)
            if (isVertexExecutable dag t tmpListe) then
                begin
                        (* DEBUG *)
                        (*print_list tmpListe;*)

                        (* Exécution de 1 tâche selon son type *)
                        if (typeressv t = 1) then
                            if (nbRessourcesDispo > nbRessourcesType2) then 
                                Dag.decreasev t 1. 
                            else
                                Dag.decreasev t (1./.alpha)
                        else 
                            if (nbRessourcesDispo <= nbRessourcesType2) then 
                                Dag.decreasev t 1. 
                            else 
                                Dag.decreasev t (1./.alpha) ;
                              
                        if (Dag.computedv t) then 
                            (* Si la tâche est fini d'être exécutée, on l'enlève des tâches non exécutée (ou non fini d'exécutée),
                               l'on diminue le nombre de ressources dispo et l'on rajoute son exécution à l'étape courante *)
                            ordonnanceur_heterogene_aux q      returnedListe verticesEnAttente (nbRessourcesDispo-1) (t::tmpListe)
                        else 
                            (* Si la tâche n'est pas fini d'être exécutée, on la laisse dans les tâches non exécutée (ou non fini d'exécutée),
                               l'on diminue le nombre de ressources dispo et l'on rajoute son exécution à l'étape courante *)
                            ordonnanceur_heterogene_aux (t::q) returnedListe verticesEnAttente (nbRessourcesDispo-1) (t::tmpListe)
                 end
            else
                (* Si l'on ne peut pas exécuter la tâche on la rajoute aux tâches en attente *)
                ordonnanceur_heterogene_aux q    returnedListe (t::verticesEnAttente) nbRessourcesDispo tmpListe

    in ordonnanceur_heterogene_aux (getListVertex dag) [] [] (nbRessourcesType1+nbRessourcesType2) [];;





(* --------------------------------------------------------------------------------------------------------------------------------*)





(* Fonction ordonnanceur_heterogene_quick : [OPTIMAL ]Affiche la trace d'éxécution des tâches en
**                                          tenant compte de leur type pour leur vitesse et selon un nombre de ressources disponible
** Paramètres :
**       - dag              : Le DAG concerné
**       - nbRessourcesType1: Le nombre de ressources de type 1 dispo
**       - nbRessourcesType2: Le nombre de ressources de type 2 dispo
**       - alpha            : Le coefficient de variation de vitesse, si type de ressource
**                            ne concorde pas avec type de tâche alors vitesse = 1/alpha
** Retourne :
**       - Une liste de liste contenant les tâches exécutées selon les étapes
** Type : float -> int -> int-> Dag.Dag.t -> trace
** NOT WORKING
**)
let ordonnanceur_heterogene_quick alpha nbRessourcesType1 nbRessourcesType2 dag  =
    (* Paramètres :
    **       - listVertices     : La liste de sommets non exécutés pour le moment ou pas totalement
    **       - returnedListe    : La liste de liste retournée à la fin
    **       - verticesEnAttente: La liste de sommets non exécutables pour le moment et en attente d'exécution
    **       - nbRessourcesDispo: Le nombre de ressources disponibles actuellement 
    **       - tmpListe         : La liste contenant l'éxécution à l'étape courante
    ** PS : tâches = Sommets
    *)
  let rec ordonnanceur_heterogene_quick_aux listVertices returnedListe verticesEnAttente nbRessourcesDispo tmpListe tmpTaches1 tmpTaches2 = 
     
    if nbRessourcesDispo == 0 then
    
      match listVertices,verticesEnAttente with
      (* Si l'on a finit tous les sommets à exécuter *)  
      |[],[]  -> begin
                  match tmpListe with 
                  |[]   -> (List.rev returnedListe)
                  |t::q -> ordonnanceur_heterogene_aux      []      (tmpListe::returnedListe) [] 0 [] 
                end
      (* Si il reste des sommets ou des sommets en attente *)
      |t::q,_ -> ordonnanceur_heterogene_aux listVertices (tmpListe::returnedListe) verticesEnAttente (nbRessourcesType1+nbRessourcesType2) []
      |_,t::q -> ordonnanceur_heterogene_aux listVertices (tmpListe::returnedListe) verticesEnAttente (nbRessourcesType1+nbRessourcesType2) []
      
    else

      match listVertices with 
      |[]   ->  begin
                  match verticesEnAttente with 
                  | []   ->   begin
                                  match tmpListe with 
                                  |[]   -> (List.rev returnedListe) 
                                  |t::q -> ordonnanceur_heterogene_aux      []      (tmpListe::returnedListe) [] nbRessourcesDispo [] 
                              end

                  | t::q ->   match tmpListe with 
                              |[]   -> ordonnanceur_heterogene_aux verticesEnAttente returnedListe [] (nbRessourcesType1+nbRessourcesType2)  []

                              (* Si l'on a plus de tâches non exécutées mais on a des tâches en attente alors on les met 
                               * dans la liste des tâches à exécuter et on réinit le nb de ressources *)
                              |t::q -> ordonnanceur_heterogene_aux verticesEnAttente (tmpListe::returnedListe) [] (nbRessourcesType1+nbRessourcesType2)  []
                end
      |t::q -> 
            (* Si le sommet peut être exécuté *)
            if (isVertexExecutable dag t tmpListe) then
                begin
                        (* DEBUG *)
                        (*print_list tmpListe;*)

                        (* Exécution de 1 tâche selon son type *)
                        if (typeressv t = 1) then
                            if (nbRessourcesDispo > nbRessourcesType2) then 
                                Dag.decreasev t 1. 
                            else
                                Dag.decreasev t (1./.alpha)
                        else 
                            if (nbRessourcesDispo <= nbRessourcesType2) then 
                                Dag.decreasev t 1. 
                            else 
                                Dag.decreasev t (1./.alpha) ;
                              
                        if (Dag.computedv t) then 
                            (* Si la tâche est fini d'être exécutée, on l'enlève des tâches non exécutée (ou non fini d'exécutée),
                               l'on diminue le nombre de ressources dispo et l'on rajoute son exécution à l'étape courante *)
                            ordonnanceur_heterogene_aux q      returnedListe verticesEnAttente (nbRessourcesDispo-1) (t::tmpListe)
                        else 
                            (* Si la tâche n'est pas fini d'être exécutée, on la laisse dans les tâches non exécutée (ou non fini d'exécutée),
                               l'on diminue le nombre de ressources dispo et l'on rajoute son exécution à l'étape courante *)
                            ordonnanceur_heterogene_aux (t::q) returnedListe verticesEnAttente (nbRessourcesDispo-1) (t::tmpListe)
                 end
            else
                (* Si l'on ne peut pas exécuter la tâche on la rajoute aux tâches en attente *)
                ordonnanceur_heterogene_aux q    returnedListe (t::verticesEnAttente) nbRessourcesDispo tmpListe

    in ordonnanceur_heterogene_aux (getListVertex dag) [] [] (nbRessourcesType1+nbRessourcesType2) [] [] [];;