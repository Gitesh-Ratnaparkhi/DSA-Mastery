-- Weather Observation Station 12
-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-12/problem
-- Descryption -> Query the list of CITY names not starting with vowels (a, e, i, o, u) or ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain duplicates.
-- Query ->
SELECT DISTINCT(CITY)
FROM STATION
WHERE LOWER(LEFT(CITY, 1)) NOT IN ('a', 'e', 'i', 'o', 'u')
    AND LOWER(RIGHT(CITY, 1)) NOT IN ('a', 'e', 'i', 'o', 'u');Weather Observation Station 7