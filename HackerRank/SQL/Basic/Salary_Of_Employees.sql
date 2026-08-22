-- Salary Of Employees

-- Link -> https://www.hackerrank.com/challenges/salary-of-employees/problem

-- Descryption -> We have to write a query to print the name of employees who earn more than 2000 per month and who have been employed for less than 10 months. Sort your result by ascending employee_id.

-- Query ->
SELECT Name From Employee
WHERE Salary > 2000 
AND Months < 10 
ORDER BY Employee_id ASC;