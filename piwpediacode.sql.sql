Microsoft Windows [Version 10.0.22631.3880]
(c) Microsoft Corporation. All rights reserved.

C:\Users\laptop>cmd
Microsoft Windows [Version 10.0.22631.3880]
(c) Microsoft Corporation. All rights reserved.

C:\Users\laptop>cd c:\xampp\mysql\bin

c:\xampp\mysql\bin>mysql -u root -p
Enter password:
ERROR 2002 (HY000): Can't connect to MySQL server on 'localhost' (10061)
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>
c:\xampp\mysql\bin>mysql -u root -p
Enter password:
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 8
Server version: 10.4.32-MariaDB mariadb.org binary distribution

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| db_praktikum2      |
| information_schema |
| mysql              |
| orderentry         |
| performance_schema |
| phpmyadmin         |
| piwpedia           |
| test               |
+--------------------+
8 rows in set (0.009 sec)

MariaDB [(none)]> USE piwdepia;
ERROR 1049 (42000): Unknown database 'piwdepia'
MariaDB [(none)]> USE piwpedia;
Database changed
MariaDB [piwpedia]> SHOW TABLES;
Empty set (0.001 sec)

MariaDB [piwpedia]> CREATE TABLE USER (
    -> id_user int(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> name_user varchar(20),
    -> email varchar(50),
    -> password varchar(50)
    -> );
Query OK, 0 rows affected (0.016 sec)

MariaDB [piwpedia]> DESCRIBE USER;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| id_user   | int(5)      | NO   | PRI | NULL    | auto_increment |
| name_user | varchar(20) | YES  |     | NULL    |                |
| email     | varchar(50) | YES  |     | NULL    |                |
| password  | varchar(50) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
4 rows in set (0.012 sec)

MariaDB [piwpedia]> C
    -> l
    -> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'C
l' at line 1
MariaDB [piwpedia]> CREATE TABLE Store (
    -> id_store int(10) NOT NULL PRIMARY KEY AUTO_iNCREMENT,
    -> name_store varchar(20)
    -> );
Query OK, 0 rows affected (0.016 sec)

MariaDB [piwpedia]> DESCRIBE store;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id_store   | int(10)     | NO   | PRI | NULL    | auto_increment |
| name_store | varchar(20) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+
2 rows in set (0.011 sec)

MariaDB [piwpedia]> CREATE TABLE Transaction;
ERROR 1113 (42000): A table must have at least 1 column
MariaDB [piwpedia]> CREATE TABLE Transaction (
    -> id_transaction varchar(50) NOT NULL PRIMARY KEY,
    -> id_user int(5) NOT NULL,
    -> date DATE,
    -> FOREIGN KEY (id_user) REFERENCES USER(id_user)
    -> );
ERROR 2006 (HY000): MySQL server has gone away
No connection. Trying to reconnect...
ERROR 2002 (HY000): Can't connect to MySQL server on 'localhost' (10061)
ERROR: Can't connect to the server

unknown [piwpedia]> show databases;
No connection. Trying to reconnect...
Connection id:    8
Current database: piwpedia

+--------------------+
| Database           |
+--------------------+
| db_praktikum2      |
| information_schema |
| mysql              |
| orderentry         |
| performance_schema |
| phpmyadmin         |
| piwpedia           |
| test               |
+--------------------+
8 rows in set (0.002 sec)

MariaDB [piwpedia]> show tables;
+--------------------+
| Tables_in_piwpedia |
+--------------------+
| store              |
| user               |
+--------------------+
2 rows in set (0.001 sec)

MariaDB [piwpedia]> CREATE TABLE Transaction(
    -> id_transaction varchar(12) NOT NULL PRIMARY KEY,
    -> id_user int(5) NOT NULL,
    -> date Date,
    -> FOREIGN KEY (id_user) REFERENCES USER(id_user)
    -> );
Query OK, 0 rows affected (0.018 sec)

MariaDB [piwpedia]> describe transaction;
+----------------+-------------+------+-----+---------+-------+
| Field          | Type        | Null | Key | Default | Extra |
+----------------+-------------+------+-----+---------+-------+
| id_transaction | varchar(12) | NO   | PRI | NULL    |       |
| id_user        | int(5)      | NO   | MUL | NULL    |       |
| date           | date        | YES  |     | NULL    |       |
+----------------+-------------+------+-----+---------+-------+
3 rows in set (0.014 sec)

MariaDB [piwpedia]> CREATE TABLE Item (
    -> id_item char(10) NOT NULL PRIMARY KEY,
    -> id_store int(10) NOT NULL,
    -> name_item varchar(50),
    -> price DECIMAL(10,2) NOT NULL
    -> );
Query OK, 0 rows affected (0.016 sec)

MariaDB [piwpedia]> describe Item;
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| id_item   | char(10)      | NO   | PRI | NULL    |       |
| id_store  | int(10)       | NO   |     | NULL    |       |
| name_item | varchar(50)   | YES  |     | NULL    |       |
| price     | decimal(10,2) | NO   |     | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
4 rows in set (0.012 sec)

MariaDB [piwpedia]> CREATE TABLE DetailTransaction (
    -> id_detail_transaction char(20) NOT NULL PRIMARY KEY,
    -> id_transaction varchar(12) NOT NULL,
    -> id_item char(10) NOT NULL,
    -> quantity int SMALLINT UNSIGNED NOT NUll
    -> );
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'SMALLINT UNSIGNED NOT NUll
)' at line 5
MariaDB [piwpedia]> CREATE TABLE DetailTransaction (
    -> id_detail_transaction char(20) NOT NULL PRIMARY KEY,
    -> id_transaction varchar(12) NOT NULL,
    -> id_item char(10) NOT NULL,
    -> quantity SMALLINT UNSIGNED NOT NULL,
    -> FOREIGN KEY id_transaction REFERENCES Transaction(id_transaction),
    -> FOREIGN KEY id_item REFERENCES Item(id_item)
    -> );
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'REFERENCES Transaction(id_transaction),
FOREIGN KEY id_item REFERENCES Item(i...' at line 6
MariaDB [piwpedia]> ALTER TABLE Item
    -> ADD CONSTRAINT fk_store
    -> FOREIGN KEY (id_store) REFERENCES Store(id_store);
Query OK, 0 rows affected (0.051 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [piwpedia]> describe item;
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| id_item   | char(10)      | NO   | PRI | NULL    |       |
| id_store  | int(10)       | NO   | MUL | NULL    |       |
| name_item | varchar(50)   | YES  |     | NULL    |       |
| price     | decimal(10,2) | NO   |     | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
4 rows in set (0.012 sec)

MariaDB [piwpedia]> create table Detail_Transaction(
    -> id_detail_transaction char(20) NOT NULL PRIMARY KEY,
    -> id_transaction varchar(12) NOT NULL,
    -> id_item char(10) NOT NULL,
    -> quantity SMALLINT UNSIGNED NOT NULL
    -> );
Query OK, 0 rows affected (0.016 sec)

MariaDB [piwpedia]> Alter Table
    -> ADD CONSTRAINT fk_store
    -> FOREIGN KEY (id
    -> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'ADD CONSTRAINT fk_store
FOREIGN KEY (id' at line 2
MariaDB [piwpedia]> ALTER TABLE Detail_Transaction(
    -> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near '(' at line 1
MariaDB [piwpedia]> ALTER TABLE Detail_Transcation
    -> ADD CONSTRAINT fk_store
    -> FOREIGN KEY (id_transaction) REFERENCES Transaction(id_transaction)
    -> FOREIGN KEY (id_item) REFERENCES Item(id_item);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FOREIGN KEY (id_item) REFERENCES Item(id_item)' at line 4
MariaDB [piwpedia]> ALTER TABLE DetailTransaction
    -> ADD CONSTRAINT fk_transaction
    -> FOERIGN KEY (id_transaction) REFERENCES Transaction(id_transaction);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FOERIGN KEY (id_transaction) REFERENCES Transaction(id_transaction)' at line 3
MariaDB [piwpedia]> ALTER TABLE DetailTransaction
    -> ADD CONSTRAINT fk_transaction
    -> FOREIGN KEY (id_transaction) REFERENCES Transaction(id_transaction);
ERROR 1146 (42S02): Table 'piwpedia.detailtransaction' doesn't exist
MariaDB [piwpedia]> FOREIGN KEY (id_transaction) REFERENCES Transaction(id_transaction); ALTER TABLE Detail_Transaction
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FOREIGN KEY (id_transaction) REFERENCES Transaction(id_transaction)' at line 1
    -> ;
Query OK, 0 rows affected (0.001 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [piwpedia]> ALTER TABLE Detail_Transaction
    -> ADD CONSTRAINT fk_transaction
    -> FOREIGN KEY (id_transaction) REFERENCES Transaction(id_transaction);
Query OK, 0 rows affected (0.041 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [piwpedia]> ALTER TABLE DETAIL_TRANSACTION
    -> ADD CONSTARINT fk_item
    -> FOREIGN KEY (id_item) REFERENCES Item(id_item);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FOREIGN KEY (id_item) REFERENCES Item(id_item)' at line 3
MariaDB [piwpedia]> ALTER TABLE Detail_Transaction
    -> ADD CONSTRAINTS fk_item
    -> FOREIGN KEY (id_item) REFERENCES Item(id_item);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FOREIGN KEY (id_item) REFERENCES Item(id_item)' at line 3
MariaDB [piwpedia]> ALTER TABLE Detail_Transaction
    -> ADD CONSTRAINT fk_item
    -> FOREIGN KEY (id_item) REFERENCES Item(id_item);
Query OK, 0 rows affected (0.053 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [piwpedia]> describe detail_transaction;
+-----------------------+----------------------+------+-----+---------+-------+
| Field                 | Type                 | Null | Key | Default | Extra |
+-----------------------+----------------------+------+-----+---------+-------+
| id_detail_transaction | char(20)             | NO   | PRI | NULL    |       |
| id_transaction        | varchar(12)          | NO   | MUL | NULL    |       |
| id_item               | char(10)             | NO   | MUL | NULL    |       |
| quantity              | smallint(5) unsigned | NO   |     | NULL    |       |
+-----------------------+----------------------+------+-----+---------+-------+
4 rows in set (0.012 sec)

MariaDB [piwpedia]> show tables;
+--------------------+
| Tables_in_piwpedia |
+--------------------+
| detail_transaction |
| item               |
| store              |
| transaction        |
| user               |
+--------------------+
5 rows in set (0.001 sec)

MariaDB [piwpedia]> show store;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'store' at line 1
MariaDB [piwpedia]> describe store;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id_store   | int(10)     | NO   | PRI | NULL    | auto_increment |
| name_store | varchar(20) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+
2 rows in set (0.012 sec)

MariaDB [piwpedia]> describe item;
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| id_item   | char(10)      | NO   | PRI | NULL    |       |
| id_store  | int(10)       | NO   | MUL | NULL    |       |
| name_item | varchar(50)   | YES  |     | NULL    |       |
| price     | decimal(10,2) | NO   |     | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
4 rows in set (0.011 sec)

MariaDB [piwpedia]> ALTER TABLE item
    -> MODIFY name_item varchar(50) NOT NULL;
Query OK, 0 rows affected (0.032 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [piwpedia]> describe item;
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| id_item   | char(10)      | NO   | PRI | NULL    |       |
| id_store  | int(10)       | NO   | MUL | NULL    |       |
| name_item | varchar(50)   | NO   |     | NULL    |       |
| price     | decimal(10,2) | NO   |     | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
4 rows in set (0.011 sec)

MariaDB [piwpedia]> show tables;
+--------------------+
| Tables_in_piwpedia |
+--------------------+
| detail_transaction |
| item               |
| store              |
| transaction        |
| user               |
+--------------------+
5 rows in set (0.001 sec)

MariaDB [piwpedia]> describe detail_transaction;
+-----------------------+----------------------+------+-----+---------+-------+
| Field                 | Type                 | Null | Key | Default | Extra |
+-----------------------+----------------------+------+-----+---------+-------+
| id_detail_transaction | char(20)             | NO   | PRI | NULL    |       |
| id_transaction        | varchar(12)          | NO   | MUL | NULL    |       |
| id_item               | char(10)             | NO   | MUL | NULL    |       |
| quantity              | smallint(5) unsigned | NO   |     | NULL    |       |
+-----------------------+----------------------+------+-----+---------+-------+
4 rows in set (0.011 sec)

MariaDB [piwpedia]> describe item;
+-----------+---------------+------+-----+---------+-------+
| Field     | Type          | Null | Key | Default | Extra |
+-----------+---------------+------+-----+---------+-------+
| id_item   | char(10)      | NO   | PRI | NULL    |       |
| id_store  | int(10)       | NO   | MUL | NULL    |       |
| name_item | varchar(50)   | NO   |     | NULL    |       |
| price     | decimal(10,2) | NO   |     | NULL    |       |
+-----------+---------------+------+-----+---------+-------+
4 rows in set (0.011 sec)

MariaDB [piwpedia]> describe store;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id_store   | int(10)     | NO   | PRI | NULL    | auto_increment |
| name_store | varchar(20) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+
2 rows in set (0.011 sec)

MariaDB [piwpedia]> describe transaction;
+----------------+-------------+------+-----+---------+-------+
| Field          | Type        | Null | Key | Default | Extra |
+----------------+-------------+------+-----+---------+-------+
| id_transaction | varchar(12) | NO   | PRI | NULL    |       |
| id_user        | int(5)      | NO   | MUL | NULL    |       |
| date           | date        | YES  |     | NULL    |       |
+----------------+-------------+------+-----+---------+-------+
3 rows in set (0.060 sec)

MariaDB [piwpedia]> describe user;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| id_user   | int(5)      | NO   | PRI | NULL    | auto_increment |
| name_user | varchar(20) | YES  |     | NULL    |                |
| email     | varchar(50) | YES  |     | NULL    |                |
| password  | varchar(50) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
4 rows in set (0.012 sec)

MariaDB [piwpedia]> describe store;