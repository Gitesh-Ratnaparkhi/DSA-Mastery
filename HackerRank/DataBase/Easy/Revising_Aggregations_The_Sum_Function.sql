-- Revising Aggregations - The Sum Function
-- Link -> https://www.hackerrank.com/challenges/revising-aggregations-sum/problem
-- Description -> Sum of population where District is California
-- Query ->
SELECT SUM(population)
FROM CITY
WHERE DISTRICT = 'california';