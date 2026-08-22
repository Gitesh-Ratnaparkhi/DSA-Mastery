-- Weather Observation Station 6

-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-6/problem

-- Descryption -> Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.

-- Query ->
SELECT DISTINCT(CITY)
FROM STATION
WHERE LOWER(LEFT(CITY, 1)) IN ('a', 'e', 'i', 'o', 'u');
