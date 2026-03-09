CREATE OR REPLACE FUNCTION NthHighestSalary(N int)
RETURNS TABLE (Salary int) AS $$
BEGIN
  IF N IS NULL OR N <= 0 THEN
    RETURN;  -- no rows
  END IF;

  RETURN QUERY
  SELECT DISTINCT e.salary
  FROM Employee e
  ORDER BY e.salary DESC
  LIMIT 1 OFFSET N - 1;
END;
$$ LANGUAGE plpgsql;
