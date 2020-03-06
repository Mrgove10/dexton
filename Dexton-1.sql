-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 05, 2020 at 01:19 PM
-- Server version: 5.7.29-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Dexton`
--

-- --------------------------------------------------------

--
-- Table structure for table `Categories`
--

CREATE TABLE `Categories` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `Categories`
--

INSERT INTO `Categories` (`ID`, `NAME`) VALUES
(1, 'Laptops'),
(2, 'Smartphones'),
(3, 'Cameras'),
(4, 'Accessories');

-- --------------------------------------------------------

--
-- Table structure for table `OrderDetails`
--

CREATE TABLE `OrderDetails` (
  `ORDER` int(11) DEFAULT NULL,
  `PRODUCT` int(11) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `Orders`
--

CREATE TABLE `Orders` (
  `ID` int(11) NOT NULL,
  `USER` int(11) DEFAULT NULL,
  `STATUS` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `Products`
--

CREATE TABLE `Products` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `DESCRIPTION` varchar(10000) COLLATE utf8mb4_bin DEFAULT NULL,
  `BRAND` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `CATEGORY` int(11) DEFAULT NULL,
  `RATING` float DEFAULT NULL,
  `ADDDATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `Products`
--

INSERT INTO `Products` (`ID`, `NAME`, `PRICE`, `DESCRIPTION`, `BRAND`, `CATEGORY`, `RATING`, `ADDDATE`) VALUES
(1, 'Super PCP 2000', 1000, 'Super PCP 2000 est LE Ortinator ULTIME de jeux', 'Amazon Basics', 1, 5, '2020-03-05'),
(2, 'iPomme 5G', 85, 'Le mobile du moment', 'Pomme', 2, 3, '2020-03-01'),
(3, 'Lorem Gen', 1564450, 'Lorem Generator for all your needs', 'Ipsum', 4, 1, '2020-01-14');

-- --------------------------------------------------------

--
-- Table structure for table `Roles`
--

CREATE TABLE `Roles` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(256) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `Roles`
--

INSERT INTO `Roles` (`ID`, `NAME`) VALUES
(1, 'user'),
(2, 'client'),
(100, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `ID` int(11) NOT NULL,
  `ROLE` int(11) DEFAULT '2',
  `EMAIL` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `LASTNAME` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `FIRSTNAME` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `PASSWORD` varchar(10000) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`ID`, `ROLE`, `EMAIL`, `LASTNAME`, `FIRSTNAME`, `PASSWORD`) VALUES
(1, 2, 'edouardclisson@gmail.com', 'CLISSON', 'Edouard', '123456'),
(7, 2, 'azer@azer.azer', 'azer', 'azer', 'azer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Categories`
--
ALTER TABLE `Categories`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `OrderDetails`
--
ALTER TABLE `OrderDetails`
  ADD KEY `OrderDetails_Orders_ID_fk` (`ORDER`),
  ADD KEY `OrderDetails_Products_ID_fk` (`PRODUCT`);

--
-- Indexes for table `Orders`
--
ALTER TABLE `Orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Orders_Users_ID_fk` (`USER`);

--
-- Indexes for table `Products`
--
ALTER TABLE `Products`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Products_Brands_ID_fk` (`BRAND`),
  ADD KEY `Products_Categories_ID_fk` (`CATEGORY`);

--
-- Indexes for table `Roles`
--
ALTER TABLE `Roles`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Users_Roles_ID_fk` (`ROLE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Categories`
--
ALTER TABLE `Categories`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Orders`
--
ALTER TABLE `Orders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Products`
--
ALTER TABLE `Products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Roles`
--
ALTER TABLE `Roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `OrderDetails`
--
ALTER TABLE `OrderDetails`
  ADD CONSTRAINT `OrderDetails_Orders_ID_fk` FOREIGN KEY (`ORDER`) REFERENCES `Orders` (`ID`),
  ADD CONSTRAINT `OrderDetails_Products_ID_fk` FOREIGN KEY (`PRODUCT`) REFERENCES `Products` (`ID`);

--
-- Constraints for table `Orders`
--
ALTER TABLE `Orders`
  ADD CONSTRAINT `Orders_Users_ID_fk` FOREIGN KEY (`USER`) REFERENCES `Users` (`ID`);

--
-- Constraints for table `Products`
--
ALTER TABLE `Products`
  ADD CONSTRAINT `Products_Categories_ID_fk` FOREIGN KEY (`CATEGORY`) REFERENCES `Categories` (`ID`);

--
-- Constraints for table `Users`
--
ALTER TABLE `Users`
  ADD CONSTRAINT `Users_Roles_ID_fk` FOREIGN KEY (`ROLE`) REFERENCES `Roles` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
