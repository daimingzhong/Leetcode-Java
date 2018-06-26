/*
Create table If Not Exists Employee (Id int, Salary int);
  Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');


For example, given the above Employee table,
the query should return 200 as the second highest salary.
If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

descending

sort -> order by

*/

SELECT DISTINCT salary AS secondhighestsalary FROM Employee ORDER BY Salary desc LIMIT 1 OFFSET 1;

SELECT max(Salary) From Employee WHERE Salary not in (SELECT max(Salary) FROM Employee );


SELECT max(salary) AS secondhighestsalary  FROM Employee WHERE salary < (SELECT max(Salary) FROM Employee);



