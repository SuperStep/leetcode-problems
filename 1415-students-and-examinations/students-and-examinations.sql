# Write your MySQL query statement below
select t.*, sum(case when e.subject_name is null then 0 else 1 end) as attended_exams from (
select s.student_id, s.student_name, sb.subject_name
from Students s
inner join Subjects sb
on true ) t
left join Examinations e
on e.student_id = t.student_id
and e.subject_name = t.subject_name
GROUP BY t.student_id, t.student_name, t.subject_name
order by s.student_id, sb.subject_name