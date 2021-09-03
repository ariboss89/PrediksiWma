# Host: localhost  (Version: 5.5.5-10.4.17-MariaDB)
# Date: 2021-09-04 00:35:29
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_barang"
#

DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE `tb_barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(255) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_barang"
#

INSERT INTO `tb_barang` VALUES (4,'Raket Lining','BADMINTON'),(5,'Bola Kaki','SEPAKBOLA');

#
# Structure for table "tb_kategori"
#

DROP TABLE IF EXISTS `tb_kategori`;
CREATE TABLE `tb_kategori` (
  `kategori` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_kategori"
#

INSERT INTO `tb_kategori` VALUES ('BADMINTON'),('SEPAKBOLA');

#
# Structure for table "tb_pengadaan"
#

DROP TABLE IF EXISTS `tb_pengadaan`;
CREATE TABLE `tb_pengadaan` (
  `id_pengadaan` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(255) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `bulan` varchar(255) DEFAULT NULL,
  `tahun` varchar(255) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pengadaan`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_pengadaan"
#

INSERT INTO `tb_pengadaan` VALUES (8,'Raket Lining','BADMINTON','JANUARI','2020',30),(9,'Bola Kaki','SEPAKBOLA','JANUARI','2020',30),(10,'Bola Kaki','SEPAKBOLA','FEBRUARI','2020',30),(11,'Bola Kaki','SEPAKBOLA','MARET','2020',25);

#
# Structure for table "tb_pengguna"
#

DROP TABLE IF EXISTS `tb_pengguna`;
CREATE TABLE `tb_pengguna` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `role` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_pengguna"
#

INSERT INTO `tb_pengguna` VALUES ('admin','ADMIN','123456'),('andez','SUPERADMIN','123456');

#
# Structure for table "tb_prediksi"
#

DROP TABLE IF EXISTS `tb_prediksi`;
CREATE TABLE `tb_prediksi` (
  `id_prediksi` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(255) DEFAULT NULL,
  `tahun` varchar(255) DEFAULT NULL,
  `hasil` varchar(255) DEFAULT NULL,
  `galat` varchar(255) DEFAULT NULL,
  `mse` varchar(255) DEFAULT NULL,
  `akurasi` varchar(255) DEFAULT NULL,
  `id_riwayat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_prediksi`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_prediksi"
#

INSERT INTO `tb_prediksi` VALUES (1,'Bola Kaki','2020','27.5','7.5','18.75','81.25%','R001');

#
# Structure for table "tb_riwayat"
#

DROP TABLE IF EXISTS `tb_riwayat`;
CREATE TABLE `tb_riwayat` (
  `id_riwayat` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_riwayat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_riwayat"
#

