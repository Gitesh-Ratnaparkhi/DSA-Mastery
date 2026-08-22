-- SelectWeather Observation Station 8
-- LInk -> https://www.hackerrank.com/challenges/weather-observation-station-8/problem
-- Descryption -> Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) and ending with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.
-- Query ->
SELECT CITY
from STATION
WHERE LOWER(LEFT(CITY, 1)) IN ('a', 'e', 'i', 'o', 'u')
    AND LOWER(RIGHT(CITY, 1)) IN ('a', 'e', 'i', 'o', 'u');