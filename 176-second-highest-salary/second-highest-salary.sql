# Write your MySQL query statement below
Select Max(salary) as SecondHighestSalary from Employee where salary < (select max(salary) from employee);