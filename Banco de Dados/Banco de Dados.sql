-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: cadastros2
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aluno` (
  `idaluno` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `inscricao` decimal(7,2) DEFAULT '1000.00',
  `datainscricao` date DEFAULT NULL,
  `login_username` varchar(20) NOT NULL,
  PRIMARY KEY (`idaluno`),
  KEY `fk_aluno_login1_idx` (`login_username`),
  CONSTRAINT `fk_aluno_login1` FOREIGN KEY (`login_username`) REFERENCES `login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Gabriel','Rua Y',0.00,'2018-11-18','gabriel'),(2,'John','Rua J',0.00,'2017-11-01','john');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_has_materia`
--

DROP TABLE IF EXISTS `aluno_has_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aluno_has_materia` (
  `aluno_idaluno` int(11) NOT NULL,
  `materia_idmateria` int(11) NOT NULL,
  PRIMARY KEY (`aluno_idaluno`,`materia_idmateria`),
  KEY `fk_materia_has_aluno_aluno1_idx` (`aluno_idaluno`),
  KEY `fk_materia_has_aluno_materia_idx` (`materia_idmateria`),
  CONSTRAINT `fk_materia_has_aluno_aluno1` FOREIGN KEY (`aluno_idaluno`) REFERENCES `aluno` (`idaluno`),
  CONSTRAINT `fk_materia_has_aluno_materia` FOREIGN KEY (`materia_idmateria`) REFERENCES `materia` (`idmateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_has_materia`
--

LOCK TABLES `aluno_has_materia` WRITE;
/*!40000 ALTER TABLE `aluno_has_materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno_has_materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assunto`
--

DROP TABLE IF EXISTS `assunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assunto` (
  `idassunto` int(11) NOT NULL,
  `nomeassunto` varchar(45) NOT NULL,
  `materia_idmateria` int(11) NOT NULL,
  PRIMARY KEY (`idassunto`),
  KEY `fk_assunto_materia1_idx` (`materia_idmateria`),
  CONSTRAINT `fk_assunto_materia1` FOREIGN KEY (`materia_idmateria`) REFERENCES `materia` (`idmateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assunto`
--

LOCK TABLES `assunto` WRITE;
/*!40000 ALTER TABLE `assunto` DISABLE KEYS */;
/*!40000 ALTER TABLE `assunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duvidas`
--

DROP TABLE IF EXISTS `duvidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `duvidas` (
  `idduvidas` int(11) NOT NULL,
  `textoduvida` varchar(45) DEFAULT NULL,
  `aluno_idaluno` int(11) NOT NULL,
  `facilitador_idfacilitador` int(11) NOT NULL,
  PRIMARY KEY (`idduvidas`),
  KEY `fk_duvidas_aluno1_idx` (`aluno_idaluno`),
  KEY `fk_duvidas_facilitador1_idx` (`facilitador_idfacilitador`),
  CONSTRAINT `fk_duvidas_aluno1` FOREIGN KEY (`aluno_idaluno`) REFERENCES `aluno` (`idaluno`),
  CONSTRAINT `fk_duvidas_facilitador1` FOREIGN KEY (`facilitador_idfacilitador`) REFERENCES `facilitador` (`idfacilitador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duvidas`
--

LOCK TABLES `duvidas` WRITE;
/*!40000 ALTER TABLE `duvidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `duvidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilitador`
--

DROP TABLE IF EXISTS `facilitador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `facilitador` (
  `idfacilitador` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `pagamento` decimal(7,2) DEFAULT '500.00',
  PRIMARY KEY (`idfacilitador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilitador`
--

LOCK TABLES `facilitador` WRITE;
/*!40000 ALTER TABLE `facilitador` DISABLE KEYS */;
/*!40000 ALTER TABLE `facilitador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilitador_has_materia`
--

DROP TABLE IF EXISTS `facilitador_has_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `facilitador_has_materia` (
  `facilitador_idfacilitador` int(11) NOT NULL,
  `materia_idmateria` int(11) NOT NULL,
  PRIMARY KEY (`facilitador_idfacilitador`,`materia_idmateria`),
  KEY `fk_facilitador_has_materia_materia1_idx` (`materia_idmateria`),
  KEY `fk_facilitador_has_materia_facilitador1_idx` (`facilitador_idfacilitador`),
  CONSTRAINT `fk_facilitador_has_materia_facilitador1` FOREIGN KEY (`facilitador_idfacilitador`) REFERENCES `facilitador` (`idfacilitador`),
  CONSTRAINT `fk_facilitador_has_materia_materia1` FOREIGN KEY (`materia_idmateria`) REFERENCES `materia` (`idmateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilitador_has_materia`
--

LOCK TABLES `facilitador_has_materia` WRITE;
/*!40000 ALTER TABLE `facilitador_has_materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `facilitador_has_materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('gabriel','123'),('john','100');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `materia` (
  `idmateria` int(11) NOT NULL,
  `nomemateria` varchar(45) NOT NULL,
  `creditos` int(11) DEFAULT NULL,
  `valor_inscricao` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`idmateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `materiasfacilitador`
--

DROP TABLE IF EXISTS `materiasfacilitador`;
/*!50001 DROP VIEW IF EXISTS `materiasfacilitador`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `materiasfacilitador` AS SELECT 
 1 AS `nome`,
 1 AS `qtdematerias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `materiassunto`
--

DROP TABLE IF EXISTS `materiassunto`;
/*!50001 DROP VIEW IF EXISTS `materiassunto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `materiassunto` AS SELECT 
 1 AS `nomemateria`,
 1 AS `nomeassunto`,
 1 AS `qtdeperguntas`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `perguntas`
--

DROP TABLE IF EXISTS `perguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `perguntas` (
  `idperguntas` int(11) NOT NULL,
  `enunciado` varchar(45) DEFAULT NULL,
  `objetiva` tinyint(1) DEFAULT NULL,
  `assunto_idassunto` int(11) NOT NULL,
  `simulado_idsimulado` int(11) NOT NULL,
  PRIMARY KEY (`idperguntas`),
  KEY `fk_perguntas_assunto1_idx` (`assunto_idassunto`),
  KEY `fk_perguntas_simulado1_idx` (`simulado_idsimulado`),
  CONSTRAINT `fk_perguntas_assunto1` FOREIGN KEY (`assunto_idassunto`) REFERENCES `assunto` (`idassunto`),
  CONSTRAINT `fk_perguntas_simulado1` FOREIGN KEY (`simulado_idsimulado`) REFERENCES `simulado` (`idsimulado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas`
--

LOCK TABLES `perguntas` WRITE;
/*!40000 ALTER TABLE `perguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `perguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respostas`
--

DROP TABLE IF EXISTS `respostas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `respostas` (
  `idrespostas` int(11) NOT NULL,
  `textoresposta` varchar(45) DEFAULT NULL,
  `perguntas_idperguntas` int(11) NOT NULL,
  PRIMARY KEY (`idrespostas`),
  KEY `fk_respostas_perguntas1_idx` (`perguntas_idperguntas`),
  CONSTRAINT `fk_respostas_perguntas1` FOREIGN KEY (`perguntas_idperguntas`) REFERENCES `perguntas` (`idperguntas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respostas`
--

LOCK TABLES `respostas` WRITE;
/*!40000 ALTER TABLE `respostas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respostas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simulado`
--

DROP TABLE IF EXISTS `simulado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `simulado` (
  `idsimulado` int(11) NOT NULL,
  `fhm_facilitador_idfacilitador` int(11) DEFAULT NULL,
  `fhm_materia_idmateria` int(11) NOT NULL,
  PRIMARY KEY (`idsimulado`),
  KEY `fk_simulado_facilitador_has_materia1_idx` (`fhm_facilitador_idfacilitador`,`fhm_materia_idmateria`),
  CONSTRAINT `fk_simulado_facilitador_has_materia1` FOREIGN KEY (`fhm_facilitador_idfacilitador`, `fhm_materia_idmateria`) REFERENCES `facilitador_has_materia` (`facilitador_idfacilitador`, `materia_idmateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simulado`
--

LOCK TABLES `simulado` WRITE;
/*!40000 ALTER TABLE `simulado` DISABLE KEYS */;
/*!40000 ALTER TABLE `simulado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simulado_has_aluno`
--

DROP TABLE IF EXISTS `simulado_has_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `simulado_has_aluno` (
  `simulado_idsimulado` int(11) NOT NULL,
  `aluno_idaluno` int(11) NOT NULL,
  `nota` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`simulado_idsimulado`,`aluno_idaluno`),
  KEY `fk_simulado_has_aluno_aluno1_idx` (`aluno_idaluno`),
  KEY `fk_simulado_has_aluno_simulado1_idx` (`simulado_idsimulado`),
  CONSTRAINT `fk_simulado_has_aluno_aluno1` FOREIGN KEY (`aluno_idaluno`) REFERENCES `aluno` (`idaluno`),
  CONSTRAINT `fk_simulado_has_aluno_simulado1` FOREIGN KEY (`simulado_idsimulado`) REFERENCES `simulado` (`idsimulado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simulado_has_aluno`
--

LOCK TABLES `simulado_has_aluno` WRITE;
/*!40000 ALTER TABLE `simulado_has_aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `simulado_has_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `valoraluno`
--

DROP TABLE IF EXISTS `valoraluno`;
/*!50001 DROP VIEW IF EXISTS `valoraluno`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `valoraluno` AS SELECT 
 1 AS `nome`,
 1 AS `inscricao`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `valoresfacilitador`
--

DROP TABLE IF EXISTS `valoresfacilitador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valoresfacilitador` (
  `facilitador_idfacilitador` int(11) NOT NULL,
  `valorduvida` decimal(5,2) DEFAULT NULL,
  `valorsimulado` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`facilitador_idfacilitador`),
  CONSTRAINT `fk_valoresfacilitador_facilitador1` FOREIGN KEY (`facilitador_idfacilitador`) REFERENCES `facilitador` (`idfacilitador`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoresfacilitador`
--

LOCK TABLES `valoresfacilitador` WRITE;
/*!40000 ALTER TABLE `valoresfacilitador` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoresfacilitador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `materiasfacilitador`
--

/*!50001 DROP VIEW IF EXISTS `materiasfacilitador`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `materiasfacilitador` AS select `facilitador`.`nome` AS `nome`,count(`facilitador_has_materia`.`materia_idmateria`) AS `qtdematerias` from (`facilitador` join `facilitador_has_materia`) where (`facilitador`.`idfacilitador` = `facilitador_has_materia`.`facilitador_idfacilitador`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `materiassunto`
--

/*!50001 DROP VIEW IF EXISTS `materiassunto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `materiassunto` AS select `materia`.`nomemateria` AS `nomemateria`,`assunto`.`nomeassunto` AS `nomeassunto`,count(`perguntas`.`idperguntas`) AS `qtdeperguntas` from ((`materia` join `assunto`) join `perguntas`) where (`perguntas`.`assunto_idassunto` = `assunto`.`idassunto`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `valoraluno`
--

/*!50001 DROP VIEW IF EXISTS `valoraluno`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `valoraluno` AS select `aluno`.`nome` AS `nome`,`aluno`.`inscricao` AS `inscricao` from `aluno` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-01 22:06:14
