create table Users
(
    ID        int auto_increment
        primary key,
    ROLE      int default 2  null,
    EMAIL     varchar(256)   null,
    LASTNAME  varchar(256)   null,
    FIRSTNAME varchar(256)   null,
    PASSWORD  varchar(10000) not null,
    constraint Users_Roles_ID_fk
        foreign key (ROLE) references Roles (ID)
);

INSERT INTO Dexton.Users (ID, ROLE, EMAIL, LASTNAME, FIRSTNAME, PASSWORD) VALUES (1, 2, 'edouardclisson@gmail.com', 'CLISSON', 'Edouard', '123456');
INSERT INTO Dexton.Users (ID, ROLE, EMAIL, LASTNAME, FIRSTNAME, PASSWORD) VALUES (7, 2, 'azer@azer.azer', 'azer', 'azer', 'azer');
INSERT INTO Dexton.Users (ID, ROLE, EMAIL, LASTNAME, FIRSTNAME, PASSWORD) VALUES (8, 2, 'richardadrien0@gmail.com', 'Richard', 'Adrien', '123456');