-- Write your PostgreSQL query statement below

select t.user_id, ROUND(coalesce(CAST(t.confirmed as decimal) / t.all, 0), 2) as confirmation_rate from (
select s.user_id, 
sum(case when c.action = 'confirmed' then 1 end) as confirmed,
sum(1) as all
from Signups s
left join Confirmations c
on s.user_id = c.user_id
group by s.user_id
) t