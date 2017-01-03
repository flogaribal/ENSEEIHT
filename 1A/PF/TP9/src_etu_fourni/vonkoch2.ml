(* ouverture des modules a utiliser			*)
open Dessin;;
open File;;

(* une definition d'un angle de 60 degres		*)
(* utile pour les triangles equilateraux		*)
let pi_sur_3 = 3.141592654 /. 3.;;

(* fonction qui engendre les points p2, p3 et p4	*)
(* a partir des points p1 et p5, selon la courbe	*)
(* de Von Koch (voir figure dans le sujet)		*)
let nouvelle_generation (x1, y1) (x5, y5) =
 let dx = (x5 -. x1) /. 3. in
 let dy = (y5 -. y1) /. 3. in
 let dl = sqrt (dx *. dx +. dy *. dy) in
 let a  = atan2 dy dx +. pi_sur_3 in
 let p2 = (x1 +. dx                 , y1 +. dy                 ) in
 let p3 = (x1 +. dx +. dl *. (cos a), y1 +. dy +. dl *. (sin a)) in
 let p4 = (x1 +. 2. *. dx           , y1 +. 2. *. dy           ) in
 (p2, p3, p4);;

(* fonction qui calcule la liste des segments à afficher *)
let rec dessin_fractal (p1,p5) n dessin =
	if n=0
	then ajouter_segment (p1,p5) dessin
	else let (p2,p3,p4) = nouvelle_generation p1 p5 in
			(dessin_fractal (p1,p2) (n-1)
                               (dessin_fractal (p2,p3) (n-1) 
                                      (dessin_fractal (p3,p4) (n-1)
                                             (dessin_fractal (p4,p5) (n-1) dessin ))));;



(* fonction qui calcule la liste des segments à afficher *)
let rec dessin_largeur file n dessin =
  
        if File.est_vide file then 
           dessin
	else 
            let ((p1,p5),b) = defiler file in
                let d = ajouter_segment (p1,p5) dessin in
                        let (p2,p3,p4) = nouvelle_generation p1 p5 in
                                let f = enfiler (p4,p5) (enfiler (p4,p3) (enfiler (p2,p3)
                                (enfiler (p1,p2) b))) in 
                                        if n=0 then
                                            dessin_largeur b 0 d
                                        else 
                                            dessin_largeur f (n-1) d;;
                                        

                
           

(* Affichage *)
let a=(100.,500.) and b=(500.,500.) in 
        let c=(fst a +. 400. *. cos pi_sur_3,snd a -. 400. *. sin pi_sur_3) in
(*dessiner(dessin_fractal (c,a) 3 (dessin_fractal (b,c) 3 (dessin_fractal (a,b)
 * 3 (creer_vide 1000 1000))));;*)
              dessiner (dessin_largeur (File.enfiler (a,b) (File.creer_vide())) 3 (creer_vide 800 800));;
