SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS AS I JOIN (SELECT * 
                           FROM ANIMAL_OUTS
                           WHERE SEX_UPON_OUTCOME LIKE 'Spayed%' 
                           OR SEX_UPON_OUTCOME LIKE 'Neutered%') AS O
                           ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE LIKE 'Intact%'
ORDER BY I.ANIMAL_ID;