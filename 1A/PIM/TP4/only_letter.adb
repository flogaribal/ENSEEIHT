-- Florian Garibal
-- 1A IMA Groupe A


--Raffinage

--R0 : programme eliminant d’une chaîne tous les caractères qui ne sont pas des lettres (caractère entre ’a’ et ’z’) 

--R1 : - Lecture de la chaîne saisie par l'utilisateur 
--        - Affichage de la chaîne saisie
--        - Suppression des caractères qui ne sont pas des lettres 
--        - Affichage de la chaîne sans les caractères interdits

--Algo : 
--      CMAX : constant entier := 30
--      Type CHAINE(1..CMAX);
--      chaine : CHAINE;
--      len_chaine : entier; 
--Début 
--   (* programme eliminant d’une chaîne tous les caractères qui ne sont pas des lettres (caractère entre ’a’ et ’z’) *)  
--       (*Lecture de la chaîne saisie par l'utilisateur *)
--          len_chaine := 0 
--           ECRIRE("Veuillez saisir une chaîne de caractère : ")
--           LIRE(chaine, len_chaine);
     
--       (* Affichage de la chaîne saisie *)
--            ECRIRE("Chaîne saisie : ");
--            ECRIRE(chaine);

--       (* Suppression des caractères qui ne sont pas des lettres *) 

--       (* Affichage de la chaîne sans les caractères interdits *)
--             ECRIRE("Chaine ne contenant que des lettres : ");
--             ECRIRE(chaine);
--     Fin


--Analyse Informelle :  
--            - Structure de contrôle : POUR
--            - Parcourir de 1 à len_chaine le tableau de caractères
--            - Répeter à chaque tour de boucle : 
--                                         - Test si le caractère courant est une lettre : 
--                                                          - Si oui -> ne rien faire
--                                                          - Sinon -> affecter au caractère courant le caractère suivant et décrémenter de 1 le nombre caractères dans la chaîne
           
--R2 : 
--        - Lecture de la chaîne saisie par l'utilisateur 
--        - Affichage de la chaîne saisie
--        - Suppression des caractères qui ne sont pas des lettres 
--                  - Parcours du tableau de caractère de 1 à len_chaine-1
--                               Test si le caractère courant est une lettre : 
--                                                          - Si oui -> ne rien faire
--                                                          - Sinon -> affecter au caractère courant le caractère suivant et décrémenter de 1 le nombre caractères dans la chaîne
--        - Affichage de la chaîne sans les caractères interdits

--Algo : 
--      CMAX : constant entier := 30
--      Type CHAINE(1..CMAX);
--      chaine : CHAINE;
--      len_chaine : entier; 
--Début 
--   (* programme eliminant d’une chaîne tous les caractères qui ne sont pas des lettres (caractère entre ’a’ et ’z’) *)  
--       (*Lecture de la chaîne saisie par l'utilisateur *)
--           len_chaine := 0 
--           ECRIRE("Veuillez saisir une chaîne de caractère : ")
--           LIRE(chaine, len_chaine);
--     
--       (* Affichage de la chaîne saisie *)
--            ECRIRE("Chaîne saisie : ");
--            ECRIRE(chaine);
--
--       (* Suppression des caractères qui ne sont pas des lettres *) 
--                  (* Parcours du tableau de caractère de 1 à len_chaine-1 *)
--                         POUR i ALLANT DE 1 à len_chaine -1 FAIRE
--                                 (* Test si le caractère courant est une lettre : *) 
--                                        SI chaine(i) > 'a' ET chaine(i) < 'z' ALORS   (*Si oui -> ne rien faire)*
--                                                  rien;
--                                        SINON (*Sinon -> affecter au caractère courant le caractère suivant et décrémenter de 1 le nombre caractères dans la chaîne*)
--                                                  chaine(i) := chaine(i+1);
--                                                  len_chaine := len_chaine-1;
--       (* Affichage de la chaîne sans les caractères interdits *)
--             ECRIRE("Chaine ne contenant que des lettres : ");
--             ECRIRE(chaine);
--     Fin
--
with Ada.Text_IO;
use Ada.Text_IO;

procedure only_letter is 
       
       -- Déclaration des constantes 
       CMAX : constant Integer := 30;

       -- Déclaration des variables locales 
       chaine : STRING(1..CMAX);  -- Chaîne de caractères
       len_chaine : Integer;  -- Taille de la chaîne 
       indEcr : Integer; -- indice d'écriture
begin
       -- Initialisation des variables locales 
       len_chaine := 0;
       indEcr := 1;

       -- Lecture de la chaîne saisie par l'utilisateur 
       Put("Saisissez une chaîne de caractère de 30 caractères au maximum : ");
       Get_Line(chaine,len_chaine);

       -- Affichage de la chaîne saisie
       New_Line(1);
       Put("Vous avez saisi la chaîne suivante : ");
       Put(chaine(1..len_chaine));

        -- Suppression des caractères qui ne sont pas des lettres 
         -- Parcours du tableau de caractère de 1 à len_chaine-1 
         For I in Integer range 1..len_chaine loop
              -- Test si le caractère courant est une lettre : 
               if chaine(i) >= 'a' and chaine(i) <= 'z' then  --Si oui -> écrire le caractère à l'indice d'écriture et incrémenter cet indice
                      chaine(indEcr) := chaine(i);
                      indEcr := indEcr+1;
               else  --Sinon -> décrémenter la taille de la chaine
                   len_chaine := len_chaine - 1;
               end if;
         end loop;

         -- Affichage de la chaîne sans les caractères interdits
         New_Line(2);
         Put("Voici la chaîne ne contenant que des lettres : ");
         Put(chaine(1..len_chaine));


end only_letter;



