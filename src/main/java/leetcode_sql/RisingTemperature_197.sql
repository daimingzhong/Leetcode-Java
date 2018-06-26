/*
Create table If Not Exists Weather (Id int, RecordDate date, Temperature int);
  Truncate table Weather;
insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30');

Given a Weather table, write a SQL query to find all dates' Ids with
higher temperature compared to its previous (yesterday's) dates.

+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
For example, return the following Ids for the above Weather table:

+----+
| Id |
+----+
|  2 |
|  4 |
+----+

互相之间要比较的，一般要inner join。这里从一个队列里找下一个比前一个小的。

for(temp : temperatur) {if ()}

for(int i = 0; i < ; i++) {if ()}

*/

SELECT w2.id FROM Weather AS w1, Weather AS w2 WHERE w1.Temperature < w2.Temperature
AND to_days(w1.RecordDate) - to_days(w2.RecordDate) = -1;