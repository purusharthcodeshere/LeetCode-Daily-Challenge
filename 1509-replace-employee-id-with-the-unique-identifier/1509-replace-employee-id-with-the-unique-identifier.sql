# Write your MySQL query statement below

SELECT
    u.unique_id,
    e.name
FROM
    Employees e
LEFT JOIN
    EmployeeUNI u
USING
    (id)
ORDER BY
    name ASC,
    unique_id ASC;