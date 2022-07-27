CREATE SCHEMA `wrestlers`;
CREATE TABLE `dupla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `Solo1` int(11) NOT NULL,
  `Solo2` int(11) NOT NULL,
  `Pontos` int(11) DEFAULT NULL,
  `Campeao` BIT NOT NULL,
   CONSTRAINT pk_duplaid PRIMARY KEY (id)
);

CREATE TABLE `solo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `Sexo` varchar(20) NOT NULL,
  `Pontos` int(11) DEFAULT NULL,
  `Principal` BIT NOT NULL,
  `Campeao` BIT NOT NULL,
  `Dupla` int(11) DEFAULT NULL,
   CONSTRAINT pk_id PRIMARY KEY (id),
   CONSTRAINT pk_dupla FOREIGN KEY (Dupla)
   REFERENCES `dupla` (id) ON DELETE SET NULL ON UPDATE CASCADE
);

ALTER TABLE `dupla`
  ADD KEY `Solo1` (`Solo1`),
  ADD KEY `Solo2` (`Solo2`),
  ADD CONSTRAINT `dupla_ibfk_1` FOREIGN KEY (`Solo1`) REFERENCES `solo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dupla_ibfk_2` FOREIGN KEY (`Solo2`) REFERENCES `solo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

