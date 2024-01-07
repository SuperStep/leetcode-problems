-- Write your PostgreSQL query statement below
select name from (
select e1.name name, e1.id, sum(1) 
from Employee e1
left join Employee e2
on e1.id = e2.managerId
group by e1.id, e1.name 
) where sum >= 5