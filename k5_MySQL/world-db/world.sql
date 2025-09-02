USE world;
SELECT 
    a.name cname, b.name ccname
FROM
	country a,
    city b
WHERE
    a.code = b.countrycode
ORDER BY cname , ccname;    
---------------------------------------
SELECT 
    a.name cname, b.name ccname
FROM
    country a,
    city b
WHERE
    a.code = b.countrycode
        AND a.name = 'United States'
ORDER BY cname , ccname;
--------------------------------------
SELECT 
    a.name cname, b.language clan
FROM
    country a, countrylanguage b
WHERE
        a.code = b.countrycode
        AND a.name = 'China'
ORDER BY cname, clan;
--------------------------------------
SELECT 
    a.name cname, a.population
FROM
    country a
WHERE
    a.population > 1000000;
-------------------------------------
SELECT a.name cname, a.IndepYear aiy
FROM country a
WHERE
	a.IndepYear > 1900;
---------------------------------------
-- SELECT 
--     a.name, b.language, a.gnp
-- FROM
--     country a,
--     countrylanguage b
-- WHERE
--     a.code = b.countrycode
--         AND b.language != 'English'
--         AND a.gnp > 1000
-- ORDER BY a.gnp;
-----------------------------------------
