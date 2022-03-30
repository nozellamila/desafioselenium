DROP TABLE IF EXISTS `mantis_user_table`;
CREATE TABLE IF NOT EXISTS `mantis_user_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(191) NOT NULL DEFAULT '',
  `realname` varchar(191) NOT NULL DEFAULT '',
  `email` varchar(191) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `protected` tinyint(4) NOT NULL DEFAULT '0',
  `access_level` smallint(6) NOT NULL DEFAULT '10',
  `login_count` int(11) NOT NULL DEFAULT '0',
  `lost_password_request_count` smallint(6) NOT NULL DEFAULT '0',
  `failed_login_count` smallint(6) NOT NULL DEFAULT '0',
  `cookie_string` varchar(64) NOT NULL DEFAULT '',
  `last_visit` int(10) unsigned NOT NULL DEFAULT '1',
  `date_created` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_cookie_string` (`cookie_string`),
  UNIQUE KEY `idx_user_username` (`username`),
  KEY `idx_enable` (`enabled`),
  KEY `idx_access` (`access_level`),
  KEY `idx_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `mantis_user_table` DISABLE KEYS */;
INSERT INTO `mantis_user_table` (`id`, `username`, `realname`, `email`, `password`, `enabled`, `protected`, `access_level`, `login_count`, `lost_password_request_count`, `failed_login_count`, `cookie_string`, `last_visit`, `date_created`) VALUES
	(1, 'administrator', 'Mila Nozella', 'root@localhost', '200ceb26807d6bf99fd6f4f0d1ca54d4', 1, 0, 90, 6, 0, 0, '8Pfw94O1akdxwD4CcBau-EsWLVgenquSatYCSZdpsbvijzySBNQOzF9LvlenXFxA', 1632148677, 1619203676),
	(3, 'leonardo55', 'Alicia Carvalho', 'joao.silva97@gmail.com', 'f741229e47342b5616e9697b4e05c3d5', 1, 0, 40, 0, 0, 0, 'TXeB2YHfehnAfIT29Qxa64WQydBw4asxr9n7qvthnlJho0pCy2EX_A9-l6fEM9x1', 1621022507, 1621022507),
	(4, 'marli_macedo21', 'Giovanna Pereira', 'isabela43@gmail.com', '2165fc563da826eab6da80ad3a1bccd0', 1, 0, 40, 0, 0, 0, 'aAV9mRCaYufj3T-CATzDKTj5YeRtv75usbtpc_asXeJB8u5W53_6Ih7eJ1CzDWIg', 1621022518, 1621022518),
	(5, 'bruna73', 'Henrique Barros', 'beatriz_albuquerque93@gmail.com', '4c2b0706baa9475d92932d4f415a7738', 1, 0, 40, 0, 0, 0, 'fMZIVbGnausECxzNDBr8vWYsfuaDMQpAHj1Aak8ilM-EPjsDChJZqhj2lVafy5pH', 1621022530, 1621022530),
	(6, 'miguel.nogueira82', 'Marli Melo', 'murilo_albuquerque24@bol.com.br', '64bb674604f46918d9b82bb81cdd5763', 0, 0, 40, 0, 0, 0, 'CCEeT3t32d1E_p90CgSnJdBvUpRkmJPTHHjzOB5_o-K3B8xKxWImHauUL1v5AX5s', 1621022542, 1621022542),
	(7, 'valentina_franco', 'Davi Lucca Melo', 'kleber11@yahoo.com', 'd2d8424ac5cb228e089823ed60fd0f27', 1, 0, 40, 0, 0, 0, 'DQRQdVasvw_yVtgXS3XZdURTkASI6iq7jQUY6vlba2CjjSpzjQEeIPnIdDBa7g-n', 1621022557, 1621022557),
	(8, 'alexandre.santos', 'Marcela Pereira', 'antonio41@live.com', '1562ff6446db6363d8241200b9401a6b', 1, 0, 40, 0, 0, 0, 'tuJfIZ4xodX21muSPnDDBkOedFauzqvtiPl64aJ_P-Qe0uHIywUPSqmMwc2E2YQK', 1621022577, 1621022577),
	(9, 'joana_macedo', 'Renata Souza', 'joana11@hotmail.com', '6942f198ec20ae0d5148f63cdb510ea5', 1, 0, 40, 0, 0, 0, 'qSuteQy8Z9TpYC64ritx2QzHNN6ph__oIMVJ4Bs3oXKpopidHMlDLPoh4y3zzrM9', 1621022591, 1621022591),
	(10, 'julia_barros', 'Marli Costa', 'enzo_xavier40@live.com', 'affcd66a7924598a9e7080ddcb01c42f', 1, 0, 40, 0, 0, 0, '1zbQxLH0SSwBqgkYrKmzC8t1gCpdxa37OUwbmJ0MCfQGfse369jtdB6eCi8R5N07', 1621022603, 1621022603),
	(11, 'isabela.martins27', 'Marcos Franco', 'felipe_melo@gmail.com', '279468535f1c974fe2b954ba406877f9', 1, 0, 40, 0, 0, 0, 'RCGF3tGcI2wA0s5IzvWlABjumOKa773pzYLSDoOhIT7AvvF1zUzDeRnI5pjLhI9S', 1631627387, 1631627387),
	(12, 'test.updater', 'Usuario Nivel Updater', 'email01@valid.com', 'aa1bf4646de67fd9086cf6c79007026c', 1, 0, 40, 1, 0, 0, '7JoNeeleXegJDJ40jJoowi3akws-IJCJ7KRmeYipjJwRDkT-DGmS22Fc20NXs27G', 1631627388, 1631627388),
	(13, 'test.reporter', 'Usuario Nivel Reporter', 'email02@valid.com', 'aa1bf4646de67fd9086cf6c79007026c', 1, 0, 25, 1, 0, 0, '2ShUqSpptUcWbvqQd9n8RZ7Z7tVZte8Z5e4q7QKO1YHGWNdm56PVg9GBhiNx7n4o', 1631627388, 1631627388),
	(14, 'test.developer', 'Usuario Nivel Developer', 'email03@valid.com', 'aa1bf4646de67fd9086cf6c79007026c', 1, 0, 55, 2, 0, 0, 'RYTtF0Dsse_sBQTmKmohuKdYpFnMofyiPHjDLJcyth-NiXaGuUySS8p0t26-xOcC', 1632148932, 1631627388),
	(15, 'test.manager', 'Usuario Nivel Manager', 'email04@valid.com', 'aa1bf4646de67fd9086cf6c79007026c', 1, 0, 70, 1, 0, 0, '_MB22IVNeHzO9abp2DI8fW8HUHTByc7ZfGfaSABKihYg9mW6ILivwJufBb3ghIQT', 1632148878, 1632148878),
	(16, 'test.viewer', 'Usuario Nivel Viewer', 'email05@valid.com', 'aa1bf4646de67fd9086cf6c79007026c', 1, 0, 10, 1, 0, 0, 'mtOlrzho6q8_WoajIACTFGJaacVOFhFNU3tIwCnVyegU4swlcrZxe-r0_irav9Nw', 1632148947, 1632148947);
ALTER TABLE `mantis_user_table` ENABLE KEYS;



