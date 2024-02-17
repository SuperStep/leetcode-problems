select lead(salary) over (order by salary desc) as SecondHighestSalary
from (select distinct salary from Employee order by salary desc limit 2) 
order by salary desc
limit 1