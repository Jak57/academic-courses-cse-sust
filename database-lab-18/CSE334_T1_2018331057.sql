

-- 1.
CREATE TABLE student (
 reg_no INT PRIMARY KEY,
 s_name VARCHAR(30),
 dept VARCHAR(30),
 cgpa FLOAT

);

INSERT INTO student VALUES(101, "A", "CSE", 3.4);
INSERT INTO student VALUES(105, "B", "EEE", 3.8);
INSERT INTO student VALUES(110, "A", "SWE", 3.7);
INSERT INTO student VALUES(115, "C", "CSE", 3.5);
INSERT INTO student VALUES(123, "D", "EEE", 3.7);
INSERT INTO student VALUES(127, "B", "CSE", 3.8);

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

SELECT * FROM stu_org;


-- comment 02: T-1

SELECT dept, MAX(cgpa)
FROM student
GROUP BY dept;

SELECT *
FROM student 
WHERE (dept, cgpa) IN (
  SELECT dept, MAX(cgpa)
  FROM student
  GROUP BY dept
);


-- comment 03: T-2

SELECT reg_no 
FROM stu_org
WHERE org = "RIM";

SELECT reg_no, dept
FROM student
WHERE reg_no IN (
  SELECT reg_no 
  FROM stu_org
  WHERE org = "RIM"
);

-- comment 04: T-3

SELECT dept, MAX(cgpa)
FROM student
GROUP BY dept;

SELECT reg_no
FROM student 
WHERE (dept, cgpa) IN (
  SELECT dept, MAX(cgpa)
  FROM student
  GROUP BY dept
)
AND dept = "CSE";

SELECT * 
FROM stu_org
WHERE reg_no IN (
  SELECT reg_no
  FROM student 
  WHERE (dept, cgpa) IN (
    SELECT dept, MAX(cgpa)
    FROM student
    GROUP BY dept
  )
  AND dept = "CSE"
);



