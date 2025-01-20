SELECT ('/home/grep/src/' || A.BOARD_ID ||'/'|| A.FILE_ID || A.FILE_NAME || A.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE A LEFT JOIN USED_GOODS_BOARD B
                                 ON (A.BOARD_ID = B.BOARD_ID)
WHERE B.BOARD_ID = (SELECT C.BOARD_ID
                    FROM ( SELECT *
                           FROM USED_GOODS_BOARD
                           ORDER BY VIEWS DESC
                         ) C
                    WHERE ROWNUM=1
)

ORDER BY FILE_ID DESC;