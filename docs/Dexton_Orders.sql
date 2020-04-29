create table Orders
(
    ID     int auto_increment
        primary key,
    USER   int         null,
    STATUS varchar(32) null,
    constraint Orders_Users_ID_fk
        foreign key (USER) references Users (ID)
);

INSERT INTO Dexton.Orders (ID, USER, STATUS) VALUES (1, 1, 'Payed');
INSERT INTO Dexton.Orders (ID, USER, STATUS) VALUES (2, 7, 'Shipped');