
DROP TABLE IF EXISTS CoverageItems CASCADE;

CREATE TABLE CoverageItems (
                               coverageId INT PRIMARY KEY AUTO_INCREMENT,
                               coverageName VARCHAR(50) NOT NULL,
                               coverageDescription VARCHAR(50) NOT NULL,
                               coverage_limit DECIMAL(19, 2) NOT NULL,
                               premium DECIMAL(19, 2) NOT NULL,
                               active BOOLEAN DEFAULT TRUE NOT NULL
);

DROP TABLE IF EXISTS Persons CASCADE;

CREATE TABLE Persons (
                         personId INT PRIMARY KEY AUTO_INCREMENT,
                         firstName VARCHAR(25) NOT NULL,
                         lastName VARCHAR(25) NOT NULL,
                         dateOfBirth DATE,
                         phoneNumber CHAR(14) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE
);