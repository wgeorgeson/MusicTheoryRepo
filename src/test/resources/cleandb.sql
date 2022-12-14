-- The following sql statements must each be on one line, otherwise our custom Database class will not run this script properly
-- This script is called from the Database class to delete and recreate each table before any unit tests are done (so we are always working with the same data to test with)
delete from users;
delete from userChords;
delete from userScales;
INSERT INTO users VALUES (1,'Mark','Knopfler','wgeorgeson@madisoncollege.edu','markyK','secret1'),(2,'Eric','Clapton','wgeorgeson@madisoncollege.edu','eclapton','secret1'),(3,'Jimmy','Page','wgeorgeson@madisoncollege.edu','jimmyP44','secret1'),(4,'Billy','Gibbons','wgeorgeson@madisoncollege.edu','bgibbons','secret1');
INSERT INTO userChords VALUES (1,'User','C11(b9)','C G Bb Db F',3),(2,'User','Eb add4','E♭ G A♭ B♭',1),(3,'User','F13','F-A-Bb-D-Eb',2),(4,'User','F7sus4','F Bb C Eb',2),(5,'User','C#aug7','C# F A B',1);
INSERT INTO userChords VALUES (6,'User','Bb 6/9','Bb D F G C',1),(7,'User','Em9','E G B D F#',3),(8,'User','E9#5','E G# C D F#',2),(9,'User','A maj9','A C# E G# B',3),(10,'User','C9(#5)','G B D# F A',1);
INSERT INTO userChords VALUES (11,'User','F# m6','F# A C# D#',2),(12,'User','Bm11','B D A E',4),(13,'User','Eb9 b5','E-G-A-Db-F',1),(14,'User','D9','D F# A C E',4),(15,'User','F# m13','F# A D# G# B E',4);
INSERT INTO userScales VALUES (1,'D Persian', 'D Eb F# G Ab Bb C#', 1),(2,'B Hungarian Minor','B, C#, D, F, F#, G, A#',3),(3,'F# Arabic', 'F#, G#, A#, B, C, D, E, F#',2),(4,'G Mixolydian Augmented','G, A, B, C, D#, E, F',2),(5,'C Arabic', 'C, D, E, F, Gb Ab, Bb, C',3);
INSERT INTO userScales VALUES (6,'A♭ Persian', 'A♭-A-C-D♭-D-E-G', 1),(7,'E Diatonic','E – F♯ – G♯ – A – B – C♯ – D♯ – E',2),(8,'C# Persian', 'C# D F F# G A C',3),(9,'B♭ Diatonic','B♭ C D E♭ F G A B♭',1),(10,'E Hungarian Minor', 'E, F#, G, A#, B, C, D#',2);
INSERT INTO userScales VALUES (11,'F Asian', 'F, Ab, Bb, C, Eb', 4),(12,'C hindu','C D E F G Ab Bb',1),(13,'Db Hungarian major', 'Db - E - F - G - Ab - Bb - Cb',3),(14,'E Spanish Gypsy','E, F, G#, A, B, C, D',4),(15,'C Neopolitan Major', 'C-Db-Eb-F-G-A-B',4);
