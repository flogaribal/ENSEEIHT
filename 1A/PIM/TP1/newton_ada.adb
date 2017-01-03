-- Garibal Florian, Groupe A
-- Programme qui permet de tester la fonction newton

with Ada.Text_IO;
use Ada.Text_IO;
with ada.float_Text_IO;
use ada.float_Text_IO;

procedure newton_ada is

    -- Constantes
    -- nbRacine : constant float := 81.0;
    -- precision : constant float := 0.001;

    -- Fonctions

        -- newton : float*float -> float
        -- Cette fonction calcule l'approximation de la racine carrée de x par
        -- la méthode de Newton avec une précision de E en utilisant la formule suivante 
        -- ak+1 = 0.5*(ak+x/ak) sachant que ak = 1.0
        -- Paramètre x : float, nombre dont on cherche à calculer la racine
        --           E : float, précision de l'approximation
        -- Précondition : x doit être strictement positif          
        -- Résultat : Approximation de la racine carrée de x par la méthode de
        -- newton avec une précision de E   
        function newton(x: float; e: float) return float is
            aKprec : float := 0.0;
            aKcurr : float := 1.0;
        begin
            -- Récurrence jusqu'à que l'intervalle entre la valeur précédente et
            -- la valeur courante est inférieur à la précision e
            loop
                akPrec := aKcurr;
                aKcurr := 0.5*(aKprec + x/aKPrec);
                exit when abs(aKcurr-aKprec) < e;
            end loop;
            -- intervalle inférieur à la précision e -> fin de boucle

            return aKcurr;
        end newton;

   -- Var locales
   resultatRacine : float := 0.0;
   nbRacine : float := 81.0;
   precision : float := 0.001;

begin

    -- Lire nbRacine de façon conviviale et fiable
    loop
	Put("Entrez le nombre à mettre à la racine : ");
	Get(nbRacine);
	  exit when nbRacine>0.0;
    end loop;
    -- nbRacine>0

    -- Lire la précision de façon conviviale et fiable
    loop
	Put("Entrez la précision souhaitée : ");
	Get(precision);
	exit when precision>0.0 and precision<1.0;
    end loop;
    -- precision<1 et precision>0

    -- Appel de fonction
    resultatRacine := newton(nbRacine,precision);

    Put("La racine du nombre ");
    Put(nbRacine);
    Put(" avec la précision de ");
    Put(precision);
    Put(" est de ");
    Put(resultatRacine);
-- TESTS 
end newton_ada;

               

                
