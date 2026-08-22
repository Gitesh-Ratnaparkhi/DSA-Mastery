-- Average Population Of Each Continent

-- Link -> https://www.hackerrank.com/challenges/average-population-of-each-continent/problem

-- Description -> We have to write a query to find the average population of each continent.

-- Query -> 
SELECT COUNTRY.Continent, FLOOR(AVG(CITY.Population))
FROM COUNTRY
JOIN CITY ON CITY.CountryCode = COUNTRY.Code
GROUP BY COUNTRY.Continent;