-- Placements
-- Link -> https://www.hackerrank.com/challenges/placements/problem
-- Descryption -> We have a table of students and their friends. Write a query to print the name of the student whose friend got the highest salary.
-- Query -> 
SELECT s.Name
FROM Students s
    JOIN Friends f ON s.ID = f.ID
    JOIN Packages p1 ON s.ID = p1.ID
    JOIN Packages p2 ON f.Friend_ID = p2.ID
WHERE p2.Salary > p1.Salary
ORDER BY p2.Salary;