-- Write your PostgreSQL query statement below
select max(counts.num) as num
from
(
select num, count(*) as count
from MyNumbers
group by num
having count(*) = 1
) as counts