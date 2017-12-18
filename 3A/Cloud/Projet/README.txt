===================================
==== Projet Cloud & Big Data ======
===================================

Membres du groupe :
- Omar BENNANI
- Florent DUBOIS
- Florian GARIBAL
- Luc SAPIN

Récupération du projet :

= IMAGES DOCKER
	|- Etre contributeur du repository fdubois/
	|
	|- Se connecter depuis le terminal Docker avec la commande suivante :
	|	docker login
	|  Rentrer son nom d'utilisateur Docker Hub et son mot de passe
	|
DOCKER	|- Récupérer les différentes images du projet à l'aide des commandes suivantes
 HUB	|	docker pull fdubois/server_basic:zookeeper
	|	docker pull fdubois/server_basic:kafka
	|	docker pull fdubois/server_basic:simu
	|	docker pull fdubois/server_basic:spark
	|	docker pull fdubois/server_basic:elasticsearch
	
ARCHIVE	|- Désarchiver l'archive docker_images_BENNANI_DUBOIS_GARIBAL_SAPIN.tar
	
	- Vérifier la présence des 5 images en lançant 
		docker images

= SCRIPTS DE LANCEMENT
	- Désarchiver l'archive "Script_lancement_Docker_BENNANI_DUBOIS_GARIBAL_SAPIN.tar"
	- Se déplacer dans l'archive
	- Rajouter les droits d'éxécution aux 4 scripts
		chmod u+x zookeeper_start.sh kafka_start.sh simu_start.sh spark_start.sh

Lancement du projet :
	- Executer les scripts de lancement dans l'ordre suivant :
		sh zookeeper_start.sh
		sh kafka_start.sh
	- Ouvrir un nouveau terminal et éxécuter :
		sh simu_start.sh
	- Lancer un navigateur web et accéder à :
		http://localhost:8080
	- Aller dans le menu "Quartiers" puis cliquer sur "Démarrer la simulation"
	- Ouvrir un nouveau terminal et éxécuter :
		sh spark_start.sh

- 	
