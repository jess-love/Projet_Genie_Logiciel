-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2021 at 11:31 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gestion_commandes_repas`
--

-- --------------------------------------------------------

--
-- Table structure for table `boisson`
--

CREATE TABLE IF NOT EXISTS `boisson` (
  `id_boisson` int(11) NOT NULL AUTO_INCREMENT,
  `id_fam_boisson` int(11) NOT NULL,
  `designation` varchar(25) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id_boisson`),
  KEY `id_fam_boisson` (`id_fam_boisson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `boisson_menu`
--

CREATE TABLE IF NOT EXISTS `boisson_menu` (
  `id_boisson` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  KEY `id_boisson` (`id_boisson`),
  KEY `id_menu` (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `carte`
--

CREATE TABLE IF NOT EXISTS `carte` (
  `id_carte` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(25) NOT NULL,
  PRIMARY KEY (`id_carte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `carte_vin`
--

CREATE TABLE IF NOT EXISTS `carte_vin` (
  `id_cart_vin` int(11) NOT NULL AUTO_INCREMENT,
  `id_boisson` int(11) NOT NULL,
  `id_vit` int(11) NOT NULL,
  `prix_achat` double NOT NULL,
  `prix_vente` double NOT NULL,
  `date_achat` date NOT NULL,
  PRIMARY KEY (`id_cart_vin`),
  KEY `id_boisson` (`id_boisson`),
  KEY `id_vit` (`id_vit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_clt` int(11) NOT NULL AUTO_INCREMENT,
  `id_pers` int(11) NOT NULL,
  PRIMARY KEY (`id_clt`),
  KEY `id_pers` (`id_pers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id_cde` int(11) NOT NULL AUTO_INCREMENT,
  `id_emp` int(11) NOT NULL,
  `id_tab` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_cde`),
  KEY `id_emp` (`id_emp`),
  KEY `id_tab` (`id_tab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `connexion`
--

CREATE TABLE IF NOT EXISTS `connexion` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `connexion`
--

INSERT INTO `connexion` (`username`, `password`) VALUES
('admin', 'admin'),
('jess', 'love');

-- --------------------------------------------------------

--
-- Table structure for table `consommation`
--

CREATE TABLE IF NOT EXISTS `consommation` (
  `id_cde` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_plat` int(11) NOT NULL,
  `id_boisson` int(11) NOT NULL,
  KEY `id_cde` (`id_cde`),
  KEY `id_menu` (`id_menu`),
  KEY `id_plat` (`id_plat`),
  KEY `id_boisson` (`id_boisson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `diplome`
--

CREATE TABLE IF NOT EXISTS `diplome` (
  `id_dip` int(11) NOT NULL AUTO_INCREMENT,
  `id_emp` int(11) NOT NULL,
  `libelle` varchar(30) NOT NULL,
  PRIMARY KEY (`id_dip`),
  KEY `id_emp` (`id_emp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `id_emp` int(11) NOT NULL AUTO_INCREMENT,
  `id_pers` int(11) NOT NULL,
  `poste` varchar(25) NOT NULL,
  PRIMARY KEY (`id_emp`),
  KEY `id_pers` (`id_pers`),
  KEY `id_pers_2` (`id_pers`),
  KEY `id_pers_3` (`id_pers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `famille_boisson`
--

CREATE TABLE IF NOT EXISTS `famille_boisson` (
  `id_fam_boisson` int(11) NOT NULL AUTO_INCREMENT,
  `nom_fam_boisson` varchar(25) NOT NULL,
  PRIMARY KEY (`id_fam_boisson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nom_menu` varchar(25) NOT NULL,
  `rabais` double NOT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id_pers` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `telephone` int(11) NOT NULL,
  PRIMARY KEY (`id_pers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `plat`
--

CREATE TABLE IF NOT EXISTS `plat` (
  `id_plat` int(11) NOT NULL AUTO_INCREMENT,
  `id_carte` int(11) NOT NULL,
  `nom_plat` varchar(25) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id_plat`),
  KEY `id_carte` (`id_carte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `plat_menu`
--

CREATE TABLE IF NOT EXISTS `plat_menu` (
  `id_menu` int(11) NOT NULL,
  `id_plat` int(11) NOT NULL,
  KEY `id_menu` (`id_menu`),
  KEY `id_plat` (`id_plat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `table`
--

CREATE TABLE IF NOT EXISTS `table` (
  `id_tab` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id_tab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `viticulteur`
--

CREATE TABLE IF NOT EXISTS `viticulteur` (
  `id_vit` int(11) NOT NULL AUTO_INCREMENT,
  `id_pers` int(11) NOT NULL,
  PRIMARY KEY (`id_vit`),
  KEY `id_pers` (`id_pers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boisson`
--
ALTER TABLE `boisson`
  ADD CONSTRAINT `boisson_ibfk_1` FOREIGN KEY (`id_fam_boisson`) REFERENCES `famille_boisson` (`id_fam_boisson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `boisson_menu`
--
ALTER TABLE `boisson_menu`
  ADD CONSTRAINT `boisson_menu_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `boisson_menu_ibfk_1` FOREIGN KEY (`id_boisson`) REFERENCES `boisson` (`id_boisson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `carte_vin`
--
ALTER TABLE `carte_vin`
  ADD CONSTRAINT `carte_vin_ibfk_1` FOREIGN KEY (`id_boisson`) REFERENCES `boisson` (`id_boisson`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `carte_vin_ibfk_2` FOREIGN KEY (`id_vit`) REFERENCES `viticulteur` (`id_vit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`id_pers`) REFERENCES `personne` (`id_pers`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`id_tab`) REFERENCES `table` (`id_tab`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_emp`) REFERENCES `employe` (`id_emp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `consommation`
--
ALTER TABLE `consommation`
  ADD CONSTRAINT `consommation_ibfk_4` FOREIGN KEY (`id_boisson`) REFERENCES `boisson` (`id_boisson`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consommation_ibfk_1` FOREIGN KEY (`id_cde`) REFERENCES `commande` (`id_cde`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consommation_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consommation_ibfk_3` FOREIGN KEY (`id_plat`) REFERENCES `plat` (`id_plat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `diplome`
--
ALTER TABLE `diplome`
  ADD CONSTRAINT `diplome_ibfk_1` FOREIGN KEY (`id_emp`) REFERENCES `employe` (`id_emp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `employe_ibfk_1` FOREIGN KEY (`id_pers`) REFERENCES `personne` (`id_pers`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `plat`
--
ALTER TABLE `plat`
  ADD CONSTRAINT `plat_ibfk_1` FOREIGN KEY (`id_carte`) REFERENCES `carte` (`id_carte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `plat_menu`
--
ALTER TABLE `plat_menu`
  ADD CONSTRAINT `plat_menu_ibfk_2` FOREIGN KEY (`id_plat`) REFERENCES `plat` (`id_plat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `plat_menu_ibfk_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `viticulteur`
--
ALTER TABLE `viticulteur`
  ADD CONSTRAINT `viticulteur_ibfk_1` FOREIGN KEY (`id_pers`) REFERENCES `personne` (`id_pers`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
