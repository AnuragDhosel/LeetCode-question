# Write your MySQL query statement below

select t2.unique_id , t1.name 
from Employees t1
left join EmployeeUNI t2
ON t1.id = t2.id;