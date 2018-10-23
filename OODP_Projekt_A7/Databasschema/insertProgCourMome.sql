INSERT INTO programs (programCode, name, description) 
VALUES ('HIG-19104','Dataingenjörsprogrammet', 'Vårt samhälle och vardag fungerar allt oftare genom olika system och IT-lösningar. Som dataingenjör möter du därför fler utmaningar än ren programmering och ofta handlar det om att hitta lösningar där någon annan kanske upplever ett problem. Här skriver du koden framtiden behöver!');
INSERT INTO programs (programCode, name, description) 
VALUES ('HIG-19200','Automationsingenjör (Co-op)','Automatiseringar finns överallt i vår omgivning - från smarta styrsystem för vår inomhusmiljö till industriella produktionsprocesser. Automation gör vår vardag enklare genom att samordna olika tekniska system som elektronik, IT, människa/maskin samt ekonomi och miljö.');
INSERT INTO programs (programCode, name, description) 
VALUES ('HIG-19108','Maskiningenjör (Co-op) 180 hp','Hur tillverkas en produkt? När du läser till maskiningenjör får du gedigen kunskap om hur en produkt blir till - från grundidé och vidare genom hela tillverkningsprocessen. Du får lära dig att utveckla, konstruera och producera produkter med hjälp av CAD, CAM och FEM-program. Dessutom får du goda beräkningskunskaper och värdefull inblick i logistik- och kvalitetsfrågor.');
INSERT INTO programs (programCode, name, description) 
VALUES ('HIG-29815','Ekonomprogrammet','Att skaffa dig en ekonomutbildning är förmodligen en av de bästa investeringar för framtiden du kan göra.');

INSERT INTO courses (courseCode, name, description, startDate, finalGrade, courseScheduleURL, coursePlanURL)
VALUES ('ST006A','Dataanalys och statistik för ekonomer','','2018-09-22','','http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sprak=SV&sokMedAND=true&forklaringar=true&resurser=k.ST006A.18204.18-','http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=ST006A');
INSERT INTO courses (courseCode, name, description, startDate, finalGrade, courseScheduleURL, coursePlanURL)
VALUES ('DVG326','Objektorienterad design och programmering','','2018-09-20','','http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG326.18426.18-%2C','http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=DVG326');
INSERT INTO courses (courseCode, name, description, startDate, finalGrade, courseScheduleURL, coursePlanURL)
VALUES ('DVG328','Databasteknik','','2018-08-20','','http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG328.18425.18-%2C','http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG326.18426.18-%2Ck.DVG328.18425.18-%2C');
INSERT INTO courses (courseCode, name, description, startDate, finalGrade, courseScheduleURL, coursePlanURL)
VALUES ('DVG320','Programvaruteknik - utveckling och underhåll av programvara','','2018-08-17','','http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG320.28414.19-%2C','http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=DVG320');

INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseCode) 
VALUES ('DVG326.0010','Skriftlig tentamen','','','',3.0,'','DVG326');
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseCode) 
VALUES ('DVG326.0020','Inlämningsuppgifter','','','',3.0,'','DVG326');
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseCode) 
VALUES ('DVG326.0030','Utvecklingsprojekt','','','',1.5,'','DVG326');
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseCode) 
VALUES ('DVG320.0010','Skriftlig tentamen','','','',5.0,'','DVG320');
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseCode) 
VALUES ('DVG320.0020','Skriftlig tentamen','','','',5.0,'','DVG320');
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseCode) 
VALUES ('DVG320.0030','Skriftlig tentamen','','','',5.0,'','DVG320');