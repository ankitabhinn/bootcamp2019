CREATE DATABASE Leaderboard;
CREATE TABLE Leaderboard.Team
(
Id INT PRIMARY KEY NOT NULL auto_increment,
TeamName VARCHAR(50) NOT NULL,
CreationDate DATETIME NULL 
);

CREATE TABLE Leaderboard.Member
(
Id INT PRIMARY KEY NOT NULL auto_increment,
MemberName VARCHAR(100) NOT NULL,
TeamId INT  NULL,
DateOfBirth DATETIME,
Gender VARCHAR(1),
Email VARCHAR(100),
CreationDate DATETIME,
FOREIGN KEY (TeamId) references Team(Id)

);

CREATE TABLE Leaderboard.Event
(
Id INT PRIMARY KEY NOT NULL auto_increment,
EventName VARCHAR(100) NOT NULL,
Description VARCHAR(500) NOT NULL,
CreationDate DATETIME

);

CREATE TABLE Leaderboard.IndividualScore
(
Id INT PRIMARY KEY NOT NULL auto_increment,
MemberId INT NOT NULL,
EventId INT  NULL,
FOREIGN KEY (MemberId) references Member(Id),

FOREIGN KEY (EventId) references Event(Id)
);

CREATE TABLE Leaderboard.TeamScore
(
TeamId INT PRIMARY KEY NOT NULL auto_increment,
Score INT NOT NULL,
FOREIGN KEY (TeamId) references Team(Id)

);

INSERT INTO Leaderboard.Team(TeamName,CreationDate) VALUES('Blue',sysdate());

INSERT INTO Leaderboard.Member(MemberName,CreationDate) VALUES('Sherin',sysdate());
INSERT INTO Leaderboard.Member(MemberName,CreationDate) VALUES('Sreerag',sysdate());
INSERT INTO Leaderboard.Member(MemberName,CreationDate) VALUES('Arathy',sysdate());


DELETE FROM Team WHERE Id = 1;

UPDATE Leaderboard.Team
SET TeamName = 'TeamBlue'
WHERE Id = 1 ;
USE DATABASE Leaderboard;
SELECT * FROM Leaderboard.Team;

INSERT INTO Leaderboard.Member(MemberName,Email,CreationDate) VALUES('Sherin','sh@gmail.com',sysdate());
select * from Leaderboard.Member