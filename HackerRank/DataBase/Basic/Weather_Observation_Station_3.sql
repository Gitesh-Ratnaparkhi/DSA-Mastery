-- Weather Observation Station 3

-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-3/problem

-- Descryption -> Query the list of CITY names from STATION that do not end with vowels. Your result cannot contain duplicates.

-- Query ->
SELECT DISTINCT CITY FROM STATION WHERE MOD(ID, 2) = 0;