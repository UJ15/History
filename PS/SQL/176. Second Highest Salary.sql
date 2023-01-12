--https://leetcode.com/problems/second-highest-salary/description/
--서브쿼리를 사용해서 데이터가 없을때 빈 테이블을 반환하도록

SELECT (SELECT DISTINCT salary
        FROM employee
        ORDER BY salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary