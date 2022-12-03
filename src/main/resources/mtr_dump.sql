-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: MusicTheoryRepo
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

create table users
               (
                 user_id int(5) NOT NULL auto_increment
                   primary key,
                 first_name varchar(25) null,
                 last_name varchar(30) null,
                 email varchar(100) null,
                 user_name varchar(15) null,
                 password varchar(30) null,
                 constraint users_user_name_uindex
                 unique (user_name)
               );
               

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Mark','Knopfler','markyk@direstraits.com','evh1','secret1'),(2,'Eric','Clapton','eclapton@aol.com','eclapton','secret2'),(3,'Jimmy','Page','jimpage@hotmail.com','jpage44','secret3');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
             
--
-- Table structure for table `keysMusic`
--
DROP TABLE IF EXISTS `keysMusic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

create table keysMusic
               (
                 key_id int(2) NOT NULL
                   primary key,
                 key_name varchar(2) null,
                 constraint keysMusic_key_name_uindex
                 unique (key_name)
               );
               
LOCK TABLES `keysMusic` WRITE;
/*!40000 ALTER TABLE `keysMusic` DISABLE KEYS */;
INSERT INTO `keysMusic` VALUES (1,'C'),(2,'G'),(3,'D'),(4,'A'),(5,'E'),(6,'B'),(7,'C#'),(8,'F#'),(9,'B♭'),(10,'E♭'),(11,'A♭'),(12,'D♭'),(13,'G♭'),(14,'C♭'),(15,'F');
/*!40000 ALTER TABLE `keysMusic` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `keyScales`
--
DROP TABLE IF EXISTS `keyScales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
             
create table keyScales
               (
                 scale_id int(4) NOT NULL auto_increment
                   primary key,
                 scale_name varchar(30) null,
                 scale_data varchar(100) null,
                 key_id int(2) null,
                 KEY `keyScales_key_id_fk` (`key_id`),
                 CONSTRAINT `keyScales_key_id_fk` FOREIGN KEY (`key_id`) REFERENCES `keysMusic` (`key_id`) ON DELETE CASCADE ON UPDATE CASCADE
               );
               
LOCK TABLES `keyScales` WRITE;
/*!40000 ALTER TABLE `keyScales` DISABLE KEYS */;
INSERT INTO `keyScales` VALUES (1,'C Major (C Ionian)', 'C D E F G A B', 1),(2,'C Dorian','C D Eb F G A Bb',1),(3,'C Phrygian', 'C Db Eb F G Ab Bb',1),(4,'C Lydian','C D E F# G A B',1),(5,'C Mixolydian', 'C D E F G A Bb',1);
INSERT INTO `keyScales` VALUES (6,'C Aeolian', 'C D Eb F G Ab Bb', 1),(7,'C Locrian','C Db Eb F Gb Ab Bb',1),(8,'C Minor', 'C D Eb F G Ab Bb',1),(9,'C Harmonic Minor','C D Eb F G Ab B',1),(10,'C Melodic Minor', 'C D Eb F G A B',1);
INSERT INTO `keyScales` VALUES (11,'C Major Pentatonic', 'C D E G A', 1),(12,'C Blues Scale','C D Eb E G A',1),(13,'C Minor Pentatonic', 'C Eb F G Bb',1),(14,'Relative Minor','A B C D E F G',1);

INSERT INTO `keyScales` VALUES (15,'G Major (G Ionian)', 'G A B C D E F#', 2),(16,'G Dorian','G A Bb C D E F',1),(17,'G Phrygian', 'G Ab Bb C D Eb F',2),(18,'G Lydian','G A B C# D E F#',2),(19,'G Mixolydian', 'G A B C D E F',2);
INSERT INTO `keyScales` VALUES (20,'G Aeolian', 'G A Bb C D Eb F', 2),(21,'G Locrian','G Ab Bb C Db Eb F',2),(22,'G Minor', 'G A Bb C D Eb F',2),(23,'G Harmonic Minor','G A Bb C D Eb F#',2),(24,'G Melodic Minor', 'G A Bb C D E F#',2);
INSERT INTO `keyScales` VALUES (25,'G Major Pentatonic', 'G A B D E', 2),(26,'G Blues Scale','G Bb C Db D F', 2),(27,'G Minor Pentatonic', 'G B♭ C D F', 2),(28,'Relative Minor','E F# G A B C D', 2);

INSERT INTO `keyScales` VALUES (29,'Bb Major (Bb Ionian)', 'B♭ C D E♭ F G A', 9),(30,'Bb Dorian','Bb C Db Eb F G Ab',9),(31,'Bb Phrygian', 'Bb Cb Db Eb F Gb Ab',9),(32,'Bb Lydian','Bb C D E F G A',9),(33,'Bb Mixolydian', 'Bb C D Eb F G Ab',9);
INSERT INTO `keyScales` VALUES (34,'Bb Aeolian', 'Bb C Db Eb F Gb Ab', 9),(35,'Bb Locrian','Bb Cb Db Eb Fb Gb Ab',9),(36,'Bb Minor', 'Bb C Db Eb F Gb Ab',9),(37,'Bb Harmonic Minor','B♭ C D♭ E♭ F G♭ A♭',9),(38,'Bb Melodic Minor', 'B♭ C D♭ E♭ F G♭ A♭',9);
INSERT INTO `keyScales` VALUES (39,'Bb Major Pentatonic', 'Bb C D F G', 9),(40,'Bb Blues Scale','Bb C Db D F G', 9),(41,'Bb Minor Pentatonic', 'Bb Db Eb F Ab',9),(42,'Relative Minor','G A Bb C D Eb F',9);
/*!40000 ALTER TABLE `keyScales` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `keyChords`
--
DROP TABLE IF EXISTS `keyChords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
             
create table keyChords
               (
                 chord_id int(4) NOT NULL auto_increment
                   primary key,
                 chord_category varchar(60) null,
                 chord_name varchar(10) null,
                 chord_data varchar(100) null,
                 key_id int(2) null,
                 KEY `keyChords_key_id_fk` (`key_id`),
                 CONSTRAINT `keyChords_key_id_fk` FOREIGN KEY (`key_id`) REFERENCES `keysMusic` (`key_id`) ON DELETE CASCADE ON UPDATE CASCADE
               );

LOCK TABLES `keyChords` WRITE;
/*!40000 ALTER TABLE `keyChords` DISABLE KEYS */;
INSERT INTO `keyChords` VALUES (1,'Triads','C Major','C E G',1),(2,'Triads','C Minor','C E♭ G',1),(3,'Triads','C Diminished','C Eb Gb',1),(4,'Triad','C Augmented','C E G#',1),(5,'Common','C sus2','C D G',1),(6,'Common','C sus4','C F G',1),(7,'Common','C6','C E A',1);
INSERT INTO `keyChords` VALUES (8,'Major','C Major','C E G',1),(9,'Major','D Minor','D F A',1),(10,'Major','E Minor','E G B',1),(11,'Major','F Major','F A C',1),(12,'Major','G Major','G B D',1),(13,'Major','A Minor','A C E',1),(14,'Major','B Diminished','B D F',1);
INSERT INTO `keyChords` VALUES (15,'Minor','C Minor','C Eb G',1),(16,'Minor','D Diminished','D Fb Ab',1),(17,'Minor','Eb Major','Eb G Bb',1),(18,'Minor','F Minor','F Ab C',1),(19,'Minor','G Minor','G Bb D',1),(20,'Minor','Ab Major','Ab C E',1),(21,'Minor','Bb Major','Bb D F',1);
INSERT INTO `keyChords` VALUES (22,'Seventh','C Maj7','C E G B',1),(23,'Seventh','Dm7','D F A C',1),(24,'Seventh','Em7','E G B D',1),(25,'Seventh','F Maj7','F A C E',1),(26,'Seventh','G7','G B D F',1),(27,'Seventh','Am7','A C E G',1),(28,'Seventh','Bm7♭5','B D F A',1);

INSERT INTO `keyChords` VALUES (29,'Triads','G Major','G B D',2),(30,'Triads','G Minor','G B♭ D',2),(31,'Triads','G Diminished','G Bb Db',2),(32,'Triad','G Augmented','G B D#',2),(33,'Common','G sus2','G A D',2),(34,'Common','G sus4','G C D',2),(35,'Common','G6','G B E',2);
INSERT INTO `keyChords` VALUES (36,'Major','G Major','G B D',2),(37,'Major','A Minor','A C E',2),(38,'Major','B Minor','B D F#',2),(39,'Major','C Major','C E G',2),(40,'Major','D Major','D F# A',2),(41,'Major','E Minor','E G B',2),(42,'Major','F# Diminished','F# A C',2);
INSERT INTO `keyChords` VALUES (43,'Minor','G Minor','G Bb D',2),(44,'Minor','A Diminished','A C Eb',2),(45,'Minor','Bb Major','Bb D F',1),(46,'Minor','C Minor','C Eb G',2),(47,'Minor','D Minor','D F A',2),(48,'Minor','Eb Major','Eb G Bb',2),(49,'Minor','F Major','F A C',2);
INSERT INTO `keyChords` VALUES (50,'Seventh','G Maj7','G B D F#',2),(51,'Seventh','Am7','A C E G',2),(52,'Seventh','Bm7','B D F# A',2),(53,'Seventh','C Maj7','C E G B',2),(54,'Seventh','D7','D F# A C',2),(55,'Seventh','Em7','E G B D',2),(56,'Seventh','F#m7♭5','F# A C E',2);

INSERT INTO `keyChords` VALUES (57,'Triads','Bb Major','Bb D F',9),(58,'Triads','Bb Minor','Bb Db F',9),(59,'Triads','Bb Diminished','Bb Db Fb',9),(60,'Triad','Bb Augmented','Bb D F#',9),(61,'Common','Bb sus2','Bb C F',9),(62,'Common','Bb sus4','Bb E F',9),(63,'Common','Bb6','Bb D G',9);
INSERT INTO `keyChords` VALUES (64,'Major','Bb Major','Bb D F',9),(65,'Major','C Minor','C Eb G',9),(66,'Major','D Minor','D F A',9),(67,'Major','Eb Major','Eb G Bb',9),(68,'Major','F Major','F A C',9),(69,'Major','G Minor','G Bb D',9),(70,'Major','A Diminished','A C Eb',3);
INSERT INTO `keyChords` VALUES (71,'Minor','Bb Minor','Bb Db F',9),(72,'Minor','C Diminished','C Eb Gb',9),(73,'Minor','Db Major','Db F Ab',9),(74,'Minor','Eb Minor','Eb Gb Bb',9),(75,'Minor','F Minor','F Ab C',9),(76,'Minor','Gb Major','Gb Bb Db',9),(77,'Minor','Ab Major','Ab C Eb',9);
INSERT INTO `keyChords` VALUES (78,'Seventh','Bb Maj7','B D F A',9),(79,'Seventh','Cm7','C Eb G Bb',9),(80,'Seventh','Dm7','D F A C',9),(81,'Seventh','Eb Maj7','Eb G Bb D',9),(82,'Seventh','F7','F A C Eb',9),(83,'Seventh','Gm7','G Bb D F',9),(84,'Seventh','Am7♭5','A C Eb G',9);
/*!40000 ALTER TABLE `keyChords` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `userScales`
--
DROP TABLE IF EXISTS `userScales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

create table userScales
               (
                 user_scale_id int(4) NOT NULL auto_increment
                   primary key,
                 user_scale_name varchar(30) null,
                 user_scale_data varchar(100) null,
                 user_id int(5) null,
                 KEY `userScales_user_id_fk` (`user_id`),
                 CONSTRAINT `userScales_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
               );
               
LOCK TABLES `userScales` WRITE;
/*!40000 ALTER TABLE `userScales` DISABLE KEYS */;
INSERT INTO `userScales` VALUES (1,'D Persian', 'D Eb F# G Ab Bb C#', 1),(2,'B Hungarian Minor','B, C#, D, F, F#, G, A#',3),(3,'F# Arabic', 'F#, G#, A#, B, C, D, E, F#',2),(4,'G Mixolydian Augmented','G, A, B, C, D#, E, F',2),(5,'C Arabic', 'C, D, E, F, Gb Ab, Bb, C',3);
INSERT INTO `userScales` VALUES (6,'A♭ Persian', 'A♭-A-C-D♭-D-E-G', 1),(7,'E Diatonic','E – F♯ – G♯ – A – B – C♯ – D♯ – E',2),(8,'C# Persian', 'C# D F F# G A C',3),(9,'B♭ Diatonic','B♭ C D E♭ F G A B♭',1),(10,'E Hungarian Minor', 'E, F#, G, A#, B, C, D#',2);
/*!40000 ALTER TABLE `userScales` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `userChords`
--
DROP TABLE IF EXISTS `userChords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

create table userChords
               (
                 user_chord_id int(4) NOT NULL auto_increment
                   primary key,
                 user_chord_category varchar(60) null,
                 user_chord_name varchar(10) null,
                 user_chord_data varchar(100) null,
                 user_id int(5) null,
                 KEY `userChords_user_id_fk` (`user_id`),
                 CONSTRAINT `userChords_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
               );
               
LOCK TABLES `userChords` WRITE;
/*!40000 ALTER TABLE `userChords` DISABLE KEYS */;
INSERT INTO `userChords` VALUES (1,'User','C11(b9)','C G Bb Db F',3),(2,'User','Eb add4','E♭ G A♭ B♭',1),(3,'User','F13','F-A-Bb-D-Eb',2),(4,'User','F7sus4','F Bb C Eb',2),(5,'User','C#aug7','C# F A B',1);
INSERT INTO `userChords` VALUES (6,'User','Bb 6/9','Bb D F G C',1),(7,'User','Em9','E G B D F#',3),(8,'User','E9#5','E G# C D F#',2),(9,'User','A maj9','A C# E G# B',3),(10,'User','C9(#5)','G B D# F A',1);
/*!40000 ALTER TABLE `userChords` ENABLE KEYS */;
UNLOCK TABLES;


-- Table structure for table `songs`
--
DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

create table songs
               (
                 song_id int(4) NOT NULL auto_increment
                   primary key,
                 song_name varchar(30) null,
                 song_artist varchar(100) null,
                 key_id int(2) null,
                 KEY `song_key_id_fk` (`key_id`),
                 CONSTRAINT `songs_key_id_fk` FOREIGN KEY (`key_id`) REFERENCES `keysMusic` (`key_id`) ON DELETE CASCADE ON UPDATE CASCADE
               );
               
LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'Jump','Van Halen', 1),(2,'Like A Rolling Stone','Bob Dylan',1),(3,'Let it Be', 'The Beatles',1),(4,'Tiny Dancer','Elton John',1),(5,'Halleluluah', 'Leonard Cohen',1);
INSERT INTO `songs` VALUES (6,'Wish You Were Here', 'Pink Floyd', 2),(7,'Come As You Are','Nirvana',2),(8,'Sweet Home Alabama', 'Lynyrd Skynyrd',2),(9,'Good Riddance','Green Day',2),(10,'Blackbird', 'The Beatles',2);
INSERT INTO `songs` VALUES (11,'Rocket Man','Elton John',9),(12,'Johnny B. Goode','Chuck Berry',9),(13,'Purple Rain', 'Prince',9),(14,'Teenage Dream','Katy Perry',9),(15,'Spiderwebs', 'No Doubt',9);
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;

