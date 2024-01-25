select round(sum(tt.total), 2) as immediate_percentage
from(
select 
    cast(100 * sum(case when t.d1 = t.d2 then 1 else 0 end) as Decimal)/
    count(*) over() as total
from
(
select customer_id, MIN(order_date) as d1, min(customer_pref_delivery_date) as d2
from Delivery
group by customer_id) as t
group by t.customer_id
) tt