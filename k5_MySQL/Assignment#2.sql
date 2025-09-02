#문제1
use university;
select ins.name, ins.dept_name
from instructor ins

where ins.dept_name = 'Biology';

-- --------------------------------------------------

#문제2
select dept.dept_name, course.title, course.credits
from department dept, course
where dept.dept_name = "Comp. Sci."
AND course.credits = 3;

-- --------------------------------------------------

#문제3
SELECT 
    t.id tid,
    t.course_id tcid,
    c.course_id,
    c.title
FROM
    takes t,
    course c
WHERE
    t.course_id = c.course_id
        AND t.id = '12078'
GROUP BY tid , tcid;

-- --------------------------------------------------

#문제4
SELECT 
    t.id tid,
    t.course_id tcid,
    c.course_id,
    c.title,
    s.id,
    s.tot_cred,
    c.credits,
    sum(c.credits)
FROM
	student s,
    takes t,
    course c
WHERE
    t.course_id = c.course_id
        AND s.id = '12078'
GROUP BY tid , tcid