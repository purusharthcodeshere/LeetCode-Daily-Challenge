# Write your MySQL query statement below

WITH StudentSubjects AS (
    SELECT
        st.student_id,
        st.student_name,
        sub.subject_name
    FROM
        Students AS st
    CROSS JOIN
        Subjects AS sub
)

SELECT
    ss.student_id,
    ss.student_name,
    ss.subject_name,
    IFNULL(COUNT(e.student_id), 0) AS attended_exams
FROM
    StudentSubjects AS ss
LEFT JOIN
    Examinations AS e
ON
    ss.student_id = e.student_id AND
    ss.subject_name = e.subject_name
GROUP BY
    ss.student_id,
    ss.student_name,
    ss.subject_name
ORDER BY
    ss.student_id ASC,
    ss.subject_name ASC;

