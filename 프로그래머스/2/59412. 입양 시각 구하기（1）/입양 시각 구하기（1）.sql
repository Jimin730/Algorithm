SELECT
    DATE_FORMAT(datetime, '%H') hour,
    COUNT(animal_id) cnt
FROM
    animal_outs
WHERE
    DATE_FORMAT(datetime, '%H') BETWEEN 09 AND 19
GROUP BY
    1
ORDER BY
    1;