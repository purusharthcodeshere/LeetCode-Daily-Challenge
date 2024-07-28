# Write your MySQL query statement below

SELECT
    t.request_at AS `Day`,
    ROUND(
        SUM(
            t.status IN (
                'cancelled_by_driver', 'cancelled_by_client'
            )
        ) / COUNT(*), 2
    ) AS 'Cancellation Rate'
FROM
    Trips t
JOIN
    (SELECT
        users_id
    FROM
        Users
    WHERE
        banned = 'No'
    ) AS c ON t.client_id = c.users_id
JOIN
    (SELECT
        users_id
    FROM
        Users
    WHERE
        banned = 'No'
    ) AS d ON t.driver_id = d.users_id
WHERE
    t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY
    t.request_at
ORDER BY
    `Day` ASC,
    'Cancellation Rate' ASC;