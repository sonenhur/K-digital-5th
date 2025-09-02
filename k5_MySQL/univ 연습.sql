use university;
SELECT 
    inst.name, inst.dept_name
FROM
    instructor inst
WHERE
    inst.dept_name = 'Biology'
ORDER BY inst.name;

-- -----------------------------------------
SELECT 
    dept.dept_name, course.title, course.credits
FROM
    department dept,
    course
WHERE
    dept.dept_name = 'Comp. Sci.'
        AND course.credits = 3;

-- -----------------------------------------

SELECT 
    t.id, c.course_id, c.title
FROM
    takes t,
    course c
WHERE
    t.course_id = c.course_id
        AND t.id = '12078'
        GROUP BY t.id , t.course_id;
-- -----------------------------------------

SELECT 
    t.id, SUM(c.credits) credits
FROM
    takes t,
    course c
WHERE
    t.course_id = c.course_id
GROUP BY t.id
ORDER BY credits DESC;

-- -----------------------------------------

SELECT 
    c.dept_name, t.course_id
FROM
    department dept,
    course c,
    takes t
WHERE
    t.course_id = c.course_id
        AND dept.dept_name = 'Comp. Sci.';
	