-- Write your PostgreSQL query statement below
WITH StudentSubjects AS (
    SELECT
        s.student_id,
        sub.subject_name,
        COALESCE(COUNT(e.subject_name), 0) as attended_exams
    FROM Students s
    CROSS JOIN Subjects sub
    LEFT JOIN Examinations e ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
    GROUP BY s.student_id, sub.subject_name
)

SELECT
    ss.student_id,
    s.student_name,
    ss.subject_name,
    ss.attended_exams
FROM StudentSubjects ss
JOIN Students s ON ss.student_id = s.student_id
ORDER BY ss.student_id, ss.subject_name;