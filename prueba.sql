-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2021 at 05:50 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prueba`
--

-- --------------------------------------------------------

--
-- Table structure for table `registros`
--

CREATE TABLE `registros` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registros`
--

INSERT INTO `registros` (`ID`, `Nombre`, `Apellido`, `Edad`) VALUES
(6, 'Elvis', 'Manuel', 18),
(7, 'Elvis', 'garcia', 12),
(8, 'Brayan', 'Martinez', 18),
(9, 'Lux', 'Demacia', 20),
(10, 'Probando', 'jeje', 12),
(11, 'hh', 'hh', 1),
(12, 'ee', 'ee', 10),
(13, 'ee', 'ee', 12);

-- --------------------------------------------------------

--
-- Table structure for table `registros2`
--

CREATE TABLE `registros2` (
  `ID` int(11) NOT NULL,
  `Nusuario` varchar(255) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Numerotel` varchar(20) NOT NULL,
  `Correo` varchar(255) NOT NULL,
  `Contraseña` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registros2`
--

INSERT INTO `registros2` (`ID`, `Nusuario`, `Nombre`, `Apellido`, `Numerotel`, `Correo`, `Contraseña`) VALUES
(3, 'Tr4shy', 'Elvis Manuel', 'Garcia Encarnacion', '8494586788', 'ElvisManuel20032020@gmail.com', 0x4775697461727261313233),
(5, 'Aether', 'Manuel', 'Encarnacion', '8495568282', 'Elvis@gmail.com', 0x4775697461727261333231),
(9, 'AlbertoKiller', 'Alberto', 'Gutabo', '8097187212', 'qiweqwyeqwue@gmail.com', 0x4775697461727261313233),
(14, 'Microondas', 'Manolo', 'Garcia', '8091822873', 'Manolo@gmail.com', 0x4775697461727261313233);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `registros2`
--
ALTER TABLE `registros2`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registros`
--
ALTER TABLE `registros`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `registros2`
--
ALTER TABLE `registros2`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
