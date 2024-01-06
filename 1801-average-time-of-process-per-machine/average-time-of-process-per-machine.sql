# Write your MySQL query statement below
SELECT t.machine_id, ROUND(AVG(t.processing_time), 3) as processing_time from (
SELECT machine_id, process_id, COUNT(activity_type), MAX(timestamp) - MIN(timestamp) as processing_time 
FROM Activity
group by machine_id, process_id
) as t
GROUP BY t.machine_id
