-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP12 liste entier
--

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;


with p_list_ent;
use p_list_ent;

procedure test_p_list is


   

    ptr: ptr_list;
begin
 
    ptr := creer_liste_vide;
    if est_Vide(ptr) then
        Put_Line("Liste vide");
    else 
        Put_Line("Liste non vide");
    end if;
    New_Line(1);
    
    Put("Insertion en tête 2,3,4,5,6,7");
    inserer_en_tete(ptr,2);
    inserer_en_tete(ptr,3);
    inserer_en_tete(ptr,4);
    inserer_en_tete(ptr,5);
    inserer_en_tete(ptr,6);
    inserer_en_tete(ptr,7);
    New_Line(1);


    afficher_liste(ptr);

    
    New_Line(1);

    Put_Line("Insertion 12 après 5 : ");
    
    inserer_apres(ptr, 12,5);
   
    afficher_liste(ptr);
    
    New_Line(1);

    Put_Line("Insertion 10 avant 2 : ");
    inserer_avant(ptr,10,2);

    afficher_liste(ptr);
    
    New_Line(1);

    Put_Line("Suppression de 3 : ");
    enlever(ptr,3);

    afficher_liste(ptr);


end test_p_list;
