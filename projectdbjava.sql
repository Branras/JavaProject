-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 13, 2014 at 11:16 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.9-1ubuntu4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `projectdbjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `docent`
--

CREATE TABLE `docent` (
`id` int(11) NOT NULL,
  `Naam` varchar(40) NOT NULL,
  `Familienaam` varchar(40) NOT NULL,
  `Login` varchar(40) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `Pass` varchar(40) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docent`
--

INSERT INTO `docent` (`id`, `Naam`, `Familienaam`, `Login`, `Pass`) VALUES
(1, 'Bram', 'Driesen', 'bram', 'bram');

-- --------------------------------------------------------

--
-- Table structure for table `klas`
--

CREATE TABLE `klas` (
`klasid` int(11) NOT NULL,
  `naam` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `klas`
--

INSERT INTO `klas` (`klasid`, `naam`) VALUES
(1, '3TIa1'),
(2, '3TIa2');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
`scoreid` int(11) NOT NULL,
  `score` int(3) NOT NULL,
  `testid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `maxaantalpunten` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
`studentid` int(11) NOT NULL,
  `familienaam` varchar(40) NOT NULL,
  `voornaam` varchar(40) NOT NULL,
  `nummer` int(6) NOT NULL,
  `klasid` int(11) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
`testid` int(11) NOT NULL,
  `naam` varchar(40) NOT NULL,
  `datum` date NOT NULL,
  `vakid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `vak`
--

CREATE TABLE `vak` (
`vakid` int(11) NOT NULL,
  `naam` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `docent`
--
ALTER TABLE `docent`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klas`
--
ALTER TABLE `klas`
 ADD PRIMARY KEY (`klasid`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
 ADD PRIMARY KEY (`scoreid`), ADD KEY `testid` (`testid`,`studentid`), ADD KEY `studentid` (`studentid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`studentid`), ADD KEY `klasid` (`klasid`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
 ADD PRIMARY KEY (`testid`), ADD KEY `vakid` (`vakid`);

--
-- Indexes for table `vak`
--
ALTER TABLE `vak`
 ADD PRIMARY KEY (`vakid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `docent`
--
ALTER TABLE `docent`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `klas`
--
ALTER TABLE `klas`
MODIFY `klasid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
MODIFY `scoreid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
MODIFY `studentid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
MODIFY `testid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `vak`
--
ALTER TABLE `vak`
MODIFY `vakid` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `score`
--
ALTER TABLE `score`
ADD CONSTRAINT `studentidscore` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`),
ADD CONSTRAINT `testidscore` FOREIGN KEY (`testid`) REFERENCES `test` (`testid`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
ADD CONSTRAINT `klasidstudent` FOREIGN KEY (`klasid`) REFERENCES `klas` (`klasid`) ON UPDATE CASCADE;

--
-- Constraints for table `test`
--
ALTER TABLE `test`
ADD CONSTRAINT `vakidtest` FOREIGN KEY (`vakid`) REFERENCES `vak` (`vakid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
