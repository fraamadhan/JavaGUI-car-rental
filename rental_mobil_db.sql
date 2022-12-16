-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20221010.6785c97d22
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 09:47 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_mobil_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `mobil_id` varchar(10) NOT NULL,
  `jenis` varchar(255) DEFAULT NULL,
  `sewa` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`mobil_id`, `jenis`, `sewa`, `stok`) VALUES
('A001', 'Avanza', 100000, 9),
('B001', 'BMW', 400000, 5),
('B002', 'Bentley', 1000000, 0),
('C001', 'Chevrolet', 350000, 3),
('J001', 'Jeep', 250000, 3),
('L001', 'Lexus', 400000, 2),
('L002', 'Lamborghini', 1000000, 12),
('X001', 'Xeniia', 200000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `kode` varchar(1) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `contact_person` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`username`, `password`, `userId`, `kode`, `nama`, `alamat`, `contact_person`) VALUES
('banibaran', '70c9367451252202e086ae2704d40ec63e0da23c41fad6e8738f83c7223545ca', 1, '2', 'Rabbani Aldebaran', 'Jl. Sindanglayu No. 18', '085647213489'),
('admin', 'fb001dfcffd1c899f3297871406242f097aecf1a5342ccf3ebcd116146188e4b', 6, '1', NULL, NULL, NULL),
('InshiraVietaAmara', '79c3271cace67c9caf2477aaca46e7231d3ea0b7e1757cced1316f709d2006fb', 7, '2', 'Inshira Vieta Amara', 'Jl. Sekelong No. 73', '08987509934'),
('rahmaadinda', '8fe4f446d4875968e53e2cf1d041db28028c0e0f34b2f533888bfff1a18956f9', 11, '2', 'Rahma Adinda Putri', 'Jl. Cigadoo', '08765482192'),
('Dimz', '3880eece9f1c47a1d230517da9b7359c5403c51fc587b4417b0e8aa2dfeb0b84', 12, '2', 'Dimaz Daffa', 'Jl. Wartawan Parahyangan', '089765421335');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(100) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `contact_person` varchar(20) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `alamat`, `contact_person`, `userId`) VALUES
('A001', 'Abdillah Kavindra Zhafif', 'Jl. Buah Stone Bandung', '08121409089', 7),
('C001', 'Chiquita Ahsanunissa', 'Jl. Chinodung Bandung', '085623914029', 7),
('F001', 'Fakhri Fajar Ramadhan', 'Jl. Sekelong Bandung	', '081726962012', 7),
('K11', 'Kania Kamelia', 'Jl. Gatot Subroto', '085678462123', 7),
('L001', 'Levina Iola', 'Jl. Solo Unbraw', '08121876123', 7),
('S001', 'Sherly Azzahra', 'Jl. Situmondok', '081214081923', 7),
('T001', 'Tanya Qatrunnada', 'Jl. Salendro East', '08761234152', 7);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(10) NOT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_harus_kembali` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `lama_pinjam` int(11) DEFAULT NULL,
  `telat` int(11) DEFAULT NULL,
  `denda` int(11) DEFAULT NULL,
  `total_sewa` int(11) DEFAULT NULL,
  `id_pelanggan` varchar(100) DEFAULT NULL,
  `mobil_id` varchar(10) DEFAULT NULL,
  `id_pegawai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `tanggal_pinjam`, `tanggal_harus_kembali`, `tanggal_kembali`, `lama_pinjam`, `telat`, `denda`, `total_sewa`, `id_pelanggan`, `mobil_id`, `id_pegawai`) VALUES
('K001', '2022-12-01', '2022-12-03', '2022-12-06', 2, 3, 300000, 800000, 'A001', 'B001', 7),
('K002', '2022-12-02', '2022-12-09', '2022-12-09', 7, 0, 0, 840000, 'T001', 'X001', 7),
('K019', '2022-12-17', '2022-12-19', '2022-12-21', 2, 2, 200000, 1000000, 'K11', 'L001', 7),
('K069', '2022-12-02', '2022-12-05', '2022-12-07', 3, 2, 200000, 3000000, 'F001', 'L002', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`mobil_id`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `mobil_id` (`mobil_id`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `pelanggan_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `pegawai` (`userId`);

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`mobil_id`) REFERENCES `mobil` (`mobil_id`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
