#문제1
USE world;
SELECT 
    c.name Capital, co.name Country
FROM
    city c,
    country co
WHERE
    c.id = co.capital
ORDER BY co.name , c.name;

-- ------------------------------------------------------
#문제2
USE world;
SELECT 
    a.name Country, b.name City
FROM
    country a,
    city b
WHERE
    a.code = b.countrycode
        AND a.name = 'United States'
ORDER BY Country , City;

-- ------------------------------------------------------
#문제3
use world;
SELECT 
    a.name Country, b.language Language
FROM
    country a,
    countrylanguage b
WHERE
    a.code = b.countrycode
        AND a.name = 'China'
ORDER BY Country , Language;

-- ------------------------------------------------------
#문제4
USE world;
SELECT 
    a.name Country, a.population Population
FROM
    country a
WHERE
    a.population > 1000000
ORDER BY Population;

-- ------------------------------------------------------
#문제5
USE world;
SELECT 
    a.name Country, a.indepyear Independence
FROM
    country a
WHERE
    a.indepyear > 1900
ORDER BY Independence;

-- ------------------------------------------------------
#문제6
USE world;
SELECT 
    a.name Country, b.language Language, a.gnp GNP
FROM
    country a,
    countrylanguage b
WHERE
    a.code = b.countrycode
        AND b.language != 'English'
        AND a.gnp > 1000
ORDER BY a.gnp;

-- ------------------------------------------------------
#문제7
USE world;
SELECT 
    a.Name, a.Population
FROM
    city a
ORDER BY Population DESC
LIMIT 5;