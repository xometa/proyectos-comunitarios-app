-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-01-2019 a las 19:54:42
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estructura`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alcaldes`
--

CREATE TABLE `alcaldes` (
  `idpersona` int(11) NOT NULL,
  `tipo` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alcaldes`
--

INSERT INTO `alcaldes` (`idpersona`, `tipo`) VALUES
(1, 'Nacional'),
(3, 'Nacional'),
(10, 'Nacional');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alcaldia`
--

CREATE TABLE `alcaldia` (
  `idalcaldia` int(11) NOT NULL,
  `nombrealcaldia` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nit` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idmunicipio` int(11) DEFAULT NULL,
  `idalcalde` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alcaldia`
--

INSERT INTO `alcaldia` (`idalcaldia`, `nombrealcaldia`, `nit`, `telefono`, `idmunicipio`, `idalcalde`) VALUES
(2, 'Alcaldia de San Martín', '0102-011079-001-9', '2225-1515', 2, 10),
(4, 'Alcaldia de Aguilares', '5451-515151-515-1', '2221-4511', 4, 3),
(5, 'Alcaldia de Ahuachapan', '0101-010611-001-0', '2222-2222', 1, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comunidades`
--

CREATE TABLE `comunidades` (
  `idcomunidad` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idmunicipio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comunidades`
--

INSERT INTO `comunidades` (`idcomunidad`, `nombre`, `codigo`, `idmunicipio`) VALUES
(2, 'San Miguelito', 'SO4569', 1),
(5, 'El Paraíso', 'EO4990', 1),
(6, 'La Esperanza', 'LA3376', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `iddepartamento` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idzona` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`iddepartamento`, `nombre`, `codigo`, `idzona`) VALUES
(8, 'Ahuachapan', 'AHU820', 2),
(9, 'Santa Ana', 'SAN744', 1),
(10, 'Sonsonate', 'SON456', 1),
(11, 'San Salvador', 'SAN745', 3),
(13, 'Chalatenango', 'CHA417', 3),
(14, 'La Libertad', 'LAL456', 3),
(15, 'Usulutan', 'USU478', 2),
(16, 'San Miguel', 'SAN742', 2),
(17, 'Morazán', 'MOR012', 2),
(18, 'La Unión', 'LAU786', 2),
(19, 'La Paz', 'LAP418', 4),
(20, 'Cabañas', 'CAB146', 4),
(21, 'San Vicente', 'SAN741', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donaciones`
--

CREATE TABLE `donaciones` (
  `idonaciones` int(11) NOT NULL,
  `iddonante` int(11) DEFAULT NULL,
  `idproyecto` int(11) DEFAULT NULL,
  `montodonar` double(10,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `donaciones`
--

INSERT INTO `donaciones` (`idonaciones`, `iddonante`, `idproyecto`, `montodonar`, `fecha`) VALUES
(23, 2, 2, 1000.00, '2019-01-07'),
(26, 7, 2, 3000.00, '2019-01-15'),
(27, 7, 2, 7000.00, '2019-01-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donantes`
--

CREATE TABLE `donantes` (
  `iddonantes` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `empresa` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigopostal` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudad` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pais` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `donantes`
--

INSERT INTO `donantes` (`iddonantes`, `nombre`, `empresa`, `email`, `direccion`, `codigopostal`, `ciudad`, `telefono`, `tipo`, `pais`) VALUES
(1, 'José Saúl Hernández Vásquez', 'La Curacao S.A de C.V', 'josemaichol@gmail.com', 'San Pedro Perulapan', '45789', 'San Pedro Perulapan', '7588-5986', 'Nacional', ''),
(2, 'Jenny Maricela Hernández Vásquez', 'Omnispport S.A de C.V', 'jenny99@hotmail.com', 'av. 45, calle 75, soyapango', '78965', 'Soyapango', '7145-8963', 'Extranjero', 'Alemania'),
(7, 'Nancy Irene Hernández Vásquez', 'RAF SA DE CV', 'raf@hotmail.com', 'calle 27, gerardo barrios, soyapango', '7896', 'Cojutepeque', '4596-8968', 'Extranjero', 'Alemania'),
(11, 'Jose Angel García López', 'LEMON COMPANY', 'lemon@gmail.com', 'elemania,barrio55, barcelona', '7456', 'Barcenlona', '2225-7859', 'Nacional', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipios`
--

CREATE TABLE `municipios` (
  `idmunicipio` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iddepartamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `municipios`
--

INSERT INTO `municipios` (`idmunicipio`, `nombre`, `codigo`, `iddepartamento`) VALUES
(1, 'Ahuachapan', 'AHU988', 18),
(2, 'Apaneca', 'APA745', 8),
(4, 'Aguilares', 'AGU990', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `dui` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nit` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `profesion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `apellidos`, `fechanacimiento`, `dui`, `nit`, `profesion`, `sexo`) VALUES
(1, 'Don Lazaro ', 'Flores', '1974-01-17', '48489487-4', '8747-847847-847-8', 'Alcalde', 'Masculino'),
(3, 'José Saúl', 'Hernández Vásquez', '1998-07-02', '12481441-5', '1132-181561-561-5', 'Ingeniero en Sistemas', 'Masculino'),
(10, 'Jenny', 'Vasquez', '1999-08-12', '23265615-6', '1321-864156-156-1', 'Comunicaiones', 'Femenino'),
(45, 'Evelin del Carmen', 'López Ventura', '1970-01-02', '54515545-6', '7848-481151-515-1', 'Lic. en Contaduría Pública', 'Femenino'),
(46, 'Jenny Maricela ', 'Hernandez Vasquez', '1999-08-12', '78484874-4', '7846-418415-154-5', 'Hosteleria y turismo', 'Femenino'),
(47, 'José Saúl', 'Hernández Vásquez', '1998-01-01', '05737518-9', '0710-020798-101-0', 'Turismo', 'Masculino'),
(48, 'Adaministrador', 'Administrador', '1980-01-02', '05737518-0', '1551-515151-561-5', 'Ingeniería en Sistemas', 'Masculino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preliquidaciones`
--

CREATE TABLE `preliquidaciones` (
  `idpreliquidacion` int(11) NOT NULL,
  `clasedeobra` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `capitulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `precioproyecto` double(10,2) DEFAULT NULL,
  `unidadesproyecto` double(10,2) DEFAULT NULL,
  `importeproyecto` double(10,2) DEFAULT NULL,
  `unidadespreliquidaciones` double(10,2) DEFAULT NULL,
  `importepreliquidaciones` double(10,2) DEFAULT NULL,
  `diferencia` double(10,2) DEFAULT NULL,
  `idproyecto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `preliquidaciones`
--

INSERT INTO `preliquidaciones` (`idpreliquidacion`, `clasedeobra`, `capitulo`, `precioproyecto`, `unidadesproyecto`, `importeproyecto`, `unidadespreliquidaciones`, `importepreliquidaciones`, `diferencia`, `idproyecto`) VALUES
(12, 'Limpieza', 'Fontanería', 12.00, 123.00, 1476.00, 100.00, 1200.00, -276.00, 1),
(13, '100', 'Vidrieria', 100.00, 10.00, 1000.00, 14.00, 1400.00, 400.00, 3),
(14, '10', 'Fontanería', 12.00, 10.00, 120.00, 120.00, 1440.00, 1320.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `idproyecto` int(11) NOT NULL,
  `codigoproyecto` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `monto` double(10,2) DEFAULT NULL,
  `fechainicia` date DEFAULT NULL,
  `fechafinaliza` date DEFAULT NULL,
  `estado` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idalcaldia` int(11) DEFAULT NULL,
  `idcomunidad` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`idproyecto`, `codigoproyecto`, `descripcion`, `monto`, `fechainicia`, `fechafinaliza`, `estado`, `idalcaldia`, `idcomunidad`, `iduser`) VALUES
(1, 'R000E195074', 'Reparacion de Calle', 5000.00, '2019-01-09', '2019-01-26', 'Ejecutandose', 2, 2, 46),
(2, 'R000N107103', 'Reparacion', 10000.00, '2019-01-01', '2019-01-25', 'Ejecutado', 4, 6, 47),
(3, 'C000A225282', 'Construccion de Cancha', 15000.00, '2019-01-02', '2019-01-26', 'Cancelado', 5, 5, 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idpersonauser` int(11) NOT NULL,
  `codigo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contrasena` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipouser` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idpersonauser`, `codigo`, `usuario`, `contrasena`, `tipouser`) VALUES
(45, 'L000A13112', 'eve54', 'c5b2cebf15b205503560c4e8e6d1ea78', 'Empleado'),
(46, 'H000Z17146', 'jenny99', 'c5b2cebf15b205503560c4e8e6d1ea78', 'Administrador'),
(47, 'H000Z17274', 'Sony', 'c5b2cebf15b205503560c4e8e6d1ea78', 'Administrador'),
(48, 'A000R1329', 'Administrador', 'c5b2cebf15b205503560c4e8e6d1ea78', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE `zonas` (
  `idzona` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `zonas`
--

INSERT INTO `zonas` (`idzona`, `nombre`, `codigo`) VALUES
(1, 'Zona Occidental', 'ZO4578'),
(2, 'Zona Oriental', 'ZO4575'),
(3, 'Zona Central', 'ZC3785'),
(4, 'Zona Paracentral', 'ZP7482');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alcaldes`
--
ALTER TABLE `alcaldes`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `alcaldia`
--
ALTER TABLE `alcaldia`
  ADD PRIMARY KEY (`idalcaldia`),
  ADD KEY `fk_idalcalde` (`idalcalde`),
  ADD KEY `fk_idmuni` (`idmunicipio`);

--
-- Indices de la tabla `comunidades`
--
ALTER TABLE `comunidades`
  ADD PRIMARY KEY (`idcomunidad`),
  ADD KEY `fk_idmunicipio` (`idmunicipio`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`iddepartamento`),
  ADD KEY `fk_idzona` (`idzona`);

--
-- Indices de la tabla `donaciones`
--
ALTER TABLE `donaciones`
  ADD PRIMARY KEY (`idonaciones`),
  ADD KEY `fk_iddonante` (`iddonante`),
  ADD KEY `fk_idproyecto` (`idproyecto`);

--
-- Indices de la tabla `donantes`
--
ALTER TABLE `donantes`
  ADD PRIMARY KEY (`iddonantes`);

--
-- Indices de la tabla `municipios`
--
ALTER TABLE `municipios`
  ADD PRIMARY KEY (`idmunicipio`),
  ADD KEY `fk_iddepartamento` (`iddepartamento`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD UNIQUE KEY `dui` (`dui`),
  ADD UNIQUE KEY `nit` (`nit`);

--
-- Indices de la tabla `preliquidaciones`
--
ALTER TABLE `preliquidaciones`
  ADD PRIMARY KEY (`idpreliquidacion`),
  ADD KEY `fk_idproyectos` (`idproyecto`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`idproyecto`),
  ADD UNIQUE KEY `codigoproyecto` (`codigoproyecto`),
  ADD KEY `fk_iduser` (`iduser`),
  ADD KEY `fk_idalcaldia` (`idalcaldia`),
  ADD KEY `fk_idcomunidad` (`idcomunidad`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idpersonauser`);

--
-- Indices de la tabla `zonas`
--
ALTER TABLE `zonas`
  ADD PRIMARY KEY (`idzona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alcaldes`
--
ALTER TABLE `alcaldes`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `alcaldia`
--
ALTER TABLE `alcaldia`
  MODIFY `idalcaldia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `comunidades`
--
ALTER TABLE `comunidades`
  MODIFY `idcomunidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `iddepartamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `donaciones`
--
ALTER TABLE `donaciones`
  MODIFY `idonaciones` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `donantes`
--
ALTER TABLE `donantes`
  MODIFY `iddonantes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `municipios`
--
ALTER TABLE `municipios`
  MODIFY `idmunicipio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `preliquidaciones`
--
ALTER TABLE `preliquidaciones`
  MODIFY `idpreliquidacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `idproyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idpersonauser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `zonas`
--
ALTER TABLE `zonas`
  MODIFY `idzona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alcaldes`
--
ALTER TABLE `alcaldes`
  ADD CONSTRAINT `fk_idpersonaalcalde` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`);

--
-- Filtros para la tabla `alcaldia`
--
ALTER TABLE `alcaldia`
  ADD CONSTRAINT `fk_idalcalde` FOREIGN KEY (`idalcalde`) REFERENCES `alcaldes` (`idpersona`),
  ADD CONSTRAINT `fk_idmuni` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`);

--
-- Filtros para la tabla `comunidades`
--
ALTER TABLE `comunidades`
  ADD CONSTRAINT `fk_idmunicipio` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`);

--
-- Filtros para la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD CONSTRAINT `fk_idzona` FOREIGN KEY (`idzona`) REFERENCES `zonas` (`idzona`);

--
-- Filtros para la tabla `donaciones`
--
ALTER TABLE `donaciones`
  ADD CONSTRAINT `fk_iddonante` FOREIGN KEY (`iddonante`) REFERENCES `donantes` (`iddonantes`),
  ADD CONSTRAINT `fk_idproyecto` FOREIGN KEY (`idproyecto`) REFERENCES `proyectos` (`idproyecto`);

--
-- Filtros para la tabla `municipios`
--
ALTER TABLE `municipios`
  ADD CONSTRAINT `fk_iddepartamento` FOREIGN KEY (`iddepartamento`) REFERENCES `departamentos` (`iddepartamento`);

--
-- Filtros para la tabla `preliquidaciones`
--
ALTER TABLE `preliquidaciones`
  ADD CONSTRAINT `fk_idproyectos` FOREIGN KEY (`idproyecto`) REFERENCES `proyectos` (`idproyecto`);

--
-- Filtros para la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD CONSTRAINT `fk_idalcaldia` FOREIGN KEY (`idalcaldia`) REFERENCES `alcaldia` (`idalcaldia`),
  ADD CONSTRAINT `fk_idcomunidad` FOREIGN KEY (`idcomunidad`) REFERENCES `comunidades` (`idcomunidad`),
  ADD CONSTRAINT `fk_iduser` FOREIGN KEY (`iduser`) REFERENCES `usuarios` (`idpersonauser`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_idpersonauser` FOREIGN KEY (`idpersonauser`) REFERENCES `persona` (`idpersona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
