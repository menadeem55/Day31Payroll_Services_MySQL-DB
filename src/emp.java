Microsoft Windows [Version 10.0.19045.2486]
(c) Microsoft Corporation. All rights reserved.

C:\Users\menad>mysql -u root -p
Enter password: ********
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 19
Server version: 8.0.31 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| addressbook        |
| addressbookservice |
| cricket            |
| empdb              |
| employeedb         |
| football           |
| hospital           |
| information_schema |
| mysql              |
| payroll_service    |
| performance_schema |
| sys                |
+--------------------+
12 rows in set (0.00 sec)

mysql> use payroll_service;
Database changed
mysql> select database();
+-----------------+
| database()      |
+-----------------+
| payroll_service |
+-----------------+
1 row in set (0.00 sec)

mysql> desc employee_payroll;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int unsigned | NO   | PRI | NULL    | auto_increment |
| name   | varchar(150) | NO   |     | NULL    |                |
| gender | char(1)      | YES  |     | NULL    |                |
| salary | double       | NO   |     | NULL    |                |
| start  | date         | NO   |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
5 rows in set (0.02 sec)

mysql> insert into employee_payroll (name, salary, start) values	# inserting values table
    -> ('Bill', 1000000.88, '2018-01-03' ),
    -> ('Terisa', 2000000.88, '2019-05-13' ),
    -> ('Charlie', 6000000.88, '2020-11-21' );
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from employee_payroll;
+----+---------+--------+------------+------------+
| id | name    | gender | salary     | start      |
+----+---------+--------+------------+------------+
|  1 | Bill    | M      |  450000.55 | 2018-01-03 |
|  2 | Terisa  | F      | 2000000.88 | 2019-05-13 |
|  3 | Charlie | M      | 6000000.88 | 2020-11-21 |
+----+---------+--------+------------+------------+
3 rows in set (0.02 sec)

mysql> select salary from employee_payroll where name = 'Bill';
+-----------+
| salary    |
+-----------+
| 450000.55 |
+-----------+
1 row in set (0.00 sec)

mysql> select * from employee_payroll
    -> where start between cast('2018-01-03' as date)
    -> and date(now());
+----+---------+--------+------------+------------+
| id | name    | gender | salary     | start      |
+----+---------+--------+------------+------------+
|  1 | Bill    | M      |  450000.55 | 2018-01-03 |
|  2 | Terisa  | F      | 2000000.88 | 2019-05-13 |
|  3 | Charlie | M      | 6000000.88 | 2020-11-21 |
+----+---------+--------+------------+------------+
3 rows in set (0.01 sec)

mysql>