/*
 * 이보슬_문제07
 * 
 * 1. STUDENT_TB에서 주소가 '서울시'이면서 핸드폰 번호에 5가 한 번도 들어가지 않은 학생 조회하시오.
 *	- 다중행-다중열을 이용하여 조회하시오.
 *	- 조회 결과에 핸드폰 뒤에 4자리는 '****'로 출력되도록 하시오. 
 *	  단, 별칭은 STU_PHONE 으로 한다.
 *	
 * 2. LEVEL_TB 테이블에 stu_teacher 컬럼을 추가하시오.
 *		- 자료형 : VARCHAR2(20) 
 * 3. stu_teacher 컬럼에 값을 아래와 같이 추가하시오.
 *			1학년 1반 담임 : 송중기
 *			1학년 2반 담임 : 박보영
 *			1학년 3반 담임 : 남주혁
 *			2학년 1반 담임 : 김우빈
 *			2학년 2반 담임 : 이광수
 *			2학년 3반 담임 : 송지효
 *			3학년 1반 담임 : 서인국
 *			3학년 2반 담임 : 김수현
 *			3학년 3반 담임 : 한지민
 *
 * 4. 담당선생님이 '송중기'인 학생들의 stu_id, stu_name, stu_age를 출력하시오.
 * 	 	- 서브쿼리를 이용하시오.
 */

/*<단일행>
 * 서브쿼리가 단일 행 비교 연산자(=, <, <=, >, >=, <>)와 함께 사용할 때는 
 * 서브쿼리의 결과 건수가 반드시 1건 이하여야 한다.
 * 
 * <다중행>
 * 서브쿼리의 결과가 2건 이상 반환될 수 있다면 반드시 
 * 다중 행 비교 연산자(IN, ALL, ANY, SOME)와 함께 사용해야 한다.
 * 
 * LPAD 함수는 지정한 길이 만큼 왼쪽부터 특정문자로 채워준다.
 * LPAD("값", "총 문자길이", "채움문자")
 * 
 */



-- 1. STUDENT_TB에서 주소가 '서울시'이면서 핸드폰 번호에 5가 한 번도 들어가지 않은 학생 조회

SELECT STU_ID 
	 , STU_NAME 
	 , STU_AGE 
	 , SUBSTR(STU_PHONE,0,9)||LPAD('*',4, '*') STU_PHONE 
	 , STU_ADDRESS 
	 , CLUB_ID 
FROM STUDENT_TB
WHERE (STU_PHONE, STU_ADDRESS) IN (SELECT STU_PHONE , STU_ADDRESS 
						 			 FROM STUDENT_TB
									WHERE INSTR(STU_PHONE,'5') = 0
									  AND INSTR(STU_ADDRESS, '서울시') != 0);

-- 2.stu_teacher 추가하기									 
ALTER TABLE LEVEL_TB ADD (stu_teacher VARCHAR2(20));


-- 3. stu_teacher 값 추가하기

UPDATE LEVEL_TB
SET stu_teacher = (CASE WHEN LEVEL_NO = 1 AND CLASS_NO = 1 THEN '송중기'
					 WHEN LEVEL_NO = 1 AND CLASS_NO = 2 THEN '박보영'
					 WHEN LEVEL_NO = 1 AND CLASS_NO = 3 THEN '남주혁'
					 WHEN LEVEL_NO = 2 AND CLASS_NO = 1 THEN '김우빈'
					 WHEN LEVEL_NO = 2 AND CLASS_NO = 2 THEN '이광수'
					 WHEN LEVEL_NO = 2 AND CLASS_NO = 3 THEN '송지효'
					 WHEN LEVEL_NO = 3 AND CLASS_NO = 1 THEN '서인국'
					 WHEN LEVEL_NO = 3 AND CLASS_NO = 2 THEN '김수현'
					 WHEN LEVEL_NO = 3 AND CLASS_NO = 3 THEN '한지민'
					 END);

-- 4. 담당선생님 '송중기'인 학생들 출력
SELECT STU_ID
	 , STU_NAME
	 , STU_AGE
FROM STUDENT_TB
WHERE  STU_ID IN (SELECT STU_ID
				   FROM LEVEL_TB
				  WHERE STU_TEACHER = '송중기');


				 
/*
 * 홍유라_문제07
 * 
 * 1. score_t 테이블에 데이터를 추가하시오.
 *   - 학번: 2201, 수학:  70, 영어:  85, 국어: 95, 자바: 90, 과목점수합계: NULL, 과목점수평균: NULL
 *   - 학번: 2202, 수학: 100, 영어:  95, 국어: 95, 자바: 90, 과목점수합계: NULL, 과목점수평균: NULL
 *   - 학번: 2203, 수학:  64, 영어:  70, 국어: 76, 자바: 80, 과목점수합계: NULL, 과목점수평균: NULL
 *   - 학번: 2204, 수학:  97, 영어:  81, 국어: 72, 자바: 88, 과목점수합계: NULL, 과목점수평균: NULL
 *   - 학번: 2205, 수학:  88, 영어: 100, 국어: 82, 자바: 74, 과목점수합계: NULL, 과목점수평균: NULL
 * 
 * 2. UPDATE 문을 사용하여 과목점수 합계를 score_total 에 넣으시오.
 * 
 * 3. UPDATE 문을 사용하여 과목점수 평균값을 score_avg 에 넣으시오.
 *
 * 4. 서브쿼리를 사용하여 score_t 테이블에서 score_avg 컬럼값을 기준으로 학생들의 등수를 조회하시오.
 * 	 - '순위', '학번', '과목점수평균' 만 조회되도록 한다.
 * 	 - 예외적으로 동일한 점수가 있을 시, 순위는 끊이지 않고 순차적으로 이어지게 한다.   
 *   - 사진과 같이 과목점수평균을 기준으로 내림차순 정렬한다.
 */

				 
SELECT * FROM SCORE_T;
INSERT INTO SCORE_T (STU_ID, MATH, ENG, KOR, JAVA) VALUES(2201, 70,  85,  95, 90);
INSERT INTO SCORE_T (STU_ID, MATH, ENG, KOR, JAVA) VALUES(2202, 100, 95,  95, 90);
INSERT INTO SCORE_T (STU_ID, MATH, ENG, KOR, JAVA) VALUES(2203, 64,  70,  76, 80);
INSERT INTO SCORE_T (STU_ID, MATH, ENG, KOR, JAVA) VALUES(2204, 97,  81,  72, 88);
INSERT INTO SCORE_T (STU_ID, MATH, ENG, KOR, JAVA) VALUES(2205, 88,  100, 82, 74);

UPDATE SCORE_T 
   SET SCORE_TOTAL = MATH + ENG + KOR + JAVA 
 WHERE STU_ID = 2201;
UPDATE SCORE_T
   SET SCORE_TOTAL = MATH + ENG + KOR + JAVA 
 WHERE STU_ID = 2202;
UPDATE SCORE_T
   SET SCORE_TOTAL = MATH + ENG + KOR + JAVA
 WHERE STU_ID = 2203;
UPDATE SCORE_T
   SET SCORE_TOTAL = MATH + ENG + KOR + JAVA
 WHERE STU_ID = 2204;
UPDATE SCORE_T
   SET SCORE_TOTAL = MATH + ENG + KOR + JAVA
 WHERE STU_ID = 2205;

UPDATE SCORE_T 
   SET SCORE_AVG = (MATH + ENG + KOR + JAVA) / 4
 WHERE STU_ID = 2201;
UPDATE SCORE_T 
   SET SCORE_AVG = (MATH + ENG + KOR + JAVA) / 4
 WHERE STU_ID = 2202;
UPDATE SCORE_T 
   SET SCORE_AVG = (MATH + ENG + KOR + JAVA) / 4
 WHERE STU_ID = 2203;
UPDATE SCORE_T 
   SET SCORE_AVG = (MATH + ENG + KOR + JAVA) / 4
 WHERE STU_ID = 2204;
UPDATE SCORE_T 
   SET SCORE_AVG = (MATH + ENG + KOR + JAVA) / 4
 WHERE STU_ID = 2205;

-- 점수를 기준으로 ORDER BY 해준다. 
SELECT RANK() OVER(ORDER BY SCORE_AVG DESC) AS 순위
	 , STU_ID
	 , SCORE_AVG
FROM SCORE_T;

/*
 * 김규연_문제07
 * 
 * 서브쿼리를 이용하여 다음 문제를 푸세요.
 * 		1. JOBS 테이블에서 JOB_ID 가 SA_인 것들의 MAX_SALAY를 조회하고
 * 		   EMPLOYEES의 SALARY가 조회한 SALARY 이상인 것이 조회되도록 하세요.
 * 		   	  - 조회 결과는 EMPLOYEE_ID, NAME(FIRST_NAME과 LAST_NMAE 합치기), JOB_ID, SALARY가 출력되도록 하세요.
 * 				  - 다중행 비교연산자 활용하세요.
 * 		
 * 		2. bread_t 테이블에서 빵가격이 높은 순서대로 순위를 매겨 출력되도록 하세요.
 * 				  - 조회결과는 순위, bread_name, bread_total, bread_type, bread_price이 출력되도록 하세요.
 * 				  - 순위는 중복이 되든 안되든 등수가 1씩 증가되도록 하세요.
 * 				  - 순위가 1 ~ 5 위까지만 출력되도록 하세요.
 */

SELECT * FROM JOBS;
SELECT * FROM bread_t;

-- 이런 경우에는 >= ANY를 사용해야 한다. -> ANY를 사용한 다중행
SELECT EMPLOYEE_ID
	 , FIRST_NAME || LAST_NAME NAME
	 , JOB_ID
	 , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= ANY (SELECT MAX_SALARY
 				   	   FROM JOBS
 				   	  WHERE JOB_ID LIKE 'SA_%');

SELECT *
  FROM (SELECT DENSE_RANK () OVER(ORDER BY BREAD_PRICE DESC) 순위
  			 , BREAD_NAME
	 		 , BREAD_TOTAL
	 		 , BREAD_TYPE
	 		 , BREAD_PRICE
	     FROM  BREAD_T)
 WHERE 순위 <= 5 ;
/*
 * 김재은_문제07
 * 
 * 1. ref_mart_t의 테이블명을 ref_mart_tb로 변경하시오.
 *    MART_T의 테이블명을 mart_tb로 변경하시오.
 *    EMP_MART_T의 테이블명을 emp_mart_tb로 변경하시오.
 * 2. FK_MART_T_BARCODE 제약조건을 제거하시오.
 *    PK_REF_MART_T_R_BAR 제약조건을 제거하시오.
 *    ref_mart_tb 테이블을 제거하시오.
 * 3. emp_mart_tb의 name의 자료형을 가변길이 20자로 변경하시오.
 * 
 * 4. mart_tb에 값을 추가시오.
 *    ('2080', 3000, '애경', '치약' ,'O', 2080, 5)
 *    ('계란30구', 6000, '농협', '알류', 'O', 9090, 6)
 * 5. emp_mart_tb에 값을 추가하시오. 
 *    ('김봉지', 3000, 1), ('최박스', 3200, 2), ('다니엘소스', 3200, 3),
 *    ('오젤리', 2900, 4), ('이민트', 4000, 5), ('윤아리', 3400 , 6)
 * 6. 서브쿼리를 이용하여 mart_tb에서 kind의 값이 '젤리'이거나 '과자'가 들어가는 물품을 찾아 
 *    emp_mart_t 를 조회하시오. 
 *    (sort와 manage_sort를 이용하세요)
 */



ALTER TABLE REF_MART_T RENAME TO ref_mart_tb;
ALTER TABLE MART_T RENAME TO mart_tb;
ALTER TABLE EMP_MART_T RENAME TO emp_mart_tb;
-- 2. 제약조건 & 테이블 삭제
ALTER TABLE MART_TB DROP CONSTRAINT FK_MART_T_BARCODE ;
ALTER TABLE MART_TB DROP CONSTRAINT PK_REF_MART_T_R_BAR ;
DROP TABLE ref_mart_tb;

-- 3. 자료형 길이 변경
ALTER TABLE EMP_MART_TB MODIFY NAME VARCHAR2(20);

-- 4. MART_TB에 값추가
INSERT INTO MART_TB VALUES ('2080', 	3000, '애경', '치약', 'O', 2080, 5);
INSERT INTO MART_TB VALUES ('계란30구', 	6000, '농협', '알류', 'O', 9090, 6);
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MART_TB';

-- 5. EMP_MART_TB에 값추가
INSERT INTO emp_mart_tb VALUES('김봉지',		3000, 	1);
INSERT INTO emp_mart_tb VALUES('최박스', 		3200, 	2);
INSERT INTO emp_mart_tb VALUES('다니엘소스', 	3200, 	3);
INSERT INTO emp_mart_tb VALUES('오젤리', 		2900, 	4); 
INSERT INTO emp_mart_tb VALUES('이민트', 		4000, 	5); 
INSERT INTO emp_mart_tb VALUES('윤아리', 		3400 , 	6);
COMMIT;

SELECT * FROM EMP_MART_TB;
SELECT * FROM MART_TB;

-- 6. 서브쿼리 
SELECT * 
  FROM EMP_MART_TB
 WHERE MANAGE_SORT IN (SELECT SORT
 						  FROM MART_TB
 						 WHERE KIND = '젤리'
 						    OR KIND LIKE '%과자');
