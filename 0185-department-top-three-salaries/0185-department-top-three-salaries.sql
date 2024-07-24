# Write your MySQL query statement below

SELECT
    d.name AS Department,
    emp.name AS Employee,
    emp.salary
FROM (
    SELECT
        employee.*,
        DENSE_RANK() OVER (
            PARTITION BY 
                departmentId 
            ORDER BY
                salary DESC
        ) AS `rank`
    FROM 
        employee
) AS emp
LEFT JOIN
    department AS d
    ON d.id = emp.departmentId
WHERE
    emp.rank <= 3
ORDER BY
    d.name ASC,
    emp.name ASC,
    emp.salary DESC;