CREATE DATABASE `muzedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
DROP TABLE IF EXISTS `audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

DROP TABLE IF EXISTS `user_audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;


CREATE TABLE `user_audio` (
  `Userid` int NOT NULL AUTO_INCREMENT,
  `Audioid` int NOT NULL,
  `is_Uploaded` boolean,
  `is_Downloaded` boolean,
  PRIMARY KEY (`Userid`,`Audioid`),
  KEY `Audioid` (`Audioid`),
  CONSTRAINT `Audioid` FOREIGN KEY (`Audioid`) REFERENCES `audio` (`Audio_id`),
  CONSTRAINT `Userid` FOREIGN KEY (`Userid`) REFERENCES `user` (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `audio` (
  `Audio_id` int NOT NULL AUTO_INCREMENT,
  `Audioname` varchar(45) NOT NULL,
  `Artist` varchar(45) NOT NULL,
  `Uploader` varchar(45) NOT NULL,
  PRIMARY KEY (`Audio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `User_id` int NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `e-mail` varchar(45) NOT NULL,
  `portnumber` varchar(45) NOT NULL,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;