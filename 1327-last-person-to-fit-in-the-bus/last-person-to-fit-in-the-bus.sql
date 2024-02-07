select p.name as person_name
from 
(
    select q.person_id as person_id, q.turn as turn, 
    sum ( q.weight ) over ( 
         order by q.turn 
         rows unbounded preceding 
       ) prev_w 
    
from Queue as q
order by q.turn
) as q
left join (select distinct  person_id, person_name as name from Queue) as p
on q.person_id = p.person_id
group by q.person_id, q.turn, p.name
having max(q.prev_w) <= 1000
order by q.turn desc 
limit 1