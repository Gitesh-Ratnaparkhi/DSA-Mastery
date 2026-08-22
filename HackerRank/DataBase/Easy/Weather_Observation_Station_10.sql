-- Weather Observation Station 10

-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-10/problem

-- Descryption -> Query the list of CITY names ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain duplicates.

-- Query ->
SELECT DISTINCT(CITY) FROM STATION 
WHERE LOWER(RIGHT(CITY , 1)) NOT IN('a', 'e', 'i', 'o', 'u');