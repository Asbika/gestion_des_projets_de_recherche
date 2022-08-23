-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 06 juin 2022 à 00:41
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_des_projets_de_recherche`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartenir`
--

CREATE TABLE `appartenir` (
  `id_Appartenir` int(11) NOT NULL,
  `Id_Utilisateur` int(11) NOT NULL,
  `Id_Projet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `appartenir`
--

INSERT INTO `appartenir` (`id_Appartenir`, `Id_Utilisateur`, `Id_Projet`) VALUES
(77, 85, 126),
(78, 87, 126),
(80, 85, 128),
(81, 88, 128),
(82, 85, 129);

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `IdDemande` int(11) NOT NULL,
  `NomCourt` varchar(30) NOT NULL,
  `NomLong` varchar(40) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `Theme` varchar(30) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Licence` varchar(30) NOT NULL,
  `Visibilite` varchar(30) NOT NULL,
  `TypeDemande` varchar(30) NOT NULL,
  `estAccepte` int(11) DEFAULT 0,
  `traitement` int(11) DEFAULT 0,
  `Id_Utilisateur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `demande`
--

INSERT INTO `demande` (`IdDemande`, `NomCourt`, `NomLong`, `Description`, `Theme`, `Type`, `Licence`, `Visibilite`, `TypeDemande`, `estAccepte`, `traitement`, `Id_Utilisateur`) VALUES
(63, 'inwi', 'Inwi76FG5', 'logiciel intra communication', 'rs180', 'logiciel', 'DF13462', 'public', 'creation', 1, 1, 85),
(66, 'GE', 'gestion des employés', 'metre en place une strategie donnee sous forme d\'application', 'logiciel', 'logiciel', 'REFT432468', 'public', 'creation', 1, 1, 85),
(68, 'inwi', 'Inwi76FG5', 'logiciel intra communication', 'rs180', 'logiciel', 'DF13462', 'public', 'suppression', 0, 1, 85),
(69, 'LC', 'Logiciel comptabilité', 'gestion financier', 'Logiciel ', 'logiciel', 'RFG76566E', 'public', 'creation', 1, 1, 85);

-- --------------------------------------------------------

--
-- Structure de la table `groupes`
--

CREATE TABLE `groupes` (
  `Id_Groupe` int(11) NOT NULL,
  `Nom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `groupes`
--

INSERT INTO `groupes` (`Id_Groupe`, `Nom`) VALUES
(150, 'inwi'),
(151, 'inwi-adm'),
(154, 'GE'),
(155, 'GE-adm'),
(156, 'LC'),
(157, 'LC-adm');

-- --------------------------------------------------------

--
-- Structure de la table `guests`
--

CREATE TABLE `guests` (
  `Id_Guest` int(11) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `MotDePasse` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `integrer`
--

CREATE TABLE `integrer` (
  `Id_Utilisateur` int(11) NOT NULL,
  `Id_Groupe` int(11) NOT NULL,
  `Responsabilite` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `integrer`
--

INSERT INTO `integrer` (`Id_Utilisateur`, `Id_Groupe`, `Responsabilite`) VALUES
(85, 151, 'admin'),
(87, 150, 'member'),
(85, 155, 'admin'),
(88, 154, 'member'),
(85, 157, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `projets`
--

CREATE TABLE `projets` (
  `Id_Projet` int(11) NOT NULL,
  `NomCourt` varchar(30) NOT NULL,
  `NomLong` varchar(30) NOT NULL,
  `Description` varchar(4000) NOT NULL,
  `Theme` varchar(30) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Licence` varchar(30) NOT NULL,
  `Visibilite` varchar(30) NOT NULL,
  `Etat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `projets`
--

INSERT INTO `projets` (`Id_Projet`, `NomCourt`, `NomLong`, `Description`, `Theme`, `Type`, `Licence`, `Visibilite`, `Etat`) VALUES
(126, 'inwi', 'Inwi76FG5', 'logiciel intra communication', 'rs180', 'logiciel', 'DF13462', 'public', 'Actif'),
(127, 'nowChat', 'hgrt34e', 'test1', 'plateforme', 'logiciel', 'Rx8789', 'privé', 'clos'),
(128, 'GE', 'gestion des employés', 'metre en place une strategie donnee sous forme d\'application', 'logiciel', 'logiciel', 'REFT432468', 'public', 'Actif'),
(129, 'LC', 'Logiciel comptabilité', 'gestion financier', 'Logiciel ', 'logiciel', 'RFG76566E', 'public', 'Actif');

-- --------------------------------------------------------

--
-- Structure de la table `ressources`
--

CREATE TABLE `ressources` (
  `Id_Ressource` int(11) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `contenu` longtext DEFAULT NULL,
  `Id_Projet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ressources`
--

INSERT INTO `ressources` (`Id_Ressource`, `Type`, `contenu`, `Id_Projet`) VALUES
(147, 'ajenda-inwi', '', 126),
(148, 'liste-inwi', 'todo inwiProject : \n\n	12-->13 : \noo', 126),
(149, 'Src-inwi', NULL, 126),
(150, 'Web-inwi', NULL, 126),
(151, 'ajenda-nowChat', NULL, 127),
(152, 'liste-nowChat', NULL, 127),
(153, 'Src-nowChat', NULL, 127),
(154, 'Web-nowChat', NULL, 127),
(155, 'ajenda-GE', NULL, 128),
(156, 'liste-GE', NULL, 128),
(157, 'Src-GE', NULL, 128),
(158, 'Web-GE', NULL, 128),
(159, 'ajenda-LC', NULL, 129),
(160, 'liste-LC', NULL, 129),
(161, 'Src-LC', NULL, 129),
(162, 'Web-LC', NULL, 129);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `Id_Utilisateur` int(11) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `NomDUtilisateur` varchar(30) NOT NULL,
  `MotDePasse` varchar(30) NOT NULL,
  `Agenda` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`Id_Utilisateur`, `Nom`, `Prenom`, `Email`, `NomDUtilisateur`, `MotDePasse`, `Agenda`) VALUES
(85, 'asbika', 'hicham', 'asbika@gmail.com', 'asbika1', '123456', NULL),
(86, 'youssera', 'mansouri', 'mansouri@gmail.com', 'mansouri1', '123456', NULL),
(87, 'ihsane', 'nhairi', 'nhairi@gmail.com', 'nhairi', '123456', NULL),
(88, 'hamza', 'asri', 'asri@gmail.com', 'asri12', 'asri123', NULL),
(89, 'nassima', 'morabit', 'morabit@gmail.com', 'morabit45', 'morabitk45', NULL),
(90, 'aissa', 'mahmoud', 'mahmoud@gmail.com', 'mahmoud43', 'mahmoud321', NULL),
(91, 'akrami', 'ilyass', 'akrami@gmail.com', 'akrami7', '1234', NULL),
(92, 'misbah', 'nouaman', 'misbah@gmail.com', 'misbah23', '112233', NULL),
(93, 'mihdar', 'zineb', 'mihdar@hotmail.com', 'mihdar98', '123465', NULL),
(94, 'riah', 'roukaya', 'riah@gmail.com', 'riah3', '123456', NULL),
(95, 'maarouf', 'houssam', 'maarouf@gmail.com', 'maarouf6', '123456', NULL),
(96, 'hasni', 'nizar', 'nizar@gmail.com', 'nizar8', '12345', NULL),
(97, 'khalidi', 'mustapha', 'khalidi@gmail.com', 'khalidi', '987654', NULL),
(98, 'akouh', 'noura', 'akouh@gmail.com', 'akouh7', '12345', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD PRIMARY KEY (`id_Appartenir`),
  ADD KEY `Id_Projet` (`Id_Projet`),
  ADD KEY `Id_Utilisateur` (`Id_Utilisateur`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`IdDemande`),
  ADD KEY `Id_Utilisateur` (`Id_Utilisateur`);

--
-- Index pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`Id_Groupe`);

--
-- Index pour la table `guests`
--
ALTER TABLE `guests`
  ADD PRIMARY KEY (`Id_Guest`);

--
-- Index pour la table `integrer`
--
ALTER TABLE `integrer`
  ADD KEY `Id_Utilisateur` (`Id_Utilisateur`,`Id_Groupe`),
  ADD KEY `Id_Utilisateur_2` (`Id_Utilisateur`,`Id_Groupe`),
  ADD KEY `Id_Utilisateur_3` (`Id_Utilisateur`,`Id_Groupe`),
  ADD KEY `Id_Utilisateur_4` (`Id_Utilisateur`,`Id_Groupe`),
  ADD KEY `integrer_ibfk_2` (`Id_Groupe`);

--
-- Index pour la table `projets`
--
ALTER TABLE `projets`
  ADD PRIMARY KEY (`Id_Projet`);

--
-- Index pour la table `ressources`
--
ALTER TABLE `ressources`
  ADD PRIMARY KEY (`Id_Ressource`),
  ADD KEY `Id_Projet` (`Id_Projet`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`Id_Utilisateur`),
  ADD KEY `Id_Ressource` (`Agenda`(768)),
  ADD KEY `Id_Utilisateur` (`Id_Utilisateur`),
  ADD KEY `Id_Utilisateur_2` (`Id_Utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `appartenir`
--
ALTER TABLE `appartenir`
  MODIFY `id_Appartenir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `IdDemande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT pour la table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `Id_Groupe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=158;

--
-- AUTO_INCREMENT pour la table `guests`
--
ALTER TABLE `guests`
  MODIFY `Id_Guest` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projets`
--
ALTER TABLE `projets`
  MODIFY `Id_Projet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- AUTO_INCREMENT pour la table `ressources`
--
ALTER TABLE `ressources`
  MODIFY `Id_Ressource` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=163;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `Id_Utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD CONSTRAINT `appartenir_ibfk_1` FOREIGN KEY (`Id_Utilisateur`) REFERENCES `utilisateurs` (`Id_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appartenir_ibfk_2` FOREIGN KEY (`Id_Projet`) REFERENCES `projets` (`Id_Projet`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `demande_ibfk_1` FOREIGN KEY (`Id_Utilisateur`) REFERENCES `utilisateurs` (`Id_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `integrer`
--
ALTER TABLE `integrer`
  ADD CONSTRAINT `integrer_ibfk_1` FOREIGN KEY (`Id_Utilisateur`) REFERENCES `utilisateurs` (`Id_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `integrer_ibfk_2` FOREIGN KEY (`Id_Groupe`) REFERENCES `groupes` (`Id_Groupe`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `ressources`
--
ALTER TABLE `ressources`
  ADD CONSTRAINT `ressources_ibfk_1` FOREIGN KEY (`Id_Projet`) REFERENCES `projets` (`Id_Projet`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
