-- Florian Garibal 
-- 1A IMA Groupe A
-- TP Bilan - Module Programmation Impérative

-- Programme principal du jeu du Morpion 
--
pragma Assertion_Policy(CHECK);
with Ada.Assertions ; use Ada.Assertions ;

with Ada.Text_IO; 
use Ada.Text_IO;
with Ada.Integer_Text_IO; 
use Ada.Integer_Text_IO;



procedure morpion is 

    -- Déclaration des constantes
    KMAX : constant Integer := 10;            				-- Taille max du damier 

    -- Déclaration des Types 
    Type SYMBOLE is (LIBRE,ROND,CROIX); 					-- Contenu d’une case du damier 
    Type DAMIER is array (1..KMAX, 1..KMAX) of SYMBOLE;  	-- Un damier
    Type JOUEUR is (JROND, JCROIX);      					-- Deux joueurs seulement
    Type ETAT_JEU is (EN_COURS, GAGNE, NUL);				

    -- Déclaration des fonctions et procédures
    -------------------------------------------------------------------------------------
    -- procedure : initialiser_jeu
    -- Permet d'initialiser le damier en mettant dans toutes ces cases le symbole "LIBRE"
    -- Paramètres le_damier : 	Mode Données/Résultats
    --							Type DAMIER
    --							L'espace de jeu à initialiser
    --				  le_n  :   Mode Résultat
    --				  --				  			Type INTEGER
    --				  			La taille réelle du damier
    --			  le_joueur :   Mode Résultat
    --							Type JOUEUR
    -- 							Le joueur courant
    --------------------------------------------------------------------------------------
    procedure initialiser_jeu(le_damier: IN OUT DAMIER; le_n: IN OUT INTEGER; le_joueur: OUT JOUEUR) 
        WITH 
        PRE => (le_n >= 3) and (le_n <= KMAX),

        POST => (FOR ALL i IN 1..le_n => 
        (FOR ALL j IN 1..le_n => 
        le_damier(i,j) = LIBRE));

        procedure initialiser_jeu(le_damier: IN OUT DAMIER; le_n: IN OUT INTEGER; le_joueur: OUT JOUEUR) is

        begin
            -- Lecture du nombre de case souhaité pour le damier de manière conviviale et fiable
            loop
                Put("Veuillez saisir le nombre de case que vous souhaitez pour votre damier (3<nbCases<");
                Put(KMAX,1);
                Put(") : ");
                Get(le_n);
                exit when le_n >=3 and le_n <= KMAX;

                le_joueur := JCROIX;

            end loop;
            -- Parcours de tout le damier est affectation à toute les cases du symbole "LIBRE"
            For I in Integer range 1..le_n loop
                For J in Integer range 1..le_n loop
                    le_damier(I,J) := LIBRE;
                end loop;
            end loop;
            -- Fin du parcours du damier

        end initialiser_jeu;

        ---------------------------------------------------------------------------------------
        -- procedure : afficher_jeu
        -- Permet d'afficher l'état courant du jeu à l'aide de caractères ASCII
        -- Exemple d'affichage pour un morpion 5x5
        --
        --			0   1   2   3   4
        --              0   .   .   .   .   .
        --		1   .   .   X   X   .
        --		2   .   .   .   X   .
        --		3   .   .   .   .   .
        --		4   O   O   O   X   O
        --
        -- Paramètres le_damier : 	Mode Données
        --							Type DAMIER
        --							L'espace de jeu à initialiser
        --				  le_n  :   Mode Données 
        --				  			Type INTEGER
        --				  			La taille réelle du damier
        --			  le_joueur :   Mode Données
        --							Type JOUEUR
        -- 							Le joueur courant
        --------------------------------------------------------------------------------------
        procedure afficher_jeu(le_damier: DAMIER; le_n: INTEGER; le_joueur: JOUEUR) 
            WITH 
            PRE => (le_n >= 3) and (le_n <= KMAX);
            procedure afficher_jeu(le_damier: DAMIER; le_n: INTEGER; le_joueur: JOUEUR) is
            begin
                -- Affichage de la première ligne contenant les chiffres des colonnes
                Put("   ");
                For I in Integer range 1..(le_n) loop
                    Put(I,1); 
                    Put("   ");
                end loop;

                -- Affichage du reste du damier
                For I in Integer range 1..le_n loop

                    -- Affichage du numéro de ligne  
                    New_Line(1);
                    Put(I,1);

                    For J in Integer range 1..le_n loop
                        Put("   ");
                        -- Affichage du contenu du damier
                        if le_damier(I,J) = LIBRE then 	-- Si la case courante est libre
                            Put(".");
                        elsif le_damier(I,J) = ROND then	-- Si la case courante appartient au joueur JROND
                            Put("O");
                        else 								-- Si la case courante appartient au joueur JCROIX
                            Put("X");
                        end if;

                    end loop;
                end loop;
                -- Fin du parcours du damier

            end afficher_jeu;

            ---------------------------------------------------------------------------------------------------------------------------------------------------------
            -- fonction : how_etat_is
            -- Permet de tester si la situation courante du jeu/du damier est une situation gagnante, nulle ou en cours à savoir qu'une situation gagnante est une sitation où
            -- "le_n" symboles identiques sont alignés horizontalement verticalement ou diagonalement et une situation est une situation où toutes les cases du damiers sont 
            -- utilisées sans présenter une situation gagnante. 
            -- Paramètres le_damier : 	Mode Données
            --							Type DAMIER
            --							L'espace de jeu à initialiser
            --				  le_n  :   Mode Données 
            --				  			Type INTEGER
            --				  			La taille réelle du damier
            --			 le_symbole :   Mode Données
            --							Type SYMBOLE
            -- 							Le symbole joueur courant
            -- Résultat : Type ETAT_JEU
            --		      GAGNE si le damier comporte un alignement de "le_n" symboles identiques
            -- 			  NUL si toutes les cases sont utilisées mais aucune situation gagnante
            --			  EN_COURS si ni NUL ni GAGNE          
            ---------------------------------------------------------------------------------------------------------------------------------------------------------
            function how_etat_is(le_damier: DAMIER; le_n: Integer; le_symbole: SYMBOLE) return ETAT_JEU
                WITH 
                PRE => le_n >= 3 and le_n <= KMAX;

                function how_etat_is(le_damier: DAMIER; le_n: Integer; le_symbole: SYMBOLE) return ETAT_JEU is 
                    -- Déclaration des variables
                    next_etat: ETAT_JEU;
                    cpt_symboles_alignes_lignes: Integer;
                    cpt_symboles_alignes_colonnes: Integer;
                    cpt_symboles_alignes_diagonales1: Integer;
                    cpt_symboles_alignes_diagonales2: Integer;
                    cpt_symboles_total: Integer;
                    I: Integer;
                    J: Integer;
                begin
                    -- Initialisation des variables
                    next_etat := EN_COURS;
                    cpt_symboles_alignes_lignes := 0;
                    cpt_symboles_alignes_colonnes := 0;
                    cpt_symboles_alignes_diagonales1 := 0;
                    cpt_symboles_alignes_diagonales2 := 0;
                    cpt_symboles_total := 0;
                    I := 1;
                    J := 1;

                    -- Tests des lignes et diagonales
                    while next_etat = EN_COURS and I <= le_n loop
                        while next_etat = EN_COURS and J <= le_n loop
                            -- Test si case libre pour test d'état NUL 
                            if le_damier(I,J) /= LIBRE then
                                cpt_symboles_total := cpt_symboles_total +1;
                            else 
                                null;
                            end if;

                            -- Tests pour les diagonales
                            if I = J and le_damier(I,J) = le_symbole then					-- Diagonale de haut gauche à bas droit
                                cpt_symboles_alignes_diagonales1 := cpt_symboles_alignes_diagonales1 +1;
                            elsif J = (le_n-I)  then											

                                cpt_symboles_alignes_diagonales2 := cpt_symboles_alignes_diagonales2 +1;		-- Diagonale de haut droit à bas gauche
                            end if;

                            -- Test pour les lignes				
                            if le_damier(I,J) = le_symbole then
                                cpt_symboles_alignes_lignes := cpt_symboles_alignes_lignes +1;
                            else
                                null;
                            end if;

                            J := J+1; -- Incrémentation numéro de colonne
                        end loop;
                        -- Fin du parcours de la ligne courante du damier ou situation gagnante trouvée

                        -- Test du nombre de symbole alignés sur la ligne parcourue 
                        if cpt_symboles_alignes_lignes = le_n then
                            next_etat := GAGNE;
                        else 
                            cpt_symboles_alignes_lignes := 0;
                        end if;

                        J := 1;		-- Remise à zéro du numéro des colonnes pour passer à la ligne suivante
                        I := I+1;	-- Incrémentation du numéro de ligne	
                    end loop;
                    -- Fin du parcours des lignes du damier ou situation gagnante trouvée

                    -- Test de situation gagnante sur les diagonales si situation pas déjà gagnante 
                    if next_etat = EN_COURS and (cpt_symboles_alignes_diagonales1 = le_n or cpt_symboles_alignes_diagonales2 = le_n) then
                        next_etat := GAGNE;
                    else
                        null;
                    end if;

                    -- Tests des colonnes 
                    while next_etat = EN_COURS and J <= le_n loop
                        while next_etat = EN_COURS and I <= le_n loop
                            -- Tests pour les colonnes 
                            if le_damier(I,J) = le_symbole then
                                cpt_symboles_alignes_lignes := cpt_symboles_alignes_colonnes +1;
                            else
                                null;
                            end if;

                            I := I+1;
                        end loop;

                        -- Test du nombre de symbole alignés sur la colonne parcourue 
                        if cpt_symboles_alignes_colonnes = le_n then
                            next_etat := GAGNE;
                        else 
                            cpt_symboles_alignes_colonnes := 0;
                        end if;

                        I := 1;		-- Remise à zéro du numéro des de ligne pour passer à la colonne suivante
                        J := J+1;	-- Incrémentation du numéro de colonne
                    end loop;

                    -- Test pour l'état NUL
                    if next_etat = EN_COURS and cpt_symboles_total = (le_n*le_n) then
                        next_etat := NUL;
                    else
                        null;
                    end if;

                    return next_etat;

                end how_etat_is;

                ---------------------------------------------------------------------------------------------------------------------------------------------------------
                -- procedure : jouer
                -- Permet d'effectuer un tour de jeu à savoir demander au joueur courant "le_joueur" la case dans laquelle il veut jouer puis de placer le symbole correspond au joueur
                -- en cours dans la case correspondante. 
                -- Enfin la procédure teste si la nouvelle situation modifie l'état de la partie si c'est le cas elle change l'état sinon elle change le joueur courant
                -- Paramètres le_damier : 	Mode Données/Résultats
                --							Type DAMIER
                --							L'espace de jeu à initialiser
                --				l_etat  :   Mode Données/Résultats
                --				  			Type ETAT_JEU
                --				  			L'état courant du jeu
                --			  le_joueur :   Mode Données/résultat
                --							Type JOUEUR
                -- 							Le joueur courant
                ---------------------------------------------------------------------------------------------------------------------------------------------------------
                procedure jouer(le_damier: IN OUT DAMIER; le_n: Integer; l_etat: IN OUT ETAT_JEU; le_joueur: IN OUT JOUEUR)
                    WITH
                    PRE => l_etat = EN_COURS;

                    procedure jouer(le_damier: IN OUT DAMIER; le_n: Integer; l_etat: IN OUT ETAT_JEU; le_joueur: IN OUT JOUEUR) is

                        -- Déclaration des variables
                        ligne: Integer;
                        colonne: Integer;
                        le_symbole: SYMBOLE;
                        next_etat: ETAT_JEU;
                    begin

                        -- Attribution du symbole à placer
                        if le_joueur = JROND then
                            le_symbole := ROND;
                        else 
                            le_symbole := CROIX;
                        end if;

                        -- Saisie de la position du prochain coup du joueur courant de manière conviviale et fiable
                        loop
                            New_Line(1);
                            Put("JOUEUR ");
                            if le_symbole = ROND then
                                Put(" ROND ");
                            else 
                                Put(" CROIX ");
                            end if;
                            New_Line(1);
                            Put("Veuillez saisir le numéro de ligne où vous souhaitez jouer : ");
                            Get(ligne);
                            New_Line(1);
                            Put("Veuillez saisir le numéro de colonne où vous souhaitez jouer : ");
                            Get(colonne);			
                        exit when ligne >= 1 and colonne >= 1 and ligne <= le_n and colonne <= le_n and le_damier(ligne,colonne) = LIBRE;
                end loop;
                --ligne >= 1 and colonne >= 1 and ligne <= le_n and colonne <= le_n and le_damier(ligne)(colonne) = LIBRE;

                -- Affectation du symbole du joueur courant à la case demandée
                le_damier(ligne,colonne) := le_symbole;

                -- Tests état de la nouvelle situation  -> si GAGNE ou NUL modification de l'état, 
                -- 										-> sinon modification du joueur courant
                next_etat := how_etat_is(le_damier,le_n,le_symbole);
                if next_etat /= EN_COURS then
                    l_etat := next_etat;
                else 
                    if le_joueur = JROND then
                        le_joueur := JCROIX;
                    else 
                        le_joueur := JROND;
                    end if;
                end if;

        end jouer;

	---------------------------------------------------------------------------------------------------------------------------------------------------------
	-- procedure : afficher_fin_de_jeu
	-- Permet d'afficher l'état du jeu lorsqu'il est fini
	-- Exemple d'affichage pour un morpion 5x5
	--
	--			0   1   2   3   4    		--			0   1   2   3   4    		--			0   1   2   3   4    
	--              0   .   .   .   X   .			--              0   .   .   O   X   .			--              0   X   O   O   X   O
	--		1   .   .   X   X   .			--		1   .   .   O   X   .			--		1   O   X   O   X   O
	--		2   .   .   O   X   .			--		2   .   .   O   0   .			--		2   X   X   O   0   X				
	--		3   .   .   O   X   .			--		3   .   .   O   X   .			--		3   O   O   X   X   O			
	--		4   O   O   O   X   O 			--		4   O   O   O   X   O 			--		4   O   O   O   X   O
	--
	-- Le joueur croix a gagné !  			               -- Le joueur rond a gagné !   			        -- Match nul ! 
	--
	-- Paramètres le_damier : 	Mode Données
	--							Type DAMIER
	--							L'espace de jeu à initialiser
	--				  le_n  :   Mode Données 
	--				  			Type INTEGER
	--				  			La taille réelle du damier
	--			  le_joueur :   Mode Données
	--							Type JOUEUR
	-- 							Le joueur courant
        --				l_etat  :   Mode Données/Résultats
        --				  			Type ETAT_JEU
        --				  			L'état courant du jeu	
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        procedure afficher_fin_de_jeu(le_damier: DAMIER; le_n: INTEGER; le_joueur: JOUEUR; l_etat: ETAT_JEU) 
            WITH 
            PRE => (le_n >= 3) and (le_n <= KMAX) and l_etat /= EN_COURS;

            procedure afficher_fin_de_jeu(le_damier: DAMIER; le_n: INTEGER; le_joueur: JOUEUR; l_etat: ETAT_JEU) is
            begin	
                -- Affichage du damier classique
                afficher_jeu(le_damier,le_n,le_joueur);

                -- Affichage du message
                New_Line(1);
                if l_etat = NUL then 
                    Put("MATCH NUL ! ");
                else
                    Put("Le joueur ");
                    if le_joueur = JCROIX then 
                        Put(" CROIX ");
                    else 
                        Put(" ROND ");
                    end if;
                    Put(" a gagné la partie !");
                end if;

            end afficher_fin_de_jeu;


	-- Déclaration des variables locales
le_damier : DAMIER;  									-- Espace de jeu 
le_n : INTEGER;											-- Dimension réelle du damier. Entre 3 et KMAX 
le_joueur : JOUEUR;	   								    -- Le joueur courant 
l_etat : ETAT_JEU;										-- L’etat courant du jeu 


begin
    le_n := 3;
    l_etat := EN_COURS;

    -- Initialiser le jeu 
    initialiser_jeu(le_damier, le_n, le_joueur);   

    -- Jouer 
    loop
        -- Afficher le damier et le joueur courant;
        afficher_jeu(le_damier, le_n, le_joueur);
        -- Le joueur courant joue
        jouer(le_damier, le_n, l_etat, le_joueur);

        -- Arrêt de la boucle quand l'état courant est différent de EN_COURs c'est à dire qu'il est passé à GAGNE ou à NUL
        exit when l_etat /= EN_COURS;
    end loop;
    -- partie terminee l_etat /= EN_COURS


    afficher_fin_de_jeu(le_damier, le_n, le_joueur, l_etat);
end morpion;


