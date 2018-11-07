CREATE table courses 
(courseId SERIAL PRIMARY KEY,
courseCode VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL, 
description TEXT,
finalGrade VARCHAR(10),
courseScheduleURL VARCHAR(255),
coursePlanURL VARCHAR(255),
startDate DATE);

CREATE TABLE programs
(programId SERIAL PRIMARY KEY,
programCode VARCHAR(20) NOT NULL,
name VARCHAR(255) NOT NULL,
description TEXT);

CREATE TABLE teachers 
(teacherId SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email VARCHAR(255),
phoneNr VARCHAR(255),
office VARCHAR(255));

CREATE TABLE students 
(studentId SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email VARCHAR(255), 
phoneNr VARCHAR(255),
city VARCHAR(255),
address VARCHAR(255),
programId INTEGER REFERENCES programs);

CREATE TABLE moments
(momentId SERIAL PRIMARY KEY,
momentCode VARCHAR(255) NOT NULL,
type VARCHAR(255) NOT NULL,
description TEXT,
grade VARCHAR(10),
date DATE,
credit DECIMAL(5,2),
place VARCHAR(255),
courseId INTEGER REFERENCES courses NOT NULL);

CREATE TABLE groups 
(groupId SERIAL PRIMARY KEY,
name VARCHAR(255),
description TEXT,
momentId INTEGER REFERENCES moments NOT NULL);

CREATE TABLE studentGroups
(studentGroupId SERIAL PRIMARY KEY,
groupId INTEGER REFERENCES groups NOT NULL,
studentId INTEGER REFERENCES students NOT NULL);

CREATE TABLE courseTeachers
(courseTeacherId SERIAL PRIMARY KEY,
courseId INTEGER REFERENCES courses NOT NULL,
teacherId INTEGER REFERENCES teachers NOT NULL);

CREATE TABLE programTeachers 
(programTeacherId SERIAL PRIMARY KEY,
teacherId INTEGER REFERENCES teachers NOT NULL,
programId INTEGER REFERENCES programs NOT NULL);

CREATE TABLE courseStudents
(courseStudentId SERIAL PRIMARY KEY,
studentId INTEGER REFERENCES students NOT NULL,
courseId INTEGER REFERENCES courses NOT NULL);

CREATE TABLE programCourses
(programCourseId SERIAL PRIMARY KEY,
courseId INTEGER REFERENCES courses NOT NULL,
programId INTEGER REFERENCES programs NOT NULL);

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

INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) 
VALUES ('DVG326.0010','Skriftlig tentamen','','','2018-11-22',3.0,'',2);
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) 
VALUES ('DVG326.0020','Inlämningsuppgifter','','','2018-11-15',3.0,'',2);
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) 
VALUES ('DVG326.0030','Utvecklingsprojekt','','','2018-11-21',1.5,'',2);
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) 
VALUES ('DVG320.0010','Skriftlig tentamen','','','2019-03-19',5.0,'',3);
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) 
VALUES ('DVG320.0020','Skriftlig tentamen','','','2019-01-01',5.0,'',3);
INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) 
VALUES ('DVG320.0030','Skriftlig tentamen','','','2018-12-24',5.0,'',3);

INSERT INTO students (name, email, phoneNr, city, address, programId)
VALUES ('Felix', 'felix.palmberg@gmail.com', '0734176067', 'Gävle', 'södrakungsgatan 56B', 1);
INSERT INTO students (name, email, phoneNr, city, address, programId)
VALUES ('Marcus', 'marcus@gmail.com', '07072957265', 'Storvik', 'Stoviksvägen 22', 1);
INSERT INTO students (name, email, phoneNr, city, address, programId)
VALUES ('Fabian', 'fabian.palmberg@gmail', '0734177072', 'Älvkarleby', 'Västanåvägen 20', 2);
INSERT INTO students (name, email, phoneNr, city, address, programId)
VALUES ('Alfred', 'Alfred.nilsson@hotmail.se', '0764789022', '', '', 3);

INSERT INTO teachers (name, email, office)
VALUES ('Åke', 'ake@hig.se', '99530');
INSERT INTO teachers (name, email, office)
VALUES ('Carina', 'carina@hig.se', '99532');
INSERT INTO teachers (name, email, office)
VALUES ('Ann-sofie', 'annsofie@hig.se', '99531');
INSERT INTO teachers (name, email, office)
VALUES ('Anders', 'anders@hig.se', '99540');

INSERT INTO groups (name, description, momentId)
VALUES ('Labbgrupp', 'Grupp för laborationer i OODP', 1);
INSERT INTO groups (name, description, momentId)
VALUES ('Projektgrupp', 'Grupp för projekt i Databasteknik', 2);
INSERT INTO groups (name, description, momentId)
VALUES ('PM-grupp', 'Grupp för att samskriva ett PM i datorsystem', 4);
INSERT INTO groups (name, description, momentId)
VALUES ('Rapportskrivning', 'Grupp för att skriva rapport i OODP', 1);