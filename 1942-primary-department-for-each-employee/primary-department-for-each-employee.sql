
select * from 
(
select e1.employee_id, case when e1.department_id is null then e2.department_id else e1.department_id end as department_id
from
(
SELECT employee_id, MAX(CASE WHEN primary_flag = 'Y' THEN department_id END) AS department_id
FROM Employee
GROUP BY employee_id
) as e1
left join 
(
    select employee_id, max(department_id) as department_id
    from Employee 
    where primary_flag = 'N' 
    group by employee_id 
    having count(department_id) = 1
) as e2
on e1.employee_id = e2.employee_id
and e1.department_id is null
) as t
where t.department_id is not null