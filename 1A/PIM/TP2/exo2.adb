with text_io; use text_io;
with ada.integer_text_io; use ada.integer_text_io;

Procedure exo2 is
    -- On initialise le type tableau
    
    -- Déclaration des constantes 
    NMAX : constant INTEGER := 5; -- Indice maximum du tableau

    -- Déclaration des types
    type TAB_ENTIERS is array(1..NMAX) of integer;

    -- Déclaration des variables locales
    un_tab: TAB_ENTIERS; -- un tableau d'au maximum NMAX entiers
    nb_elements : integer; --Le nombre effectif d'éléments (<= NMAX) de un_tab.
    indice: integer; -- indice de la valeur à modifier
    val: integer; -- nouvelle valeur à affecter à une case du tableau

begin

    -- Initialisation des variables
    indice := 0 ;


    -- Afficher un tableau préalablement initialisé
    
        -- Initialisation du tableau 
              -- Saisie du nombre de valeurs effectives  nb_elements de manière conviviale et
              -- fiable
        loop
            Put("Saisissez le nombre de valeurs que le tableau doit contenir <=");
                        Put(NMAX,2);

            get(nb_elements);
            exit when nb_elements > 0 and nb_elements <= NMAX;
        end loop;
        -- nb_elements > 0 et nb_elements <=NMAX
               
              -- Saisie de chaque valeur du tableau
              -- Parcours du tableau de 1 à nb_elements et saisie de chaque
              -- valeur
        for i in 1..nb_elements loop
            Put(i,2);
            Put("eme élément de un_tab: ");
            get(un_tab(i));
        end loop;

    -- Lire l'indice de la case a modifier --
        -- -- boucle répéter à arreter lorsque 1<= indice <=nb_elements --
        loop
            put("Quel élément souhaitez-vous modifier?");
            get(indice);
            new_line;
            exit when indice <= nb_elements and indice >=1;
        end loop;
    -- lire la valeur (=val) que l'on veut affecter a la case indice --
    put("Quelle valeur voulez vous donner à la case ");
    put(indice, 2);
    put(": ");
    get(val);
    -- On affecte val a la case indice --
    un_tab(indice) := val;
end exo2;
    
