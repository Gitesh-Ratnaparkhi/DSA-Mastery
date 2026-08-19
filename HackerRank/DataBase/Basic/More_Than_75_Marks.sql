-- More Thank 75 Marks

-- Link -> https://www.hackerrank.com/challenges/more-than-75-marks/problem

-- Description -> We have to write a query to find the names of students who have marks greater than 75. Order your output in descending order of marks.

-- Query ->
SELECT NAME From STUDENTS
WHERE MARKS > 75
ORDER BY RIGHT(NAME , 3), ID ASC;