SELECT a.HISTORY_ID,
       case when a.END_DATE-a.START_DATE+1 >= 7 then b.DAILY_FEE*((100-c.DISCOUNT_RATE)/100)*(a.END_DATE-a.START_DATE+1)
            else b.DAILY_FEE*(a.END_DATE-a.START_DATE+1) end "fee"
from  CAR_RENTAL_COMPANY_RENTAL_HISTORY a,
      CAR_RENTAL_COMPANY_CAR b,
      CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
where a.CAR_ID = b.CAR_ID
  and b.CAR_TYPE = c.CAR_TYPE
  and c.DURATION_TYPE LIKE
      case when (a.END_DATE-a.START_DATE+1) BETWEEN 7 and 29 then '7일%'
           when (a.END_DATE-a.START_DATE+1) BETWEEN 30 and 89 then '30일%'
           when (a.END_DATE-a.START_DATE+1) >= 90 then '90일%'
           else '7일%' end
  and b.CAR_TYPE = '트럭'
order by 2 desc, 1 desc