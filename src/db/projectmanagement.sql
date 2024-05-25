-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : dim. 19 mai 2024 à 05:26
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projectmanagement`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur_plateforme`
--

CREATE TABLE `administrateur_plateforme` (
  `IdAdministrateur` int(10) NOT NULL,
  `identifiant_connexion` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `administrateur_plateforme`
--

INSERT INTO `administrateur_plateforme` (`IdAdministrateur`, `identifiant_connexion`, `nom`, `prenom`, `email`, `mot_de_passe`) VALUES
(1, 'zakar_zemat', 'zemat', 'zakariae', 'zakar@exmple.com', 'zakar123'),
(2, 'idir_oubeza', 'oubeza', 'idir', 'idir@exmple.com', 'idir123'),
(3, 'toe_arnaud', 'arnaud', 'toe', 'arnaud@exmple.com', 'arnaud12'),
(4, 'abdel_sawadogo', 'sawadogo', 'abdel', 'abdel@exmple.com', 'abdel123');

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `IdDemande` int(10) NOT NULL,
  `IdUtilisateur` int(10) NOT NULL,
  `username` varchar(255) NOT NULL,
  `nom_court_projet` varchar(255) NOT NULL,
  `nom_long_projet` varchar(255) NOT NULL,
  `description_projet` text NOT NULL,
  `theme_projet` text NOT NULL,
  `projet_is_public` bit(1) NOT NULL,
  `etat` enum('Accepted','Refused','Pending') DEFAULT NULL,
  `IdProjet` int(11) DEFAULT NULL,
  `type` enum('creation','closure','','') DEFAULT NULL,
  `date_demande` datetime DEFAULT current_timestamp(),
  `IdGroupe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `demande`
--

INSERT INTO `demande` (`IdDemande`, `IdUtilisateur`, `username`, `nom_court_projet`, `nom_long_projet`, `description_projet`, `theme_projet`, `projet_is_public`, `etat`, `IdProjet`, `type`, `date_demande`, `IdGroupe`) VALUES
(1, 1, 'zakariae_aboussad', 'Pscientifiques', 'Gestion des publications scientifiques', 'Ce projet se concentre sur la gestion des publications scientifiques, offrant une plateforme pour organiser, partager et accéder aux travaux de recherche. Les fonctionnalités incluent la gestion des auteurs, des articles, des revues et des conférences scientifiques.', 'Scientifique', b'1', 'Accepted', 1, 'creation', '2024-05-01 00:00:00', 3),
(2, 2, 'ibtissam_rhoubi', 'médiathèque', 'Gestion d’une médiathèque', 'La médiathèque est conçue pour faciliter la gestion des ressources culturelles, incluant des livres, des films, de la musique et d’autres médias. Le projet permet la recherche, l’emprunt et la gestion des utilisateurs pour une expérience fluide et efficace.', 'Culture', b'1', 'Accepted', 2, 'closure', '2024-05-02 00:00:00', 5),
(3, 3, 'mohamed_rifai', 'admin_collège', 'Gestion administrative d’un collège', 'Ce projet vise à optimiser la gestion administrative d’un collège, couvrant les inscriptions, les horaires, les notes et les communications entre étudiants et enseignants. L’objectif est de simplifier les processus administratifs et éducatifs.', 'Éducation', b'1', 'Accepted', 3, 'creation', '2024-05-03 00:00:00', 7),
(4, 4, 'mohamed_elghabouri', 'Agence_rec', 'Agence de recrutement', 'Le projet Agence de recrutement fournit des outils pour la gestion des candidats, des offres d’emploi et des processus de sélection. Il aide les recruteurs à trouver les meilleurs talents et à gérer les candidatures de manière efficace et organisée.', 'Ressources Humaines', b'1', 'Accepted', 4, 'closure', '2024-05-04 00:00:00', 9),
(5, 5, 'chaimae_afyf', 'stages_ese', 'Gestion de l’attribution de stages en entreprise', 'Ce projet gère l’attribution de stages en entreprise, en facilitant les connexions entre étudiants et employeurs. Les fonctionnalités incluent la recherche de stages, la soumission de candidatures et la gestion des accords de stage.', 'Éducation', b'1', 'Accepted', 5, 'creation', '2024-05-05 00:00:00', 11),
(6, 6, 'abdelghani_elbakkali', 'docBibilo', 'Gestion des documents d’une Bibliothèque municipale', 'Le projet docBibilo se concentre sur la gestion des documents d’une bibliothèque municipale, permettant aux utilisateurs d’accéder à un large éventail de ressources, de réserver des livres en ligne et de gérer leurs emprunts et retours.', 'Culture', b'1', 'Accepted', 6, 'closure', '2024-05-06 00:00:00', 13),
(7, 7, 'yahya_errame', 'billets_avions', 'Réservation de billets d’avions en ligne', 'Ce projet offre une plateforme pour la réservation de billets d’avion en ligne, incluant la recherche de vols, la comparaison des prix, et la réservation de billets. Il vise à simplifier le processus de planification de voyages aériens.', 'Tourisme', b'1', 'Accepted', 7, 'creation', '2024-05-07 00:00:00', 15),
(8, 8, 'yasser_moujtahid', 'matériel_IT', 'Création d’un site de vente de matériels Informatiques', 'Le projet matériel IT crée un site de vente en ligne de matériels informatiques, proposant une vaste gamme de produits technologiques. Les utilisateurs peuvent rechercher, comparer et acheter des équipements informatiques facilement et rapidement.', 'Technologie', b'1', 'Accepted', 8, 'closure', '2024-05-08 00:00:00', 17),
(9, 9, 'oubeza_idir', 'Gest_personnel', 'Gestion des personnels', 'Ce projet de gestion des personnels est destiné à centraliser les informations sur les employés, gérer les horaires, les congés et les performances. Il vise à améliorer l’efficacité des ressources humaines au sein de l’organisation.', 'Ressources Humaines', b'1', 'Accepted', 9, 'creation', '2024-05-09 00:00:00', 19),
(20, 29, 'youssef_benali', 'eco_friendly', 'Eco-Friendly Initiatives', 'Ce projet vise à promouvoir des initiatives écologiques et durables au sein de la communauté en organisant des événements de sensibilisation, des ateliers et des campagnes de recyclage.', 'Environment', b'1', 'Refused', NULL, 'creation', '2024-05-25 10:00:00', NULL),
(21, 30, 'asmaa_elkhattabi', 'online_education', 'Online Education Platform', 'Une plateforme dédiée à la fourniture de ressources éducatives en ligne pour tous les niveaux scolaires, incluant des cours interactifs, des évaluations et des forums de discussion.', 'Education', b'1', 'Refused', NULL, 'creation', '2024-05-25 11:00:00', NULL),
(22, 31, 'mehdi_ouazzani', 'healthcare_app', 'Healthcare Management App', 'Une application mobile pour la gestion des rendez-vous médicaux et des dossiers patients, facilitant la communication entre les médecins et les patients et offrant des rappels de rendez-vous.', 'Health', b'0', 'Pending', NULL, 'creation', '2024-05-25 12:00:00', NULL),
(24, 33, 'nabil_fassi', 'startup_hub', 'Startup Hub', 'Un incubateur virtuel pour les startups, fournissant des ressources, des mentorats et des opportunités de réseautage pour aider les jeunes entrepreneurs à développer leurs idées et à lancer leurs entreprises.', 'Business', b'1', 'Refused', NULL, 'creation', '2024-05-25 14:00:00', NULL),
(25, 34, 'salma_rachidi', 'fitness_app', 'Fitness and Wellness App', 'Une application mobile dédiée à la forme physique et au bien-être, proposant des programmes d’entraînement personnalisés, des conseils nutritionnels et des suivis de performances.', 'Health', b'1', 'Pending', NULL, 'creation', '2024-05-25 15:00:00', NULL),
(26, 35, 'ayoub_hadidi', 'tech_blog', 'Tech Blog', 'Un blog dédié aux dernières tendances technologiques, offrant des articles, des tutoriels et des revues de produits pour les amateurs de technologie.', 'Technology', b'0', 'Pending', NULL, 'creation', '2024-05-25 16:00:00', NULL),
(27, 36, 'iman_bouazza', 'food_delivery', 'Food Delivery Service', 'Une plateforme en ligne pour la livraison de repas, permettant aux utilisateurs de commander des plats de leurs restaurants préférés et de suivre leurs commandes en temps réel.', 'Food', b'1', 'Refused', NULL, 'creation', '2024-05-25 17:00:00', NULL),
(28, 37, 'amine_jouti', 'book_club', 'Virtual Book Club', 'Un club de lecture en ligne où les membres peuvent discuter de leurs livres préférés, participer à des sessions de lecture en direct et accéder à des critiques littéraires.', 'Education', b'1', 'Pending', NULL, 'creation', '2024-05-25 18:00:00', NULL),
(29, 38, 'laila_soufi', 'travel_planner', 'Travel Planner App', 'Une application mobile pour la planification de voyages, offrant des outils pour créer des itinéraires personnalisés, réserver des billets et des hébergements, et explorer des destinations.', 'Travel', b'0', 'Pending', NULL, 'creation', '2024-05-25 19:00:00', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `IdDocument` int(10) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `contenu` blob DEFAULT NULL,
  `IdProjet` int(10) NOT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `Document_type` enum('src','web') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`IdDocument`, `titre`, `contenu`, `IdProjet`, `extension`, `Document_type`) VALUES
(118, 'Rapport de Recherche 2024', NULL, 1, '.docx', 'web'),
(119, 'Article sur les Particules', NULL, 1, '.html', 'web'),
(120, 'Code de Simulation', NULL, 1, '.css', 'src'),
(121, 'Notes de Recherche', NULL, 1, '.java', 'src'),
(122, 'Catalogue des Nouveautés', NULL, 2, '.docx', 'web'),
(123, 'Page d\'Accueil', NULL, 2, '.docx', 'web'),
(124, 'Script de Gestion', NULL, 2, '.py', 'src'),
(125, 'Design CSS', NULL, 2, '.css', 'src'),
(126, 'Règlement Intérieur', NULL, 3, '.docx', 'web'),
(127, 'Interface Web', NULL, 3, '.docx', 'web'),
(128, 'Script de Gestion des Notes', NULL, 3, '.css', 'src'),
(129, 'Application Java', NULL, 3, '.txt', 'src'),
(130, 'Guide du Recruteur', NULL, 4, '.docx', 'web'),
(131, 'Page de Profil', NULL, 4, '.docx', 'web'),
(132, 'Script de Sélection', NULL, 4, '.py', 'src'),
(133, 'Fichier Java', NULL, 4, '.java', 'src'),
(134, 'Guide de Stage', NULL, 5, '.docx', 'web'),
(135, 'Page de Recherche', NULL, 5, '.html', 'web'),
(136, 'Script de Gestion de Stages', NULL, 5, '.css', 'src'),
(137, 'Application Java', NULL, 5, '.txt', 'src'),
(138, 'Catalogue des Livres', NULL, 6, '.docx', 'web'),
(139, 'Page de Consultation', NULL, 6, '.html', 'web'),
(140, 'Script de Gestion des Livres', NULL, 6, '.css', 'src'),
(141, 'Application Java', NULL, 6, '.java', 'src'),
(142, 'Guide de Réservation', NULL, 7, '.docx', 'web'),
(143, 'Page de Réservation', NULL, 7, '.html', 'web'),
(144, 'Script de Gestion des Réservations', NULL, 7, '.py', 'src'),
(145, 'Application Java', NULL, 7, '.java', 'src');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `IdEvenement` int(10) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `heure` time NOT NULL DEFAULT current_timestamp(),
  `titre_evenement` varchar(255) NOT NULL,
  `description_evenement` text NOT NULL,
  `IdProjet` int(10) DEFAULT NULL,
  `IdUtilisateur` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`IdEvenement`, `date`, `heure`, `titre_evenement`, `description_evenement`, `IdProjet`, `IdUtilisateur`) VALUES
(10, '2024-06-01', '12:00:00', 'Présentation des Résultats de Recherche', 'Présentation des derniers résultats de recherche sur les particules subatomiques.', 1, 1),
(11, '2024-06-15', '14:00:00', 'Conférence sur la Physique Quantique', 'Conférence avec des experts sur les avancées en physique quantique.', 1, 2),
(12, '2024-07-01', '16:00:00', 'Atelier de Simulation', 'Atelier pratique sur la simulation des interactions de particules.', 1, 3),
(13, '2024-06-05', '10:00:00', 'Inauguration de la Nouvelle Section', 'Inauguration de la nouvelle section dédiée aux livres de science-fiction.', 2, 2),
(14, '2024-06-20', '11:00:00', 'Atelier de Lecture pour Enfants', 'Atelier de lecture pour enfants avec des auteurs invités.', 2, 3),
(15, '2024-07-05', '15:00:00', 'Séance de Dédicace', 'Séance de dédicace avec des auteurs locaux.', 2, 1),
(16, '2024-06-10', '09:00:00', 'Réunion de Préparation aux Examens', 'Réunion avec les enseignants pour préparer les examens de fin d’année.', 3, 3),
(17, '2024-06-25', '13:00:00', 'Journée Portes Ouvertes', 'Journée portes ouvertes pour présenter les installations du collège.', 3, 1),
(18, '2024-07-10', '10:00:00', 'Formation des Enseignants', 'Formation sur les nouvelles méthodes pédagogiques pour les enseignants.', 3, 2),
(19, '2024-06-15', '11:00:00', 'Salon de l’Emploi', 'Salon de l’emploi pour mettre en relation recruteurs et candidats.', 4, 1),
(20, '2024-07-01', '14:00:00', 'Atelier de Rédaction de CV', 'Atelier pour aider les candidats à rédiger des CV efficaces.', 4, 2),
(21, '2024-07-15', '09:00:00', 'Session de Coaching', 'Session de coaching pour les candidats en recherche d’emploi.', 4, 3),
(22, '2024-06-05', '08:00:00', 'Rencontre avec les Entreprises', 'Rencontre entre les étudiants et les entreprises proposant des stages.', 5, 2),
(23, '2024-06-20', '12:00:00', 'Atelier de Préparation aux Stages', 'Atelier pour préparer les étudiants à leurs futurs stages.', 5, 3),
(24, '2024-07-05', '16:00:00', 'Retour d’Expérience', 'Retour d’expérience des étudiants ayant terminé leurs stages.', 5, 1),
(25, '2024-06-10', '09:00:00', 'Présentation du Nouveau Catalogue', 'Présentation du nouveau catalogue de la bibliothèque.', 6, 1),
(26, '2024-06-25', '14:00:00', 'Atelier de Numérisation', 'Atelier sur la numérisation des documents.', 6, 2),
(27, '2024-07-10', '11:00:00', 'Formation à la Gestion des Livres', 'Formation sur les nouvelles méthodes de gestion des livres.', 6, 3),
(28, '2024-06-15', '10:00:00', 'Lancement de la Nouvelle Interface', 'Présentation de la nouvelle interface de réservation en ligne.', 7, 2),
(29, '2024-07-01', '12:00:00', 'Atelier de Réservation', 'Atelier pour apprendre à utiliser le système de réservation en ligne.', 7, 3),
(30, '2024-07-15', '15:00:00', 'Retour d’Expérience des Utilisateurs', 'Session pour recueillir les retours d’expérience des utilisateurs.', 7, 1),
(31, '2024-06-05', '11:00:00', 'Présentation des Nouveaux Produits', 'Présentation des nouveaux produits disponibles à la vente.', 8, 3),
(32, '2024-06-20', '13:00:00', 'Atelier de Configuration', 'Atelier sur la configuration des nouveaux équipements informatiques.', 8, 1),
(33, '2024-07-05', '14:00:00', 'Session de Formation', 'Session de formation sur l’utilisation des nouveaux matériels.', 8, 2),
(34, '2024-06-10', '10:00:00', 'Réunion des RH', 'Réunion pour discuter des nouvelles politiques RH.', 9, 2),
(35, '2024-06-25', '15:00:00', 'Session de Formation RH', 'Session de formation pour le département des ressources humaines.', 9, 3),
(36, '2024-07-10', '09:00:00', 'Atelier de Bien-être au Travail', 'Atelier sur le bien-être au travail pour les employés.', 9, 1);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `IdGroupe` int(20) NOT NULL,
  `nom_groupe` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`IdGroupe`, `nom_groupe`) VALUES
(1, 'Admin'),
(2, 'Pscientifiques'),
(3, 'Pscientifiques-adm'),
(4, 'médiathèque'),
(5, 'médiathèque-adm'),
(6, 'admin_collège'),
(7, 'admin_collège-adm'),
(8, 'Agence_rec'),
(9, 'Agence_rec-adm'),
(10, 'stages_ese'),
(11, 'stages_ese-adm'),
(12, 'docBibilo'),
(13, 'docBibilo-adm'),
(14, 'billets_avions'),
(15, 'billets_avions-adm'),
(16, 'matériel_IT'),
(17, 'matériel_IT-adm'),
(18, 'Gest_personnel'),
(19, 'Gest_personnel-adm');

-- --------------------------------------------------------

--
-- Structure de la table `invitation_demande`
--

CREATE TABLE `invitation_demande` (
  `Invitation_Id` int(11) NOT NULL,
  `host` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `IdGroupe` int(11) NOT NULL,
  `IdProject` int(11) NOT NULL,
  `nom_Projet` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  `etat` enum('Accepted','Refused','Pending','') NOT NULL,
  `type` enum('invitation','demande','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `invitation_demande`
--

INSERT INTO `invitation_demande` (`Invitation_Id`, `host`, `user`, `IdGroupe`, `IdProject`, `nom_Projet`, `date`, `etat`, `type`) VALUES
(10, 'zakariae_aboussad', 'youssef_benali', 2, 1, 'Pscientifiques', '2024-05-25 10:00:00', 'Pending', 'invitation'),
(11, 'ibtissam_rhoubi', 'asmaa_elkhattabi', 4, 2, 'médiathèque', '2024-05-25 11:00:00', 'Pending', 'demande'),
(12, 'mohamed_rifai', 'mehdi_ouazzani', 6, 3, 'admin_collège', '2024-05-25 12:00:00', 'Pending', 'invitation'),
(13, 'mohamed_elghabouri', 'karima_tazi', 8, 4, 'Agence_rec', '2024-05-25 13:00:00', 'Pending', 'demande'),
(14, 'chaimae_afyf', 'nabil_fassi', 10, 5, 'stages_ese', '2024-05-25 14:00:00', 'Pending', 'invitation'),
(15, 'abdelghani_elbakkali', 'salma_rachidi', 12, 6, 'docBibilo', '2024-05-25 15:00:00', 'Pending', 'demande'),
(16, 'yahya_errame', 'ayoub_hadidi', 14, 7, 'billets_avions', '2024-05-25 16:00:00', 'Pending', 'invitation'),
(17, 'yasser_moujtahid', 'iman_bouazza', 16, 8, 'matériel_IT', '2024-05-25 17:00:00', 'Pending', 'demande'),
(18, 'oubeza_idir', 'amine_jouti', 18, 9, 'Gest_personnel', '2024-05-25 18:00:00', 'Pending', 'invitation'),
(19, 'abdel_sawadogo', 'laila_soufi', 20, 10, 'un_autre_projet', '2024-05-25 19:00:00', 'Pending', 'demande');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `IdMessage` int(11) NOT NULL,
  `idSender` int(11) DEFAULT NULL,
  `idReceiver` int(255) DEFAULT NULL,
  `date_envoi` date NOT NULL,
  `heure_envoi` time NOT NULL,
  `contenu` text NOT NULL,
  `idGroup` int(11) DEFAULT NULL,
  `idProjet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`IdMessage`, `idSender`, `idReceiver`, `date_envoi`, `heure_envoi`, `contenu`, `idGroup`, `idProjet`) VALUES
(1, 1, 2, '2024-05-01', '10:00:00', 'Nous devons préparer la publication du prochain article scientifique pour la revue de juin. Assurez-vous que toutes les révisions sont complétées. Des suggestions ?', 2, 1),
(2, 2, 3, '2024-05-02', '11:00:00', 'Nouveaux livres arrivés. Mettez à jour le catalogue.', 4, 2),
(3, 3, 4, '2024-05-03', '12:00:00', 'Finalisez les horaires des examens pour ce semestre. Vérifiez les informations avant vendredi.', 6, 3),
(4, 4, 5, '2024-05-04', '13:00:00', 'Revoir les nouveaux candidats pour les postes ouverts et programmer des entretiens dès que possible.', 8, 4),
(5, 5, 6, '2024-05-05', '14:00:00', 'Les étudiants doivent soumettre leurs rapports de stage avant la fin du mois. Rappel ?', 10, 5),
(6, 6, 7, '2024-05-06', '15:00:00', 'Mise à jour du système de gestion de la bibliothèque. Sauvegardez les données avant de procéder.', 12, 6),
(7, 7, 8, '2024-05-07', '16:00:00', 'Réservations de vols pour les vacances ouvertes. Vérifiez les disponibilités et les offres.', 14, 7),
(8, 8, 9, '2024-05-08', '17:00:00', 'Stock de nouveaux matériels informatiques à mettre à jour sur le site. Vérifiez les descriptions.', 16, 8),
(9, 9, 1, '2024-05-09', '18:00:00', 'Le nouveau règlement du personnel doit être diffusé. Assurez-vous que chaque membre signe l’accusé de réception.', 18, 9);

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `IdProjet` int(20) NOT NULL,
  `nom_court` varchar(255) NOT NULL,
  `nom_long` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `theme` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `isPublic` bit(1) NOT NULL,
  `etat` enum('Enabled','Closed') DEFAULT NULL,
  `date_creation` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`IdProjet`, `nom_court`, `nom_long`, `description`, `theme`, `type`, `isPublic`, `etat`, `date_creation`) VALUES
(1, 'Pscientifiques', 'Gestion des publications scientifiques', 'Ce projet se concentre sur la gestion des publications scientifiques, offrant une plateforme pour organiser, partager et accéder aux travaux de recherche. Les fonctionnalités incluent la gestion des auteurs, des articles, des revues et des conférences scientifiques.', 'Scientifique', 'Scientifique', b'1', 'Enabled', '2024-03-14'),
(2, 'médiathèque', 'Gestion d’une médiathèque', 'La médiathèque est conçue pour faciliter la gestion des ressources culturelles, incluant des livres, des films, de la musique et d’autres médias. Le projet permet la recherche, l’emprunt et la gestion des utilisateurs pour une expérience fluide et efficace.', 'Culture', 'Scientifique', b'1', 'Closed', '2024-02-19'),
(3, 'admin_collège', 'Gestion administrative d’un collège', 'Ce projet vise à optimiser la gestion administrative d’un collège, couvrant les inscriptions, les horaires, les notes et les communications entre étudiants et enseignants. L’objectif est de simplifier les processus administratifs et éducatifs.', 'Éducation', 'Scientifique', b'1', 'Enabled', '2024-01-30'),
(4, 'Agence_rec', 'Agence de recrutement', 'Le projet Agence de recrutement fournit des outils pour la gestion des candidats, des offres d’emploi et des processus de sélection. Il aide les recruteurs à trouver les meilleurs talents et à gérer les candidatures de manière efficace et organisée.', 'Ressources Humaines', 'Scientifique', b'1', 'Closed', '2024-04-07'),
(5, 'stages_ese', 'Gestion de l’attribution de stages en entreprise', 'Ce projet gère l’attribution de stages en entreprise, en facilitant les connexions entre étudiants et employeurs. Les fonctionnalités incluent la recherche de stages, la soumission de candidatures et la gestion des accords de stage.', 'Éducation', 'Scientifique', b'1', 'Enabled', '2024-01-01'),
(6, 'docBibilo', 'Gestion des documents d’une Bibliothèque municipale', 'Le projet docBibilo se concentre sur la gestion des documents d’une bibliothèque municipale, permettant aux utilisateurs d’accéder à un large éventail de ressources, de réserver des livres en ligne et de gérer leurs emprunts et retours.', 'Culture', 'Scientifique', b'1', 'Closed', '2024-01-09'),
(7, 'billets_avions', 'Réservation de billets d’avions en ligne', 'Ce projet offre une plateforme pour la réservation de billets d’avion en ligne, incluant la recherche de vols, la comparaison des prix, et la réservation de billets. Il vise à simplifier le processus de planification de voyages aériens.', 'Tourisme', 'Scientifique', b'1', 'Enabled', '2024-05-07'),
(8, 'matériel_IT', 'Création d’un site de vente de matériels Informatiques', 'Le projet matériel IT crée un site de vente en ligne de matériels informatiques, proposant une vaste gamme de produits technologiques. Les utilisateurs peuvent rechercher, comparer et acheter des équipements informatiques facilement et rapidement.', 'Technologie', 'Scientifique', b'1', 'Closed', '2024-03-16'),
(9, 'Gest_personnel', 'Gestion des personnels', 'Ce projet de gestion des personnels est destiné à centraliser les informations sur les employés, gérer les horaires, les congés et les performances. Il vise à améliorer l’efficacité des ressources humaines au sein de l’organisation.', 'Ressources Humaines', 'Scientifique', b'1', 'Enabled', '2023-12-24');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `IdUtilisateur` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `derniere_date_connexion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IdUtilisateur`, `username`, `nom`, `prenom`, `email`, `mot_de_passe`, `derniere_date_connexion`) VALUES
(1, 'zakariae_aboussad', 'ABOUSSAAD', 'Zakariae', 'zakariae.aboussad@example.com', 'password123', '2024-05-02 00:00:00'),
(2, 'ibtissam_rhoubi', 'RHOUBI', 'Ibtissam', 'ibtissam.rhoubi@example.com', 'ibtissam_rhoubi', '2024-05-10 00:00:00'),
(3, 'mohamed_rifai', 'RIFAI', 'Mohamed', 'mohamed.rifai@example.com', 'incorrectpassword', '2024-05-02 00:00:00'),
(4, 'mohamed_elghabouri', 'ELGHABOURI', 'Mohamed', 'mohamed.elghabouri@example.com', 'hahahahaha', '2024-05-20 00:00:00'),
(5, 'chaimae_afyf', 'AFYF', 'Chaimae', 'chaimae.ayfi@example.com', 'password123', '2024-05-02 00:00:00'),
(6, 'abdelghani_elbakkali', 'ELBAKKALI', 'Abdelghani', 'abdelghani.elbakkali@example.com', '202020202020', '2024-05-02 00:00:00'),
(7, 'yahya_errame', 'ERRAME', 'Yahya', 'meriem.errayme@example.com', 'password123', '2024-05-02 00:00:00'),
(8, 'yasser_moujtahid', 'MOUJTAHID', 'Yasser', 'hamza.laabal@example.com', 'Codecraft', '2024-05-02 00:00:00'),
(9, 'oubeza_idir', 'IDIR', 'Oubeza', 'oubeza.idir@example.com', 'passwordvalid', '2024-05-19 04:05:16'),
(10, 'abdel_sawadogo', 'abdel', 'sawadogo', 'abdel@example.com', 'az456', '2024-05-22 00:00:00'),
(11, 'oulaid_raidi', 'RAIDI', 'Oulaid', 'oulaid.raidi@example.com', 'toto123', '2024-05-06 00:00:00'),
(12, 'marwa_boubernous', 'BOUBERNOUS', 'Marwa', 'marwa.boubernous@example.com', '00000000', '2024-05-06 00:00:00'),
(13, 'othmane_kabbar', 'KABBAR', 'Othmane', 'othmane.kabbar@example.com', 'password123', '2024-05-06 00:00:00'),
(14, 'hamza_laabali', 'LAABALI', 'Hamza', 'hamza.laabali@example.com', '123456789', '2024-05-06 00:00:00'),
(15, 'anime_abbach', 'ABBACH', 'Anime Ahmed', 'anime.abbach@example.com', '101010101', '0000-00-00 00:00:00'),
(16, 'ismail_isaili', 'ISAILI', 'Ismail', 'ismail.isaili@example.com', '111111111', '0000-00-00 00:00:00'),
(17, 'oumaima_lguhibi', 'LGUHIBI', 'Oumaima', 'oumaima.lguhibi@example.com', '111100110', '0000-00-00 00:00:00'),
(18, 'oumaima_ouchlih', 'OUCHLIH', 'Oumaima', 'oumaima.ouchlih@example.com', '8d0867a102c117494936b8a6f5f273b6', '0000-00-00 00:00:00'),
(19, 'ahmed_asali', 'ASALI', 'Ahmed', 'ahmed.asali@example.com', '7f63b050d085ad7577da199ce8b85d4b', '0000-00-00 00:00:00'),
(20, 'safae_matin', 'MATIN', 'Safae', 'safae.matin@example.com', '1e4a74d62b8b30b55a8ce1ca793f6001', '0000-00-00 00:00:00'),
(21, 'fatima_ahguine', 'AHGUINE', 'Fatima', 'fatima.ahguine@example.com', 'fe5302e52a4fd6c76cfb31ac446f1c7c', '0000-00-00 00:00:00'),
(22, 'zouhair_toufani', 'TOUFANI', 'Zouhair', 'zouhair.toufani@example.com', 'c685030f4894e9692891540b9e7f188e', '0000-00-00 00:00:00'),
(23, 'hiba_rhandour', 'RHANDOUR', 'Hiba', 'hiba.rhandour@example.com', 'a4281da200dfdac5f511dc20eda5e01b', '0000-00-00 00:00:00'),
(24, 'zakariae_zemat', 'ZEMAT', 'Zakariae', 'zakariae.zemat@example.com', '8cf8de45e0b99010b0eccfd2abf4ac41', '0000-00-00 00:00:00'),
(29, 'youssef_benali', 'BENALI', 'Youssef', 'youssef.benali@example.com', 'password123', '2024-05-25 00:00:00'),
(30, 'asmaa_elkhattabi', 'ELKHATTABI', 'Asmaa', 'asmaa.elkhattabi@example.com', 'password123', '2024-05-25 00:00:00'),
(31, 'mehdi_ouazzani', 'OUAZZANI', 'Mehdi', 'mehdi.ouazzani@example.com', 'password123', '2024-05-25 00:00:00'),
(32, 'karima_tazi', 'TAZI', 'Karima', 'karima.tazi@example.com', 'password123', '2024-05-25 00:00:00'),
(33, 'nabil_fassi', 'FASSI', 'Nabil', 'nabil.fassi@example.com', 'password123', '2024-05-25 00:00:00'),
(34, 'salma_rachidi', 'RACHIDI', 'Salma', 'salma.rachidi@example.com', 'password123', '2024-05-25 00:00:00'),
(35, 'ayoub_hadidi', 'HADIDI', 'Ayoub', 'ayoub.hadidi@example.com', 'password123', '2024-05-25 00:00:00'),
(36, 'iman_bouazza', 'BOUAZZA', 'Iman', 'iman.bouazza@example.com', 'password123', '2024-05-25 00:00:00'),
(37, 'amine_jouti', 'JOUTI', 'Amine', 'amine.jouti@example.com', 'password123', '2024-05-25 00:00:00'),
(38, 'laila_soufi', 'SOUFI', 'Laila', 'laila.soufi@example.com', 'password123', '2024-05-25 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_groupe`
--

CREATE TABLE `utilisateur_groupe` (
  `IdUtilisateur` int(20) NOT NULL,
  `IdGroupe` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `utilisateur_groupe`
--

INSERT INTO `utilisateur_groupe` (`IdUtilisateur`, `IdGroupe`) VALUES
(1, 3),
(2, 5),
(3, 7),
(4, 2),
(4, 9),
(5, 11),
(6, 4),
(6, 13),
(7, 15),
(8, 6),
(8, 17),
(9, 19),
(10, 8),
(12, 10),
(14, 12),
(16, 14),
(18, 16),
(20, 18),
(21, 2),
(22, 3),
(23, 4),
(24, 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrateur_plateforme`
--
ALTER TABLE `administrateur_plateforme`
  ADD PRIMARY KEY (`IdAdministrateur`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`IdDemande`),
  ADD KEY `IdUtilisateur` (`IdUtilisateur`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`IdDocument`),
  ADD KEY `IdProjet` (`IdProjet`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`IdEvenement`),
  ADD KEY `IdProjet` (`IdProjet`),
  ADD KEY `IdUtilisateur` (`IdUtilisateur`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`IdGroupe`);

--
-- Index pour la table `invitation_demande`
--
ALTER TABLE `invitation_demande`
  ADD PRIMARY KEY (`Invitation_Id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`IdMessage`),
  ADD KEY `idSender` (`idSender`),
  ADD KEY `idReceiver` (`idReceiver`),
  ADD KEY `idGroup` (`idGroup`),
  ADD KEY `idProjet` (`idProjet`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`IdProjet`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`IdUtilisateur`);

--
-- Index pour la table `utilisateur_groupe`
--
ALTER TABLE `utilisateur_groupe`
  ADD PRIMARY KEY (`IdUtilisateur`,`IdGroupe`),
  ADD KEY `IdGroupe` (`IdGroupe`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `administrateur_plateforme`
--
ALTER TABLE `administrateur_plateforme`
  MODIFY `IdAdministrateur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `IdDemande` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT pour la table `document`
--
ALTER TABLE `document`
  MODIFY `IdDocument` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `IdEvenement` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `IdGroupe` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `invitation_demande`
--
ALTER TABLE `invitation_demande`
  MODIFY `Invitation_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `IdMessage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `IdProjet` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `IdUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `demande_ibfk_1` FOREIGN KEY (`IdUtilisateur`) REFERENCES `utilisateur` (`IdUtilisateur`);

--
-- Contraintes pour la table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `document_ibfk_1` FOREIGN KEY (`IdProjet`) REFERENCES `projet` (`IdProjet`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`IdProjet`) REFERENCES `projet` (`IdProjet`),
  ADD CONSTRAINT `evenement_ibfk_2` FOREIGN KEY (`IdUtilisateur`) REFERENCES `utilisateur` (`IdUtilisateur`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`idSender`) REFERENCES `utilisateur` (`IdUtilisateur`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`idReceiver`) REFERENCES `utilisateur` (`IdUtilisateur`),
  ADD CONSTRAINT `message_ibfk_3` FOREIGN KEY (`idGroup`) REFERENCES `groupe` (`IdGroupe`),
  ADD CONSTRAINT `message_ibfk_4` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`IdProjet`);

--
-- Contraintes pour la table `utilisateur_groupe`
--
ALTER TABLE `utilisateur_groupe`
  ADD CONSTRAINT `utilisateur_groupe_ibfk_1` FOREIGN KEY (`IdUtilisateur`) REFERENCES `utilisateur` (`IdUtilisateur`),
  ADD CONSTRAINT `utilisateur_groupe_ibfk_2` FOREIGN KEY (`IdGroupe`) REFERENCES `groupe` (`IdGroupe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
