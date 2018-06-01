-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2018 a las 09:33:11
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `plant`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
  `Comment_ID` int(11) NOT NULL,
  `Comment` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `User` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Post_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plant`
--

CREATE TABLE `plant` (
  `Plant` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Description` varchar(2000) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post`
--

CREATE TABLE `post` (
  `ID` int(11) NOT NULL,
  `Head` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Body` varchar(2000) COLLATE utf8_spanish_ci NOT NULL,
  `User` int(200) NOT NULL,
  `Plant` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Username` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Password` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Mail` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`Comment_ID`);

--
-- Indices de la tabla `plant`
--
ALTER TABLE `plant`
  ADD PRIMARY KEY (`Plant`);

--
-- Indices de la tabla `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `username_unique` (`Username`),
  ADD UNIQUE KEY `mail_unique` (`Mail`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
