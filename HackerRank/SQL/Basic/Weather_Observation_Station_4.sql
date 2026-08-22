-- Weather Observation Station 4

-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-4/problem

-- Descryption -> We have to find the difference between the number of CITY entries in the table and the number of distinct CITY entries in the table.

-- Query ->
SELECT COUNT(CITY) - COUNT(DISTINCT CITY)
From STATION;