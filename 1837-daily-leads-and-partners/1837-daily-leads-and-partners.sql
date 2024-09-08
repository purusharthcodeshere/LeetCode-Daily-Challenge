# Write your MySQL query statement below
/* Write your T-SQL query statement below */
SELECT 
    DATE_ID, 
    MAKE_NAME, 
    COUNT(DISTINCT LEAD_ID) AS UNIQUE_LEADS, 
    COUNT(DISTINCT PARTNER_ID) AS UNIQUE_PARTNERS
FROM 
    DAILYSALES 
GROUP BY 
    DATE_ID, 
    MAKE_NAME