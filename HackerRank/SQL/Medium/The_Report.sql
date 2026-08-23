-- The Report

--Link -> https://www.hackerrank.com/challenges/the-report/problem?isFullScreen=true

-- Query ->
SELECT
    CASE
        WHEN Grades.Grade < 8 THEN NULL
        ELSE Students.name
    END AS name,
    Grades.Grade,
    Students.marks
FROM Students
JOIN Grades
    ON Students.marks BETWEEN Grades.Min_Mark AND Grades.Max_Mark
ORDER BY
    Grades.Grade DESC,
    CASE
        WHEN Grades.Grade >= 8 THEN Students.name
        ELSE NULL
    END ASC,
    CASE
        WHEN Grades.Grade < 8 THEN Students.marks
        ELSE NULL
    END ASC;