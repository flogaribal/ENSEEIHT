-- Garibal Florian, Groupe A
-- Programme permettant de tester la fonction somme
with Ada.Text_IO; 
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure somme_ada is
  

	-- somme : int*int -> int
	-- Calculer la somme des entiers compris entre 2 entiers naturels m et n 
	-- Paramètre m : entier naturel, la borne inférieure de l'intervalle
	--           n : entier naturel, la borne supérieure de l'intervalle
	-- Précondition : m et n doivent être strictement positifs et m doit être inférieur ou égal à n
	-- Résultat : la sommme des entiers compris entre m et n
	function somme(m : Integer;n : Integer) return Integer is
	  somme : Integer := 0; -- Variable qui stockera la somme des entiers
	begin        
	    -- Parcours des entiers compris entre m et n
	    for I in Integer range m..n loop	        
	        somme := somme + I; -- Ajout de l'entier courant dans la variable somme
	    end loop;
	    -- Fin parcours des entiers -> Somme calculée
	    
	    return somme;
	end somme;
	-- Fin de la fonction somme
	
	-- Déclaration des variables qui contiendront les bornes de l'intervalle
  	m : Integer := 0;
	n : Integer := 0;
	-- Déclaration de la variable qui stockera la somme retournée par la fonction
	sommeInt : Integer := 0;


begin
  
  -- Lire m de façon conviviale et fiable
  loop
	Put("Entrez la borne inférieure de l'intervalle : ");
	Get(m);
	  exit when m>0;
  end loop;
  -- m>0

  -- Lire n de façon conviviale et fiable
  loop
	Put("Entrez la borne supérieure de l'intervalle : ");
	Get(n);
	exit when n>0 and n>=m;
  end loop;
  -- n>0 et n>=m
 
  -- Appel de la fonction somme et récupération du résultat dans la variable somme
  sommeInt := somme(m,n);

  -- Affichage du résultat
  Put("La somme des entiers compris entre "); 
  Put(m);
  Put(" et ");
  Put(n);
  Put(" est ");
  Put(sommeInt);
end somme_ada;
