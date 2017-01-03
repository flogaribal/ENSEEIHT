-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP12  pile
--

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

package body pile_ent is



    ----------------------------------------------------------    
    -- creer_pile_vide
    -- Retourne une pile composé d'aucun élément
    -- Précondition : -------------
    -- Postcondition : estVide(l) = True
    -- Exception : -------
    ----------------------------------------------------------
    function creer_pile_vide return ptr_pile is
    begin
       return null; 
    end creer_pile_vide;
  
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
    function est_Vide(pile : ptr_pile) return boolean is
    begin
        return pile = null;
    end est_Vide;


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
    -- Postcondition : e est sur le haut de la liste
    -- Exception : -------
    ----------------------------------------------------------
    procedure empiler(pile: OUT ptr_pile; e: Integer) is
        new_elt: ptr_pile;
    begin
        new_elt := new pile_ent;
        new_elt.all.val := e;
        new_elt.all.next := pile;

        pile := new_elt;

    end empiler;

    ----------------------------------------------------------
    -- depiler
    -- depiler l'élément
    -- Paramètre l : la pile à depiler
    --               Mode Résultat
    --               Type ptr_pile
    -- Précondition : -----------
    -- Postcondition : le premier élément a été enlever
    -- Exception : -------
    ----------------------------------------------------------
    function depiler(pile: OUT ptr_pile) return Integer is
        pile_vide: Exception;
        element_trouve: Integer;

    begin
        if not est_Vide(pile) then
            element_trouve := pile.all.val;
            
            pile := pile.all.next; 
             -- free(element_trouve);
        else 
            raise pile_vide;
        end if;
        return element_trouve;
    Exception
        when pile_vide => Put_Line("Vous ne pouvez plus dépiler car la pile est vide");
        when others => Put_Line("Erreur inconnue");
    end depiler;

    ----------------------------------------------------------
    -- afficher_pile
    -- Affiche les éléments de la pile l de manière RECURSIVE
    -- Paramètre l : la pile à afficher
    --               Mode Données
    --               Type ptr_pile
    -- Précondition : pile non vide 
    -- Postcondition : ---------
    -- Exception : -------
    ----------------------------------------------------------
    procedure afficher_pile(pile: ptr_pile) is
    begin
       if pile /= null then
           Put(pile.all.val,1);
           if pile.all.next /= null then
                Put(", ");
                afficher_pile(pile.all.next);
           else
                null;
           end if;
        end if;
    end afficher_pile;




end pile_ent;

