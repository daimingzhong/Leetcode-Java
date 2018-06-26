/*

Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+


 */

# 为什么这个屌不行。这个要生成view？？？？
SELECT p1.Id id, p1.Email email
FROM Person p1 JOIN Person p2
WHERE p1.Id < p2.Id AND p1.Email != p2.Email;


SELECT DISTINCT p2.Email
FROM Person p2;

# 生成一个新表，并在里面delete
DELETE p1
FROM Person p1, Person p2
WHERE p1.email = p2.email AND p1.Id > p2.Id;