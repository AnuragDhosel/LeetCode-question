# Write your MySQL query statement below

select project_id , ROUND(sum(experience_years) / count(experience_years) , 2) as average_years 
from Project t1
left join Employee t2
on t1.employee_id = t2.employee_id 
group by project_id;