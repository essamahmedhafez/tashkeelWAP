-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 17, 2014 at 08:53 PM
-- Server version: 5.5.35
-- PHP Version: 5.3.10-1ubuntu3.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Game`
--

-- --------------------------------------------------------

--
-- Table structure for table `Players`
--

CREATE TABLE IF NOT EXISTS `Players` (
  `playerID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`playerID`),
  UNIQUE KEY `username` (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Possible_Digitizations`
--

CREATE TABLE IF NOT EXISTS `Possible_Digitizations` (
  `digitization` varchar(100) NOT NULL,
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `imageID` int(11) NOT NULL,
  `playerID` int(11) NOT NULL,
  `hinterID` int(11) NOT NULL,
  `solverID` int(11) NOT NULL,
  `number_of_signs` int(11) NOT NULL,
  `franco` varchar(50) NOT NULL,
  PRIMARY KEY (`session_id`),
  KEY `digitization_without_diacritics` (`digitization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Words`
--

CREATE TABLE IF NOT EXISTS `Words` (
  `imageID` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(100) NOT NULL,
  `digitization_without_diacritics` varchar(50) NOT NULL,
  `most_repeated_diacritics_digitization` varchar(100) NOT NULL,
  `repetition_number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`imageID`),
  UNIQUE KEY `path` (`path`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=56 ;

--
-- Dumping data for table `Words`
--

INSERT INTO `Words` (`imageID`, `path`, `digitization_without_diacritics`, `most_repeated_diacritics_digitization`, `repetition_number`) VALUES
(1, 'images/1.jpg', 'يا', 'يا', 0),
(2, 'images/2.jpg', 'غلام', 'غلام', 0),
(3, 'images/3.jpg', 'إني', 'إني', 0),
(4, 'images/4.jpg', 'أعلمك', 'أعلمك', 0),
(5, 'images/5.jpg', 'كلمات', 'كلمات', 0),
(6, 'images/6.jpg', 'أحفظ', 'أحفظ', 0),
(7, 'images/7.jpg', 'الله', 'الله', 0),
(8, 'images/8.jpg', 'يحفظك', 'يحفظك', 0),
(9, 'images/9.jpg', 'أحفظ', 'أحفظ', 0),
(10, 'images/10.jpg', 'الله', 'الله', 0),
(11, 'images/11.jpg', 'تجده', 'تجده', 0),
(12, 'images/12.jpg', 'تجاهك', 'تجاهك', 0),
(13, 'images/13.jpg', 'إذا', 'إذا', 0),
(14, 'images/14.jpg', 'سألت', 'سألت', 0),
(15, 'images/15.jpg', 'فاسأل', 'فاسأل', 0),
(16, 'images/16.jpg', 'الله', 'الله', 0),
(17, 'images/17.jpg', 'وإذا', 'وإذا', 0),
(18, 'images/18.jpg', 'استعنت', 'استعنت', 0),
(19, 'images/19.jpg', 'فاستعن', 'فاستعن', 0),
(20, 'images/20.jpg', 'بالله', 'بالله', 0),
(21, 'images/21.jpg', 'واعلم', 'واعلم', 0),
(22, 'images/22.jpg', 'أن', 'أن', 0),
(23, 'images/23.jpg', 'الأمة', 'الأمة', 0),
(24, 'images/24.jpg', 'لو', 'لو', 0),
(25, 'images/25.jpg', 'اجتمعت', 'اجتمعت', 0),
(26, 'images/26.jpg', 'على', 'على', 0),
(27, 'images/27.jpg', 'أن', 'أن', 0),
(28, 'images/28.jpg', 'ينفعوك', 'ينفعوك', 0),
(29, 'images/29.jpg', 'بشيء', 'بشيء', 0),
(30, 'images/30.jpg', 'لم', 'لم', 0),
(31, 'images/31.jpg', 'ينفعوك', 'ينفعوك', 0),
(32, 'images/32.jpg', 'إلا', 'إلا', 0),
(33, 'images/33.jpg', 'بشيء', 'بشيء', 0),
(34, 'images/34.jpg', 'قد', 'قد', 0),
(35, 'images/35.jpg', 'كتبه', 'كتبه', 0),
(36, 'images/36.jpg', 'الله', 'الله', 0),
(37, 'images/37.jpg', 'لك', 'لك', 0),
(38, 'images/38.jpg', 'ولو', 'ولو', 0),
(39, 'images/39.jpg', 'اجتمعوا', 'اجتمعوا', 0),
(40, 'images/40.jpg', 'على', 'على', 0),
(41, 'images/41.jpg', 'أن', 'أن', 0),
(42, 'images/42.jpg', 'يضروك', 'يضروك', 0),
(43, 'images/43.jpg', 'بشيء', 'بشيء', 0),
(44, 'images/44.jpg', 'لم', 'لم', 0),
(45, 'images/45.jpg', 'يضروك', 'يضروك', 0),
(46, 'images/46.jpg', 'إلا', 'إلا', 0),
(47, 'images/47.jpg', 'بشيء', 'بشيء', 0),
(48, 'images/48.jpg', 'قد', 'قد', 0),
(49, 'images/49.jpg', 'كتبه', 'كتبه', 0),
(50, 'images/50.jpg', 'الله', 'الله', 0),
(51, 'images/51.jpg', 'عليك', 'عليك', 0),
(52, 'images/52.jpg', 'رفعت', 'رفعت', 0),
(53, 'images/53.jpg', 'الأقلام', 'الأقلام', 0),
(54, 'images/54.jpg', 'وجفت', 'وجفت', 0),
(55, 'images/55.jpg', 'الصحف', 'الصحف', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
