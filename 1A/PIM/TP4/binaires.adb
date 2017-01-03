-- Florian Garibal
-- Groupe A

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

-- Manipulation de nombres binaires -- 

procedure binaires is
  -- DECLARATION DES CONSTANTES
        NMAX : constant Integer := 7;

  -- DECLARATION DES TYPES
        Type BINAIRE is array (0..NMAX) of Integer;

  -- DECLARATION DES FONCTIONS ET PROCEDURES

    -- affich_binaire 
    -- Permet d'afficher un nombre au format binaire. Ce nombre est stocké dans
    -- l'ordre inverse des puissances c'est à dire que la première case
    -- correspond à la puissance 2⁰, la deuxième à 2¹ etc..
    -- Paramètre tab_nombre : Mode DONNEES 
    --                        type BINAIRE, le tableau contenant le nombre codé en
    --                        binaire à afficher
    -- Préconditions : ----                       
    -- Postcondition : Affichage du nombre binaire dans l'ordre "naturel"
    --                 d'affichage d'un nombre binaire (bit de poids fort à gauche)
        procedure affich_binaire(tab_nombre: BINAIRE) is
        
        begin
            New_Line(1);
            Put("Le nombre en base 2 vaut : ");
            -- Parcours du tableau à l'envers pour obtenir l'ordre naturel
            -- d'affichage des nombres binaires
            for I in reverse Integer range 0..7 loop
               Put(tab_nombre(I),1);
               Put(" ");
            end loop;
            New_Line(1);
            -- Fin du parcours du tableau
        end affich_binaire;



    -- convert_base10 
    -- Converti en base 10 un nombre binaire fourni en paramètre en utilisant la
    -- somme des puissances de 2
    -- Paramètre tab_nombre : Mode DONNEES
    --                        type BINAIRE, le tableau contenant le nombre codé en
    --                        binaire à convertir
    -- Préconditions : ----                       
    -- Résultat : un entier contenant l'équivalent du nombre en base 10                       
    -- Postcondition : Le nombre obtenu sera l'équivalent en base 10 du nombre binaire fourni
    --                 en paramètre 
        function convert_base10(tab_nombre: BINAIRE) return Integer is
            -- Déclaration des variables
            new_nb_base10 : Integer;

        begin
            
            -- Initialisation des variables
            new_nb_base10 := 0;
            
            -- Parcours du tableau dans le sens normal pour que les puissances
            -- correspondent
            for I in Integer range 0..7 loop
                -- Si la case courante possède un bit "1"
                if tab_nombre(I) = 1 then
                        -- Ajout de la puissance courante de 2 à la somme finale
                        new_nb_base10 := new_nb_base10 + 2**I;
                else
                    null;
                end if;
            end loop;
            -- Fin parcours du tableau

            return new_nb_base10;

        end convert_base10;



    -- convert_base2 
    -- Converti en base 2 un nombre en base 10 fourni en paramètre
    -- Paramètre nombre : Mode DONNEES
    --                    type entier, nombre en base 2 à convertir en base 10
    -- Préconditions : ----                       
    -- Résultat : un tableau de type BINAIRE contenant le nombre converti
    -- Postcondition : Le nombre obtenu sera l'équivalent en base 2 du nombre en base 10
    --                 fourni en paramètre
        function convert_base2(nombre : Integer) return BINAIRE is

            -- Déclaration variables locales
            new_nombre_b2 : BINAIRE;    -- Valeur convertie qui sera retournée
            quotient : Integer;         -- Stockera le quotient intermédiaire
                                        -- des divisions
            
            curr_bit : Integer;         -- Stockera le reste intermédiaires des
                                        -- divisions

            tmp_nombre : Integer;       -- Copie le nombre passé en paramètre
                                        -- pour pouvoir le modifier

            ind_bit : Integer;          -- Stocke l'indice où l'on doit écrire
                                        -- le prochain bit

        begin

            -- Initialisation des variables 
            tmp_nombre := nombre;
            quotient := 0;
            curr_bit := 0;
            ind_bit := 0;       -- On écrit d'abord les bits de poids fort
           
           -- Initialisation du tableau
           for I in Integer range 0..7 loop
               new_nombre_b2(I) := 0;
           end loop;


            -- Tant que le quotient des divisions n'est pas inférieur à 0 
            while tmp_nombre /= 0 loop

               -- Récupération du reste de la division courante et assignation
                -- du bit dans le tableau à la case correspondante
               new_nombre_b2(ind_bit) := tmp_nombre mod 2;

               -- Récupération du quotient de la division courante
               tmp_nombre := tmp_nombre/2;
               
               -- Décrémentation de l'indice d'écriture
               ind_bit := ind_bit+1;

            end loop;
            -- tmp_nombre <= 0 
            

            return new_nombre_b2;

        end convert_base2;




    -- add_base2 
    -- Additionne deux nombres binaires
    -- Paramètre tab_nb1 : Mode DONNEES 
    --                     type BINAIRE, le premier nombre binaire à additionner
    --           tab_nb2 : Mode DONNEES
    --                     type BINAIRE, le deuxième nombre binaire à additionner
    -- Préconditions : ----                       
    -- Résultat : un tableau de type BINAIRE contenant la somme des deux nombres
    --            binaires passés en paramètre
        function add_base2(tab_nb1 : BINAIRE; tab_nb2 : BINAIRE) return BINAIRE
        is
            -- Déclaration des variables
            somme_b2 : BINAIRE;
            retenue : Integer; -- Stockera la retenue intermédiaire des
                               -- additions

        begin
            
            -- Initialisation des variables
            retenue := 0;

            -- Parcours des trois tableaux simultanément
            for I in Integer range 0..7 loop
               -- Calcul du bit courant 
               somme_b2(I) := (tab_nb1(I) + tab_nb2(I) + retenue) mod 2;
               -- Calcul de la retenue courante
               retenue := (tab_nb1(I) + tab_nb2(I) + retenue)/2;
            end loop;
            -- Fin du parcours

            return somme_b2;

        end add_base2;
    
     -- saisie_nb_base2 
     -- Permet la saisie d'un nombre binaire et l'initialisation du tableau
     -- correspondant
     -- Paramètre tab_nombre : Mode RESULTAT
     --                        type BINAIRE, tableau qui contiendra le nombre
     --                        binaire saisi
     -- Précondition : ----
     -- Post Conditions : Le tableau ne contiendra que des "1" et des "0" et
     procedure saisie_nb_base2(tab_nombre: OUT BINAIRE)is
        saisie : Integer;
     begin
         saisie := 0;
         Put("Vous allez devoir saisir un nombre binaire de 8 bits ");
         New_Line(1);

         For I in Integer range 0..7 loop
             loop 
                  Put("Saisissez le bit 2^");
                  Put(I,1); 
                  Put(" : ");
                  Get(saisie);
             exit when saisie = 0 or saisie = 1;
             end loop;
             tab_nombre(I) := saisie;
         end loop;

     end saisie_nb_base2;
  
  -- DECLARATION DES VARIABLES LOCALES
        nombre_b2 : BINAIRE;
        nombre1_b2 : BINAIRE;
        
        nombre_b10 : Integer;
        
        
        choix : character;
        saisie : Integer;

begin
    -- Initialisation variables
    choix := ' ';
    saisie := 0;
    For I in Integer range 7..0 loop
        nombre_b2(I) := 0;
        nombre1_b2(I) := 0;
    end loop;


    -- Boucle permettant d'afficher le menu en permanence jusqu'à que
    -- l'utilisateur ai choisi de quitter (choix "q")
    loop 
        Put_Line("Que faire : ");
        Put_Line("(c)onvertir en base 10 un nombre binaire");
        Put_Line("(p)asser en base 2 un nombre décimal");
        Put_Line("(a)dditionner deux nombres binaires");
        Put_Line("(q)uitter ?");

        Get(choix);

        -- Traitement des differentes possibilités pour choix
        case choix is
            when 'c' => saisie_nb_base2(nombre_b2);
                        affich_binaire(nombre_b2);
                        nombre_b10 := convert_base10(nombre_b2); 
                        Put("Le nombre en base 10 vaut ");
                        Put(nombre_b10,3);
                        New_Line(1);

            when 'p' => loop
                           Put_Line("Saisissez un nombre entier >=0 : ");
                           Get(nombre_b10);
                           exit when nombre_b10>=0;
                        end loop;
                        affich_binaire(convert_base2(nombre_b10));


            when 'a' => saisie_nb_base2(nombre_b2);
                        saisie_nb_base2(nombre1_b2);
                        affich_binaire(add_base2(nombre_b2, nombre1_b2));
                        
            when 'q' => Put_line("Fin");

            when others => Put_line("Choix inconnu");
        end case;
        exit when choix = 'q';
    end loop;
    -- fin d'affichage du menu


   
end binaires;
