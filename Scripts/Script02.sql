/*
 * 이보슬 문제02
 * 
 * EMPLOYEES테이블에서 FIRST_NAME의 글자수가 5개이고 고용년도가 1998~2000 사이인 직원들의 
 * EMPLOYEE_ID, FIRST_NAME, EMAIL, HIRE_DATE를 조회하시오.
 * 	- EMAIL은 'EMAIL@gmail.com'와 같은 형식으로 출력되도록 하고 EMAIL 이라고 별칭을 부여한다.
 * 	- HIRE_DATE는 년도만 출력되도록 하고 HIRE_YEAR 라고 별칭을 부여한다. 
 */


SELECT EMPLOYEE_ID 
	 , FIRST_NAME
	 , CONCAT(EMAIL, '@gmail.com') EMAIL 
	 , EXTRACT(YEAR FROM HIRE_DATE) HIRE_DATE 
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '_____'
  AND EXTRACT(YEAR FROM HIRE_DATE) BETWEEN 1998 AND 2000;
  
 
SELECT EMPLOYEE_ID 
	 , FIRST_NAME
	 , CONCAT(EMAIL, '@gmail.com') EMAIL 
	 , EXTRACT(YEAR FROM HIRE_DATE) HIRE_DATE 
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '_____'
  AND EXTRACT(YEAR FROM HIRE_DATE) IN(1998,1999,2000);

 
 /*
  *
  * 홍유라 문제02
  * COUNTRIES 테이블에서 REGION_ID 가 1 이면 'Europe'
  * , 2 이면 'Americas', 3 이면 'Asia', 4 이면 'Middle East and Africa'로 
  * 조회하되 각 개수를 하나의 컬럼으로 나타내도록 하시오.
  */
SELECT COUNTRY_ID 
	 , COUNTRY_NAME 
	 , DECODE(REGION_ID, 1, 'Europe', 2, 'Americas', 3, 'Asia', 4, 'Middle East and Africa') REGION 
FROM COUNTRIES;
 
 SELECT * FROM COUNTRIES; 

 /*
  * 김규연 문제02
  * EMPLOYEES 테이블에서
  * 급여가 1000부터 3000 사이의 사람은 급여의 5%를 보너스를 받도록 하였다.	-> 급여가 1000~3000인 사람 WHERE 문에서 고르고 (O)
  * 급여와 보너스를 합친 금액을 출력하세요. (단, 정수값 뒤에 두자릿수를 절삭해서 출력하세요.)	-> SELECT 문에서 TRUNC  
  * 급여와 보너스의 경우 , 을 이용해서 천단위로 끊어서 출력하시오.(ex) 1,000,000)	-> TO_CHAR( , '999,999,999') (O)
  * 이름은 함수를 이용해서 FISRT_NAME과 LAST_NAME을 합치세요.					-> CONCAT 사용 (O)
  * 입사일은 "2022년 5월 19일 오후 05시 20분 48초" 형식으로 출력되게 하세요.		-> TO_CHAR
  * 
  * <별칭 부여> 
  * SALARY -> 급여, 급여와 보너스 합친 금액 -> 총 급여			
  * HIRE_DATE -> 입사일, FISRT_NAME와 LAST_NAME -> 이름
  */
SELECT CONCAT(FIRST_NAME, LAST_NAME) 이름
	 , TO_CHAR(SALARY, '999,999,999') 급여
	 , TO_CHAR(TRUNC(CASE WHEN SALARY >= 1000 AND SALARY <= 3000 THEN SALARY * 0.05 + SALARY
	 		ELSE SALARY
	 	END , -2) , '999,999,999') 총급여
	 , TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" HH"시" MI"분" SS"초"') 입사일
FROM EMPLOYEES;


 
/* 김재은 문제02
 * EMPLOYEES 테이블에서 EMPLOYEE_ID, EMAIL, COMMISSION_PCT
 * , PHONE_NUMBER, SALARY, DEPARTMENT_ID를 출력하라
 *   - EMAIL 은 소문자로 출력하라.
 *   - COMMISSION_PCT 값이 NULL이면 0.05 가 출력되게 하라
 *   - PHONE_NUMBER의 앞에 세자리가 '515'면 '인사', '590'이면 '총무',
 *     '650'이면 '영업', '011'이면 '기획', 그 외에는 '비서'로 출력되게 하라
 */
SELECT EMPLOYEE_ID 
	 , LOWER(EMAIL) EMAIL
	 , NVL(COMMISSION_PCT, 0.05) COMMISSION_PCT
	 , DECODE(SUBSTR(PHONE_NUMBER, 1,3), '515','인사', '590','총무','650','영업','011','기획', '비서') PHONE_NUMBER 
	 , SALARY
	 , DEPARTMENT_ID
FROM EMPLOYEES;

/*
 * 김경욱 문제02
 * DECODE 함수로 직급에 따라 급여를 인상해봅시다 
 * 직급이 ‘ST_CLERK”인 사원은 200, ‘SA_MAN’인 사원은 180,
 * ‘SA_REP’인 사원은 150, ‘IT_PROG”인 사원은 100을 인상
 * 이름과 급여 인상된급여를 출력해주세요
 */ 

SELECT FIRST_NAME || LAST_NAME 이름 
	 , SALARY 급여
	 , DECODE(JOB_ID, 'ST_CLERK', SALARY + 200, 'SA_MAN', SALARY + 180, 'SA_REP', SALARY + 150, 'IT_PROG', SALARY + 100, SALARY) "인상된 급여"
FROM EMPLOYEES;

SELECT * FROM EMPLOYEES;