-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP10_pointeurs



with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure tp10_ptr is

    -- Déclaration des constantes
    STRMAX: constant Integer := 5;
    
    -- Déclaration des types 
    type PINT is access Integer;

    type MATIERE is record
        code: STRING(1..STRMAX);
        ptr_note: PINT;
     end record;

    -- Déclaration des sous programmes
    
    
    ----------------------------------------------------------
    -- init_Matiere
    -- Initialise la matière avec un code mais sans note associée
    -- C'est à dire que le pointeur sera égal à null
    -- Paramètre mat : Mode Résultats
    --                 Type MATIERE
    --                 LA matière à initialiser
    -- Précondition : -------
    -- Postcondition : mat.code /= null and 
    --                 mat.ptr_note = null
    -- Exception : ------                
    ----------------------------------------------------------
    procedure init_Matiere (mat : OUT MATIERE) is
    begin
        Put("Entrez le code de la matière (exactement 5 caractères) : ");
        Get(mat.code);
        mat.ptr_note := null;

    end init_Matiere;


    ----------------------------------------------------------
    -- affich_Matiere
    -- Affiche la matière passée en paramètre
    -- Paramètre mat : Mode Données
    --                 Type MATIERE
    --                 La matière à afficher
    -- Précondition : --------
    -- Postcondition : ------
    -- Exception : CONSTRAINT_ERROR si la note n'a pas été initialisée                
    ----------------------------------------------------------
    procedure affich_Matiere(mat: IN MATIERE) is
    begin

       Put_Line("======================");
       Put("Code : ");
       Put_Line(mat.code);
       Put("Note associée : ");
       Put(mat.ptr_note.all,1);
       New_Line(1);
       Put_Line("======================");
    Exception
        when CONSTRAINT_ERROR => Put_Line("La note n'a pas été encore initialisée, vous ne pouvez y accéder");
    end affich_Matiere;


    ----------------------------------------------------------
    -- modifNote_Matiere
    -- Affiche la matière passée en paramètre
    -- Paramètre mat : Mode Résultat
    --                 Type MATIERE
    --                 La matière à modifier
    --          note : Mode Donnée
    --                 Type Integer
    --                 La note à affecter à la matière
    -- Précondition : --------
    -- Postcondition : modifNote_Matiere'RESULT.ptr_note.all = note
    -- Exception : ------                
    ----------------------------------------------------------
    procedure modifNote_Matiere(mat: OUT MATIERE; note: IN Integer) is
    begin
        mat.ptr_note := new Integer;
        mat.ptr_note.all := note;
       
    end modifNote_Matiere;


    -- Déclaration des variables
    p: PINT;
    pf : MATIERE;

begin
   
  ----------------------  EXERCICE 1 -------------------------
    -- Initialisation
    p := new Integer;
    p.all := 99;

    -- Affichage 
    Put("p pointe sur : ");
    Put(p.all,1);

    New_Line(1);
    Put("Veuillez rentrer la zone que vous voulez que p pointe : ");
    Get(p.all);
    
    -- Affichage 
    New_Line(1);
    Put("p pointe sur : ");
    Put(p.all,1);
    New_Line(1);



  ----------------------  EXERCICE 2 -------------------------
    
    init_Matiere(pf);
    affich_Matiere(pf);
    New_Line(1);
    modifNote_Matiere(pf,15);
    New_Line(1);
    affich_Matiere(pf);

Exception
    when CONSTRAINT_ERROR => Put_Line("Accès à un élément null");
    when others => Put_Line("Erreur inconnue");


end tp10_ptr;
