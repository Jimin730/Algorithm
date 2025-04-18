SELECT I.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I 
JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME - O.DATETIME > 0
ORDER BY I.DATETIME;