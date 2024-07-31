# Write your MySQL query statement below

SELECT
    q1.person_name
FROM
    Queue AS q1
JOIN
    Queue AS q2
ON
    q1.turn >= q2.turn
GROUP BY
    q1.turn
HAVING
    SUM(q2.weight) <= 1000
ORDER BY
    SUM(q2.weight) DESC
LIMIT 1;

/*
The goal is to find the last person who can fit on the bus without exceeding the weight limit. We need to consider the order of people based on their turn and calculate the cumulative weight at each turn to check if it exceeds the weight limit.

Approach
We join the Queue table with itself, creating combinations of rows where each row is paired with all rows that have a higher or equal turn value.
We group the rows by turn and calculate the sum of weights for each group.
Using the HAVING clause, we filter out groups whose sum of weights exceeds the weight limit of 1000.
We order the results by the sum of weights in descending order, ensuring the last person who can fit is at the top.
Finally, we limit the result to 1 row since we only need the information of the last person.
Complexity
Time complexity:
The time complexity of this query is dependent on the number of rows in the Queue table. Let's denote this number as 'n'. The join operation has a complexity of O(n^2), as it pairs each row with all the rows that have a higher turn. The grouping operation has a complexity of O(n), as it groups the rows by turn. Finally, ordering the result and limiting it to 1 row have a complexity of O(nlogn). Therefore, the overall time complexity is O(n^2).

Space complexity:
The space complexity is determined by the memory required to store the rows and the intermediate results of the query. In this case, it is proportional to the number of rows in the Queue table, so the space complexity is O(n).
*/