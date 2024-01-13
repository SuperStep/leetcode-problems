-- Write your PostgreSQL query statement below
select p.product_id ,
COALESCE(ROUND(CAST(SUM(s.units * p.price) as Decimal) / SUM(s.units), 2), 0) as average_price
from Prices as p
left join UnitsSold as s
on s.product_id = p.product_id
and s.purchase_date between p.start_date and p.end_date
group by p.product_id