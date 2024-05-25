Membres du Groupe

	-ZEMAT Zakariae
	-OUBEZA Idir
	-SAWADOGO Abdel
	-Arnaud Ulrich TOE

Compilation des Programmes

	-Pour compiler les programmes, veuillez suivre les étapes suivantes :

Configuration de la Base de Données :

	-Créez une base de données MySQL et importez le fichier projectmanagement.sql fourni dans le répertoire db.
	-Mettez à jour les paramètres de connexion à la base de données dans le fichier Utilitaire.java situé dans le répertoire src/metier en fonction de votre 	configuration MySQL locale.

Compilation avec un IDE :

	-Ouvrez le projet dans votre IDE préféré (Eclipse, IntelliJ IDEA).
	-compiler et exécuter le programme.

Description des Répertoires:
src/ :

	metier/ : Contient les classes principales de gestion des utilisateurs, des projets, et des ressources.
db/ :

	Contient les fichiers SQL pour la création et la gestion de la base de données. Exemple : projectmanagement.sql.
assets/ :

	Contient les ressources graphiques utilisées par l'application, telles que les images et les icônes. Exemple : icons8-user-30.png, icons8-lock-30.png.
Utilisation de l'Application
	Lancer l'Application :

		Exécutez la classe P4P pour démarrer l'application.
	Connexion :

		Utilisez le formulaire de connexion pour accéder à la plateforme avec un compte utilisateur, administrateur ou invité (guest).Pour se connecter en tant qu'invité username = guest et password = guest
	Fonctionnalités Principales :

	Inscription de nouveaux utilisateurs.
	Gestion des projets (création, modification, suppression).
	Gestion des utilisateurs et des rôles.
	Suivi et gestion des ressources de projet.
	Interface de tableau de bord pour les administrateurs.
