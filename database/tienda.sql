/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.19-nt : Database - tienda
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tienda` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `tienda`;

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `categoriaId` INT(6) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` VARCHAR(250) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY  (`categoriaId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


/*Table structure for table `detallepedido` */

DROP TABLE IF EXISTS `detallepedido`;

CREATE TABLE `detallepedido` (
  `pedidoId` INT(6) NOT NULL,
  `productoId` INT(6) NOT NULL,
  `cantidad` INT(6) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  KEY `pedidoId` (`pedidoId`),
  KEY `productoId` (`productoId`),
  CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`pedidoId`) REFERENCES `pedido` (`pedidoId`),
  CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`productoId`) REFERENCES `producto` (`productoId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `detallepedido` */

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `pedidoId` INT(6) NOT NULL AUTO_INCREMENT,
  `usuarioId` INT(6) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY  (`pedidoId`),
  KEY `usuarioId` (`usuarioId`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`usuarioId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `pedido` */

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `productoId` INT(6) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(500) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` TEXT COLLATE utf8_spanish_ci NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `categoriaId` INT(11) NOT NULL,
  `imagen` VARCHAR(500) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY  (`productoId`),
  KEY `categoriaId` (`categoriaId`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`categoriaId`) REFERENCES `categoria` (`categoriaId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `usuarioId` INT(6) NOT NULL AUTO_INCREMENT,
  `nombreCompleto` VARCHAR(250) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  `nombreUsuario` VARCHAR(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  `password` VARCHAR(100) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` VARCHAR(500) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY  (`usuarioId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `usuario` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
