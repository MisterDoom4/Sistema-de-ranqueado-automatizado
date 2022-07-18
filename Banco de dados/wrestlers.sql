--
-- Banco de dados: `wrestlers`
--
-- --------------------------------------------------------
--
-- Estrutura da tabela `dupla`
--
CREATE TABLE `dupla` (
  `id` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Solo1` int(11) NOT NULL,
  `Solo2` int(11) NOT NULL,
  `Pontos` int(11) DEFAULT NULL,
  `Campeao` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
--
-- Estrutura da tabela `solo`
--
CREATE TABLE `solo` (
  `id` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Sexo` char(20) NOT NULL,
  `Pontos` int(11) DEFAULT NULL,
  `Principal` tinyint(1) NOT NULL,
  `Campeao` tinyint(1) NOT NULL,
  `Dupla` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Índices para tabelas despejadas
--
--
-- Índices para tabela `dupla`
--
ALTER TABLE `dupla`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Solo1` (`Solo1`),
  ADD KEY `Solo2` (`Solo2`);
--
-- Índices para tabela `solo`
--
ALTER TABLE `solo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Dupla` (`Dupla`);
--
-- AUTO_INCREMENT de tabelas despejadas
--
--
-- AUTO_INCREMENT de tabela `dupla`
--
ALTER TABLE `dupla`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `solo`
--
ALTER TABLE `solo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restrições para despejos de tabelas
--
--
-- Limitadores para a tabela `dupla`
--
ALTER TABLE `dupla`
  ADD CONSTRAINT `dupla_ibfk_1` FOREIGN KEY (`Solo1`) REFERENCES `solo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dupla_ibfk_2` FOREIGN KEY (`Solo2`) REFERENCES `solo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Limitadores para a tabela `solo`
--
ALTER TABLE `solo`
  ADD CONSTRAINT `solo_ibfk_1` FOREIGN KEY (`Dupla`) REFERENCES `dupla` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;