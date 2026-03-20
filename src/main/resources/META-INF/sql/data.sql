INSERT INTO Persons (personId,  firstName,  lastName, dateOfBirth, phoneNumber,  email)
VALUES (1, 'Vadym', 'Ivchencko', '2001-05-12', '38002345551', 'vadym@i.ua');
INSERT INTO Persons (personId,  firstName,  lastName, dateOfBirth, phoneNumber,  email)
VALUES (2, 'Anna', 'Kovalenko', '1995-08-23', '380067123456', 'anna.kovalenko@gmail.com');
INSERT INTO Persons (personId,  firstName,  lastName, dateOfBirth, phoneNumber,  email)
VALUES (3, 'Dmytro', 'Shevchenko', '1988-11-15', '380050987654', 'dmytro.shevchenko@ukr.net');
INSERT INTO Persons (personId,  firstName,  lastName, dateOfBirth, phoneNumber,  email)
VALUES(4, 'Olena', 'Bondarenko', '1992-03-30', '380063112233', 'olena.bondarenko@mail.com');
INSERT INTO Persons (personId,  firstName,  lastName, dateOfBirth, phoneNumber,  email)
VALUES (5, 'Serhiy', 'Petrenko', '1979-07-09', '380099445566', 'serhiy.petrenko@i.ua');
INSERT INTO Persons (personId,  firstName,  lastName, dateOfBirth, phoneNumber,  email)
VALUES(6, 'Iryna', 'Tkachenko', '2000-12-01', '380073778899', 'iryna.tkachenko@gmail.com');

INSERT INTO CoverageItems ( coverageName, coverageDescription,  coverage_limit, premium, active)
VALUES (  'PD', 'Property damage', 10000, 20, true),
       ( 'BI', 'Body Injury', 15000, 30, true),

       ( 'TI', 'Trip Interruption', 15000, 10, true),

       ( 'TS', 'Towing and Storage', 8000, 15, false),

       ( 'MP', 'Medical payments', 25000, 40, true),

       ( 'PD', 'Property damage', 15000, 18, true);