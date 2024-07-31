# Write your MySQL query statement below

SELECT id, 
	SUM(CASE WHEN MONTH = 'jan' THEN revenue ELSE NULL end) AS Jan_Revenue,
	SUM(CASE WHEN MONTH = 'feb' THEN revenue ELSE NULL end) AS Feb_Revenue,
	SUM(CASE WHEN MONTH = 'mar' THEN revenue ELSE NULL end) AS Mar_Revenue,
	SUM(CASE WHEN MONTH = 'apr' THEN revenue ELSE NULL end) AS Apr_Revenue,
	SUM(CASE WHEN MONTH = 'may' THEN revenue ELSE NULL end) AS May_Revenue,
	SUM(CASE WHEN MONTH = 'jun' THEN revenue ELSE NULL end) AS Jun_Revenue,
	SUM(CASE WHEN MONTH = 'jul' THEN revenue ELSE NULL end) AS Jul_Revenue,
	SUM(CASE WHEN MONTH = 'aug' THEN revenue ELSE NULL end) AS Aug_Revenue,
	SUM(CASE WHEN MONTH = 'sep' THEN revenue ELSE NULL end) AS Sep_Revenue,
	SUM(CASE WHEN MONTH = 'oct' THEN revenue ELSE NULL end) AS Oct_Revenue,
	SUM(CASE WHEN MONTH = 'nov' THEN revenue ELSE NULL end) AS Nov_Revenue,
	SUM(CASE WHEN MONTH = 'dec' THEN revenue ELSE NULL end) AS Dec_Revenue
FROM 
    department
GROUP BY
    id
ORDER BY
    id ASC;