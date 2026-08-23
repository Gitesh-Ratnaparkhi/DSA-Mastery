-- The PADS

-- Link -> https://www.hackerrank.com/challenges/the-pads/problem?isFullScreen=true

-- Query ->
SELECT CONCAT(Name, '(', LEFT(Occupation, 1), ')')
FROM OCCUPATIONS
ORDER BY Name;

SELECT CONCAT(
    'There are a total of ',
    COUNT(*),
    ' ',
    LOWER(Occupation),
    's.'
)
FROM OCCUPATIONS
GROUP BY Occupation
ORDER BY COUNT(*), Occupation;