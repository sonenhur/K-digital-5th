USE sakila;
SELECT category.name, COUNT(*) 
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
GROUP BY category.name;
--------------------------------------------------------------------------

SELECT 
    customer.first_name, customer.last_name
FROM
    rental
        JOIN
    inventory ON rental.inventory_id = inventory.inventory_id
        JOIN
    film ON inventory.film_id = film.film_id
        JOIN
    customer ON rental.customer_id = customer.customer_id
WHERE
    film.title = 'ACADEMY DINOSAUR';

---------------------------------------------------------

SELECT
	actor.first_name,
	actor.last_name,
    COUNT(film_actor.film_id) cnt
FROM actor JOIN film_actor ON actor.actor_id = film_actor.actor_id
GROUP BY actor.actor_id
order by cnt DESC
limit 1;

---------------------------------------------------------

select
from
