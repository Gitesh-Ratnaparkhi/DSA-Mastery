-- Weather Observation Station 17

-- Link -> https://www.hackerrank.com/challenges/weather-observation-station-17/problem

-- Descryption -> Largest point of latitude less than 137.2345

-- Query ->
SELECT ROUND(LONG_W, 4)
FROM STATION
WHERE LAT_N > 38.7780
ORDER BY LAT_N ASC
LIMIT 1;