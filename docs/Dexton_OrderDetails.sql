create table OrderDetails
(
    `ORDER`  int null,
    PRODUCT  int null,
    QUANTITY int null,
    ID       int auto_increment
        primary key,
    constraint OrderDetails_Orders_ID_fk
        foreign key (`ORDER`) references Orders (ID),
    constraint OrderDetails_Products_ID_fk
        foreign key (PRODUCT) references Products (ID)
);

INSERT INTO Dexton.OrderDetails (`ORDER`, PRODUCT, QUANTITY, ID) VALUES (1, 1, 2, 1);
INSERT INTO Dexton.OrderDetails (`ORDER`, PRODUCT, QUANTITY, ID) VALUES (2, 2, 3, 2);
INSERT INTO Dexton.OrderDetails (`ORDER`, PRODUCT, QUANTITY, ID) VALUES (1, 3, 2, 3);
INSERT INTO Dexton.OrderDetails (`ORDER`, PRODUCT, QUANTITY, ID) VALUES (1, 2, 6, 4);