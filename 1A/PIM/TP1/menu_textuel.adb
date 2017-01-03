-- Florian Garibal, Groupe A
-- Programme de l'exercice 3 du TP1, menu textuel

-- Quelle structure de controle ?
--
-- Je choisis la la structure de controle répéter car le menu sera forcément
-- affiché une fois et ne sera plus affiché au moment où l'utilisateur
-- effectuera le choix "q". Repeter... tant que choix <> "q"


with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure menu_textuel is
    
    choix : character := ' ';
    demarre : boolean := false;
    vitesse : Integer := 0;

    -- demarrer 
    -- Procedure qui affiche le contenu du menu demarrer
    -- Si l'utilisateur a déjà démarrer affiche "vous avez déjà démarrer sinon
    -- affiche "vous démarrez"
    procedure  demarrer is
    begin
        if not demarre then
             demarre := true;
             Put_line("Vous avez démarré");
        else 
             Put_line("Vous avez déjà démarré");
        end if;
    end demarrer;


    -- accelerer 
    -- Procedure qui teste si l'utilisateur a démarrer 
    --                  si c'est le cas elle teste si il a atteint la vitesse maximale (5) 
    --                            si c'est le cas elle arrête le programme 
    --                            sinon elle incrémente la vitesse de 1
    --                  sinon elle informe l'utilisateur qu'il a pas démarré
    procedure accelerer is   
    begin
        if not demarre then
             Put_line("Vous n'avez pas encore démarré");
        else 
             vitesse := vitesse +1;
             if vitesse = 5 then
                 Put_line("Vous avez atteint la vitesse maximale de 5, le programme va se fermer");
             else 
                 Put_line("Vous accélérez, votre vitesse est maintenant de ");
                 Put(vitesse);
                 Put_line("");
            end if;
        end if;
     end accelerer;


    -- freiner 
    -- Procedure qui teste si l'utilisateur a démarrer 
    --                  si c'est le cas elle teste si il a une vitesse  (5) 
    --                            si c'est le cas elle informe l'utilisateur
     --                            qu'il est déjà à la vitesse minimale
    --                            sinon elle incrémente la vitesse de 1 
    --                  sinon elle informe l'utilisateur qu'il a pas démarré
    procedure freiner is
    begin
        if not demarre then
             Put_line("Vous n'avez pas encore démarré");
        else 
             if vitesse = 0 then
                 Put_line("Vous avez deja une vitesse de 0, vous ne pouvez pas freiner");
             else 
                 vitesse := vitesse -1;
                 Put_line("Vous freinez, votre vitesse est maintenant de ");
                 Put(vitesse);
                 Put_line("");
             end if;
        end if;
     end freiner;




    
begin
    -- Boucle permettant d'afficher le menu en permanence jusqu'à que
    -- l'utilisateur ai choisi de quitter (choix "q")
    loop 
        Put("Que faire : (d)emarrer    (a)ccélérer    (f)reiner    (q)uitter ?");
        Get(choix);

        -- Traitement des differentes possibilités pour choix
        case choix is
            when 'd' => demarrer; 

            when 'a' => accelerer;
                        Put(vitesse);
                        if vitesse = 5 then 
                            exit;
                        end if;

            when 'f' => freiner;

            when 'q' => Put_line("Fin");

            when others => Put_line("Choix inconnu");
        end case;
        exit when choix = 'q';
    end loop;
    -- fin d'affichage du menu

end menu_textuel;

