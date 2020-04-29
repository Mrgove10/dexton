create table Products
(
    ID          int auto_increment
        primary key,
    NAME        varchar(256)   null,
    PRICE       float          null,
    DESCRIPTION varchar(10000) null,
    BRAND       varchar(256)   not null,
    CATEGORY    int            null,
    RATING      float          null,
    ADDDATE     date           null,
    constraint Products_Categories_ID_fk
        foreign key (CATEGORY) references Categories (ID)
);

create index Products_Brands_ID_fk
    on Products (BRAND);

INSERT INTO Dexton.Products (ID, NAME, PRICE, DESCRIPTION, BRAND, CATEGORY, RATING, ADDDATE) VALUES (1, 'Super PCP 2000', 1000, 'Super PCP 2000 est LE Ortinator ULTIME de jeux', 'Amazon Basics', 1, 5, '2020-03-05');
INSERT INTO Dexton.Products (ID, NAME, PRICE, DESCRIPTION, BRAND, CATEGORY, RATING, ADDDATE) VALUES (2, 'iPomme 5G', 85, 'Le mobile du moment', 'Pomme', 2, 3, '2020-03-01');
INSERT INTO Dexton.Products (ID, NAME, PRICE, DESCRIPTION, BRAND, CATEGORY, RATING, ADDDATE) VALUES (3, 'Lorem Gen', 1564450, 'Lorem Generator for all your needs', 'Ipsum', 4, 1, '2020-01-14');
INSERT INTO Dexton.Products (ID, NAME, PRICE, DESCRIPTION, BRAND, CATEGORY, RATING, ADDDATE) VALUES (5, 'Product1', 1500, 'Test', 'Pomme', 2, 2, '2020-03-05');
INSERT INTO Dexton.Products (ID, NAME, PRICE, DESCRIPTION, BRAND, CATEGORY, RATING, ADDDATE) VALUES (6, 'Product2', 2000, 'Test', 'Ipsum', 1, 4.9, '2020-03-02');