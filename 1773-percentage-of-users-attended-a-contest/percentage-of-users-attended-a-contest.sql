-- Write your PostgreSQL query statement below
with AllUsers as (select count(distinct user_id) as count from Users) 

select c.contest_id, round(cast(c.user_count as decimal) / u.count * 100 , 2) as percentage
from(
select contest_id , count(distinct user_id) as user_count
from Register
group by contest_id
) as c
left join AllUsers u
on true
order by percentage desc, contest_id asc