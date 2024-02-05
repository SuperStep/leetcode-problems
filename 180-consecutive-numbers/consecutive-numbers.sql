select distinct t.num as ConsecutiveNums
from
(
select id, lag(num) over (order by id) as prev, num, lead(num) over (order by id) as next
from Logs
order by id
) as t
where prev = num and num = next