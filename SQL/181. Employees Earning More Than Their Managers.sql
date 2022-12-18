--https://leetcode.com/problems/employees-earning-more-than-their-managers/description/

SELECT a.name AS Employee
FROM employee a, employee b
WHERE a.managerId = b.id AND a.salary > b.salary