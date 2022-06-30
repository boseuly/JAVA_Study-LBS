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
