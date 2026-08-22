-- Asian Population
-- Link: https://www.hackerrank.com/challenges/asian-population/problem
-- Descryption -> Query the sum of the populations where continent is Asia.
-- Query ->
SELECT SUM(CITY.population)
FROM CITY
    JOIN COUNTRY ON CITY.CountryCode = COUNTRY.Code
WHERE COUNTRY.continent = 'Asia';