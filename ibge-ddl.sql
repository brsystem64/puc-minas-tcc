-- `census-core`.tb_pergunta definition

CREATE TABLE `tb_pergunta` (
  `cod_pergunta` int(8) NOT NULL AUTO_INCREMENT,
  `txt_pergunta` varchar(150) NOT NULL,
  `cod_tipo_pergunta` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_pergunta`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_resposta definition

CREATE TABLE `tb_resposta` (
  `cod_resposta` int(8) NOT NULL AUTO_INCREMENT,
  `txt_resposta` varchar(80) NOT NULL,
  `val_resposta` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_resposta`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_roteiro definition

CREATE TABLE `tb_roteiro` (
  `cod_roteiro` int(8) NOT NULL AUTO_INCREMENT,
  `txt_roteiro` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_roteiro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_ticket definition

CREATE TABLE `tb_ticket` (
  `cod_ticket` varchar(64) NOT NULL,
  `tip_documento` varchar(1) NOT NULL,
  `cod_documento` varchar(16) NOT NULL,
  `txt_nome_entrevistado` varchar(70) NOT NULL,
  `cod_recenseador` int(8) NOT NULL,
  `dat_criacao` date NOT NULL,
  PRIMARY KEY (`cod_ticket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_entrevista definition

CREATE TABLE `tb_entrevista` (
  `cod_entrevista` int(8) NOT NULL AUTO_INCREMENT,
  `cod_roteiro` int(8) NOT NULL,
  `cod_ticket` varchar(64) DEFAULT NULL,
  `cod_status` varchar(2) NOT NULL,
  `dat_inicio` date NOT NULL,
  `dat_conclusao` date DEFAULT NULL,
  `cod_ultima_sessao` int(8) DEFAULT NULL,
  PRIMARY KEY (`cod_entrevista`),
  UNIQUE KEY `cod_ticket` (`cod_ticket`),
  KEY `cod_roteiro` (`cod_roteiro`),
  CONSTRAINT `tb_entrevista_ibfk_1` FOREIGN KEY (`cod_ticket`) REFERENCES `tb_ticket` (`cod_ticket`),
  CONSTRAINT `tb_entrevista_ibfk_2` FOREIGN KEY (`cod_roteiro`) REFERENCES `tb_roteiro` (`cod_roteiro`)
) ENGINE=InnoDB AUTO_INCREMENT=1064 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_pergunta_dependencia definition

CREATE TABLE `tb_pergunta_dependencia` (
  `cod_pergunta` int(8) NOT NULL,
  `cod_pergunta_pai` int(8) NOT NULL,
  `cod_resposta` int(8) NOT NULL,
  KEY `cod_pergunta` (`cod_pergunta`),
  KEY `cod_pergunta_pai` (`cod_pergunta_pai`),
  KEY `cod_resposta` (`cod_resposta`),
  CONSTRAINT `tb_pergunta_dependencia_ibfk_1` FOREIGN KEY (`cod_pergunta`) REFERENCES `tb_pergunta` (`cod_pergunta`),
  CONSTRAINT `tb_pergunta_dependencia_ibfk_2` FOREIGN KEY (`cod_pergunta_pai`) REFERENCES `tb_pergunta` (`cod_pergunta`),
  CONSTRAINT `tb_pergunta_dependencia_ibfk_3` FOREIGN KEY (`cod_resposta`) REFERENCES `tb_resposta` (`cod_resposta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_pergunta_resposta definition

CREATE TABLE `tb_pergunta_resposta` (
  `cod_pergunta` int(8) NOT NULL,
  `cod_resposta` int(8) NOT NULL,
  KEY `cod_pergunta` (`cod_pergunta`),
  KEY `cod_resposta` (`cod_resposta`),
  CONSTRAINT `tb_pergunta_resposta_ibfk_1` FOREIGN KEY (`cod_pergunta`) REFERENCES `tb_pergunta` (`cod_pergunta`),
  CONSTRAINT `tb_pergunta_resposta_ibfk_2` FOREIGN KEY (`cod_resposta`) REFERENCES `tb_resposta` (`cod_resposta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_sessao definition

CREATE TABLE `tb_sessao` (
  `cod_sessao` int(8) NOT NULL AUTO_INCREMENT,
  `txt_sessao` varchar(150) NOT NULL,
  `cod_sessao_pai` int(8) DEFAULT NULL,
  `cod_roteiro` int(8) NOT NULL,
  `flg_composto` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_sessao`),
  KEY `cod_roteiro` (`cod_roteiro`),
  CONSTRAINT `tb_sessao_ibfk_1` FOREIGN KEY (`cod_roteiro`) REFERENCES `tb_roteiro` (`cod_roteiro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_sessao_pergunta definition

CREATE TABLE `tb_sessao_pergunta` (
  `cod_questao` int(8) NOT NULL AUTO_INCREMENT,
  `cod_sessao` int(8) NOT NULL,
  `cod_pergunta` int(8) NOT NULL,
  `min_char` varchar(4) DEFAULT NULL,
  `max_char` varchar(4) DEFAULT NULL,
  `flg_obrigatorio` varchar(1) NOT NULL,
  `cod_ordem` int(3) NOT NULL,
  `flg_ativa` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_questao`),
  KEY `cod_sessao` (`cod_sessao`),
  CONSTRAINT `tb_sessao_pergunta_ibfk_1` FOREIGN KEY (`cod_sessao`) REFERENCES `tb_sessao` (`cod_sessao`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- `census-core`.tb_entrevista_respostas definition

CREATE TABLE `tb_entrevista_respostas` (
  `cod_entrevista` int(8) NOT NULL,
  `cod_questao` int(8) NOT NULL,
  `val_level` int(8) DEFAULT NULL,
  `val_resposta` varchar(100) DEFAULT NULL,
  `cod_entrevista_resposta` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cod_entrevista_resposta`),
  KEY `cod_entrevista` (`cod_entrevista`),
  KEY `cod_questao` (`cod_questao`),
  CONSTRAINT `tb_entrevista_respostas_ibfk_1` FOREIGN KEY (`cod_entrevista`) REFERENCES `tb_entrevista` (`cod_entrevista`),
  CONSTRAINT `tb_entrevista_respostas_ibfk_2` FOREIGN KEY (`cod_questao`) REFERENCES `tb_sessao_pergunta` (`cod_questao`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;