-- Write your PostgreSQL query statement below
select x, y, z , case when x > abs(y - z) and x < y + z then 'Yes' else 'No' end as triangle
from Triangle

