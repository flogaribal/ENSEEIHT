with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;
with Ada.Unchecked_Deallocation ; 

package body p_list_ent is
        

        -- Déclaration des fonctions et procédures 

    ----------------------------------------------------------    
    -- creer_liste_vide
    -- Retourne une liste composé d'aucun élément
    -- Précondition : -------------
    -- Postcondition : estVide(l) = True
    -- Exception : -------
    ----------------------------------------------------------
    function creer_liste_vide return ptr_list is
    begin
        return null;
    end creer_liste_vide;


    ----------------------------------------------------------
    -- est_Vide
    -- Teste si la liste passée en paramètre est une liste vide
    -- Paramètre l : la liste à tester
    --               Mode Données
    --               Type ptr_list
    -- Précondition : -----------
    -- Postcondition : ---------
    -- Exception : -------
    ----------------------------------------------------------
    function est_Vide(liste : ptr_list) return boolean is
    begin
        return liste = null;
    end est_Vide;


    ----------------------------------------------------------
    -- insérer_en_tête
    -- Insère l'élément e en tête de la liste l
    -- Paramètre l : la liste à tester
    --               Mode Résultat
    --               Type ptr_list
    --           e : L'élément à insérer en tête de la liste
    --               Mode Données
    --               Type Integer
    -- Précondition : -----------
    -- Postcondition : e appartient à la liste
    -- Exception : -------
    ----------------------------------------------------------
    procedure inserer_en_tete(liste: OUT ptr_list; e: Integer) is
        new_elt: ptr_list;
    begin
        new_elt := new p_list_ent;
        new_elt.all.val := e;
        new_elt.all.next := liste;

        liste := new_elt;

    end inserer_en_tete;


    ----------------------------------------------------------
    -- afficher_liste
    -- Affiche les éléments de la liste l de manière RECURSIVE
    -- Paramètre l : la liste à tester
    --               Mode Données
    --               Type ptr_list
    -- Précondition : -----------
    -- Postcondition : ---------
    -- Exception : -------
    ----------------------------------------------------------
    procedure afficher_liste(liste: ptr_list) is
    begin
        if liste /= null then
                Put(liste.all.val,1);
                if liste.all.next /= null then
                    Put(", ");
                    afficher_liste(liste.all.next);
                else
                    null;
                end if;
        end if;
    end afficher_liste;


    ----------------------------------------------------------
    -- rechercher
    -- Recherche si l'élément e est présent dans la liste l
    -- Retourne l'adresse de e ou null si non présent dans la liste ou liste
    -- vide
    -- Paramètre l : la liste à parcourir
    --               Mode Données
    --               Type ptr_list
    --           e : L'élément à rechercher dans la liste
    --               Mode Données
    --               Type Integer
    -- Précondition : -----------
    -- Postcondition : ---------
    -- Exception : -------
    ----------------------------------------------------------
    function rechercher(liste: ptr_list; e: Integer) return ptr_list is
        tmp: ptr_list;
    begin
        tmp := liste;

        while tmp /= null and then tmp.all.val /= e loop
            tmp := tmp.all.next;
        end loop;
        return tmp;
    end rechercher;
        


    ----------------------------------------------------------
    -- inserer_apres 
    -- Insere dans la liste l l'élément e après l'élément data
    -- Paramètre l : la liste à parcourir
    --               Mode Données/Resultat
    --               Type ptr_list
    --           e : L'élément à inserer dans la liste
    --               Mode Données
    --               Type Integer
    --        data : L'élément après lequel on doit insérer e 
    --               Mode Données
    --               Type Integer
    -- Précondition : -----------
    -- Postcondition : e appartient à la liste
    -- Exception : - data n'est pas dans la liste
    --             - La liste est vide
    ----------------------------------------------------------
    procedure inserer_apres(liste: IN OUT ptr_list; e: Integer; data: Integer) is
        addr_data : ptr_list;
        data_absent : Exception;
        liste_vide: Exception;
        new_elt: ptr_list;

    begin
       if est_Vide(liste) then
           raise liste_Vide;
       else 
           addr_data := rechercher(liste,data);
           
           if addr_data = null then
               raise data_absent;
           else
               new_elt := new p_list_ent;

               -- Attribution valeur
               new_elt.all.val := e;

               -- Attribution du suivant du nouvel élément
               new_elt.all.next := addr_data.all.next;

               -- Attribution du suivant de l'élément data
               addr_data.next := new_elt;
           end if;
       end if;
        
    Exception
        when data_absent => Put_Line("La valeur data n'est pas dans la liste");
        when liste_vide => Put_Line("La liste est vide");

    end inserer_apres;


    ----------------------------------------------------------
    -- inserer_avant 
    -- Insere dans la liste l l'élément e avant l'élément data
    -- Paramètre l : la liste à parcourir
    --               Mode Données/Resultat
    --               Type e_elt
    --           e : L'élément à inserer dans la liste
    --               Mode Données
    --               Type Integer
    --        data : L'élément après lequel on doit insérer e 
    --               Mode Données
    --               Type Integer
    
    -- Précondition : -----------
    -- Postcondition : e appartient à la liste 
    -- Exception : - Data n'est pas dans la liste
    --             - La liste est vide     
    ----------------------------------------------------------
    procedure inserer_avant(liste: IN OUT ptr_list; e: Integer; data: Integer) is
        data_absent : Exception;
        liste_vide: Exception;
        new_elt: ptr_list;
        tmp: ptr_list;

    begin
       if est_Vide(liste) then
           raise liste_Vide;
       else
          new_elt := new p_list_ent;
          -- Attribution valeur
          new_elt.all.val := e;

          -- Cas du premier élément
          if liste.all.val = data then
             inserer_en_tete(liste,e);
          else -- Autre cas
                  
                 tmp := liste;
                -- Parcours liste chaine tant que l'élément suivant n'est pas égal à
                -- data
                 while tmp.all.next /= null and then tmp.all.next.all.val /= data loop
                         tmp := tmp.all.next;
                end loop; 
           
                -- Si la liste a été entiérement parcourue -> data absent
                if tmp.all.next = null then
                         raise data_absent;
                else -- Sinon next élément = data

                        -- Attribution du suivant du nouvel élément
                        new_elt.all.next := tmp.all.next;

                        -- Attribution du suivant de l'élément avant data
                        tmp.all.next := new_elt;
                 end if;
           end if;
       end if;
        
    Exception
        when data_absent => Put_Line("La valeur data n'est pas dans la liste");
        when liste_vide => Put_Line("La liste est vide");

    end inserer_avant;



    ----------------------------------------------------------
    -- enlever
    -- Enleve l'élément e de la liste
    -- Paramètre l : la liste à parcourir
    --               Mode Données/Resultat
    --               Type e_elt
    --           e : L'élément à enlever de la liste
    --               Mode Données
    --               Type Integer
    -- Précondition : -----------
    -- Postcondition : e n'appartient pas à la liste
    -- Exception : -------
    ----------------------------------------------------------
    procedure enlever(liste: IN OUT ptr_list; e: Integer) is
        tmp: ptr_list;
        element_trouve: ptr_list;
    begin
          -- Cas du premier élément
          if liste.all.val = e then
              liste := liste.all.next;   
          else -- Autre cas
                  
            tmp := liste;
            -- Parcours liste chaine tant que l'élément suivant n'est pas égal à
            -- data
            while tmp.all.next /= null and then tmp.all.next.all.val /= e loop
                tmp := tmp.all.next;
            end loop; 
            
            element_trouve := tmp.all.next;
            -- Attribution du suivant de l'élément avant data
            tmp.all.next := tmp.all.next.all.next;

           -- free(element_trouve);
          end if;
            

    end enlever;

end p_list_ent;

