  CREATE TABLE IF NOT EXISTS `raf_pacientes` (
    `nmid` int NOT NULL AUTO_INCREMENT,
    `dsnombre` varchar(100) NOT NULL,
    `nmidespecie` int NOT NULL,
    `nmidraza` int NOT NULL,
    `fenacimiento` date NOT NULL,
    `nmidtipoidentificacion` int NOT NULL,
    `nmidentificacion` int NOT NULL,
    `dsduenio` varchar(50) NOT NULL,
    `dsciudad` varchar(50) NOT NULL,
    `dsdireccion` varchar(50) NOT NULL,
    `nmtelefono` int NOT NULL,
    `feregistro` date NOT NULL,
    PRIMARY KEY (`nmid`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

    CREATE TABLE IF NOT EXISTS `raf_administradores` (
      `nmid` int NOT NULL AUTO_INCREMENT,
      `dsnombre` varchar(100) NOT NULL,
      `email` varchar(100) NOT NULL,
      `password` varchar(100) NOT NULL,
      PRIMARY KEY (`nmid`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;