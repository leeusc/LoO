-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2024 at 04:31 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `piwpedia`
--
CREATE DATABASE IF NOT EXISTS `piwpedia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `piwpedia`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cust_id` char(5) NOT NULL,
  `cust_name` varchar(25) NOT NULL,
  `cust_address` varchar(30) DEFAULT NULL,
  `cust_city` varchar(25) DEFAULT NULL,
  `cust_state` varchar(5) DEFAULT NULL,
  `cust_zip` varchar(5) DEFAULT NULL,
  `cust_country` varchar(20) DEFAULT NULL,
  `cust_contact` varchar(25) DEFAULT NULL,
  `cust_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cust_id`, `cust_name`, `cust_address`, `cust_city`, `cust_state`, `cust_zip`, `cust_country`, `cust_contact`, `cust_email`) VALUES
('10002', 'Mouse House', '333 Fromage Lane', 'Columbus', 'OH', '43333', 'USA', 'Jerry Mouse', NULL),
('10003', 'Wascals', '1 Sunny Place', 'Muncie', 'IN', '42222', 'USA', 'Jim Jones', 'rabbit@wascally.com'),
('10004', 'Yosemite Place', '5 Sunny Place', 'Phoenix', 'AZ', '88888', 'USA', 'Y SAM', 'sam@yosemite.com'),
('10005', 'E Fudd', '4545 53rd Street', 'Chicago', 'IL', '54545', 'USA', 'E Fudd', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE IF NOT EXISTS `orderitems` (
  `order_num` int(11) NOT NULL,
  `order_item` int(11) NOT NULL,
  `prod_id` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`order_num`,`order_item`),
  KEY `prod_id` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderitems`
--

INSERT INTO `orderitems` (`order_num`, `order_item`, `prod_id`, `quantity`) VALUES
(20005, 1, 'ANV01', 10),
(20005, 2, 'ANV02', 3),
(20005, 3, 'TNT2', 5),
(20005, 4, 'FB', 1),
(20006, 1, 'JP2000', 1),
(20007, 1, 'TNT2', 100),
(20008, 1, 'FC', 50),
(20009, 1, 'FB', 1),
(20009, 2, 'OL1', 1),
(20009, 3, 'SLING', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_num` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `cust_id` varchar(10) NOT NULL,
  PRIMARY KEY (`order_num`),
  KEY `cust_id` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_num`, `order_date`, `cust_id`) VALUES
(20005, '0000-00-00', '10002'),
(20006, '0000-00-00', '10005'),
(20007, '0000-00-00', '10004'),
(20008, '0000-00-00', '10003'),
(20009, '0000-00-00', '10005');

-- --------------------------------------------------------

--
-- Table structure for table `productnotes`
--

DROP TABLE IF EXISTS `productnotes`;
CREATE TABLE IF NOT EXISTS `productnotes` (
  `note_id` char(3) NOT NULL,
  `prod_id` varchar(10) NOT NULL,
  `note_date` date NOT NULL,
  `note_text` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  KEY `prod_id` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `prod_id` varchar(10) NOT NULL,
  `vend_id` char(4) NOT NULL,
  `prod_name` varchar(25) NOT NULL,
  `prod_price` int(11) NOT NULL,
  `prod_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `vend_id` (`vend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`prod_id`, `vend_id`, `prod_name`, `prod_price`, `prod_desc`) VALUES
('ANV01', '1001', '.5 ton anvil', 6, '.5 ton anvil, black, complete with handy hook'),
('ANV02', '1001', '1 ton anvil', 12, '1 ton anvil, black, complete with handy hook and carrying case'),
('ANV03', '1001', '2 ton anvil', 18, '2 ton anvil, black, complete with handy hook and carrying case'),
('DTNTR', '1003', 'Detonator', 13, 'Detonator (plunger powered), fuses not included'),
('FB', '1003', 'Bird seed', 10, 'Large bag (suitable for road runners)'),
('FC', '1003', 'Carrots', 6, 'Carrots (rabbit hunting season only)'),
('FU1', '1002', 'Fuses', 3, '1 dozen, extra long'),
('JP1000', '1005', 'JetPack 1000', 34, 'JetPack 1000, intended for single use'),
('JP2000', '1005', 'JetPack 2000', 55, 'JetPack 2000, multi-use'),
('OL1', '1002', 'Oil can', 9, 'Oil can, red'),
('SAFE', '1002', 'Safe', 40, 'Safe with combination lock'),
('SLING', '1003', 'Sling', 4, 'Sling, one size fits all'),
('TNT1', '1003', 'TNT (1 stick)', 3, 'TNT, red, single stick'),
('TNT2', '1003', 'TNT (5 sticks)', 10, 'TNT, red, pack of 10 sticks');

-- --------------------------------------------------------

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
CREATE TABLE IF NOT EXISTS `vendors` (
  `vend_id` char(4) NOT NULL,
  `vend_name` varchar(25) NOT NULL,
  `vend_address` varchar(30) DEFAULT NULL,
  `vend_city` varchar(20) DEFAULT 'NOTSUPPPLIED',
  `vend_state` varchar(20) NOT NULL DEFAULT 'NOTSUPPLIED',
  `vend_zip` varchar(7) DEFAULT NULL,
  `vend_country` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`vend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vendors`
--

INSERT INTO `vendors` (`vend_id`, `vend_name`, `vend_address`, `vend_city`, `vend_state`, `vend_zip`, `vend_country`) VALUES
('1001', 'Anvils R Us', '123 Main Street', 'SouthField', 'MI', '48075', 'USA'),
('1002', 'LT Supplies', '500 Park Street', 'AnyTown', 'OH', '44333', 'USA'),
('1003', 'ACME', '555 High Street', 'Los Angeles', 'CA', '90046', 'USA'),
('1004', 'Furblass Inc.', '1000 5th Avenue', 'New York', 'NY', '11111', 'USA'),
('1005', 'Jet Set', '42 Galaxy Road', 'London', 'not null', 'N16 6PS', 'England'),
('1006', 'Jouets Et Ours', '1 Rue Amusement', 'Paris', 'NOTSUPPLIED', '45678', 'France');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD CONSTRAINT `orderitems_ibfk_1` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`),
  ADD CONSTRAINT `orderitems_ibfk_2` FOREIGN KEY (`order_num`) REFERENCES `orders` (`order_num`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`);

--
-- Constraints for table `productnotes`
--
ALTER TABLE `productnotes`
  ADD CONSTRAINT `productnotes_ibfk_1` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`vend_id`) REFERENCES `vendors` (`vend_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
