# Write your MySQL query statement below
select t.name, t.bonus
from (
select 
e.name,
b.bonus
from Employee as e
left join Bonus as b
on e.empId = b.empId
) t
where t.bonus < 1000 or t.bonus is null