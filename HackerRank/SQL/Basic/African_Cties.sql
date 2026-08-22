-- African Cities

-- Link -> https://www.hackerrank.com/challenges/african-cities/problem

-- Description -> We have to write a query to find the names of all cities where the CONTINENT is 'Africa'. From CITY and COUNTRY tables.


-- Query ->
SELECT CITY.name from CITY
JOIN COUNTRY
ON CITY.CountryCode = COUNTRY.Code
WHERE COUNTRY.CONTINENT  = 'Africa';