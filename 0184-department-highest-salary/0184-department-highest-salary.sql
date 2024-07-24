# Write your MySQL query statement below

SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM
    Employee AS e
JOIN
    Department AS d
ON
    e.departmentId = d.id
WHERE (
    e.departmentId, salary
) IN (
    SELECT 
        e1.departmentId, 
        MAX(e1.salary)
    FROM
        Employee e1
    GROUP BY
        e1.departmentId
    )
ORDER BY
    d.name ASC,
    e.name ASC,
    e.salary DESC;