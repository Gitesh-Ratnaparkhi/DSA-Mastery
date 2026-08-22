-- Revising The Select Query I

-- Link -> https://www.hackerrank.com/challenges/revising-the-select-query/problem

-- Descryption -> We Have to select all columns from the CITY table where the COUNTRYCODE is USA and the POPULATION is greater than 100000.

-- Query ->
SELECT * From CITY 
WHERE COUNTRYCODE = 'USA' 
AND POPULATION > 100000;