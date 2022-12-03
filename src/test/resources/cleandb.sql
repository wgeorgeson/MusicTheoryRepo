-- The following sql statements must each be on one line, otherwise our custom Database class will not run this script properly
-- This script is called from the Database class to delete and recreate each table before any unit tests are done (so we are always working with the same data to test with)
delete from users;
delete from userChords;
delete from userScales;
INSERT INTO users VALUES (1,'Mark','Knopfler','markyk@direstraits.com','mknopfler','secret1'),(2,'Eric','Clapton','eclapton@aol.com','eclapton','secret2'),(3,'Jimmy','Page','jimpage@hotmail.com','jpage44','secret3');
INSERT INTO userChords VALUES (1,'User','C11(b9)','C G Bb Db F',3),(2,'User','Eb add4','E♭ G A♭ B♭',1),(3,'User','F13','F-A-Bb-D-Eb',2),(4,'User','F7sus4','F Bb C Eb',2),(5,'User','C#aug7','C# F A B',1);
INSERT INTO userChords VALUES (6,'User','Bb 6/9','Bb D F G C',1),(7,'User','Em9','E G B D F#',3),(8,'User','E9#5','E G# C D F#',2),(9,'User','A maj9','A C# E G# B',3),(10,'User','C9(#5)','G B D# F A',1);
INSERT INTO userScales VALUES (1,'D Persian', 'D Eb F# G Ab Bb C#', 1),(2,'B Hungarian Minor','B, C#, D, F, F#, G, A#',3),(3,'F# Arabic', 'F#, G#, A#, B, C, D, E, F#',2),(4,'G Mixolydian Augmented','G, A, B, C, D#, E, F',2),(5,'C Arabic', 'C, D, E, F, Gb Ab, Bb, C',3);
INSERT INTO userScales VALUES (6,'A♭ Persian', 'A♭-A-C-D♭-D-E-G', 1),(7,'E Diatonic','E – F♯ – G♯ – A – B – C♯ – D♯ – E',2),(8,'C# Persian', 'C# D F F# G A C',3),(9,'B♭ Diatonic','B♭ C D E♭ F G A B♭',1),(10,'E Hungarian Minor', 'E, F#, G, A#, B, C, D#',2);
