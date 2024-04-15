-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Apr 15, 2024 alle 13:37
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionecolli`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `idpermesso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `account`
--

INSERT INTO `account` (`id`, `username`, `email`, `password`, `idpermesso`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin', 1),
(2, 'glssalerno', 'glssalerno@gmail.com', 'glssalerno', 2),
(21, 'd', 'd', 'd', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `colli`
--

CREATE TABLE `colli` (
  `id` int(11) NOT NULL,
  `codice` varchar(20) NOT NULL,
  `mittente` varchar(30) NOT NULL,
  `destinatario` varchar(30) NOT NULL,
  `peso` int(11) NOT NULL,
  `stato` varchar(30) DEFAULT NULL,
  `idveicolo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `colli`
--

INSERT INTO `colli` (`id`, `codice`, `mittente`, `destinatario`, `peso`, `stato`, `idveicolo`) VALUES
(1, 'a', 'a', 'a', 1, 'spedito', 7),
(4, 'aaaaa', 'a', 'a', 3, 'spedito', 8),
(5, 'r', 'r', 'r', 16, 'spedito', 9),
(6, 'rrrr', 'r', 'r', 3, 'inlavorazione', 8),
(7, 'prova', 'elio', 'peppe', 10, 'inlavorazione', 8),
(8, 'qwerty', 'alfio', 'caio', 1, 'inlavorazione', 7),
(9, '131101', 'alfredo', 'aldo', 2, NULL, 8);

-- --------------------------------------------------------

--
-- Struttura della tabella `corrieri`
--

CREATE TABLE `corrieri` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `piva` char(13) NOT NULL,
  `indirizzo` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `citta` varchar(30) NOT NULL,
  `cap` varchar(10) NOT NULL,
  `idaccount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `corrieri`
--

INSERT INTO `corrieri` (`id`, `nome`, `piva`, `indirizzo`, `telefono`, `citta`, `cap`, `idaccount`) VALUES
(1, 'gls', 'IT00000000001', 'via roma 1', '3333333333', 'salerno', '84070', 2),
(4, 'd', 'd', 'd', 'd', 'd', 'd', 21);

-- --------------------------------------------------------

--
-- Struttura della tabella `permessi`
--

CREATE TABLE `permessi` (
  `id` int(11) NOT NULL,
  `permesso` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `permessi`
--

INSERT INTO `permessi` (`id`, `permesso`) VALUES
(1, 'admin'),
(2, 'guest');

-- --------------------------------------------------------

--
-- Struttura della tabella `veicoli`
--

CREATE TABLE `veicoli` (
  `id` int(11) NOT NULL,
  `codice` varchar(25) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `capienza` int(11) NOT NULL,
  `caricoattuale` int(11) DEFAULT NULL,
  `idcorriere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `veicoli`
--

INSERT INTO `veicoli` (`id`, `codice`, `tipo`, `capienza`, `caricoattuale`, `idcorriere`) VALUES
(7, 'qqqqqq', 'porter', 12, 11, 4),
(8, 'rtyy', 'porter', 15, 15, 4),
(9, 'asda', 'porter', 17, 16, 4),
(12, 'iop', 'Camion', 20, 4, 4),
(13, 'prova', 'porter', 12, NULL, 4);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idxemail` (`email`),
  ADD KEY `idpermesso` (`idpermesso`),
  ADD KEY `idxuserpass` (`username`,`password`),
  ADD KEY `idxemailpass` (`email`,`password`);

--
-- Indici per le tabelle `colli`
--
ALTER TABLE `colli`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idxcodice` (`codice`),
  ADD KEY `fk_idveicolo` (`idveicolo`);

--
-- Indici per le tabelle `corrieri`
--
ALTER TABLE `corrieri`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idxtelefono` (`telefono`),
  ADD KEY `idaccount` (`idaccount`);

--
-- Indici per le tabelle `permessi`
--
ALTER TABLE `permessi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idxpermesso` (`permesso`);

--
-- Indici per le tabelle `veicoli`
--
ALTER TABLE `veicoli`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idxcodice` (`codice`),
  ADD KEY `fkcorriere` (`idcorriere`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT per la tabella `colli`
--
ALTER TABLE `colli`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT per la tabella `corrieri`
--
ALTER TABLE `corrieri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `permessi`
--
ALTER TABLE `permessi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`idpermesso`) REFERENCES `permessi` (`id`);

--
-- Limiti per la tabella `colli`
--
ALTER TABLE `colli`
  ADD CONSTRAINT `fk_idveicolo` FOREIGN KEY (`idveicolo`) REFERENCES `veicoli` (`id`);

--
-- Limiti per la tabella `corrieri`
--
ALTER TABLE `corrieri`
  ADD CONSTRAINT `corrieri_ibfk_1` FOREIGN KEY (`idaccount`) REFERENCES `account` (`id`);

--
-- Limiti per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  ADD CONSTRAINT `fkcorriere` FOREIGN KEY (`idcorriere`) REFERENCES `corrieri` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
