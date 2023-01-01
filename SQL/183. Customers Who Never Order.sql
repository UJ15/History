--https://leetcode.com/problems/customers-who-never-order/description/

SELECT name AS 'Customers'
FROM customers c
LEFT JOIN orders o ON c.id = o.customerId
WHERE o.customerId IS NULL
