with minYear as 
    (select product_id, MIN(year) as year
    from Sales
    group by product_id)
select s.product_id,  s.year as first_year, s.quantity, s.price
from Sales s  
inner join minYear
on minYear.product_id = s.product_id
and minYear.year = s.year