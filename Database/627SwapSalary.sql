# Write your MySQL query statement below
update Salary
set sex = CASE
    WHEN sex = 'm' THEN 'f'
    ELSE 'm'
    END;