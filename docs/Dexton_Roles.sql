create table Roles
(
    ID   int auto_increment
        primary key,
    NAME varchar(256) not null
);

INSERT INTO Dexton.Roles (ID, NAME) VALUES (1, 'user');
INSERT INTO Dexton.Roles (ID, NAME) VALUES (2, 'client');
INSERT INTO Dexton.Roles (ID, NAME) VALUES (100, 'admin');