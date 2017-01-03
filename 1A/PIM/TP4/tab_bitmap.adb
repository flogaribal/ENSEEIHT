-- GARIBAL Florian 
-- Groupe A 
--
-- Gestion d'un tableau avec bitmap

--------------------------------------------------
-- Pour les pre et post conditions
pragma Assertion_Policy(CHECK);
with Ada.Assertions; 
use Ada.Assertions;
--------------------------------------------------



with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;
use Ada.Float_Text_IO;



procedure tab_bitmap is

    -- Déclaration des constantes
        NMAX : constant Integer := 10;

    -- Déclaration des types
        Type TAB_BOOLEAN is array (1..NMAX) of boolean;
        Type TAB_VAL_FLOAT is array (1..NMAX) of float;

    -- Déclaration des fonctions & procédures

        -----------------------------------------------------------------------
        -- procédure : ajout_val 
        -- Permet d'ajouter une valeur au tableau de valeurs
        --      L'ajout sera d'abord tenté entre imin et imax et en cas d'échec
        --      l'ajout se fera en dessous de imin ou au dessus de imax
        -- 
        -- Paramètre tab_float : Mode Données et résultat
        --                       Type TAB_VAL_FLOAT
        --                       Le tableau de valeur
        --            tab_bool : Mode Données et résultat
        --                       Type TAB_BOOLEAN
        --                       Le tableau de booléen qui nous indique si la
        --                       valeur correspondante dans le tableau de float
        --                       est significative ou non. True -> valeur
        --                       significative; False -> valeur non
        --                       significative
        --                imin : Mode Données et résultat
        --                       Type Integer 
        --                       L'indice de la première valeur significative du
        --                       tableau
        --                imax : Mode Données et résultat
        --                       Type Integer
        --                       L'indice de la dernière valeur significative du
        --                       tableau
        --                   e : Mode données
        --                       Type Float 
        --                       L'élément à ajouter au tableau
        --         nb_elements : Mode Données et Résultat
        --                       Type Integer
        --                       Stocke le nombre de valeurs significatives dans
        --                       le tableau
        -- 
        -- Préconditions : 0 <= imin <= imax
        --                 imin <= imax <= NMAX
        --                 nb_elements < NMAX
        --                 
        --
        -- Postconditions : L'élément e a été ajouté au tableau tab_float, le tableau
        --                  tab_bool a été modifié pour signaler la présence
        --                  d'une nouvelle valeur significative
        --                  Si l'ajout s'est fait entre imin et imax -> aucune
        --                  modification de ces valeurs
        --                  Sinon si il a été fait avant imin, imin est mis
        --                  à jour et si il a été fait après imax, imax est mis
        --                  à jour.
        ---------------------------------------------------------------------------
        procedure ajout_val(tab_float: IN OUT TAB_VAL_FLOAT; tab_bool: IN OUT TAB_BOOLEAN;
            imin: IN OUT Integer; imax: IN OUT Integer; e: Float; nb_elements: IN OUT Integer)
                WITH 
                        PRE => imin >= 0 and imin <= imax and imax <= NMAX and
                               nb_elements < NMAX,

                        POST => (FOR SOME I IN imin..imax => (tab_float(I) = e) and
                                                             (tab_bool(I)))
                                and (tab_bool(imin))
                                and (tab_bool(imax));

        procedure ajout_val(tab_float: IN OUT TAB_VAL_FLOAT; tab_bool: IN OUT TAB_BOOLEAN;
            imin: IN OUT Integer; imax: IN OUT Integer; e: Float; nb_elements: IN OUT Integer) is
               
            -- Déclaration des variables
            i : Integer;
            ajoute : boolean;

        begin
            -- Initialisation des variables    
            ajoute := false;

                -- Tentative d'insertion entre les bornes imin et imax
                i := imin;
                
                -- Parcours du tableau entre imin et imax 
                while i<=imax and tab_bool(i) loop
                    i := i+1;
                end loop;
                -- Fin du parcours du tableau ou valeur non significative
                -- trouvée

                -- Si la valeur courante n'est pas significative
                if not tab_bool(i) and i<= imax then
                   tab_float(i) := e;
                   tab_bool(i) := true;
                   nb_elements := nb_elements+1;
                   ajoute := true;
                end if;
                
                -- Si la valeur n'a  pas déjà été ajoutée
                if not ajoute then
                    -- Insertion avant imin ou après imax
                    -- Insertion avant imin
                    if imin > 1 and not tab_bool(imin-1) then 
                        tab_float(imin-1) := e;
                        tab_bool(imin-1) := true;
                        nb_elements := nb_elements+1;
                        imin := imin-1;
                    else 
                        -- Insertion après imax
                        if imax < NMAX and not tab_bool(imax +1) then
                            tab_float(imax+1) := e;
                            tab_bool(imax+1) := true;
                            nb_elements := nb_elements+1;
                            imax := imax+1;
                        end if;
                    end if;
                else -- Si elle a déjà été ajoutée
                    null;
                end if;           
        end ajout_val;

               
        -----------------------------------------------------------------------
        -- procédure : suppr_val 
        -- Permet de supprimer une valeur au tableau de valeurs
        --        La suppression se fera simplement en mettant faux à l'indice
        --        de la valeur à supprimer dans le tableau tab_bool
        --
        -- Paramètres tab_bool : Mode Données et résultat
        --                       Type TAB_BOOLEAN
        --                       Le tableau de booléen qui nous indique si la
        --                       valeur correspondante dans le tableau de float
        --                       est significative ou non. True -> valeur
        --                       siggnificative; False -> valeur non
        --                       significative
        --                   i : Mode données
        --                       Type Integer 
        --                       L'indice de l'élément à supprimer du tableau
        --                imin : Mode Données et résultat
        --                       Type Integer 
        --                       L'indice de la première valeur significative du
        --                       tableau
        --                imax : Mode Données et résultat
        --                       Type Integer
        --                       L'indice de la dernière valeur significative du
        --                       tableau
        --         nb_elements : Mode Données et Résultat
        --                       Type Integer
        --                       Stocke le nombre de valeurs significatives dans
        --                       le tableau
        --
        -- Préconditions : 
        --                 tab_bool(i) = true
        --                 0 < i <= NMAX
        --                 0 <= imin <= imax
        --                 imin <= imax <= NMAX
        --
        -- Postconditions : tab_bool(i) = false && tab_bool(imin) = true &&
        --                  tab_bool(imax) = true
        --                  L'élément a été "supprimé" du tableau c'est à dire
        --                  que la valeur est toujours présente dans le tableau
        --                  tab_float mais elle n'est plus considérée comme une
        --                  valeur significative.
        --                  Si l'élément supprimé était à l'indice imin ou imax
        --                  alors imin ou imax est mis à jour
        ---------------------------------------------------------------------------
        procedure suppr_val(tab_bool: IN OUT TAB_BOOLEAN; i: Integer; 
            imin: IN OUT Integer; imax: IN OUT Integer; nb_elements: IN OUT Integer) 
                WITH 
                        PRE => imin >= 0 and imin <= imax and imax <= NMAX and i>0 and i<= NMAX,
                               
                        POST => (tab_bool(i) = false) and 
                                (tab_bool(imin) = true) and 
                                (tab_bool(imax) = true);
                                
        
        procedure suppr_val(tab_bool: IN OUT TAB_BOOLEAN; i: Integer; 
            imin: IN OUT Integer; imax: IN OUT Integer; nb_elements: IN OUT Integer) is 
             
            -- Déclaration des variables
            j : Integer;

        begin

            -- Initialisation des variables
             tab_bool(i) := false;
             nb_elements := nb_elements -1;
             
             -- Si il reste des éléments dans le tableau
             if nb_elements > 0 then
                -- Si i = imin, on doit actualiser imin
                if i = imin then
                         -- Parcours du tableau de booleen entre imin et imax pour
                         -- trouver la prochaine valeur significative et affecter son
                         -- indice à imin
                         j := imin;
                         while j <= imax and not tab_bool(j) loop
                             j := j+1;
                         end loop;
                         -- Fin du parcours du tableau ou une valeur
                         -- significative a été trouvée
                         imin := j;
                else
                        -- Si i = imax on doit actualiser imax
                        if i = imax then
                            -- Parcours du tableau de imax à imin pour trouver la
                            -- précédente valeur significative et affecter son indice à
                            -- imax
                            j := imax;
                            while j>= imin and not tab_bool(j) loop
                                j := j-1;
                            end loop;
                            -- Fin du parcours du tableau ou une valeur
                            -- significative a été trouvée
                        else
                            null;
                        end if;
                end if;
             
             -- Si il n'y a plus aucun élément dans le tableau
             else 
                 imin := 0;
                 imax := 0;
             end if;
        end suppr_val;

        ---------------------------------------------------------------------------
        -- fonction : rech_prem_occ 
        -- Recherche la première occurence d'une valeur passée en paramètre dans
        -- le tableau tab_float. Si la valeur est trouvée, la fonction renvoie
        -- son indice sinon elle renvoi 0
        --
        -- Paramètre tab_float : Mode Données
        --                       Type TAB_VAL_FLOAT
        --                       Le tableau de valeur
        --            tab_bool : Mode Données 
        --                       Type TAB_BOOLEAN
        --                       Le tableau de booléen qui nous indique si la
        --                       valeur correspondante dans le tableau de float
        --                       est significative ou non. True -> valeur
        --                       significative; False -> valeur non
        --                       significative
        --                   e : Mode Données
        --                       Type Float
        --                       L'élément à rechercher dans le tableau de float
        --                imin : Mode Données et résultat
        --                       Type Integer 
        --                       L'indice de la première valeur significative du
        --                       tableau
        --                imax : Mode Données et résultat
        --                       Type Integer
        --                       L'indice de la dernière valeur significative du
        --                       tableau
        -- Préconditions : 0 <= imin <= imax
        --                 imin <= imax <= NMAX
        --
        -- Résultats : i tq tab_float(i) = e 
        --             L'indice de la valeur trouvée si elle a été trouvée, 0 si
        --             la valeur n'a pas été trouvée
        ---------------------------------------------------------------------------
        function rech_prem_occ(tab_float: TAB_VAL_FLOAT; tab_bool : TAB_BOOLEAN; e :
            Float; imin: Integer; imax: Integer) return Integer 
                WITH 
                        PRE => (imin >= 0) and 
                               (imin <= imax) and 
                               (imax <= NMAX),

                        POST => (tab_bool(rech_prem_occ'RESULT) and
                                tab_float(rech_prem_occ'RESULT) = e) 
                                or
                                (rech_prem_occ'RESULT = 0);

        function rech_prem_occ(tab_float: TAB_VAL_FLOAT; tab_bool : TAB_BOOLEAN; e :
            Float; imin: Integer; imax: Integer) return Integer is  
 
            -- Déclaration des variables
            i : Integer;

        begin

            -- Initialisation des variables
            i := imin;
                
            -- Parcours du tableau tant que le tableau n'a pas été totalement
            -- parcouru et tant que l'élément courant n'est pas égal à l'élément
            -- recherché
            while i<=imax and then tab_float(i) /= e loop
                i := i+1;
            end loop;
            -- Soit le tableau a fini d'être parcouru soit on a trouvé l'élément
            -- recherché
            
            -- Si le tableau a été totalement parcouru
            if i>imax then
                return 0;
            -- Si on a trouvé l'élément recherché
            else
                return i;
            end if;
        end rech_prem_occ;


        ---------------------------------------------------------------------------
        -- procedure : affich_tab 
        -- Affiche IMin, IMax et le contenu des deux tableaux entre l'indice 
        -- minimum imin et l'indice maximum imax.
        -- Ensuite on affiche le nombre et les valeurs "utiles"/significatives 
        -- du tableau 
        -- Ex : 
        --
        -- Indice min = 2
        -- Indice max = 6
        -- =====================================
        -- tableau de tableau de
        -- indices    booléens        valeurs
        -- =====================================
        -- 1       false          4.1
        -- 2       true           3.1
        -- 3       false          0.0
        -- 4       false          8.0
        -- 5       true           4.0
        -- 6       true           6.0
        -- 7       false          8.0
        -- =====================================
        --
        -- Nb effectif d'éléments = 3
        -- Valeurs
        -- =======
        -- 3.1
        -- 4.0
        -- 6.0
        -- =======
        --
        -- Paramètre tab_float : Mode Données 
        --                       Type TAB_VAL_FLOAT
        --                       Le tableau de valeur 
        --            tab_bool : Mode Données
        --                       Type TAB_BOOLEAN
        --                       Le tableau de booléen qui nous indique si la
        --                       valeur correspondante dans le tableau de float
        --                       est significative ou non. True -> valeur
        --                       siggnificative; False -> valeur non
        --                       significative
        --                imin : Mode Données        
        --                       Type Integer 
        --                       L'indice de la première valeur significative du
        --                       tableau
        --                imax : Mode Données
        --                       Type Integer
        --                       L'indice de la dernière valeur significative du
        --                       tableau
        --         nb_elements : Mode Données
        --                       Type Integer
        --                       Stocke le nombre de valeurs significatives dans
        --                       le tableau
        -- 
        -- Précondition : nb_elements > 0 
        --
        -- Résultat : Affichage de imin et imax, des deux tableaux et du nombre
        --            et des valeurs significatives
        ---------------------------------------------------------------------------
        procedure affich_tab(tab_float: TAB_VAL_FLOAT; tab_bool: TAB_BOOLEAN; imin:
            Integer; imax: Integer; nb_elements: Integer) 
                WITH 
                        PRE => nb_elements > 0;
        
        procedure affich_tab(tab_float: TAB_VAL_FLOAT; tab_bool: TAB_BOOLEAN; imin:
            Integer; imax: Integer; nb_elements: Integer) is 
            
        begin
            Put("Indice minimum : ");
            Put(imin,2);
            New_Line(1);
            Put("Indice maximum : ");
            Put(imax,2);
            New_Line(1);
            Put_Line("=====================================");
            Put_Line("tableau d' tableau de");
            Put_Line("indices    booléens        valeurs");
            Put_Line("=====================================");
            
            -- Parcours des deux tableaux pour afficher les indices, les
            -- booléens et les valeurs
            For I in Integer range imin..imax loop
                -- Affichage de type : 1       false          4.1
                New_Line(1);
                Put(i,3);
                Put("       ");
                if tab_bool(i) then
                    Put("true");
                else 
                    Put("false");
                end if;
                Put("       ");
                Put(tab_float(i),3);
            end loop;
            -- Fin du parcours du tableau
            --
            New_Line(1);
            Put_Line("=====================================");
            
            New_Line(1);
            Put("Nb effectif d'éléménts = ");
            Put(nb_elements,2);

            New_Line(2);
            Put("=======");
            -- Parcours du tableau pour afficher que les valeurs significatives
            For I in imin..imax loop
                if tab_bool(i) then
                    New_Line(1);
                    Put(tab_float(i),3);
                else 
                    null;
                end if;
            end loop;
            -- Fin du parcours du tableau
            --
            New_Line(1);
            Put("======");

            New_Line(3);
        end affich_tab;


        ---------------------------------------------------------------------------
        -- procedure : condens_tab 
        -- Compacte le tableau ("bouche les trous") c'est à dire que la fonction
        -- va faire en sorte qu'il n'y est aucun trou entre imin et imax. Pour
        -- cela elle va décaler à la fois les valeurs du tableau tab_float mais
        -- aussi les booléens associés dans le tableau tab_bool. De ce fait la
        -- fonction va modifier les deux tableaux mais aussi imin et imax.
        --
        -- Paramètre tab_float : Mode Données et Résultat
        --                       Type TAB_VAL_FLOAT
        --                       Le tableau de valeur 
        --            tab_bool : Mode Données et Résultat
        --                       Type TAB_BOOLEAN
        --                       Le tableau de booléen qui nous indique si la
        --                       valeur correspondante dans le tableau de float
        --                       est significative ou non. True -> valeur
        --                       siggnificative; False -> valeur non
        --                       significative
        --                imin : Mode Données et Résultat        
        --                       Type Integer 
        --                       L'indice de la première valeur significative du
        --                       tableau
        --                imax : Mode Données et Résultat
        --                       Type Integer
        --                       L'indice de la dernière valeur significative du
        --                       tableau
        --         nb_elements : Mode Données
        --                       Type Integer
        --                       Stocke le nombre de valeurs significatives dans
        --                       le tableau
        -- 
        -- Préconditions : nb_elements > 0 
        --
        -- Postconditions : nb_elements'OLD = nb_elements
        --                  Les tableaux tab_float et tab_bool ont été condensé ce
        --                  qui implique qu'il n'y a plus aucune valeur non significative
        --                  entre imin et imax. De plus imin et imax ont été mis à
        --                  jour.
        --------------------------------------------------------------------------
        procedure condens_tab(tab_float: IN OUT TAB_VAL_FLOAT; tab_bool: IN OUT TAB_BOOLEAN; imin:
            IN OUT Integer; imax: IN OUT Integer; nb_elements: Integer)
                WITH 
                        PRE => (nb_elements > 0), 

                        POST => (FOR ALL I IN imin..imax => tab_bool(I));
        
        procedure condens_tab(tab_float: IN OUT TAB_VAL_FLOAT; tab_bool: IN OUT TAB_BOOLEAN; imin:
            IN OUT Integer; imax: IN OUT Integer; nb_elements: Integer) is
            
            indEcr : Integer;

        begin
           
            -- Initialisation des variables
            indEcr := imin;

            -- Parcours du tableau entre imin et imax pour supprimer les valeurs
            -- non significatives entre ces bornes
            for I in Integer range imin..imax loop
               -- Si la valeur courante est significative on copie la valeur à
               -- l'indice d'écriture et on incrémente cet indice
               if tab_bool(I) then
                   tab_bool(indEcr) := tab_bool(I);
                   tab_float(indEcr) := tab_float(I);
                   indEcr := indEcr+1 ;
               -- Sinon on décrémente imax de 1 et on incrémente pas l'indice
               -- d'écriture
               else 
                   imax := imax -1;
               end if;
            end loop;
            -- Parcours du tableau fini
        end condens_tab;



    -- Déclaration des variables locales

        un_tab_bool : TAB_BOOLEAN;
        un_tab_float : TAB_VAL_FLOAT;
        nb_elements : Integer;
        imin : Integer;
        imax : Integer;
        indice_prem_occ : Integer;


begin
        
    -- Initialisation des variables 
        nb_elements := 0;
        imin := 0;
        imax := 0;
        indice_prem_occ := 0;


        un_tab_bool := (false, true, false, false, false, true, false, true, true,false);
        un_tab_float := (4.1,5.8,25.2,9.15,7.0,3.33,4.96,8.8,1.01,5.1);
        imin := 2;
        imax := 9;
        nb_elements := 4;

        -- Affichage tableau de base
        Put_Line("BASE : ");
        affich_tab(un_tab_float, un_tab_bool,imin, imax,nb_elements);
        New_Line(4);


    -- Ajout d'une valeur dans le tableau un_tab_float
        ajout_val(un_tab_float, un_tab_bool, imin, imax,5.0, nb_elements);

        -- Vérification de l'ajout par un affichage
        Put_Line("Tableau après ajout de 5.0");
        affich_tab(un_tab_float, un_tab_bool,imin, imax,nb_elements);


    -- Ajout de plusieurs valeurs dans le tableau
        ajout_val(un_tab_float, un_tab_bool, imin, imax, 2.75, nb_elements);
        ajout_val(un_tab_float, un_tab_bool, imin, imax, 4.7, nb_elements);
        ajout_val(un_tab_float, un_tab_bool, imin, imax, 9.2, nb_elements);
        ajout_val(un_tab_float, un_tab_bool, imin, imax, 3.0, nb_elements);
            
        -- Vérification des ajouts par un affichage
        Put_Line("Tableau après ajout de 4 valeurs (2.75,4.7,9.2,3.0)");
        affich_tab(un_tab_float, un_tab_bool,imin, imax,nb_elements);

    -- Recherche de la première occurrence d'un élément dans le tableau
        indice_prem_occ := rech_prem_occ(un_tab_float, un_tab_bool, 4.7, imin, imax);
        if indice_prem_occ = 0 then
            Put_Line("La valeur n'a pas été trouvée dans le tableau");
        else 
            Put("La valeur a été trouvée à l'indice ");
            Put(indice_prem_occ,2);
            Put_Line(" dans le tableau");
        end if;


    -- Suppression d'une valeur à un indice donnée
        suppr_val(un_tab_bool, 6, imin, imax, nb_elements);

        -- Vérification de la suppression par un affichage
        Put_Line("Tableau après suppression de l'élément à l'indice 6");
        affich_tab(un_tab_float, un_tab_bool,imin, imax,nb_elements);

    -- Compactage du tableau
        condens_tab(un_tab_float,un_tab_bool, imin, imax,nb_elements);

        -- Vérification du compactage par un affichage
        Put_Line("Tableau après condensation");
        affich_tab(un_tab_float, un_tab_bool,imin, imax,nb_elements);


end tab_bitmap;
