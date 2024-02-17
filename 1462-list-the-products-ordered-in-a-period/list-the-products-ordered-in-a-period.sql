-- Write your PostgreSQL query statement below
select p.product_name, s.unit
from
( 
select distinct product_id, sum(unit) unit
from Orders
where order_date between '2020-02-01' and '2020-02-29'
group by product_id
having sum(unit) >= 100
) s
left join Products p
on p.product_id = s.product_id
