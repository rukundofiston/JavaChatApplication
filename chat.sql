-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Mer 30 Mai 2012 à 14:53
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `chat`
--

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur1` int(11) DEFAULT NULL,
  `idUtilisateur2` int(11) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `bloque` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `contact`
--

INSERT INTO `contact` (`ID`, `idUtilisateur1`, `idUtilisateur2`, `categorie`, `bloque`) VALUES
(1, 2, 3, 'amis', NULL),
(2, 2, 4, 'amis', NULL),
(3, 3, 2, 'amis', NULL),
(4, 3, 4, 'amis', NULL),
(5, 2, 8, NULL, 'non'),
(6, 8, 2, NULL, 'non'),
(7, 3, 8, NULL, 'non'),
(8, 8, 3, NULL, 'non'),
(9, 11, 12, NULL, 'non'),
(10, 12, 11, NULL, 'non'),
(11, 13, 12, NULL, 'non'),
(12, 12, 13, NULL, 'non');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idEmetteur` int(11) DEFAULT NULL,
  `idRecepteur` int(11) DEFAULT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `lu` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=62 ;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`ID`, `idEmetteur`, `idRecepteur`, `contenu`, `date`, `lu`) VALUES
(1, 3, 2, 'salam', '2012-05-30 10:44:03', b'1'),
(2, 3, 2, 'wash?', '2012-05-30 10:49:23', b'1'),
(3, 3, 2, 'wash', '2012-05-30 10:49:31', b'1'),
(4, 3, 2, 'salam', '2012-05-30 10:53:48', b'1'),
(5, 3, 2, 'salam', '2012-05-30 10:54:48', b'1'),
(6, 3, 2, 'cava?', '2012-05-30 10:54:59', b'1'),
(7, 2, 3, 'cava hamdoulah', '2012-05-30 10:55:15', b'1'),
(8, 2, 3, 'et tpoi', '2012-05-30 10:55:31', b'1'),
(9, 3, 2, 'gggggggggggggggggggggggg', '2012-05-30 10:57:43', b'1'),
(10, 3, 2, 'salam', '2012-05-30 10:58:44', b'1'),
(11, 2, 3, 'wa3alikom salam', '2012-05-30 10:58:55', b'1'),
(12, 3, 2, 'salam', '2012-05-30 11:03:19', b'1'),
(13, 2, 3, 'cava?', '2012-05-30 11:03:33', b'1'),
(61, 11, 12, 'salam', '2012-05-30 15:50:48', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `questionSecrete` varchar(255) DEFAULT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `nom`, `prenom`, `sexe`, `login`, `password`, `photo`, `questionSecrete`, `reponse`) VALUES
(2, 'CHEIKH TOURA','Mohamedouu', 'Masculin', 'weddou','weddou', NULL, 'what is your name', 'weddou'),
(13, 'RUKUNDO', 'Fiston', 'Masculin', 'bxdn', 'bxdn', NULL, 'what is your name', 'bxdn');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
