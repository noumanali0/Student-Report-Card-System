create database student;
use student;
CREATE TABLE `Records` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Chemistry` int DEFAULT NULL,
  `Physics` int DEFAULT NULL,
  `Maths` int DEFAULT NULL,
  `PS` int DEFAULT NULL,
  `Biology` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

drop table Records;

insert into Records(id,Name,Chemistry,Physics,Maths,PS,Biology) values (1,'Nouman',22.3,25.3,25.5,32.3,40.5);
insert into Records(id,Name,Chemistry,Physics,Maths,PS,Biology) values (2,'Tanveer',50,60,70,80,90);

CREATE TABLE `Comments` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

insert into Comments(ID,Comments) values (1,'fit hy sara kuch jani');
insert into Comments(Comments) values ('I want to recheck my biology paper');


select * from comments;
