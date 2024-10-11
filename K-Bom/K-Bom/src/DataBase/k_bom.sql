-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Set-2024 às 19:19
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `k_bom`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--
CREATE DATABASE `k_bom`;

USE `k_bom`;

CREATE TABLE `administrador` (
  `ID_adm` int(11) NOT NULL,
  `Nome_adm` varchar(150) NOT NULL,
  `Senha` varchar(150) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Data_Nasc` date NOT NULL,
  `Token` varchar(200) NULL,
  `Token_expira_em` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `ID_categoria` int(11) NOT NULL,
  `Descricao` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `ID_cliente` int(11) NOT NULL,
  `Nome_Cli` varchar(200) NOT NULL,
  `Senha` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `CPF` varchar(16) NOT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `Token` varchar(200) DEFAULT NULL,
  `Token_expira_em` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `controle`
--

CREATE TABLE `controle` (
  `ID_adm` int(11) DEFAULT NULL,
  `ID_Produto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itensdacompra`
--

CREATE TABLE `itensdacompra` (
  `Id_Produto` int(11) DEFAULT NULL,
  `Qnt_vendida` int(11) NOT NULL,
  `Id_Registro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `ID_produto` int(11) NOT NULL,
  `Nome_Prod` varchar(150) NOT NULL,
  `Estq_produto` int(11) NOT NULL,
  `Preco_Produto` decimal(10,2) NOT NULL,
  `Categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `registrodecompra`
--

CREATE TABLE `registrodecompra` (
  `Id_Registro` int(11) NOT NULL,
  `ID_cliente` int(11) DEFAULT NULL,
  `Dt_compra` date NOT NULL,
  `ID_Triagem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `triagem`
--

CREATE TABLE `triagem` (
  `ID_Triagem` int(11) NOT NULL,
  `Etapa` varchar(50) NOT NULL,
  `Data_entrega` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`ID_adm`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID_categoria`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_cliente`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Índices para tabela `controle`
--
ALTER TABLE `controle`
  ADD KEY `ID_adm` (`ID_adm`),
  ADD KEY `ID_Produto` (`ID_Produto`);

--
-- Índices para tabela `itensdacompra`
--
ALTER TABLE `itensdacompra`
  ADD KEY `Id_Produto` (`Id_Produto`),
  ADD KEY `Id_Registro` (`Id_Registro`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`ID_produto`),
  ADD KEY `Categoria` (`Categoria`);

--
-- Índices para tabela `registrodecompra`
--
ALTER TABLE `registrodecompra`
  ADD PRIMARY KEY (`Id_Registro`),
  ADD KEY `ID_cliente` (`ID_cliente`),
  ADD KEY `ID_Triagem` (`ID_Triagem`);

--
-- Índices para tabela `triagem`
--
ALTER TABLE `triagem`
  ADD PRIMARY KEY (`ID_Triagem`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `administrador`
--
ALTER TABLE `administrador`
  MODIFY `ID_adm` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID_categoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `ID_produto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `registrodecompra`
--
ALTER TABLE `registrodecompra`
  MODIFY `Id_Registro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `triagem`
--
ALTER TABLE `triagem`
  MODIFY `ID_Triagem` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `controle`
--
ALTER TABLE `controle`
  ADD CONSTRAINT `controle_ibfk_1` FOREIGN KEY (`ID_adm`) REFERENCES `administrador` (`ID_adm`),
  ADD CONSTRAINT `controle_ibfk_2` FOREIGN KEY (`ID_Produto`) REFERENCES `produto` (`ID_produto`);

--
-- Limitadores para a tabela `itensdacompra`
--
ALTER TABLE `itensdacompra`
  ADD CONSTRAINT `itensdacompra_ibfk_1` FOREIGN KEY (`Id_Produto`) REFERENCES `produto` (`ID_produto`),
  ADD CONSTRAINT `itensdacompra_ibfk_2` FOREIGN KEY (`Id_Registro`) REFERENCES `registrodecompra` (`Id_Registro`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`ID_categoria`);

--
-- Limitadores para a tabela `registrodecompra`
--
ALTER TABLE `registrodecompra`
  ADD CONSTRAINT `registrodecompra_ibfk_1` FOREIGN KEY (`ID_cliente`) REFERENCES `cliente` (`ID_cliente`),
  ADD CONSTRAINT `registrodecompra_ibfk_2` FOREIGN KEY (`ID_Triagem`) REFERENCES `triagem` (`ID_Triagem`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
