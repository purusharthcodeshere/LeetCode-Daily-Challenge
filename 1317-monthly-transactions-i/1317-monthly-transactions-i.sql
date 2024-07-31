# Write your MySQL query statement below

SELECT
    LEFT(trans_date, 7) AS `month`,
    country,
    COUNT(id) AS trans_count,
    SUM(state = 'approved') AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM((state = 'approved') * amount) AS approved_total_amount
FROM
    Transactions
GROUP BY
    month,
    country
ORDER BY
    `month` ASC;

-- Approach
-- Extract Month and Year:
-- Use the LEFT function to get the YYYY-MM part from the trans_date. The LEFT() function extracts a number of characters from a string (starting from left).

-- Group By Month and Country:
-- Group the transactions by the extracted month and country.

-- Count Transactions:
-- Use COUNT(id) to count all transactions per group.

-- Count Approved Transactions:
-- Use SUM(state = 'approved') to count approved transactions, leveraging the fact that boolean expressions return 1 for true and 0 for false.

-- Sum Total Amounts:
-- Use SUM(amount) to sum the transaction amounts for all transactions per group.

-- Sum Approved Amounts:
-- Use SUM((state = 'approved') * amount) to sum the transaction amounts for approved transactions, ensuring only approved amounts are summed.