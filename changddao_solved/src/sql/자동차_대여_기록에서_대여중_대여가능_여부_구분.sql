
SELECT CAR_ID, CASE WHEN CAR_ID IN(SELECT CAR_ID
                                   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                   WHERE '2022-10-16'
                                             BETWEEN TO_CHAR(START_DATE,'YYYY-MM-DD')
                                             AND TO_CHAR(END_DATE,'YYYY-MM-DD'))
                        THEN '대여중'
                    ELSE '대여 가능'
    END AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC; k