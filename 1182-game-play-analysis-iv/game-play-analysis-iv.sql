SELECT ROUND(SUM(CASE
    WHEN a1.event_date = a2.first_login_date + 1 THEN 1
    ELSE 0
END)/CAST(COUNT(DISTINCT(a1.player_id)) AS decimal), 2) as fraction
FROM Activity AS a1 CROSS JOIN (SELECT player_id, MIN(event_date) AS first_login_date
FROM Activity GROUP BY player_id) as a2
WHERE a1.player_id = a2.player_id


-- select round(sum(logged.count) / a.count, 2) as fraction
-- from
-- (select count(distinct a1.player_id) as count
-- from (select player_id, min(event_date) as event_date from Activity group by player_id) as a1
-- inner join 
-- Activity as a2
-- on a1.player_id = a2.player_id
-- and a2.event_date - a1.event_date = 1
-- ) as logged
-- left join 
-- (select count(distinct player_id) as count from Activity) as a
-- on true
-- group by a.count

-- select a1.player_id, a1.event_date, a2.event_date
-- from (select player_id, min(event_date) as event_date from Activity group by player_id) as a1
-- inner join 
-- Activity as a2
-- on a1.player_id = a2.player_id
-- and a2.event_date - a1.event_date = 1
-- order by a1.player_id
