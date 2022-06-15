# Write your MySQL query statement below

select Person.firstName , Person.lastName , Address.city , Address.state 
from Person left join address on Person.personId=address.personId
