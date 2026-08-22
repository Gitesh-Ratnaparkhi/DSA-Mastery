-- Revising Aggregations - Averages
-- Link -> https://www.hackerrank.com/challenges/revising-aggregations-averages/problem
-- Description -> Query the average population of all cities in CITY where District is California.
-- Query ->
SELECT AVG(population) FROM CITY
WHERE District = 'California';