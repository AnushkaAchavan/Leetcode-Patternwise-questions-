/* Write your T-SQL query statement below */
SELECT DISTINCT
    contest_id,
    ROUND(
        COUNT(contest_id) * 100.0 / (select count(*) from Users) ,
        2
    ) AS percentage  
FROM REGISTER 
GROUP BY contest_id
ORDER BY percentage DESC,contest_id ASC;

