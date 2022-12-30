--https://leetcode.com/problems/duplicate-emails/description/

SELECT email AS Email FROM person
GROUP BY email
HAVING count(email) > 1