# Write your MySQL query statement below

# select E1.Name
#  from Employee as E1,Employee as E2
#  where E1.ManagerId=E2.Id and E1.Salary>E2.Salary
 
select name as Employee from Employee e1 where
salary>(select salary from Employee e2 where e2.id=e1.managerId)