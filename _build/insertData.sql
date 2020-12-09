INSERT INTO users (email, pseudo, name, surname) VALUES ('bob@dylan@gmail.com', 'Boby', 'Bob', 'Dylan'), ('jaz.morvax@gmail.com', 'Jaz', 'Jaz', 'Morvax');

INSERT INTO permissions (name) VALUES ('Noob'),('God');

INSERT INTO langages (name) VALUES ('CSS'),('HTML'),('Java'),('Javascript'),('Bash');

INSERT INTO os (name) VALUES ('Linux'),('Mac'),('Windows');

INSERT INTO frameworks (name) VALUES ('Angular'),('Node.js'),('Symphony');

INSERT INTO libraries (name) VALUES ('Linux'),('Mac'),('Windows');

INSERT INTO doc_content (content) VALUES ('<ul><li>Désolé de vous avoir vue, et se félicitent du silence fait autour de toi.</li><li>Rêve, folie et souvenir se mêlent fébrilement en une série de petites cellules s''ouvraient au bord.</li><li>Pousser une autre porte entrebâillée laissait filtrer un rayon de costumes pour enfants, qui, maltraitées ou trahies par un ingénieux bandage en papier, et pour quoi faire ?</li></ul>'),('<h2>Illustre et belle patrie, nos nobles, tel que je suis né aux environs, et qu''il voulait parler.</h2><p>Apprenez donc de moi, tiendra le plus longtemps au plafond pour en faire sortir le sang, pouvait racheter une autre vie. Voudraient-elles bien parler encore, pour un bon capitaine c''est celui qui en portait un énorme plateau.<p>'),('Faites que je vous suis. Près d''elle et luttait contre la brise, on apercevait, dans les bras de quarante hommes réunis. Aux autres endroits, des feuilles humides, ils souffraient en quelque sorte pris par trahison.');


INSERT INTO doc_permissions (doc_content_id, permission_id) VALUES (1,1);
INSERT INTO doc_permissions (doc_content_id, permission_id) VALUES (2,2);
INSERT INTO doc_permissions (doc_content_id, permission_id) VALUES (3,1);

INSERT INTO doc_langages (doc_content_id, langage_id) VALUES (1,1);
INSERT INTO doc_langages (doc_content_id, langage_id) VALUES (2,2);
INSERT INTO doc_langages (doc_content_id, langage_id) VALUES (3,3);

INSERT INTO doc_os (doc_content_id, os_id) VALUES (1,1);
INSERT INTO doc_os (doc_content_id, os_id) VALUES (2,2);
INSERT INTO doc_os (doc_content_id, os_id) VALUES (3,3);


INSERT INTO doc_frameworks (doc_content_id, framework_id) VALUES (1,1);
INSERT INTO doc_frameworks (doc_content_id, framework_id) VALUES (2,2);
INSERT INTO doc_frameworks (doc_content_id, framework_id) VALUES (3,3);

INSERT INTO doc_libraries (doc_content_id, library_id) VALUES (1,1);
INSERT INTO doc_libraries (doc_content_id, library_id) VALUES (2,2);
INSERT INTO doc_libraries (doc_content_id, library_id) VALUES (3,3);