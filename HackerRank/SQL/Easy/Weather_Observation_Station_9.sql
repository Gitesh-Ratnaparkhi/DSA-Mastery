-- Weather Observation Station 9


-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-9/problem

-- Descryption -> Query the list of CITY names are not starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.

-- Query ->
SELECT DISTINCT CITY FROM STATION
WHERE LOWER(LEFT(CITY, 1)) NOT IN ('a', 'e', 'i', 'o', 'u');
