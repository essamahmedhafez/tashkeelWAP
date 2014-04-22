-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 22, 2014 at 05:34 AM
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
-- Table structure for table `digitization`
--

CREATE TABLE IF NOT EXISTS `digitization` (
  `session_num` int(11) NOT NULL AUTO_INCREMENT,
  `digitization` varchar(255) DEFAULT NULL,
  `word_id` int(11) DEFAULT NULL,
  `franco` varchar(255) DEFAULT NULL,
  `no_of_signs` int(11) DEFAULT NULL,
  `hinter_id` int(11) DEFAULT NULL,
  `solver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`session_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `play_evolutions`
--

CREATE TABLE IF NOT EXISTS `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `play_evolutions`
--

INSERT INTO `play_evolutions` (`id`, `hash`, `applied_at`, `apply_script`, `revert_script`, `state`, `last_problem`) VALUES
(1, 'af3e1fb8e3dd727c6a842a1bbad466aad96ecda1', '2014-04-22 02:32:57', 'create table digitization (\nsession_num               integer auto_increment not null,\ndigitization              varchar(255),\nword_id                   integer,\nfranco                    varchar(255),\nno_of_signs               integer,\nhinter_id                 integer,\nsolver_id                 integer,\nconstraint pk_digitization primary key (session_num))\n;\n\ncreate table user (\nemail                     varchar(255) not null,\nid                        integer,\nname                      varchar(255),\npassword                  varchar(255),\nscore                     integer,\nconstraint pk_user primary key (email))\n;\n\ncreate table words (\nid                        integer auto_increment not null,\nword                      varchar(255),\nimage_link                varchar(255),\nrepetition_num            integer,\ntashkeel                  varchar(255),\nconstraint pk_words primary key (id))\n;', 'SET FOREIGN_KEY_CHECKS=0;\n\ndrop table digitization;\n\ndrop table user;\n\ndrop table words;\n\nSET FOREIGN_KEY_CHECKS=1;', 'applied', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `email` varchar(255) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `id`, `name`, `password`, `score`) VALUES
('a@a.com', 1, 'Menna Bakry', 'a', 0);

-- --------------------------------------------------------

--
-- Table structure for table `words`
--

CREATE TABLE IF NOT EXISTS `words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL,
  `image_link` varchar(255) DEFAULT NULL,
  `repetition_num` int(11) DEFAULT NULL,
  `tashkeel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=56 ;

--
-- Dumping data for table `words`
--

INSERT INTO `words` (`id`, `word`, `image_link`, `repetition_num`, `tashkeel`) VALUES
(1, 'يا', 'images/1.jpg', 0, 'يا'),
(2, 'غلام', 'images/2.jpg', 0, 'غلام'),
(3, 'إني', 'images/3.jpg', 0, 'إني'),
(4, 'أعلمك', 'images/4.jpg', 0, 'أعلمك'),
(5, 'كلمات', 'images/5.jpg', 0, 'كلمات'),
(6, 'أحفظ', 'images/6.jpg', 0, 'أحفظ'),
(7, 'الله', 'images/7.jpg', 0, 'الله'),
(8, 'يحفظك', 'images/8.jpg', 0, 'يحفظك'),
(9, 'أحفظ', 'images/9.jpg', 0, 'أحفظ'),
(10, 'الله', 'images/10.jpg', 0, 'الله'),
(11, 'تجده', 'images/11.jpg', 0, 'تجده'),
(12, 'تجاهك', 'images/12.jpg', 0, 'تجاهك'),
(13, 'إذا', 'images/13.jpg', 0, 'إذا'),
(14, 'سألت', 'images/14.jpg', 0, 'سألت'),
(15, 'فاسأل', 'images/15.jpg', 0, 'فاسأل'),
(16, 'الله', 'images/16.jpg', 0, 'الله'),
(17, 'وإذا', 'images/17.jpg', 0, 'وإذا'),
(18, 'استعنت', 'images/18.jpg', 0, 'استعنت'),
(19, 'فاستعن', 'images/19.jpg', 0, 'فاستعن'),
(20, 'بالله', 'images/20.jpg', 0, 'بالله'),
(21, 'واعلم', 'images/21.jpg', 0, 'واعلم'),
(22, 'أن', 'images/22.jpg', 0, 'أن'),
(23, 'الأمة', 'images/23.jpg', 0, 'الأمة'),
(24, 'لو', 'images/24.jpg', 0, 'لو'),
(25, 'اجتمعت', 'images/25.jpg', 0, 'اجتمعت'),
(26, 'على', 'images/26.jpg', 0, 'على'),
(27, 'أن', 'images/27.jpg', 0, 'أن'),
(28, 'ينفعوك', 'images/28.jpg', 0, 'ينفعوك'),
(29, 'بشيء', 'images/29.jpg', 0, 'بشيء'),
(30, 'لم', 'images/30.jpg', 0, 'لم'),
(31, 'ينفعوك', 'images/31.jpg', 0, 'ينفعوك'),
(32, 'إلا', 'images/32.jpg', 0, 'إلا'),
(33, 'بشيء', 'images/33.jpg', 0, 'بشيء'),
(34, 'قد', 'images/34.jpg', 0, 'قد'),
(35, 'كتبه', 'images/35.jpg', 0, 'كتبه'),
(36, 'الله', 'images/36.jpg', 0, 'الله'),
(37, 'لك', 'images/37.jpg', 0, 'لك'),
(38, 'ولو', 'images/38.jpg', 0, 'ولو'),
(39, 'اجتمعوا', 'images/39.jpg', 0, 'اجتمعوا'),
(40, 'على', 'images/40.jpg', 0, 'على'),
(41, 'أن', 'images/41.jpg', 0, 'أن'),
(42, 'يضروك', 'images/42.jpg', 0, 'يضروك'),
(43, 'بشيء', 'images/43.jpg', 0, 'بشيء'),
(44, 'لم', 'images/44.jpg', 0, 'لم'),
(45, 'يضروك', 'images/45.jpg', 0, 'يضروك'),
(46, 'إلا', 'images/46.jpg', 0, 'إلا'),
(47, 'بشيء', 'images/47.jpg', 0, 'بشيء'),
(48, 'قد', 'images/48.jpg', 0, 'قد'),
(49, 'كتبه', 'images/49.jpg', 0, 'كتبه'),
(50, 'الله', 'images/50.jpg', 0, 'الله'),
(51, 'عليك', 'images/51.jpg', 0, 'عليك'),
(52, 'رفعت', 'images/52.jpg', 0, 'رفعت'),
(53, 'الأقلام', 'images/53.jpg', 0, 'الأقلام'),
(54, 'وجفت', 'images/54.jpg', 0, 'وجفت'),
(55, 'الصحف', 'images/55.jpg', 0, 'الصحف');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
