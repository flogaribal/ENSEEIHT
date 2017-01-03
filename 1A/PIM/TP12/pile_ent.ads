-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP12 pile 
--


package pile_ent is

type pile_ent is private;
type ptr_pile is access pile_ent;



  ----------------------------------------------------------    
    -- creer_pile_vide
    -- Retourne une pile composé d'aucun élément
    -- Précondition : -------------
    -- Postcondition : estVide(l) = True
    -- Exception : -------
    ----------------------------------------------------------
    function creer_pile_vide return ptr_pile;
  
    ----------------------------------------------------------
    -- est_Vide
    -- Teste si la pile passée en paramètre est une pile vide
    -- Paramètre l : la pile à tester
    --               Mode Données
    --               Type ptr_pile
    -- Précondition : -----------
    -- Postcondition : ---------
    -- Exception : -------
    ----------------------------------------------------------
    function est_Vide(pile : ptr_pile) return boolean ;

    ----------------------------------------------------------
    -- empiler
    -- empiler l'élément
    -- Paramètre l : la pile à tester
    --               Mode Résultat
    --               Type ptr_pile
    --           e : L'élément à empiler
    --               Mode Données
    --               Type Integer
    -- Précondition : -----------
    -- Postcondition : e appartient à la liste
    -- Exception : -------
    ----------------------------------------------------------
    procedure empiler(pile: OUT ptr_pile; e: Integer) ;

    ----------------------------------------------------------
    -- depiler
    -- depiler l'élément
    -- Paramètre l : la pile à depiler
    --               Mode Résultat
    --               Type ptr_pile
    -- Précondition : -----------
    -- Postcondition : e n'appartient plus à la liste
    -- Exception : pile_vide si la pile est déjà vide 
    ----------------------------------------------------------
     function depiler (pile: OUT ptr_pile)return Integer ;


    ----------------------------------------------------------
    -- afficher_pile
    -- Affiche les éléments de la pile l de manière RECURSIVE
    -- Paramètre l : la pile à afficher
    --               Mode Données
    --               Type ptr_pile
    -- Précondition : -----------
    -- Postcondition : ---------
    -- Exception : -------
    ----------------------------------------------------------
    procedure afficher_pile(pile: ptr_pile) ;


private 
        type pile_ent is record
           val : Integer;
           next : ptr_pile;
        end record;

end pile_ent;

