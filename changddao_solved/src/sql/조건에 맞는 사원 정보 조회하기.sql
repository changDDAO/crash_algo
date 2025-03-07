SELECT SUM(B.SCORE) AS SCORE, A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
FROM HR_EMPLOYEES A left join HR_GRADE B ON (A.EMP_NO = B.EMP_NO)
                    left join HR_DEPARTMENT C ON (A.DEPT_ID = C.DEPT_ID)
GROUP BY A.EMP_NO
ORDER BY SCORE DESC
    LIMIT 1;

