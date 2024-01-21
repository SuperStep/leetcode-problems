with Q as (
    select query_name, count(1) as count from Queries group by query_name
)

SELECT 
    Queries.query_name,
    ROUND(AVG(CAST(rating AS DECIMAL) / position), 2) AS quality,
    ROUND(sum(case when rating < 3 then 1 else 0 end)/CAST(Q.count as Decimal) * 100, 2) AS poor_query_percentage
FROM Queries
left join Q
on Q.query_name = Queries.query_name
 where Queries.query_name is not null
GROUP BY Queries.query_name, Q.count



