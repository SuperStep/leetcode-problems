-- Write your PostgreSQL query statement below
with dates as (
    select min(visited_on) as min_date,
    max(visited_on) as max_date
    from Customer
)
select * from (
select 
visited_on,
sum(amount) over (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW ) as amount,
round(avg(amount) over (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW ), 2) as average_amount
from (select sum(amount) as amount, visited_on from Customer group by visited_on)
)
where visited_on between (select min_date from dates) + 6 and (select max_date from dates)