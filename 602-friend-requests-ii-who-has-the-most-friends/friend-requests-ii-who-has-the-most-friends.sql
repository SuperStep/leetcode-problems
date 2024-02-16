select
requester_id as id,
sum(req) as num
from (
select requester_id, count(1) as req
from RequestAccepted
group by requester_id
union all
select accepter_id, count(1) as req
from RequestAccepted
group by accepter_id
)
group by requester_id
order by num desc
limit 1