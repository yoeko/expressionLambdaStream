Etape 1: Récupérer le projet
- Allez a l'adresse web suivante:	https://github.com/zeushias/GestionEnsupV2
- Cliquez sur le bouton "Clone or Download" et appuyez sur le bouton "Download ZIP"
- Faites un extract de l'archive dans le dossier de votre choix

Etape 2: Mettre en place la base de donnée:
- Si vous n'avez pas d'éditeurs SQL, installez en un (HeidiSql, DBeaver, etc ...)
- Une fois l'éditeur installé, copiez/collez les requettes suivantes (*) et executez les.


Etape 3: Parametrer l'executable
- Ouvrez le fichier lunch.bat et modifiez les lignes suivantes:
	 cd "C:\Program Files\Java\jdk1.8.0_162\bin" 	
		=> Changer le texte entre guillemets pour indiquer le chemin vers votre JDK

	"C:\Users\zeuhias\eclipse-workspace\EtudiantEcole-master\EtudiantEcole.jar" 
		=> Changer le texte entre quote pour indiquer le chemin vers le fichier .jar

Etape 4: Lancer le logiciel
- Executez le fichier lunch.bat.



(*) Code SQL a executer:
  
-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 06 Mars 2020 à 09:39
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ges_ecole_ensup`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `idCours` int(11) NOT NULL,
  `theme` varchar(255) NOT NULL,
  `nombreHeure` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

CREATE TABLE `ecole` (
  `idEcole` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `directeur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `idPersonne` int(11) NOT NULL,
  `idEcole` int(11) DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `telephone` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `date_naissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne_cours`
--

CREATE TABLE `personne_cours` (
  `id` int(11) NOT NULL,
  `idPersonne` int(11) NOT NULL,
  `idCours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUser` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `profil` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`idCours`);

--
-- Index pour la table `ecole`
--
ALTER TABLE `ecole`
  ADD PRIMARY KEY (`idEcole`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD KEY `ecole_personne` (`idEcole`);

--
-- Index pour la table `personne_cours`
--
ALTER TABLE `personne_cours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `personne_cours` (`idPersonne`),
  ADD KEY `cours_personne` (`idCours`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `idCours` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `ecole`
--
ALTER TABLE `ecole`
  MODIFY `idEcole` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personne_cours`
--
ALTER TABLE `personne_cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `ecole_personne` FOREIGN KEY (`idEcole`) REFERENCES `ecole` (`idEcole`);

--
-- Contraintes pour la table `personne_cours`
--
ALTER TABLE `personne_cours`
  ADD CONSTRAINT `cours_personne` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`),
  ADD CONSTRAINT `personne_cours` FOREIGN KEY (`idPersonne`) REFERENCES `personne` (`idPersonne`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
