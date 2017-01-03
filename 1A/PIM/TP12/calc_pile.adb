-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP12  pile
--

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

with pile_ent;
use pile_ent;

procedure calc_pile is 


        commande: STRING(1..10);
        longueur: INTEGER;
        n: INTEGER;
        pile: ptr_pile;
        mauvais_operateur: Exception;
        op1: Integer;
        op2: Integer;

begin
        pile := creer_pile_vide;

        
        loop    
                n := 0;
                New_Line(1);
                Put_Line("Veuillez saisir un chiffre ou un opérateur (10 caractères max) : ");
                Put_Line("Pour effectuer une opération saisissez les deux membres un à un puis l'opérateur ;");
                Put_Line("Pour quitter le programme, saisissez le caractère \'q\'");   
                Get_Line(commande,longueur);
                                    
                -- cas nombre   
                n := INTEGER'VALUE(commande(1..longueur));
                empiler(pile,n);
                Put("Nombre saisi : ");
                Put(n);
                New_Line(1);

                exit when commande(1) = 'q';
        end loop;


Exception
    when mauvais_operateur => Put_Line("Votre opérateur ne doit être que sur un caractère et doit être parmi les suivants : +,-,*,/");

    when CONSTRAINT_ERROR => if longueur > 1 then
                                raise mauvais_operateur;
                             else
                                 op1 := depiler(pile);
                                 op2 := depiler(pile);
                                
                                 Put_Line("Résultat du calcul de "& INTEGER'IMAGE(op1) & commande(1) & INTEGER'IMAGE(op2) & " : ");
                                
                                 if commande(1) = '+' then
                                     empiler(pile,op1+op2);
                                     Put(op1+op2);
                                 elsif commande(1) = '-' then
                                     empiler(pile,op1-op2);
                                     Put(op1-op2);
                                 elsif commande(1) = '*' then 
                                     empiler(pile,op1*op2);
                                     Put(op1*op2);
                                 elsif commande(1) = '/' then
                                     empiler(pile,op1/op2);
                                     Put(op1/op2);
                                 else
                                     raise mauvais_operateur;
                                 end if;
                             end if;
end calc_pile;
