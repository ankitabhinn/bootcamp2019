CREATE DATABASE Leaderboard;                          -- creatingdatabase

CREATE TABLE Leaderboard.team(
Id INT PRIMARY KEY NOT NULL auto_increment,
TeamName VARCHAR(50) NOT NULL,
CreationDate DATETIME NULL
);
select * from team
CREATE TABLE Leaderboard.member(                     
Id INT PRIMARY KEY NOT NULL auto_increment,
MemberName VARCHAR(100) NOT NULL,
TeamId INT,
Dob DATETIME NOT NULL,
Gender VARCHAR(20) NULL,
Email VARCHAR(100) NULL,
CreationDate DATETIME ,
FOREIGN KEY(TeamId) references team(Id)
);

CREATE TABLE Leaderboard.event1(
Id INT PRIMARY KEY NOT NULL auto_increment,
EventName VARCHAR(100) NOT NULL,
Description VARCHAR(200) NOT NULL,
CreationDate DATETIME 
);


CREATE TABLE Leaderboard.indscore(
Id INT PRIMARY KEY NOT NULL auto_increment,
MemberId INT NOT NULL,
EventId INT NOT NULL,
FOREIGN KEY(MemberId) references member(Id),
FOREIGN KEY(EventId) references event1(Id)
);

CREATE TABLE Leaderboard.team_score(
Id INT PRIMARY KEY NOT NULL auto_increment,
TeamId INT NOT NULL,
EventId INT NOT NULL,
FOREIGN KEY(EventId) references event1(Id),
FOREIGN KEY(TeamId) references team(Id)
);

INSERT INTO Leaderboard.team(TeamName,CreationDate) VALUES('Red',sysdate());
INSERT INTO Leaderboard.team(TeamName,CreationDate) VALUES('Green',sysdate());
INSERT INTO Leaderboard.team(TeamName,CreationDate) VALUES('Yellow',sysdate());
INSERT INTO Leaderboard.team(TeamName,CreationDate) VALUES('Blue',sysdate());

SELECT TeamName FROM Leaderboard.team;
UPDATE Leaderboard.team
SET TeamName='REd'
WHERE Id=4;
DELETE FROM Leaderboard.team 
WHERE Id in 4;


INSERT INTO Leaderboard.member(MemberName,TeamId,gender,CreationDate) VALUES('SUJITH','4','MALE','23/12/2019'sysdate());
INSERT INTO Leaderboard.member(MemberName,TeamId,gender,CreationDate) VALUES('ANJANA','4','FEMALE','23/12/2019'sysdate());
INSERT INTO Leaderboard.member(MemberName,TeamId,gender,CreationDate) VALUES('SUMAYYA','4','FEMALE','23/12/2019'sysdate());
INSERT INTO Leaderboard.member(MemberName,TeamId,gender,CreationDate) VALUES('ASWIN','3','FEMALE','23/12/2019'sysdate());
INSERT INTO Leaderboard.member(MemberName,TeamId,gender,CreationDate) VALUES('SONA','4','FEMALE','23/12/2019'sysdate());
INSERT INTO Leaderboard.member(MemberName,TeamId,gender,CreationDate) VALUES('DIVYA','4','FEMALE','23/12/2019'sysdate());








SELECT * FROM 

