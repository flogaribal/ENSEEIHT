/* Serveur pour communication avec socket */

#ifndef _SERV		

#define _SERV

#define NBD FD_SETSIZE-1

/* sock_server :
- se met a l'ecoute de toute demande de communication sur le port numero "numport"
- maxcon : nombre max de clients (une connexion diffrente par client)
- din : tableau des descripteur en entrée : din[i] est le descripteur sur lequel sock_server lit l'information a envoyer au client numero i
- dout : tableau des descripteurs en sortie : dout[i] est le descripteur sur lequel sock_server  ecrit l'inforation recue depuis le client numero i

Fonctionnement :
- sock_server accepte toute nouvelle demande de connexion provenant du meme utilisateur
si maxcon n'est pas atteint
- écrit sur dout[i] tout message reçu de la connexion numero i,
	* Lors d'une nouvelle connexion un message explicite est écrit sur dout[i]
	* lorsque la connexion i est fermee par le client, le message "Fermee" est ecrit sur dout[i]
- envoie au client numero i tout message lu sur din[i]
- 
*/

void sock_server(int numport, int *din, int *dout, int maxcon);

#endif

