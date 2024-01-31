with stat as (select reports_to as employee_id, 
count(*) as reports_count, 
ROUND(avg(age),0) as average_age
from Employees
where reports_to is not null
group by reports_to)
select stat.employee_id, emp.name, stat.reports_count, stat.average_age
from stat
left join Employees emp
on emp.employee_id = stat.employee_id
order by stat.employee_id