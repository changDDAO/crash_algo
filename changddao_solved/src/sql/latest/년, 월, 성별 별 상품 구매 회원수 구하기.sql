SELECT
    to_char(os.sales_date, 'YYYY') AS year,
    to_number(to_char(os.sales_date, 'mm')) AS month,
    u.gender AS gender,
    COUNT(DISTINCT(u.user_id)) AS users
FROM online_sale os
    INNER JOIN user_info u
ON os.user_id = u.user_id
WHERE
    u.gender is not null
GROUP BY
    to_char(os.sales_date, 'YYYY'),
    to_number(to_char(os.sales_date, 'mm')),
    u.gender
ORDER BY
    year ASC,
    month ASC,
    gender ASC
