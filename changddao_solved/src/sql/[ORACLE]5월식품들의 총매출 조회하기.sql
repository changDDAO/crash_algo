select a.product_id, a.product_name, sum(amount*price) as total_sales
from food_product a join food_order b on (a.product_id = b.product_id)
where TO_CHAR(b.produce_date, 'YYYY-MM') = '2022-05'
group by a.product_id, a.product_name
order by total_sales desc, a.product_id;