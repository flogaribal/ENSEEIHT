(* Florian Garibal 
 * 1A IMA Groupe A
 * File
 *)

type 'a file = 'a list * 'a list;;


let creer_vide ()=
    ([],[]);;

let est_vide file = 
    file = ([],[]);;

let enfiler e (f1,f2) = (f1,(e::f2));;

let defiler file = 
    match file with
    |([],[]) -> failwith("La file est déjà vide")
    |([],l2) -> 
                begin
                    match List.rev l2 with
                    |t::q -> (t,(q,[]))
                    |[] -> failwith("Ce cas ne devrait pas arriver")
                end
    |(t::q,l2) -> (t,(q,l2));;
