-- 1.
CREATE TABLE student (
 reg_no INT PRIMARY KEY,
 s_name VARCHAR(30),
 dept VARCHAR(30),
 cgpa FLOAT

);

INSERT INTO student VALUES(101, "Poltu", "CSE", 3.25);
INSERT INTO student VALUES(105, "Boltu", "EEE", 3.8);
INSERT INTO student VALUES(110, "Montu", "SWE", 3.7);
INSERT INTO student VALUES(115, "Jhontu", "CSE", 3.5);
INSERT INTO student VALUES(123, "Tourist", "EEE", 3.7);
INSERT INTO student VALUES(127, "Petr", "CSE", 3.6);

SELECT * FROM student;

CREATE TABLE stu_org(
  reg_no INTEGER ,
  org TEXT NOT NULL
);

INSERT INTO stu_org VALUES(105,"KIN");
INSERT INTO stu_org VALUES(101,"RIM");
INSERT INTO stu_org VALUES(105,"RIM");
INSERT INTO stu_org VALUES(127,"KIN");
INSERT INTO stu_org VALUES(127,"SSA");

-- SELECT * FROM stu_org;


-- Task-00

SELECT *
FROM student
WHERE cgpa = (
  SELECT cgpa
  FROM student
  WHERE cgpa < (
    SELECT MAX(cgpa)
    FROM student
  ) ORDER BY cgpa DESC LIMIT 1
);

-- Another approach

SELECT * 
FROM student
WHERE cgpa = (
  SELECT DISTINCT(cgpa)
  FROM student
  ORDER BY cgpa DESC LIMIT 1, 1
);


-- Task-01

SELECT * 
FROM student
WHERE cgpa = (
  SELECT DISTINCT(cgpa)
  FROM student
  WHERE dept = "CSE"
  ORDER BY cgpa DESC LIMIT 1, 1
)
AND dept = "CSE";


-- Task-02

SELECT dept, MIN(reg_no) AS reg
FROM student
GROUP BY dept;

-- Task-03

SELECT *
FROM student
WHERE s_name LIKE "%tu";

-- Task-04

SELECT *
FROM student
WHERE LENGTH(s_name) >= 3 AND s_name LIKE "p%";

-- Task-05

SELECT *
FROM student
WHERE s_name LIKE "%on%";

-- Task-06
/*
SELECT * 
FROM student
WHERE reg_no = ANY(
  110, 115, 123
);
*/
-- MySql doesn't support ANY









