-- Weather Observation Station 11
-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-11/problem
-- Descryption -> 
-- Query ->
SELECT DISTINCT(CITY) FROM STATION
WHERE LOWER(LEFT(CITY,1)) NOT IN ('a', 'e', 'i', 'o', 'u')
OR LOWER(RIGHT(CITY,1)) NOT IN ('a', 'e', 'i', 'o', 'u');