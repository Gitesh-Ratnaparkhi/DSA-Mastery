-- Weather Observation Station 5
-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-5/problem
-- Description -> Find the legth of the longest city name and the length of the shortest city name from STATION. If there are multiple shortest names, choose the one that comes first alphabetically.
-- Query->
SELECT CITY,
    LENGTH(CITY)
FROM STATION
ORDER BY LENGTH(CITY) ASC,
    CITY
LIMIT 1;
SELECT CITY,
    LENGTH(CITY)
FROM STATION
ORDER BY LENGTH(CITY) DESC,
    CITY
LIMIT 1;