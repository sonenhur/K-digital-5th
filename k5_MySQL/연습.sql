USE world;
SELECT 
    a.code, a.population CountryPop, b.population CityPop
FROM
    country a,
    city b
WHERE
    a.code = b.countrycode
order by CountryPop desc;
-- 

-- 국가별 인구 대비 도시 인구 비율을 구하시오
#COUNT, SUM, AVG, MIN, MAX