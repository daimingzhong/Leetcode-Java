# truncate 
truncate 和 delete 只删除数据不删除表的结构(定义)
drop 语句将删除表的结构被依赖的约束(constrain)、触发器(trigger)、索引(index)；依赖于该表的存储过程/函数将保留,但是变为 invalid 状态

# limit
LIMIT后的第一个参数是输出记录的初始位置，第二个参数偏移量，偏移多少，输出的条目就是多少。
假设有这么一张表名叫ids，只有id一列：（1，2，3...）
SELECT * FROM ids LIMIT 10, 3 // 去掉前10个。
输出：(11, 12, 13)


# offset
SELECT * FROM ids LIMIT 5 OFFSET 2
输出：3 4 5 6 7 前两个不要。

# group by
select xx group by 的返回，必须是可以aggregate的。max()

department name salary
IT	Joe	70000
Sales	Henry	80000
Sales	Sam	60000
IT	Max	90000
这里不能对department直接group by
