select case when c.accounts_count is null then 0 else c.accounts_count end as accounts_count, 
t.category
from (select
case when income < 20000 then 'Low Salary' 
when 20000 <= income and income <= 50000 then 'Average Salary'
when income > 50000 then 'High Salary' end as category,
count(account_id) as accounts_count 
from Accounts
group by category ) as c
right join (select * 
    from 
    (VALUES (0, 'High Salary'), (0,'Low Salary'), (0,'Average Salary')) 
    AS t (count, category)) as t
on c.category = t.category
