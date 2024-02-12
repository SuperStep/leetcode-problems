select results 
from(
select name as results
from (
select u.name as name, count(*) as count
from MovieRating
left join Users u
on u.user_id = MovieRating.user_id
group by u.name
) as rating
order by rating.count desc, rating.name
limit 1)


UNION all

select results from(
select rating.movie as results
from(
select m.title as movie, avg(rating) as rating
from MovieRating
left join Movies m
on m.movie_id = MovieRating.movie_id
where created_at between '2020-02-01' and '2020-02-29'
group by m.title
) as rating
order by rating desc, rating.movie
limit 1)

-- select u.name as name, count(*) as count
-- from MovieRating
-- left join Users u
-- on u.user_id = MovieRating.user_id
-- group by u.name
-- order by count desc, u.name