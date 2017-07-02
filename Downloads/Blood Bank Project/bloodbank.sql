-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2017 at 11:26 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloodbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank_table`
--

CREATE TABLE `bank_table` (
  `bank_id` varchar(100) NOT NULL,
  `bank_name` varchar(200) NOT NULL,
  `o_pos` int(10) NOT NULL,
  `o_neg` int(10) NOT NULL,
  `a_pos` int(10) NOT NULL,
  `a_neg` int(10) NOT NULL,
  `b_pos` int(10) NOT NULL,
  `b_neg` int(10) NOT NULL,
  `ab_pos` int(10) NOT NULL,
  `ab_neg` int(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `latitude` varchar(25) NOT NULL,
  `longitude` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_table`
--

INSERT INTO `bank_table` (`bank_id`, `bank_name`, `o_pos`, `o_neg`, `a_pos`, `a_neg`, `b_pos`, `b_neg`, `ab_pos`, `ab_neg`, `address`, `phone_no`, `latitude`, `longitude`) VALUES
('birla5659', 'Birla Institute of Medical Research', 10, 10, 10, 10, 21, 26, 62, 84, 'Surya Mandir Road, Residency, Gwalior, Madhya Pradesh 474006', '0751 240 5659', '26.2353', '78.2184'),
('cancer6502', 'Cancer Hospital & Research Centre', 51, 65, 25, 22, 95, 15, 84, 62, 'Cancer Hills(Pahadi) Road, Gwalior 474009', '0751 233 6502', '26.1836', '78.1656'),
('jagroup3200', 'J.A. Group of Hospitals and Medical College', 511, 4, 23, 48, 51, 11, 6, 66, 'J A Hospital Campus, Kampu, Gwalior 474001', '0751 240 3200', '26.1922', '78.1607'),
('radha0393', 'Radhaswami Blood Bank', 51, 55, 63, 25, 16, 15, 14, 87, 'Near Canara Bank, Dal Bazar Tiraha Lashkar, Gwalior - 474001,', '0751 233 0393', '26.1954', '78.1585'),
('redcross4294', 'Red Cross Society', 84, 65, 26, 22, 32, 81, 62, 83, 'Behind Kamla Raja Hospital Kampu, Gwalior 474009', '0751 407 4294', '26.1918', '78.1595');

-- --------------------------------------------------------

--
-- Table structure for table `packet_table`
--

CREATE TABLE `packet_table` (
  `qr_code` varchar(100) NOT NULL,
  `donor_name` varchar(100) NOT NULL,
  `uid` varchar(100) NOT NULL,
  `donation_date` date NOT NULL,
  `donation_time` varchar(50) NOT NULL,
  `blood_group` varchar(10) NOT NULL,
  `RDVD` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `bank_id` varchar(100) NOT NULL,
  `recieve_date` date NOT NULL,
  `recieve_time` varchar(50) NOT NULL,
  `expiry_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` bigint(15) NOT NULL,
  `address` varchar(150) NOT NULL,
  `gender` int(1) NOT NULL,
  `bloodgroup` varchar(5) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `credits` int(11) NOT NULL,
  `last_donated` date NOT NULL,
  `dob` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`name`, `email`, `password`, `phone`, `address`, `gender`, `bloodgroup`, `uid`, `username`, `credits`, `last_donated`, `dob`) VALUES
('shreya', 'email_shreya', 'dump', 7544421456, 'shreya_Add', 1, 'NULL', 'slasdkm', 'djkn', 12, '0000-00-00', '0000-00-00'),
('hadjo', 'jaggu', 'dump', 9408411554, 'tree', 2, 'NULL', 'verified', 'jaggabandar', 25, '0000-00-00', '1900-01-02'),
('maria', 'dfjs', 'dump', 7544224456, 'addme', 1, 'NULL', '616155', 'maria', 12, '2017-06-15', '0000-00-00'),
('pdg', 'pdg@gmail.com', 'dump', 9407512465, 'address', 2, 'AB-', '485688567895', 'pdg', 10, '2015-04-01', '1994-04-14'),
('dummy', 'dummy@gmail.com', 'qwerty', 9407512480, 'dummy_address', 1, 'O+', 'uid1', 'prakhar4edu', 25, '2017-03-27', '2017-03-27'),
('shruti', 'shruti@fma', 'dump', 9422266545, 'address here', 1, 'AB+', 'v', 'shruti4', 12, '0000-00-00', '1996-06-16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_table`
--
ALTER TABLE `bank_table`
  ADD PRIMARY KEY (`bank_id`),
  ADD UNIQUE KEY `address` (`address`);

--
-- Indexes for table `packet_table`
--
ALTER TABLE `packet_table`
  ADD PRIMARY KEY (`qr_code`),
  ADD UNIQUE KEY `qr_code` (`qr_code`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
