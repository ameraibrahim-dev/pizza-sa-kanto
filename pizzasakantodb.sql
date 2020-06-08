-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2020 at 07:51 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pizzasakantodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_details`
--

CREATE TABLE `customer_details` (
  `customerID` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `emailAddress` varchar(50) NOT NULL,
  `houseNumber` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `barangaySubdivision` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `province` varchar(50) NOT NULL,
  `zipcode` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_details`
--

INSERT INTO `customer_details` (`customerID`, `firstName`, `lastName`, `phoneNumber`, `emailAddress`, `houseNumber`, `street`, `barangaySubdivision`, `city`, `province`, `zipcode`) VALUES
('CABOTE09776564247', 'mac', 'cabote', '09776564247', 'mac@gmail.com', 'B 303 L 03', 'Maya St.', 'Barangay Rizal', 'Makati CIty', 'Metro Manila', '1218'),
('CABOTE09776564248', 'mac robert', 'cabote', '09776564248', 'mac@gmail.com', 'B 303 L 03', 'Maya St.', 'Barangay Rizal', 'Makati CIty', 'Metro Manila', '1218');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transactionID` int(11) NOT NULL,
  `customerID` varchar(50) NOT NULL,
  `transaction_grossPay` float NOT NULL,
  `transaction_VAT` float NOT NULL,
  `transaction_netPay` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transactionID`, `customerID`, `transaction_grossPay`, `transaction_VAT`, `transaction_netPay`) VALUES
(1, 'CABOTE09776564247', 0, 0, 0),
(2, 'CABOTE09776564247', 0, 0, 0),
(3, 'CABOTE09776564247', 315, 37.8, 277.2),
(4, 'CABOTE09776564247', 315, 37.8, 277.2),
(5, 'CABOTE09776564247', 0, 0, 0),
(6, 'CABOTE09776564247', 0, 0, 0),
(7, 'CABOTE09776564247', 0, 0, 0),
(8, 'CABOTE09776564248', 0, 0, 0),
(9, 'CABOTE09776564248', 0, 0, 0),
(10, 'CABOTE09776564248', 0, 0, 0),
(11, 'CABOTE09776564248', 525, 63, 462),
(12, 'CABOTE09776564248', 0, 0, 0),
(13, 'CABOTE09776564248', 0, 0, 0),
(14, 'CABOTE09776564248', 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_details`
--
ALTER TABLE `customer_details`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transactionID`),
  ADD KEY `customerID` (`customerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer_details` (`customerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
