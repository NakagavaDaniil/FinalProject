
CREATE DATABASE `projectdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */



CREATE TABLE `answear_variants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `variant` varchar(45) DEFAULT NULL,
  `id_question` int(11) NOT NULL,
  `is_correct_answear` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `answear_variants_questions_id_fk` (`id_question`),
  CONSTRAINT `answear_variants_questions_id_fk` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `gamehistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `local_date_time` datetime NOT NULL,
  `loser_team_name` varchar(45) DEFAULT NULL,
  `winner_team_name` varchar(45) DEFAULT NULL,
  `judge_login` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `game_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `judge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_list` int(11) DEFAULT NULL,
  `tottal_hints_given` int(11) DEFAULT NULL,
  `number_of_games` int(11) DEFAULT NULL,
  `judge_login` varchar(45) DEFAULT NULL,
  UNIQUE KEY `judge_id_uindex` (`id`),
  KEY `judge_questions_id_fk` (`question_list`),
  KEY `judge_user_login_fk` (`judge_login`),
  CONSTRAINT `judge_questions_id_fk` FOREIGN KEY (`question_list`) REFERENCES `questions` (`id`),
  CONSTRAINT `judge_user_login_fk` FOREIGN KEY (`judge_login`) REFERENCES users (`login`),
  CONSTRAINT `judge_user_user_id_fk` FOREIGN KEY (`id`) REFERENCES users (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `player` (
  `id` int(11) DEFAULT NULL,
  `user_login` varchar(45) DEFAULT NULL,
  `tottal_pints` int(11) DEFAULT NULL,
  `tottal_games` int(11) DEFAULT NULL,
  `tottal_wins` int(11) DEFAULT NULL,
  UNIQUE KEY `player_user_login_uindex` (`user_login`),
  KEY `player_user_user_id_fk` (`id`),
  CONSTRAINT `player_user_login_fk` FOREIGN KEY (`user_login`) REFERENCES users (`login`),
  CONSTRAINT `player_user_user_id_fk` FOREIGN KEY (`id`) REFERENCES users (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `questions_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `questtion_judge` (
  `id_question` int(11) DEFAULT NULL,
  `id_judge` int(11) DEFAULT NULL,
  KEY `questtion_judge_judge_id_fk` (`id_judge`),
  KEY `questtion_judge_questions_id_fk` (`id_question`),
  CONSTRAINT `questtion_judge_judge_id_fk` FOREIGN KEY (`id_judge`) REFERENCES `judge` (`id`),
  CONSTRAINT `questtion_judge_questions_id_fk` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `team_player` (
  `player_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  KEY `team_player_teamname_id_fk` (`team_id`),
  KEY `team_player_player_id_fk` (`player_id`),
  CONSTRAINT `team_player_player_id_fk` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
  CONSTRAINT `team_player_teamname_id_fk` FOREIGN KEY (`team_id`) REFERENCES `teamname` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `teamname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(45) DEFAULT NULL,
  `tottal_wins` int(11) DEFAULT NULL,
  `tottal_games` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `team_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_user_id_uindex` (`user_id`),
  UNIQUE KEY `user_login_uindex` (`login`),
  UNIQUE KEY `user_email_uindex` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

