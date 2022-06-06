-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.7.36 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando dados para a tabela bugtracker.mantis_api_token_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_api_token_table`;
INSERT INTO `mantis_api_token_table` (`id`, `user_id`, `name`, `hash`, `date_created`, `date_used`) VALUES
	(1, 1, 'Token API', '08083526e04806724f9c06413566d7a3bca2b72323c5219e82068af8bae708ab', 1619203777, 1632148947);

-- Copiando dados para a tabela bugtracker.mantis_bugnote_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_bugnote_table`;

-- Copiando dados para a tabela bugtracker.mantis_bugnote_text_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_bugnote_text_table`;

-- Copiando dados para a tabela bugtracker.mantis_bug_file_table: ~2 rows (aproximadamente)
DELETE FROM `mantis_bug_file_table`;
INSERT INTO `mantis_bug_file_table` (`id`, `bug_id`, `title`, `description`, `diskfile`, `filename`, `folder`, `filesize`, `file_type`, `content`, `date_added`, `user_id`, `bugnote_id`) VALUES
	(1, 1, '', '', '4c3d86a4ccf35cd84ca7efde127f149a', 'arquivoteste.txt', '', 18, 'text/plain; charset=us-ascii', _binary 0x4172717569766f2070617261207465737465, 1622056254, 1, NULL),
	(2, 2, '', '', 'b0c72292dc02d9ced987c168881a636c', 'desafioapi.txt', '', 21, 'text/plain; charset=us-ascii', _binary 0x4465736166696f2041504920526573745368617270, 1631627387, 1, NULL);

-- Copiando dados para a tabela bugtracker.mantis_bug_history_table: ~4 rows (aproximadamente)
DELETE FROM `mantis_bug_history_table`;
INSERT INTO `mantis_bug_history_table` (`id`, `user_id`, `bug_id`, `field_name`, `old_value`, `new_value`, `type`, `date_modified`) VALUES
	(1, 1, 1, '', '', '', 1, 1622056254),
	(2, 1, 1, '', 'arquivoteste.txt', '', 9, 1622056254),
	(3, 1, 2, '', '', '', 1, 1631627387),
	(4, 1, 2, '', 'desafioapi.txt', '', 9, 1631627387);

-- Copiando dados para a tabela bugtracker.mantis_bug_monitor_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_bug_monitor_table`;

-- Copiando dados para a tabela bugtracker.mantis_bug_relationship_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_bug_relationship_table`;

-- Copiando dados para a tabela bugtracker.mantis_bug_revision_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_bug_revision_table`;

-- Copiando dados para a tabela bugtracker.mantis_bug_table: ~2 rows (aproximadamente)
DELETE FROM `mantis_bug_table`;
INSERT INTO `mantis_bug_table` (`id`, `project_id`, `reporter_id`, `handler_id`, `duplicate_id`, `priority`, `severity`, `reproducibility`, `status`, `resolution`, `projection`, `eta`, `bug_text_id`, `os`, `os_build`, `platform`, `version`, `fixed_in_version`, `build`, `profile_id`, `view_state`, `summary`, `sponsorship_total`, `sticky`, `target_version`, `category_id`, `date_submitted`, `due_date`, `last_updated`) VALUES
	(1, 2, 1, 0, 0, 30, 50, 70, 10, 10, 10, 10, 1, '', '', '', '', '', '', 0, 10, 'Teste issue com anexo', 0, 0, '', 1, 1622056254, 1, 1622056254),
	(2, 2, 1, 0, 0, 30, 50, 70, 10, 10, 10, 10, 2, '', '', '', '', '', '', 0, 10, 'Issue com anexo', 0, 0, '', 1, 1631627387, 1, 1631627387);

-- Copiando dados para a tabela bugtracker.mantis_bug_tag_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_bug_tag_table`;

-- Copiando dados para a tabela bugtracker.mantis_bug_text_table: ~5 rows (aproximadamente)
DELETE FROM `mantis_bug_text_table`;
INSERT INTO `mantis_bug_text_table` (`id`, `description`, `steps_to_reproduce`, `additional_information`) VALUES
	(1, 'Esta issue possui um anexo em texto', '', ''),
	(2, 'Esta issue possui um anexo em texto', '', ''),
	(3, 'Descrição Válida', '', ''),
	(4, 'Descrição do Teste', '', ''),
	(5, 'Descrição do Bug', '', '');

-- Copiando dados para a tabela bugtracker.mantis_category_table: ~2 rows (aproximadamente)
DELETE FROM `mantis_category_table`;
INSERT INTO `mantis_category_table` (`id`, `project_id`, `user_id`, `name`, `status`) VALUES
	(1, 0, 0, 'General', 0),
	(2, 0, 0, 'Selenium', 0);

-- Copiando dados para a tabela bugtracker.mantis_config_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_config_table`;
INSERT INTO `mantis_config_table` (`config_id`, `project_id`, `user_id`, `access_reqd`, `type`, `value`) VALUES
	('database_version', 0, 0, 90, 1, '210');

-- Copiando dados para a tabela bugtracker.mantis_custom_field_project_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_custom_field_project_table`;

-- Copiando dados para a tabela bugtracker.mantis_custom_field_string_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_custom_field_string_table`;

-- Copiando dados para a tabela bugtracker.mantis_custom_field_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_custom_field_table`;

-- Copiando dados para a tabela bugtracker.mantis_email_table: ~2 rows (aproximadamente)
DELETE FROM `mantis_email_table`;
INSERT INTO `mantis_email_table` (`email_id`, `email`, `subject`, `metadata`, `body`, `submitted`) VALUES
	(10, 'felipe_melo@gmail.com', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:20:"host.docker.internal";}', 'The user administrator has created an account for you with username "isabela.martins27". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://host.docker.internal:8989/verify.php?id=11&confirm_hash=vTHVCTnzNuuGN1PADV7WSFw_yP9eNu43edVR9ePWTe9d3Xn8hAFo9PcZ6wFC6exoH6CWIJdDzUAnaizU6WFP\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1631627387),
	(11, 'joao.silva97@gmail.com', '[MantisBT] Password Reset', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:20:"host.docker.internal";}', 'Someone (presumably you) requested a password change through e-mail verification. If this was not you, ignore this message and nothing will happen.\n\nIf you requested this verification, visit the following URL to change your password: \n\nhttp://host.docker.internal:8989/verify.php?id=3&confirm_hash=0sGoMe4TzDAaebTBo2lQpvt7P1CxRhIEBekDGckXZHS5LA9P7zYTICc0EOTZEyj8qxaG6Ilo_P__QCCzZtEl \n\nUsername: leonardo55 \nRemote IP address: 172.18.0.1 \n\nDo not reply to this message', 1631627388);

-- Copiando dados para a tabela bugtracker.mantis_filters_table: ~3 rows (aproximadamente)
DELETE FROM `mantis_filters_table`;
INSERT INTO `mantis_filters_table` (`id`, `user_id`, `project_id`, `is_public`, `name`, `filter_string`) VALUES
	(1, 1, 0, 0, '', 'v9#{"_version":"v9","_view_type":"simple","category_id":["0"],"severity":[70],"status":[10],"per_page":50,"highlight_changed":6,"reporter_id":[0],"handler_id":[0],"project_id":[-3],"sort":"last_updated","dir":"DESC","filter_by_date":false,"start_month":5,"start_day":1,"start_year":2021,"end_month":5,"end_day":18,"end_year":2021,"filter_by_last_updated_date":false,"last_updated_start_month":5,"last_updated_start_day":1,"last_updated_start_year":2021,"last_updated_end_month":5,"last_updated_end_day":18,"last_updated_end_year":2021,"search":"","hide_status":[90],"resolution":[0],"build":["0"],"version":["0"],"fixed_in_version":["0"],"target_version":["0"],"priority":[40],"monitor_user_id":[0],"view_state":0,"custom_fields":[],"sticky":true,"relationship_type":-1,"relationship_bug":0,"profile_id":[0],"platform":["0"],"os":["0"],"os_build":["0"],"tag_string":"","tag_select":0,"note_user_id":[0],"match_type":0,"_source_query_id":4}'),
	(2, 1, 0, 1, 'Filtro Pesquisa', 'v9#{"_version":"v9","_view_type":"simple","category_id":["0"],"severity":[0],"status":[10],"per_page":50,"highlight_changed":6,"reporter_id":[0],"handler_id":[0],"project_id":[-3],"sort":"last_updated","dir":"DESC","filter_by_date":false,"start_month":5,"start_day":1,"start_year":2021,"end_month":5,"end_day":18,"end_year":2021,"filter_by_last_updated_date":false,"last_updated_start_month":5,"last_updated_start_day":1,"last_updated_start_year":2021,"last_updated_end_month":5,"last_updated_end_day":18,"last_updated_end_year":2021,"search":"","hide_status":[90],"resolution":[0],"build":["0"],"version":["0"],"fixed_in_version":["0"],"target_version":["0"],"priority":[40],"monitor_user_id":[0],"view_state":0,"custom_fields":[],"sticky":true,"relationship_type":-1,"relationship_bug":0,"profile_id":[0],"platform":["0"],"os":["0"],"os_build":["0"],"tag_string":"","tag_select":0,"note_user_id":[0],"match_type":0}'),
	(3, 1, 0, 0, 'Filtro Teste', 'v9#{"_version":"v9","_view_type":"simple","category_id":["0"],"severity":[70],"status":[10],"per_page":50,"highlight_changed":6,"reporter_id":[0],"handler_id":[0],"project_id":[-3],"sort":"last_updated","dir":"DESC","filter_by_date":false,"start_month":5,"start_day":1,"start_year":2021,"end_month":5,"end_day":18,"end_year":2021,"filter_by_last_updated_date":false,"last_updated_start_month":5,"last_updated_start_day":1,"last_updated_start_year":2021,"last_updated_end_month":5,"last_updated_end_day":18,"last_updated_end_year":2021,"search":"","hide_status":[90],"resolution":[0],"build":["0"],"version":["0"],"fixed_in_version":["0"],"target_version":["0"],"priority":[40],"monitor_user_id":[0],"view_state":0,"custom_fields":[],"sticky":true,"relationship_type":-1,"relationship_bug":0,"profile_id":[0],"platform":["0"],"os":["0"],"os_build":["0"],"tag_string":"","tag_select":0,"note_user_id":[0],"match_type":0}');

-- Copiando dados para a tabela bugtracker.mantis_news_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_news_table`;

-- Copiando dados para a tabela bugtracker.mantis_plugin_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_plugin_table`;
INSERT INTO `mantis_plugin_table` (`basename`, `enabled`, `protected`, `priority`) VALUES
	('MantisCoreFormatting', 1, 0, 3);

-- Copiando dados para a tabela bugtracker.mantis_project_file_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_project_file_table`;

-- Copiando dados para a tabela bugtracker.mantis_project_hierarchy_table: ~1 rows (aproximadamente)
DELETE FROM `mantis_project_hierarchy_table`;
INSERT INTO `mantis_project_hierarchy_table` (`child_id`, `parent_id`, `inherit_parent`) VALUES
	(13, 12, 1);

-- Copiando dados para a tabela bugtracker.mantis_project_table: ~5 rows (aproximadamente)
DELETE FROM `mantis_project_table`;
INSERT INTO `mantis_project_table` (`id`, `name`, `status`, `enabled`, `view_state`, `access_min`, `file_path`, `description`, `category_id`, `inherit_global`) VALUES
	(1, 'Projeto Mantis API REST', 10, 1, 10, 10, '/tmp/', 'Projeto Mantis API REST', 1, 1),
	(2, 'Projeto Teste Mantis API REST', 30, 1, 10, 10, '/tmp/', 'Projeto Teste Mantis API REST', 1, 1),
	(4, 'Projeto Teste Dois', 30, 0, 10, 10, '/tmp/', 'Projeto Teste Dois', 1, 1),
	(5, 'Teste Atualizar', 10, 1, 30, 10, '/tmp/', 'Projeto Dev', 1, 1),
	(6, 'Projeto Automação Mantis API REST', 10, 1, 10, 10, '/tmp/', 'Criação de Projeto Mantis', 1, 1);

-- Copiando dados para a tabela bugtracker.mantis_project_user_list_table: ~1 rows (aproximadamente)
DELETE FROM `mantis_project_user_list_table`;
INSERT INTO `mantis_project_user_list_table` (`project_id`, `user_id`, `access_level`) VALUES
	(8, 13, 25);

-- Copiando dados para a tabela bugtracker.mantis_project_version_table: ~1 rows (aproximadamente)
DELETE FROM `mantis_project_version_table`;
INSERT INTO `mantis_project_version_table` (`id`, `project_id`, `version`, `description`, `released`, `obsolete`, `date_order`) VALUES
	(1, 38, 'v1.1.0', 'Major new version', 1, 0, 1631047000);

-- Copiando dados para a tabela bugtracker.mantis_sponsorship_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_sponsorship_table`;

-- Copiando dados para a tabela bugtracker.mantis_tag_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_tag_table`;

-- Copiando dados para a tabela bugtracker.mantis_tokens_table: ~1 rows (aproximadamente)
DELETE FROM `mantis_tokens_table`;
INSERT INTO `mantis_tokens_table` (`id`, `owner`, `type`, `value`, `timestamp`, `expiry`) VALUES
	(25, 1, 4, '1', 1653949346, 1653949729);

-- Copiando dados para a tabela bugtracker.mantis_user_pref_table: ~2 rows (aproximadamente)
DELETE FROM `mantis_user_pref_table`;
INSERT INTO `mantis_user_pref_table` (`id`, `user_id`, `project_id`, `default_profile`, `default_project`, `refresh_delay`, `redirect_delay`, `bugnote_order`, `email_on_new`, `email_on_assigned`, `email_on_feedback`, `email_on_resolved`, `email_on_closed`, `email_on_reopened`, `email_on_bugnote`, `email_on_status`, `email_on_priority`, `email_on_priority_min_severity`, `email_on_status_min_severity`, `email_on_bugnote_min_severity`, `email_on_reopened_min_severity`, `email_on_closed_min_severity`, `email_on_resolved_min_severity`, `email_on_feedback_min_severity`, `email_on_assigned_min_severity`, `email_on_new_min_severity`, `email_bugnote_limit`, `language`, `timezone`) VALUES
	(1, 1, 0, 0, 0, 30, 2, 'ASC', 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'english', 'UTC'),
	(2, 13, 0, 0, 2, 30, 2, 'ASC', 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'auto', 'UTC');

-- Copiando dados para a tabela bugtracker.mantis_user_print_pref_table: ~0 rows (aproximadamente)
DELETE FROM `mantis_user_print_pref_table`;

-- Copiando dados para a tabela bugtracker.mantis_user_profile_table: ~1 rows (aproximadamente)
DELETE FROM `mantis_user_profile_table`;

-- Copiando dados para a tabela bugtracker.mantis_user_table: ~15 rows (aproximadamente)
DELETE FROM `mantis_user_table`;
INSERT INTO `mantis_user_table` (`id`, `username`, `realname`, `email`, `password`, `enabled`, `protected`, `access_level`, `login_count`, `lost_password_request_count`, `failed_login_count`, `cookie_string`, `last_visit`, `date_created`) VALUES
	(1, 'administrator', 'Mila Nozella', 'root@localhost', '200ceb26807d6bf99fd6f4f0d1ca54d4', 1, 0, 90, 23, 0, 0, '8Pfw94O1akdxwD4CcBau-EsWLVgenquSatYCSZdpsbvijzySBNQOzF9LvlenXFxA', 1653949429, 1619203676),
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

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
