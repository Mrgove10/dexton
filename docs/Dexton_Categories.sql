create table Categories
(
    ID   int auto_increment
        primary key,
    NAME varchar(256) null
);

INSERT INTO Dexton.Categories (ID, NAME) VALUES (1, 'Laptops');
INSERT INTO Dexton.Categories (ID, NAME) VALUES (2, 'Smartphones');
INSERT INTO Dexton.Categories (ID, NAME) VALUES (3, 'Cameras');
INSERT INTO Dexton.Categories (ID, NAME) VALUES (4, 'Accessories');