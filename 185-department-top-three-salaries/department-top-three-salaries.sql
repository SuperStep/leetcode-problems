WITH RankedSalaries AS (
    SELECT e.id AS employee_id,
           e.name AS employee,
           e.salary,
           d.name AS department,
           DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS salary_rank
      FROM Employee e
           JOIN Department d ON e.departmentId = d.id
)
SELECT department, employee, salary
  FROM RankedSalaries
 WHERE salary_rank <= 3;

    -- SELECT e.id AS employee_id,
    --        e.salary,
    --        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS salary_rank
    --   FROM Employee e