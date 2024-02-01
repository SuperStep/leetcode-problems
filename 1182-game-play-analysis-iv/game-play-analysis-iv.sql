
select round(sum(logged.count) / a.count, 2) as fraction
from
(select count(distinct a1.player_id) as count
from (select player_id, min(event_date) as event_date from Activity group by player_id) as a1
inner join 
Activity as a2
on a1.player_id = a2.player_id
and a2.event_date - a1.event_date = 1
) as logged
left join 
(select count(distinct player_id) as count from Activity) as a
on true
group by a.count

-- select a1.player_id, a1.event_date, a2.event_date
-- from (select player_id, min(event_date) as event_date from Activity group by player_id) as a1
-- inner join 
-- Activity as a2
-- on a1.player_id = a2.player_id
-- and a2.event_date - a1.event_date = 1
-- order by a1.player_id
