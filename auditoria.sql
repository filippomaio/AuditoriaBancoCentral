-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06-Nov-2018 às 23:52
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auditoria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `id` int(4) NOT NULL,
  `login` varchar(16) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `cargo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `login`, `senha`, `cargo`) VALUES
(1, 'auditor', 'auditor', 1),
(2, 'gestor', 'gestor', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `mitigacao`
--

CREATE TABLE `mitigacao` (
  `id` int(4) NOT NULL,
  `mitigacao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `mitigacao`
--

INSERT INTO `mitigacao` (`id`, `mitigacao`) VALUES
(1, 'mitigacaoo'),
(2, 'a');

-- --------------------------------------------------------

--
-- Estrutura da tabela `processo`
--

CREATE TABLE `processo` (
  `id` int(4) NOT NULL,
  `nomeObj` varchar(16) NOT NULL,
  `objetivo` varchar(32) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `processo`
--

INSERT INTO `processo` (`id`, `nomeObj`, `objetivo`, `descricao`) VALUES
(1, 'alterado', 'alterado', 'alterado'),
(4, 'aa', 'aaaaa', 'aaaaaaa'),
(5, 'a', 'aa', 'aaa'),
(6, 'jTextField1', 'jTextField2', 'jTextField3'),
(7, 'jTextField2', 'jTextField2', 'jTextField3');

-- --------------------------------------------------------

--
-- Estrutura da tabela `processorisco`
--

CREATE TABLE `processorisco` (
  `idProcesso` int(11) NOT NULL,
  `idRisco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `processorisco`
--

INSERT INTO `processorisco` (`idProcesso`, `idRisco`) VALUES
(1, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `risco`
--

CREATE TABLE `risco` (
  `id` int(4) NOT NULL,
  `cod` int(4) NOT NULL,
  `descricao` text NOT NULL,
  `impacto` int(1) NOT NULL,
  `probabilidade` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `risco`
--

INSERT INTO `risco` (`id`, `cod`, `descricao`, `impacto`, `probabilidade`) VALUES
(1, 1, 'a', 1, 2),
(4, 111, 'jTextField2', 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `riscomitigacao`
--

CREATE TABLE `riscomitigacao` (
  `id` int(11) NOT NULL,
  `idRisco` int(11) NOT NULL,
  `idMitigacao` int(11) NOT NULL,
  `eficacia` int(1) NOT NULL,
  `comentario` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mitigacao`
--
ALTER TABLE `mitigacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `processo`
--
ALTER TABLE `processo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `processorisco`
--
ALTER TABLE `processorisco`
  ADD PRIMARY KEY (`idProcesso`,`idRisco`),
  ADD KEY `FK_auditoria_processorisco_idRisco` (`idRisco`);

--
-- Indexes for table `risco`
--
ALTER TABLE `risco`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `riscomitigacao`
--
ALTER TABLE `riscomitigacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_auditoria_riscomitigacao_idRisco` (`idRisco`),
  ADD KEY `FK_auditoria_riscomitigacao_idMitigacao` (`idMitigacao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `mitigacao`
--
ALTER TABLE `mitigacao`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `processo`
--
ALTER TABLE `processo`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `risco`
--
ALTER TABLE `risco`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `riscomitigacao`
--
ALTER TABLE `riscomitigacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `processorisco`
--
ALTER TABLE `processorisco`
  ADD CONSTRAINT `FK_auditoria_processorisco_idProcesso` FOREIGN KEY (`idProcesso`) REFERENCES `processo` (`id`),
  ADD CONSTRAINT `FK_auditoria_processorisco_idRisco` FOREIGN KEY (`idRisco`) REFERENCES `risco` (`id`);

--
-- Limitadores para a tabela `riscomitigacao`
--
ALTER TABLE `riscomitigacao`
  ADD CONSTRAINT `FK_auditoria_riscomitigacao_idMitigacao` FOREIGN KEY (`idMitigacao`) REFERENCES `mitigacao` (`id`),
  ADD CONSTRAINT `FK_auditoria_riscomitigacao_idRisco` FOREIGN KEY (`idRisco`) REFERENCES `risco` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
