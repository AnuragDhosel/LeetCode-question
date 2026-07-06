# Write your MySQL query statement below

-- in the output , we need to find all student and their respective subject, and all students with all subject must be available in output even student is apsent in that exam 
-- that's why we use cross join


SELECT
    s.student_id,
    s.student_name,
    sub.subject_name,
    COUNT(e.subject_name) AS attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
ON s.student_id = e.student_id
AND e.subject_name = sub.subject_name
GROUP BY
    s.student_id,
    s.student_name,
    sub.subject_name
ORDER BY
    s.student_id,
    s.student_name;