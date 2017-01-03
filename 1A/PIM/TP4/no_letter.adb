-- Florian Garibal
-- 1A IMA Groupe A


--Raffinage

--R0 : programme eliminant d’une chaîne tous les caractères qui  sont  des lettres (caractères entre ’a’ et ’z’) 

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
--   (* programme eliminant d’une chaîne tous les caractères qui  sont  des lettres (caractères entre ’a’ et ’z’) *)  
--       (*Lecture de la chaîne saisie par l'utilisateur *)
--          len_chaine := 0 
--           ECRIRE("Veuillez saisir une chaîne de caractère : ")
--           LIRE(chaine, len_chaine);
     
--       (* Affichage de la chaîne saisie *)
--            ECRIRE("Chaîne saisie : ");
--            ECRIRE(chaine);

--       (* Suppression des caractères qui  sont  des lettres *) 

--       (* Affichage de la chaîne sans les caractères interdits *)
--             ECRIRE("Chaine ne contenant aucune lettre : ");
--             ECRIRE(chaine);
--     Fin


--Analyse Informelle :  
--            - Structure de contrôle : POUR
--            - Parcourir de 1 à len_chaine le tableau de caractères
--            - Répeter à chaque tour de boucle : 
--                                         - Test si le caractère courant est une lettre : 
--                                                          - Si oui  -> affecter au caractère courant le caractère suivant et décrémenter de 1 le nombre caractères dans la chaîne
--                                                          - Sinon -> ne rien faire
           
--R2 : 
--        - Lecture de la chaîne saisie par l'utilisateur 
--        - Affichage de la chaîne saisie
--        - Suppression des caractères qui  sont  des lettres 
--                  - Parcours du tableau de caractère de 1 à len_chaine-1
--                               Test si le caractère courant est une lettre : 
--                                                          - Sinon -> affecter au caractère courant le caractère suivant et décrémenter de 1 le nombre caractères dans la chaîne
--                                                          - Si oui -> ne rien faire
--        - Affichage de la chaîne sans les caractères interdits

--Algo : 
--      CMAX : constant entier := 30
--      Type CHAINE(1..CMAX);
--      chaine : CHAINE;
--      len_chaine : entier; 
--Début 
--   (* programme eliminant d’une chaîne tous les caractères qui  sont  des lettres (caractères entre ’a’ et ’z’) *)  
--       (*Lecture de la chaîne saisie par l'utilisateur *)
--           len_chaine := 0 
--           ECRIRE("Veuillez saisir une chaîne de caractère : ")
--           LIRE(chaine, len_chaine);
--     
--       (* Affichage de la chaîne saisie *)
--            ECRIRE("Chaîne saisie : ");
--            ECRIRE(chaine);
--
--       (* Suppression des caractères qui  sont  des lettres *) 
--                  (* Parcours du tableau de caractère de 1 à len_chaine-1 *)
--                         POUR i ALLANT DE 1 à len_chaine -1 FAIRE
--                                 (* Test si le caractère courant est une lettre : *) 
--                                        SI chaine(i) < 'a' ET chaine(i) > 'z' ALORS   (*Si oui -> ne rien faire)*
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

procedure no_letter is 
       
       -- Déclaration des constantes 
       CMAX : constant Integer := 30;



       procedure zero_lettre(chsrc: STRING; chdest : STRING) is

           j : Integer;
       begin
        
           j:=1;
           
          -- Suppression des caractères qui sont pas lettres 
         -- Parcours du tableau de caractère de 1 à len_chaine-1 
         For i in Integer range 1..len_chaine loop
              -- Test si le caractère courant n'est pas une lettre :
               if chsrc(i) < 'a' and chsrc(i) > 'z' then  --Si oui -> écrire le caractère à l'indice d'écriture et incrémenter cet indice
                      chdest(j) := chsrc(i);
                      j := j+1;
               else  --Sinon -> décrémenter la taille de la chaine
                      null;   
               end if;
         end loop;

       end zero_lettre;


       -- Déclaration des variables locales 
       chaine : STRING(1..CMAX);  -- Chaîne de caractères
       chaine_result : String(1..CMAX); -- chaine sans lettre
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

        
       -- Affichage de la chaîne sans les caractères interdits
       New_Line(2);
       zero_lettre(chaine,chaine_result);
       Put("Voici la chaîne  contenant aucune lettre : ");
       Put(chaine_result);


end no_letter;




