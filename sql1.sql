-- database creation

CREATE DATABASE Leaderboardtest;
DROP DATABASE Leaderboardtest;
CREATE DATABASE Leaderboard;

CREATE TABLE Leaderboard.Team(
Id INT PRIMARY KEY NOT NULL auto_increment,
TeamName VARCHAR(50) NOT NULL,
CreationDate DATETIME NULL
);

CREATE TABLE Leaderboard.Members(
Id INT PRIMARY KEY NOT NULL auto_increment,
MemberName VARCHAR(100) NOT NULL,
Dob DATETIME,
Gender VARCHAR(1),
Email VARCHAR(100),
CreationDate DATETIME NULL,
TeamId INT,
FOREIGN KEY(TeamId) references Team(Id)
);

CREATE TABLE Leaderboard.Event(
Id INT PRIMARY KEY NOT NULL auto_increment,
EventName VARCHAR(50) NOT NULL,
EventDescription VARCHAR(200) NOT NULL,
CreationDate DATETIME NULL
);

CREATE TABLE Leaderboard.IndividualScore(
Id INT PRIMARY KEY NOT NULL auto_increment,
MemberId INT,
FOREIGN KEY(MemberId) references Members(Id),
EventId INT,
FOREIGN KEY(EventId) references Event(Id),
Score INT NOT NULL
);

CREATE TABLE Leaderboard.TeamScore(
Id INT PRIMARY KEY NOT NULL auto_increment,
TeamId INT,
FOREIGN KEY(TeamId) references Team(Id),
EventId INT,
FOREIGN KEY(EventId) references Event(Id),
Score INT NOT NULL
);

INSERT INTO Leaderboard.Team (TeamName,CreationDate) VALUES('Red',sysdate());
INSERT INTO Leaderboard.Team (TeamName,CreationDate) VALUES('Green',sysdate());
INSERT INTO Leaderboard.Team (TeamName,CreationDate) VALUES('Blue',sysdate());
INSERT INTO Leaderboard.Team (TeamName,CreationDate) VALUES('Yellow',sysdate());

SELECT * FROM Leaderboard.Team;

DELETE FROM Leaderboard.Team WHERE Id = 3;



























