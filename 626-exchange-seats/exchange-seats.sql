-- Write your PostgreSQL query statement below
select 
case when id % 2 = 1 and id <> max(id) over ()  then lead(id) over ()
     when id % 2 = 0 then lag(id) over () 
else id end as id, student
from Seat
order by id