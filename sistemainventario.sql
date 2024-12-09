-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-01-2023 a las 03:01:28
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemainventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aireacondicionado`
--

CREATE TABLE `aireacondicionado` (
  `id` int(50) NOT NULL,
  `materiala` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `limpiezaSerpetines` varchar(50) NOT NULL,
  `limpiezaFiltroAire` varchar(50) NOT NULL,
  `revisionFugas` varchar(50) NOT NULL,
  `medicionPresion` varchar(50) NOT NULL,
  `medicionAmp` varchar(50) NOT NULL,
  `aprieteTornilleria` varchar(50) NOT NULL,
  `pintura` varchar(50) NOT NULL,
  `limpiezaPanelControl` varchar(50) NOT NULL,
  `lubricacion` varchar(50) NOT NULL,
  `verificarVentilador` varchar(50) NOT NULL,
  `destaparDrenes` varchar(50) NOT NULL,
  `limpiezaEvaporador` varchar(50) NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aireacondicionado`
--

INSERT INTO `aireacondicionado` (`id`, `materiala`, `fecha`, `limpiezaSerpetines`, `limpiezaFiltroAire`, `revisionFugas`, `medicionPresion`, `medicionAmp`, `aprieteTornilleria`, `pintura`, `limpiezaPanelControl`, `lubricacion`, `verificarVentilador`, `destaparDrenes`, `limpiezaEvaporador`, `observaciones`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Aire acondicionado 3', '2022-12-15', 'Si', 'Si', 'Si', 'Si', 'ert', 'Si', 'Si', 'Ningún cambio', 'Si', 'Si', 'Si', 'Si', '', 're', 'ter', 'et');

--
-- Disparadores `aireacondicionado`
--
DELIMITER $$
CREATE TRIGGER `bit_AA_Update` AFTER UPDATE ON `aireacondicionado` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'aireacondicionado')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_AA_delete` AFTER DELETE ON `aireacondicionado` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'aireacondicionado')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_AA_insert` AFTER INSERT ON `aireacondicionado` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'aireacondicionado')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombacalor`
--

CREATE TABLE `bombacalor` (
  `id` int(50) NOT NULL,
  `materialb` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `capacidad` varchar(200) NOT NULL,
  `unidad` varchar(200) NOT NULL,
  `marca` varchar(200) NOT NULL,
  `modelo` varchar(200) NOT NULL,
  `serie` varchar(200) NOT NULL,
  `lavadoAguaPresion` varchar(50) NOT NULL,
  `lavadoCondensador` varchar(50) NOT NULL,
  `revisionMotor` varchar(50) NOT NULL,
  `revisionCompresor` varchar(50) NOT NULL,
  `medicionAmp` varchar(50) NOT NULL,
  `cambioTerminales` varchar(50) NOT NULL,
  `pintura` varchar(50) NOT NULL,
  `revisionValvulasAgua` varchar(50) NOT NULL,
  `revisionFugas` varchar(50) NOT NULL,
  `revisionSisRefrigerante` varchar(50) NOT NULL,
  `medicionPresion` varchar(50) NOT NULL,
  `revisionControl` varchar(50) NOT NULL,
  `observaciones` varchar(50) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Disparadores `bombacalor`
--
DELIMITER $$
CREATE TRIGGER `bit_BC_Update` AFTER UPDATE ON `bombacalor` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'bombacalor')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_BC_delete` AFTER DELETE ON `bombacalor` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'bombacalor')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_BC_insert` AFTER INSERT ON `bombacalor` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'bombacalor')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombas`
--

CREATE TABLE `bombas` (
  `id` int(50) NOT NULL,
  `materialb` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoRondamiento` varchar(50) NOT NULL,
  `selloMecanico` varchar(50) NOT NULL,
  `amp` varchar(50) NOT NULL,
  `temperatura` varchar(50) NOT NULL,
  `aprieteTC` varchar(50) NOT NULL,
  `accionamiento` varchar(50) NOT NULL,
  `pintura` varchar(50) NOT NULL,
  `revisionManometro` varchar(50) NOT NULL,
  `observacion` varchar(50) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombas`
--

INSERT INTO `bombas` (`id`, `materialb`, `fecha`, `chequeoRondamiento`, `selloMecanico`, `amp`, `temperatura`, `aprieteTC`, `accionamiento`, `pintura`, `revisionManometro`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Bomba de agua potable 1 - Cuarto de bombas (Cisternas)', '2022-12-15', 'Si', 'Si', 'rew', 'ewr', 'Si', 'wer', 'Si', 'Si', 'rew', 'rwe', 'wre', 'er'),
(2, 'Bomba recirculación 2 - Cuarto de bombas (Hidroterapia)', '2022-12-08', 'Si', 'Si', 'sdad', 'sadasd', 'Si', 'sad', 'Si', 'Si', 'asdasd', 'asdad', 'ads', ''),
(3, 'Bomba de agua filtrada 1 - Cuarto de bombas (Cisternas)', '2022-12-30', 'Ningún cambio', 'Ningún cambio', '154654', '6265', 'Si', '50%', 'Si', 'Si', 'bhjg', 'uihiu', 'jhghg', '');

--
-- Disparadores `bombas`
--
DELIMITER $$
CREATE TRIGGER `bit_B_Update` AFTER UPDATE ON `bombas` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'bombas')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_B_delete` AFTER DELETE ON `bombas` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'bombas')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_b_insert` AFTER INSERT ON `bombas` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'bombas')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calderaelectromecanico`
--

CREATE TABLE `calderaelectromecanico` (
  `id` int(50) NOT NULL,
  `materialc` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `capacidad` varchar(100) NOT NULL,
  `unidad` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `serie` varchar(100) NOT NULL,
  `limpiezaChimenea` varchar(10) NOT NULL,
  `limpiezaCenicero` varchar(10) NOT NULL,
  `revisionQuemador` varchar(10) NOT NULL,
  `limpiezaPiloto` varchar(10) NOT NULL,
  `revisionFlama` varchar(10) NOT NULL,
  `revisionManometro` varchar(10) NOT NULL,
  `revisionValvulas` varchar(10) NOT NULL,
  `revisionSistema` varchar(10) NOT NULL,
  `medicionAmp` varchar(10) NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  `elaborado` varchar(100) NOT NULL,
  `revisado` varchar(100) NOT NULL,
  `aprobado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calderaelectromecanico`
--

INSERT INTO `calderaelectromecanico` (`id`, `materialc`, `fecha`, `capacidad`, `unidad`, `marca`, `modelo`, `serie`, `limpiezaChimenea`, `limpiezaCenicero`, `revisionQuemador`, `limpiezaPiloto`, `revisionFlama`, `revisionManometro`, `revisionValvulas`, `revisionSistema`, `medicionAmp`, `observaciones`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Caldera 1 - Azotea de Cisternas', '2022-12-16', '1 /12', 'HP', 'ARMSTRONG', 'S-25 BF', '718', 'Si', 'Si', 'Si ', 'Si', 'Si', 'Si ', 'Si', 'Si', 's', '', 'ds', 'dgs', 'g');

--
-- Disparadores `calderaelectromecanico`
--
DELIMITER $$
CREATE TRIGGER `bit_CA_Update` AFTER INSERT ON `calderaelectromecanico` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'calderaelectromecanico')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_CA_delete` AFTER INSERT ON `calderaelectromecanico` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'calderaelectromecanico')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_CE_insert` AFTER INSERT ON `calderaelectromecanico` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'calderaelectromecanico')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calderas`
--

CREATE TABLE `calderas` (
  `id` int(20) NOT NULL,
  `noCaldera` varchar(100) NOT NULL,
  `dia` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `horaEncendido` varchar(20) NOT NULL,
  `horaApagado` varchar(20) NOT NULL,
  `nombrePrende` varchar(100) NOT NULL,
  `nombreApaga` varchar(100) NOT NULL,
  `calderatrabajando` varchar(15) NOT NULL,
  `porcentaje` varchar(100) NOT NULL,
  `observaciones` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calderas`
--

INSERT INTO `calderas` (`id`, `noCaldera`, `dia`, `fecha`, `horaEncendido`, `horaApagado`, `nombrePrende`, `nombreApaga`, `calderatrabajando`, `porcentaje`, `observaciones`) VALUES
(2, '2', 'Miercoles', '2022-12-08', 'Hola', 'hola', 'SDF', 'DFS', 'Si', 'DSF', ''),
(5, '3', 'Lunes ', '2022-12-08', '10:00 am', '12:00 pm', 'Nombre x', 'Nombre x', 'Si', 'gfh', ''),
(6, '2', 'Martes', '2022-12-08', 'Hola', 'dsfs', 'dfs', 'sdf', 'No', 'sf', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cems`
--

CREATE TABLE `cems` (
  `id` int(100) NOT NULL,
  `materialce` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoGral` varchar(50) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cems`
--

INSERT INTO `cems` (`id`, `materialce`, `fecha`, `chequeoGral`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Proyector de imágenes ', '2022-12-08', 'Si ', '', 'sdda', 'sdasd', 'asda'),
(2, 'Microcomponente  ', '2022-12-08', 'Si ', '', 'sdda', 'sdasd', 'asda'),
(4, 'Proyector de imágenes ', '2022-12-03', 'No (Comentar en observaciones generales)', '', 'asdasd', 'asdad', 'dsad'),
(5, 'Proyector de imágenes ', '2022-12-03', 'Si ', '', 'ewrw', 'wer', 'ewr'),
(6, 'Tubo de burbujas 1', '2022-12-09', 'Si ', '', 'wdawd', 'dawdawd', 'awd'),
(7, 'Tapete de fibra óptica ', '2022-12-08', 'Si ', '', 'sad', 'asdads', 'sada');

--
-- Disparadores `cems`
--
DELIMITER $$
CREATE TRIGGER `bit_cems_Update` AFTER UPDATE ON `cems` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'cems')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_cems_delete` AFTER DELETE ON `cems` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'aireacondicionado')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_cems_insert` AFTER INSERT ON `cems` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'cems')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cisternaagua`
--

CREATE TABLE `cisternaagua` (
  `id` int(20) NOT NULL,
  `noCisterna` varchar(100) NOT NULL,
  `dia` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(50) NOT NULL,
  `cloro` varchar(50) NOT NULL,
  `ph` varchar(50) NOT NULL,
  `durezaTotal` varchar(20) NOT NULL,
  `nivelAgua` varchar(15) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `observaciones` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cisternaagua`
--

INSERT INTO `cisternaagua` (`id`, `noCisterna`, `dia`, `fecha`, `hora`, `cloro`, `ph`, `durezaTotal`, `nivelAgua`, `nombre`, `observaciones`) VALUES
(4, 'Cisterna 2 (agua potable) 90 m3', 'Jueves ', '2022-12-21', 'df', 'fdg', 'dfd', 'ff', 'df', 'df', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compresoraire`
--

CREATE TABLE `compresoraire` (
  `id` int(50) NOT NULL,
  `materialcom` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `capacidad` varchar(100) NOT NULL,
  `unidad` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `serie` varchar(100) NOT NULL,
  `medicionAmp` varchar(50) NOT NULL,
  `medicionPresion` varchar(50) NOT NULL,
  `medicionSistema` varchar(50) NOT NULL,
  `limpiezaGral` varchar(50) NOT NULL,
  `revisionAceite` varchar(50) NOT NULL,
  `pintura` varchar(50) NOT NULL,
  `revisionPurgado` varchar(50) NOT NULL,
  `revisionTerminales` varchar(50) NOT NULL,
  `observaciones` varchar(50) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compresoraire`
--

INSERT INTO `compresoraire` (`id`, `materialcom`, `fecha`, `capacidad`, `unidad`, `marca`, `modelo`, `serie`, `medicionAmp`, `medicionPresion`, `medicionSistema`, `limpiezaGral`, `revisionAceite`, `pintura`, `revisionPurgado`, `revisionTerminales`, `observaciones`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Compresor 1 - Parte alta de Tarja de Valoración ', '2022-12-09', '27', 'Galones', 'POWERMATE', 'CL0601712', 'D21813462', 'fds', 'dfd', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'dfsdf', 'fdsf', 'dfs');

--
-- Disparadores `compresoraire`
--
DELIMITER $$
CREATE TRIGGER `bit_compresoraire_Update` AFTER UPDATE ON `compresoraire` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'compresoraire')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_compresoraire_delete` BEFORE INSERT ON `compresoraire` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'compresoraire')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_compresoraire_insert` AFTER INSERT ON `compresoraire` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'compresoraire')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contraincendio`
--

CREATE TABLE `contraincendio` (
  `id` int(20) NOT NULL,
  `fecha` date NOT NULL,
  `material` varchar(100) NOT NULL,
  `pruebaS` varchar(100) NOT NULL,
  `obs` varchar(200) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dosificadoragua`
--

CREATE TABLE `dosificadoragua` (
  `id` int(50) NOT NULL,
  `materiald` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoSellado` varchar(50) NOT NULL,
  `chequeoFuga` varchar(50) NOT NULL,
  `chequeoCableado` varchar(50) NOT NULL,
  `limpiezaExterior` varchar(50) NOT NULL,
  `limpiezaInterior` varchar(50) NOT NULL,
  `limpiezaEvaporador` varchar(50) NOT NULL,
  `medicionAmp` varchar(50) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dosificadoragua`
--

INSERT INTO `dosificadoragua` (`id`, `materiald`, `fecha`, `chequeoSellado`, `chequeoFuga`, `chequeoCableado`, `limpiezaExterior`, `limpiezaInterior`, `limpiezaEvaporador`, `medicionAmp`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Dosificador 5 - Área de descanso de terapias ', '2022-12-02', 'SI', 'SI', 'SI', 'SI', 'SI', 'SI', 'SI', '', 'rtetre', 'ter', 'ete');

--
-- Disparadores `dosificadoragua`
--
DELIMITER $$
CREATE TRIGGER `bit_dosificadoragua_Update` AFTER UPDATE ON `dosificadoragua` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'dosificadoragua')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_dosificadoragua_delete` AFTER DELETE ON `dosificadoragua` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'dosificadoragua')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_dosificadoragua_insert` AFTER INSERT ON `dosificadoragua` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'dosificadoragua')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `electricidade`
--

CREATE TABLE `electricidade` (
  `id` int(50) NOT NULL,
  `material` varchar(150) NOT NULL,
  `fecha` date NOT NULL,
  `capacidadEl` varchar(100) NOT NULL,
  `unidadEl` varchar(100) NOT NULL,
  `marcaEl` varchar(100) NOT NULL,
  `noSerieEl` varchar(100) NOT NULL,
  `cambioAceite` varchar(5) NOT NULL,
  `cambioRefrigerante` varchar(5) NOT NULL,
  `cambioFiltroAire` varchar(5) NOT NULL,
  `cambioFiltroDiesel` varchar(5) NOT NULL,
  `cambioFiltroAceite` varchar(5) NOT NULL,
  `cambioFiltroRefrigerante` varchar(5) NOT NULL,
  `limpiezaGral` varchar(5) NOT NULL,
  `observaciones` varchar(50) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `electricidade`
--

INSERT INTO `electricidade` (`id`, `material`, `fecha`, `capacidadEl`, `unidadEl`, `marcaEl`, `noSerieEl`, `cambioAceite`, `cambioRefrigerante`, `cambioFiltroAire`, `cambioFiltroDiesel`, `cambioFiltroAceite`, `cambioFiltroRefrigerante`, `limpiezaGral`, `observaciones`, `elaborado`, `revisado`, `aprobado`) VALUES
(3, 'Planta de emergencia - Subestación de distribución', '2023-01-01', '314', 'KW', '9A0314B08', 'S/N', 'SI', 'SI', 'SI', 'SI', 'SI', 'SI ', 'SI', '', 'Lizbeth ', 'Lizbeth ', 'Nombre tal');

--
-- Disparadores `electricidade`
--
DELIMITER $$
CREATE TRIGGER `bit_electricidade_Update` AFTER UPDATE ON `electricidade` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'electricidade')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_electricidade_delete` AFTER DELETE ON `electricidade` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'electricidade')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_electricidade_insert` AFTER INSERT ON `electricidade` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'electricidade')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermeria`
--

CREATE TABLE `enfermeria` (
  `id` int(50) NOT NULL,
  `materialenf` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoGral` varchar(50) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `enfermeria`
--

INSERT INTO `enfermeria` (`id`, `materialenf`, `fecha`, `chequeoGral`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Báscula 60 Kilos', '2022-12-09', 'Si ', '', 'ghgh', 'gfhf', 'hgf'),
(2, 'Báscula 60 Kilos', '2022-12-15', 'Si ', '', 'dfdsfds', 'dfgsfs', 'fdsfdsf'),
(3, 'Horno de microondas ', '2022-12-01', 'Si ', '', 'wad', 'wad', 'wda');

--
-- Disparadores `enfermeria`
--
DELIMITER $$
CREATE TRIGGER `bit_enfermeria_delete` AFTER DELETE ON `enfermeria` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'electricidade')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_enfermeria_insert` AFTER INSERT ON `enfermeria` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'electricidade')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_enfermeriae_Update` AFTER UPDATE ON `enfermeria` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'enfermeria')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipomedico`
--

CREATE TABLE `equipomedico` (
  `id` int(50) NOT NULL,
  `materialm` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoGral` varchar(50) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipomedico`
--

INSERT INTO `equipomedico` (`id`, `materialm`, `fecha`, `chequeoGral`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Plantoscopios', '2022-12-02', 'Si ', '', 'dfsdf', 'fdsfd', 'fdsfsdf'),
(2, 'Negatoscopios', '2022-12-16', 'Si ', '', 'wda', 'wad', 'dawd'),
(3, 'Plantoscopios', '2022-12-21', 'Si ', '', 'Lizbeth', 'Lizbeth V', 'Liz');

--
-- Disparadores `equipomedico`
--
DELIMITER $$
CREATE TRIGGER `bit_equipomedico_Update` AFTER UPDATE ON `equipomedico` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'equipomedico')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_equipomedico_delete` AFTER DELETE ON `equipomedico` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'equipomedico')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_equipomedico_insert` AFTER INSERT ON `equipomedico` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'equipomedico')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extintor`
--

CREATE TABLE `extintor` (
  `id` int(20) NOT NULL,
  `materialext` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `marca` varchar(100) NOT NULL,
  `agentExtintor` varchar(30) NOT NULL,
  `capacidad` varchar(200) NOT NULL,
  `fechaUltimaRecarga` date NOT NULL,
  `fechaProxRecarga` date NOT NULL,
  `lugarAccesible` varchar(100) NOT NULL,
  `letrero` varchar(100) NOT NULL,
  `etiquetasLegibles` varchar(100) NOT NULL,
  `horquilla` varchar(100) NOT NULL,
  `corrocion` varchar(100) NOT NULL,
  `escapePresion` varchar(100) NOT NULL,
  `deformacion` varchar(100) NOT NULL,
  `exposicion` varchar(100) NOT NULL,
  `roturas` varchar(100) NOT NULL,
  `desprendimiento` varchar(100) NOT NULL,
  `protuberacion` varchar(100) NOT NULL,
  `perforacion` varchar(100) NOT NULL,
  `obstruccion` varchar(100) NOT NULL,
  `manometro` varchar(100) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `elaborado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `extintor`
--

INSERT INTO `extintor` (`id`, `materialext`, `fecha`, `marca`, `agentExtintor`, `capacidad`, `fechaUltimaRecarga`, `fechaProxRecarga`, `lugarAccesible`, `letrero`, `etiquetasLegibles`, `horquilla`, `corrocion`, `escapePresion`, `deformacion`, `exposicion`, `roturas`, `desprendimiento`, `protuberacion`, `perforacion`, `obstruccion`, `manometro`, `observacion`, `elaborado`) VALUES
(1, 'Extintor 4 - Almacen interior', '2022-12-15', 'Vymecfuego', 'PQS', '2', '2022-12-07', '2022-12-16', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'DSFSFSDFSD'),
(2, 'Extintor 5 - Subestación (planta emergencia)', '2022-12-16', 'Vymecfuego', 'CO2', '4.59', '2022-12-06', '2022-12-24', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'efsfsf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extractoraire`
--

CREATE TABLE `extractoraire` (
  `id` int(50) NOT NULL,
  `materialex` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `serie` varchar(100) NOT NULL,
  `medicionAmp` varchar(50) NOT NULL,
  `voltaje` varchar(50) NOT NULL,
  `revisionRondamiento` varchar(50) NOT NULL,
  `revisionBanda` varchar(50) NOT NULL,
  `revisionConexion` varchar(50) NOT NULL,
  `revisionTablero` varchar(50) NOT NULL,
  `eliminacionRuido` varchar(50) NOT NULL,
  `ajusteTornilleria` varchar(50) NOT NULL,
  `limpiezaGral` varchar(50) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `extractoraire`
--

INSERT INTO `extractoraire` (`id`, `materialex`, `fecha`, `marca`, `modelo`, `serie`, `medicionAmp`, `voltaje`, `revisionRondamiento`, `revisionBanda`, `revisionConexion`, `revisionTablero`, `eliminacionRuido`, `ajusteTornilleria`, `limpiezaGral`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Extractor 3 - Baños de mujeres valoración', '2022-12-15', 'SOLERPALAU', 'CRHT-10', '50103001', 'dsf', 'sdf', 'Si', 'Si ', 'Si', 'Si', 'Si', 'Si', 'Si ', '', 'fds', 'dsf', 'fd');

--
-- Disparadores `extractoraire`
--
DELIMITER $$
CREATE TRIGGER `bit_extractoraire_Update` AFTER UPDATE ON `extractoraire` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'extractoraire')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_extractoraire_delete` AFTER DELETE ON `extractoraire` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'extractoraire')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_extractoraire_insert` AFTER INSERT ON `extractoraire` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'extractoraire')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hidrante`
--

CREATE TABLE `hidrante` (
  `id` int(11) NOT NULL,
  `noHidrante` varchar(100) NOT NULL,
  `fechaH` date NOT NULL,
  `manguera` varchar(20) NOT NULL,
  `fechaPrueba` varchar(50) NOT NULL,
  `fechaProx` varchar(50) NOT NULL,
  `puerta` varchar(50) NOT NULL,
  `cristal` varchar(50) NOT NULL,
  `pintura` varchar(50) NOT NULL,
  `valvula` varchar(50) NOT NULL,
  `chiflon` varchar(50) NOT NULL,
  `estadoManguera` varchar(50) NOT NULL,
  `llave` varchar(50) NOT NULL,
  `señaletica` varchar(50) NOT NULL,
  `elaborado` varchar(100) NOT NULL,
  `observacion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hidrante`
--

INSERT INTO `hidrante` (`id`, `noHidrante`, `fechaH`, `manguera`, `fechaPrueba`, `fechaProx`, `puerta`, `cristal`, `pintura`, `valvula`, `chiflon`, `estadoManguera`, `llave`, `señaletica`, `elaborado`, `observacion`) VALUES
(1, '4 - Area azul(baños)', '2022-12-15', '30 m', '2022-12-07', '2022-12-01', 'Excelente ', 'Excelente ', 'Excelente ', 'Excelente ', 'Excelente ', 'Excelente ', 'Excelente ', 'Regular', 'Lizbeth', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidentestanqueterapeutico`
--

CREATE TABLE `incidentestanqueterapeutico` (
  `id` int(10) NOT NULL,
  `persona` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(50) NOT NULL,
  `tipoMateriaOrganica` varchar(150) NOT NULL,
  `bromaminas` varchar(150) NOT NULL,
  `tiempoCancelacion` varchar(150) NOT NULL,
  `quimicoAplicado` varchar(150) NOT NULL,
  `inicioActividad` varchar(150) NOT NULL,
  `equipoFiltrcion` varchar(150) NOT NULL,
  `observacion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidentestanqueterapeutico`
--

INSERT INTO `incidentestanqueterapeutico` (`id`, `persona`, `fecha`, `hora`, `tipoMateriaOrganica`, `bromaminas`, `tiempoCancelacion`, `quimicoAplicado`, `inicioActividad`, `equipoFiltrcion`, `observacion`) VALUES
(1, 'df', '2022-12-08', 'fsd', 'ds', 'sdf', 'dfs', 'fds', 'fds', 'dfs', 'fd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mecanoterapia`
--

CREATE TABLE `mecanoterapia` (
  `id` int(50) NOT NULL,
  `materialm` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoGral` varchar(50) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mecanoterapia`
--

INSERT INTO `mecanoterapia` (`id`, `materialm`, `fecha`, `chequeoGral`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Mesa de bipedestación 3 (ch)', '2022-12-16', 'Si ', '', 'hg', 'h', 'hjg'),
(2, 'Estéreo ', '2022-12-01', 'No (Comentar en observaciones generales)', 'werewrrew', 'rwer', 'rewrwe', 'wer'),
(3, 'Soporte parcial de peso ', '2022-12-08', 'Si ', '', 'wad', 'dwa', 'daw');

--
-- Disparadores `mecanoterapia`
--
DELIMITER $$
CREATE TRIGGER `bit_mecanoterapia_Update` AFTER UPDATE ON `mecanoterapia` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'UPDATE',
                                  CURDATE(),
                                  'mecanoterapia')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_mecanoterapia_delete` AFTER DELETE ON `mecanoterapia` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'DELETE',
                                  CURDATE(),
                                  'mecanoterapia')
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bit_mecanoterapia_insert` AFTER INSERT ON `mecanoterapia` FOR EACH ROW Insert t_bitacora(host, ususario, accion, fecha, tabla)
                           value (substring(user(), instr(user(), '@')+1),
                                  substring(user(), 1, instr(user(), '@')-1),
                                  'INSERT',
                                  CURDATE(),
                                  'mecanoterapia')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `odontopediatria`
--

CREATE TABLE `odontopediatria` (
  `id` int(50) NOT NULL,
  `materialo` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoGral` varchar(50) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `odontopediatria`
--

INSERT INTO `odontopediatria` (`id`, `materialo`, `fecha`, `chequeoGral`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Autoclave ', '2022-12-30', 'No (Comentar en observaciones generales)', '', 'lll', '24m', 'jjgf'),
(2, 'Carro rojo (Terapia ocupacional) ', '2022-12-02', 'No (Comentar en observaciones generales)', '', 'ewr', 'erw', 'ewr'),
(3, 'Autoclave ', '2022-12-07', 'Si ', '', 'wda', 'wad', 'wad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenservicio`
--

CREATE TABLE `ordenservicio` (
  `id` int(20) NOT NULL,
  `fecha` date NOT NULL,
  `equipo` varchar(200) NOT NULL,
  `areaAtencion` varchar(100) NOT NULL,
  `nombreSolicitante` text NOT NULL,
  `equipoo` varchar(50) NOT NULL,
  `marca` varchar(150) NOT NULL,
  `modelo` varchar(150) NOT NULL,
  `serie` varchar(150) NOT NULL,
  `tipoMantenimiento` varchar(200) NOT NULL,
  `descripcionServicio` varchar(200) NOT NULL,
  `observacion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ordenservicio`
--

INSERT INTO `ordenservicio` (`id`, `fecha`, `equipo`, `areaAtencion`, `nombreSolicitante`, `equipoo`, `marca`, `modelo`, `serie`, `tipoMantenimiento`, `descripcionServicio`, `observacion`) VALUES
(1, '2022-12-08', 'sad', 'asd', 'asd', 'sad', 'asdasd', 'asd', 'sda', 'sad', 'dsa', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `refrigerador`
--

CREATE TABLE `refrigerador` (
  `id` int(50) NOT NULL,
  `materialref` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `chequeoSellado` varchar(50) NOT NULL,
  `chequeoFuga` varchar(50) NOT NULL,
  `chequeoCableado` varchar(50) NOT NULL,
  `limpiezaExterior` varchar(50) NOT NULL,
  `limpiezaInterior` varchar(50) NOT NULL,
  `limpiezaEvaporador` varchar(50) NOT NULL,
  `medicionAmp` varchar(50) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `revisado` varchar(50) NOT NULL,
  `aprobado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `refrigerador`
--

INSERT INTO `refrigerador` (`id`, `materialref`, `fecha`, `chequeoSellado`, `chequeoFuga`, `chequeoCableado`, `limpiezaExterior`, `limpiezaInterior`, `limpiezaEvaporador`, `medicionAmp`, `observacion`, `elaborado`, `revisado`, `aprobado`) VALUES
(1, 'Refrigerador 1 - Botica', '2022-12-16', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'ery', 'ryey', 'ry');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siscontraincendio`
--

CREATE TABLE `siscontraincendio` (
  `id` int(20) NOT NULL,
  `fecha` date NOT NULL,
  `material` varchar(100) NOT NULL,
  `pruebaS` varchar(100) NOT NULL,
  `obs` varchar(200) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `siscontraincendio`
--

INSERT INTO `siscontraincendio` (`id`, `fecha`, `material`, `pruebaS`, `obs`, `name`) VALUES
(1, '2022-12-15', 'Bomba eléctrico', 'Si', '', 'sad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suministro`
--

CREATE TABLE `suministro` (
  `id` int(10) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `tipoGas` varchar(100) NOT NULL,
  `presionTanque` varchar(20) NOT NULL,
  `reserva` varchar(100) NOT NULL,
  `limpieza` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `observacion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `suministro`
--

INSERT INTO `suministro` (`id`, `fecha`, `tipoGas`, `presionTanque`, `reserva`, `limpieza`, `name`, `observacion`) VALUES
(1, '2022-12-23', 'Oxigeno ', 'd', 'sas', 'Si', 'asf', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suministrogaslp`
--

CREATE TABLE `suministrogaslp` (
  `id` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `noMat` varchar(200) NOT NULL,
  `litro` varchar(200) NOT NULL,
  `costo` varchar(30) NOT NULL,
  `subtotal` varchar(50) NOT NULL,
  `entrada` varchar(50) NOT NULL,
  `salida` varchar(50) NOT NULL,
  `seg` varchar(100) NOT NULL,
  `encargado` varchar(100) NOT NULL,
  `chofer` varchar(200) NOT NULL,
  `observacion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `suministrogaslp`
--

INSERT INTO `suministrogaslp` (`id`, `fecha`, `noMat`, `litro`, `costo`, `subtotal`, `entrada`, `salida`, `seg`, `encargado`, `chofer`, `observacion`) VALUES
(1, '2022-12-09', '1 - Cafetería', 'FDS', 'DS', 'DSF', 'DSF', 'DSF', 'SI', 'DFS', 'DFS', ''),
(2, '2022-12-02', '1 - Cafetería', 'dsf', 'sdf', 'sdf', 'fds', 'fds', 'SI', 'dfs', 'dsf', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suministrovaloracion`
--

CREATE TABLE `suministrovaloracion` (
  `id` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `tipoGas` varchar(100) NOT NULL,
  `dia` varchar(50) NOT NULL,
  `presionTanque` varchar(30) NOT NULL,
  `reserva` varchar(50) NOT NULL,
  `limpieza` varchar(2) NOT NULL,
  `name` varchar(100) NOT NULL,
  `observacion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `suministrovaloracion`
--

INSERT INTO `suministrovaloracion` (`id`, `fecha`, `tipoGas`, `dia`, `presionTanque`, `reserva`, `limpieza`, `name`, `observacion`) VALUES
(1, '2022-12-16', 'Aire', 'Jueves ', 'hola', 'sg', 'Si', 'dsg', ''),
(2, '2022-12-08', 'Oxigeno', 'Lunes ', 'kkh', 'kh', 'Si', 'kj', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tanquegas`
--

CREATE TABLE `tanquegas` (
  `id` int(50) NOT NULL,
  `noMat` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `encendido` varchar(50) NOT NULL,
  `apagado` varchar(50) NOT NULL,
  `nameprende` varchar(50) NOT NULL,
  `nameapaga` varchar(50) NOT NULL,
  `porcentaje` varchar(50) NOT NULL,
  `elaborado` varchar(50) NOT NULL,
  `observacion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tanqueterapeutico`
--

CREATE TABLE `tanqueterapeutico` (
  `id` int(20) NOT NULL,
  `fechaT` date NOT NULL,
  `name` varchar(200) NOT NULL,
  `semana` varchar(50) NOT NULL,
  `hora` varchar(50) NOT NULL,
  `bromo` varchar(50) NOT NULL,
  `ph` varchar(50) NOT NULL,
  `alca` varchar(50) NOT NULL,
  `dureza` varchar(50) NOT NULL,
  `temp` varchar(50) NOT NULL,
  `cloro` varchar(50) NOT NULL,
  `shock` varchar(50) NOT NULL,
  `acido` varchar(50) NOT NULL,
  `clarifi` varchar(50) NOT NULL,
  `aspirado` varchar(50) NOT NULL,
  `cepillado` varchar(50) NOT NULL,
  `contornado` varchar(50) NOT NULL,
  `moto1` varchar(50) NOT NULL,
  `moto2` varchar(50) NOT NULL,
  `filtro` varchar(50) NOT NULL,
  `presion` varchar(50) NOT NULL,
  `retrolavado` varchar(50) NOT NULL,
  `obs` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tanqueterapeutico`
--

INSERT INTO `tanqueterapeutico` (`id`, `fechaT`, `name`, `semana`, `hora`, `bromo`, `ph`, `alca`, `dureza`, `temp`, `cloro`, `shock`, `acido`, `clarifi`, `aspirado`, `cepillado`, `contornado`, `moto1`, `moto2`, `filtro`, `presion`, `retrolavado`, `obs`) VALUES
(1, '2022-12-02', 'dfg', 'Lunes ', '07:00', 'df', 'dg', 'df', 'gfdg', 'df', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Filtro 1', 'dg', 'Si', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_bitacora`
--

CREATE TABLE `t_bitacora` (
  `id` int(11) NOT NULL,
  `host` varchar(60) NOT NULL,
  `ususario` varchar(60) NOT NULL,
  `accion` varchar(60) NOT NULL,
  `fecha` varchar(60) NOT NULL,
  `tabla` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `t_bitacora`
--

INSERT INTO `t_bitacora` (`id`, `host`, `ususario`, `accion`, `fecha`, `tabla`) VALUES
(5, 'localhost', 'root', 'UPDATE', '2022-12-21', 'electricidade'),
(6, 'localhost', 'root', 'INSERT', '2022-12-23', 'electricidade'),
(7, 'localhost', 'root', 'UPDATE', '2022-12-23', 'electricidade'),
(8, 'localhost', 'root', 'UPDATE', '2022-12-29', 'bombas'),
(9, 'localhost', 'root', 'INSERT', '2022-12-30', 'bombas'),
(10, 'localhost', 'root', 'DELETE', '2022-12-31', 'electricidade'),
(11, 'localhost', 'root', 'DELETE', '2023-01-03', 'electricidade'),
(12, 'localhost', 'root', 'DELETE', '2023-01-03', 'bombacalor'),
(13, 'localhost', 'root', 'DELETE', '2023-01-03', 'aireacondicionado'),
(14, 'localhost', 'root', 'INSERT', '2023-01-04', 'electricidade'),
(15, 'localhost', 'root', 'UPDATE', '2023-01-04', 'electricidade'),
(16, 'localhost', 'root', 'UPDATE', '2023-01-04', 'electricidade'),
(17, 'localhost', 'root', 'UPDATE', '2023-01-04', 'electricidade'),
(18, 'localhost', 'root', 'INSERT', '2023-01-04', 'electricidade'),
(19, 'localhost', 'root', 'DELETE', '2023-01-04', 'electricidade');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `pass`) VALUES
(1, 'LIZBETH', 'lizbethventura608@gmail.com', '12345'),
(7, 'Yanni', 'ca403040@uaeh.edu.mx', '123456'),
(8, 'Dulce', 've412051@uaeh.edu.mx', '12345'),
(9, 'Criss', 've412051@uaeh.edu.mx', '123'),
(11, 'Mayra', 've412051@uaeh.edu.mx', '123456'),
(12, 'Martin', 've412051@uaeh.edu.mx', '123'),
(13, 'Rocy', 'lizbethventura608@gmail.com', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aireacondicionado`
--
ALTER TABLE `aireacondicionado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `bombacalor`
--
ALTER TABLE `bombacalor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `bombas`
--
ALTER TABLE `bombas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `calderaelectromecanico`
--
ALTER TABLE `calderaelectromecanico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `calderas`
--
ALTER TABLE `calderas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cems`
--
ALTER TABLE `cems`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cisternaagua`
--
ALTER TABLE `cisternaagua`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `compresoraire`
--
ALTER TABLE `compresoraire`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `contraincendio`
--
ALTER TABLE `contraincendio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `dosificadoragua`
--
ALTER TABLE `dosificadoragua`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `electricidade`
--
ALTER TABLE `electricidade`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `enfermeria`
--
ALTER TABLE `enfermeria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `equipomedico`
--
ALTER TABLE `equipomedico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `extintor`
--
ALTER TABLE `extintor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `extractoraire`
--
ALTER TABLE `extractoraire`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `hidrante`
--
ALTER TABLE `hidrante`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `incidentestanqueterapeutico`
--
ALTER TABLE `incidentestanqueterapeutico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mecanoterapia`
--
ALTER TABLE `mecanoterapia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `odontopediatria`
--
ALTER TABLE `odontopediatria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ordenservicio`
--
ALTER TABLE `ordenservicio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `refrigerador`
--
ALTER TABLE `refrigerador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `siscontraincendio`
--
ALTER TABLE `siscontraincendio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `suministro`
--
ALTER TABLE `suministro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `suministrogaslp`
--
ALTER TABLE `suministrogaslp`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `suministrovaloracion`
--
ALTER TABLE `suministrovaloracion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tanquegas`
--
ALTER TABLE `tanquegas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tanqueterapeutico`
--
ALTER TABLE `tanqueterapeutico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `t_bitacora`
--
ALTER TABLE `t_bitacora`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aireacondicionado`
--
ALTER TABLE `aireacondicionado`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `bombacalor`
--
ALTER TABLE `bombacalor`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `bombas`
--
ALTER TABLE `bombas`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `calderaelectromecanico`
--
ALTER TABLE `calderaelectromecanico`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `calderas`
--
ALTER TABLE `calderas`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cems`
--
ALTER TABLE `cems`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cisternaagua`
--
ALTER TABLE `cisternaagua`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `compresoraire`
--
ALTER TABLE `compresoraire`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `contraincendio`
--
ALTER TABLE `contraincendio`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dosificadoragua`
--
ALTER TABLE `dosificadoragua`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `electricidade`
--
ALTER TABLE `electricidade`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `enfermeria`
--
ALTER TABLE `enfermeria`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `equipomedico`
--
ALTER TABLE `equipomedico`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `extintor`
--
ALTER TABLE `extintor`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `extractoraire`
--
ALTER TABLE `extractoraire`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `hidrante`
--
ALTER TABLE `hidrante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `incidentestanqueterapeutico`
--
ALTER TABLE `incidentestanqueterapeutico`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `mecanoterapia`
--
ALTER TABLE `mecanoterapia`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `odontopediatria`
--
ALTER TABLE `odontopediatria`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ordenservicio`
--
ALTER TABLE `ordenservicio`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `refrigerador`
--
ALTER TABLE `refrigerador`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `siscontraincendio`
--
ALTER TABLE `siscontraincendio`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `suministro`
--
ALTER TABLE `suministro`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `suministrogaslp`
--
ALTER TABLE `suministrogaslp`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `suministrovaloracion`
--
ALTER TABLE `suministrovaloracion`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tanquegas`
--
ALTER TABLE `tanquegas`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tanqueterapeutico`
--
ALTER TABLE `tanqueterapeutico`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `t_bitacora`
--
ALTER TABLE `t_bitacora`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
