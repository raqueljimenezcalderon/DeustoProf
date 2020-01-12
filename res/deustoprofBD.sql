-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.36-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para deustoprof
CREATE DATABASE IF NOT EXISTS `deustoprof` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `deustoprof`;

-- Volcando estructura para tabla deustoprof.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `dni_alumno` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `birthdate` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `intolerancia` varchar(50) NOT NULL,
  PRIMARY KEY (`dni_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla deustoprof.alumno: ~3 rows (aproximadamente)
DELETE FROM `alumno`;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`dni_alumno`, `nombre`, `apellido`, `birthdate`, `sexo`, `ciudad`, `intolerancia`) VALUES
	('12', 'Eusebio', 'Gonzalez', '15/12/1987', 'F', 'Bilbao', 'N');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para tabla deustoprof.asignatura
CREATE TABLE IF NOT EXISTS `asignatura` (
  `cod_asig` varchar(50) NOT NULL DEFAULT '',
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `descripcion` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cod_asig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla deustoprof.asignatura: ~2 rows (aproximadamente)
DELETE FROM `asignatura`;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` (`cod_asig`, `nombre`, `descripcion`) VALUES
	('1', 'Historia', 'Historia de España'),
	('2', 'Matematicas2', 'Continuacion a matematicas');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;

-- Volcando estructura para tabla deustoprof.matricula
CREATE TABLE IF NOT EXISTS `matricula` (
  `dni_alumno` varchar(50) NOT NULL,
  `cod_asig` varchar(50) NOT NULL DEFAULT '',
  `nota` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dni_alumno`,`cod_asig`),
  KEY `fk_cod_asig` (`cod_asig`),
  CONSTRAINT `fk_cod_asig` FOREIGN KEY (`cod_asig`) REFERENCES `asignatura` (`cod_asig`),
  CONSTRAINT `fk_dni_alumno` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla deustoprof.matricula: ~0 rows (aproximadamente)
DELETE FROM `matricula`;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;

-- Volcando estructura para tabla deustoprof.profesor
CREATE TABLE IF NOT EXISTS `profesor` (
  `dni_profe` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `birthdate` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`dni_profe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla deustoprof.profesor: ~2 rows (aproximadamente)
DELETE FROM `profesor`;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` (`dni_profe`, `nombre`, `apellido`, `birthdate`, `sexo`, `ciudad`, `contrasena`, `telefono`) VALUES
	('1234', 'Alfredo', 'Sanz', '10/10/2010', 'Masculino', 'Bilbao', '1234', '83423217');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
