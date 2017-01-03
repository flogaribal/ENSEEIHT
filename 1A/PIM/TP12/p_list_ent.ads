
package  p_list_ent is 

    type p_list_ent is private;
    type ptr_list is access p_list_ent;
        
        -- Déclaration des fonctions et procédures 

    ----------------------------------------------------------    
    -- creer_liste_vide
    -- Retourne une liste composé d'aucun élément
    -- Précondition : -------------
    -- Postcondition : estVide(l) = True
    -- Exception : -------
    ----------------------------------------------------------
    function creer_liste_vide return ptr_list;
  
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
    function est_Vide(liste : ptr_list) return boolean ;

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
    procedure inserer_en_tete(liste: OUT ptr_list; e: Integer) ;


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
    procedure afficher_liste(liste: ptr_list) ;

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
    function rechercher(liste: ptr_list; e: Integer) return ptr_list ;
        


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
    procedure inserer_apres(liste: IN OUT ptr_list; e: Integer; data: Integer) ;


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
    ---------------------------------------------------------
    procedure inserer_avant(liste: IN OUT ptr_list; e: Integer; data: Integer) ;



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
    procedure enlever(liste: IN OUT ptr_list; e: Integer);
       
    
    PRIVATE 

        type p_list_ent is record
           val : Integer;
           next : ptr_list;
        end record;
end p_list_ent;


