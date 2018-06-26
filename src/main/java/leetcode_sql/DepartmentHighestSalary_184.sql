/*
The Employee table holds all employees. Every employee has an Id, a salary, and
there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments.
For the above tables, Max has the highest salary in the IT department and
Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
  Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');
 */


# where

# CREATE VIEW temp as (
# SELECT d1.name ,max(e1.Salary) AS salary
# from employee e1 join Department d1 where e1.departmentid = d1.id
# GROUP BY d1.Name);
#
# SELECT temp.name AS department, Employee.Name AS Employee, Employee.Salary AS salary
# FROM  Employee JOIN temp WHERE Employee.Salary = temp.salary;



SELECT d1.name AS department, max(e1.Salary) AS salary
from employee e1 join Department d1 where e1.departmentid = d1.id
GROUP BY department;


# 对每一个职业的最大值，做一个salary的筛选。

SELECT dep.Name as Department, emp.Name as Employee, emp.Salary
from Department dep, Employee emp
where emp.DepartmentId = dep.Id and
      emp.Salary = (Select max(Salary) from Employee e2 where e2.DepartmentId=dep.Id)