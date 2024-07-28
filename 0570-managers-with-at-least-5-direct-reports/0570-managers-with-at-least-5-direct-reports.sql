# Write your MySQL query statement below

SELECT 
    e.name AS 'name'
FROM
    Employee AS e
INNER JOIN
    Employee AS m
ON
    e.id = m.managerId
GROUP BY
    m.managerId
HAVING
    COUNT(m.managerId) >= 5
ORDER BY
    e.name ASC;
