# Write your MySQL query statement below

select t1.product_id , t1.product_name 
from Product t1
left join Sales t2
on t1.product_id = t2.product_id 
group by t2.product_id
having Min(t2.sale_date) >= '2019-01-01' and
       Max(t2.sale_date) <= '2019-03-31';