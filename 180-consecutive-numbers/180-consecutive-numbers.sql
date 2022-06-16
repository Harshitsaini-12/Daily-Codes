# Write your MySQL query statement below


# select distinct l1.num from Logs l1,Logs l2,Logs l3
# where l1.id=l2.id-1 and l2.id=l3.id-1
# and l1.num=l2.num and l2.num=l3.num;

# Select DISTINCT l1.Num from Logs l1, Logs l2, Logs l3 
# where l1.Id=l2.Id-1 and l2.Id=l3.Id-1 
# and l1.Num=l2.Num and l2.Num=l3.Num

select distinct a.num as ConsecutiveNums
from Logs a, Logs b, Logs c
where a.num = b.num and b.num = c.num
	and a.id+1 = b.id and b.id+1 = c.id