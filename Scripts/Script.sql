/*
 * 이보슬_문제03
 * - HIRE_DATE를 고용년대별로 묶고, COMMISSION이 있으면 'O', 없으면 'X'로 출력되도록 하시오. (ROLLUP을 이용하여 그룹 지어준다.)
 * - 그룹별 급여의 평균과 인원을 구하시오. 
 * - 단, 평균은 10의 자리에서 절삭하시오.
 * - 출력해야 할 컬럼은 아래 사진 참고
 * 
 */

SELECT * FROM EMPLOYEES; 

SELECT TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1) HIRE_DATE
	 , DECODE(COMMISSION_PCT, NULL, 'X', 'O') COMMISSION_PCT
	 , TRUNC(AVG(SALARY), -2) SALARY_AVG
	 , COUNT(*)
FROM EMPLOYEES
GROUP BY ROLLUP(TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1), DECODE(COMMISSION_PCT, NULL, 'X', 'O'));


/*
 * 홍유라_문제03
 * - EMPLOYEES 테이블에서 DEPARTMENT_ID 별 인원과 SALARY의 합계와 평균을 조회하시오.
 * 	 (부서가 NULL 인 사람은 제외하고, 부서 별 SALARY의 합계와 평균은 모든 소수점을 절삭한다.)
 * - 이때 부서 별 인원이 5명 이상이고, 부서 별 급여 평균이 5000 이상인 부서만 조회하시오.
 * - 부서ID 를 기준으로 오름차순 정렬하여 조회하시오.
 * - 모든 컬럼에 한글로 별칭을 부여한다.(결과 사진 참고)
 */
SELECT * FROM EMPLOYEES;

SELECT DEPARTMENT_ID 부서ID
	 , COUNT(*) "부서 인원"
	 , TRUNC(SUM(SALARY),0) "부서별 급여 합계"
	 , TRUNC(AVG(SALARY),0) "부서별 급여 평균"
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) >= 5 AND AVG(SALARY) >= 5000
ORDER BY DEPARTMENT_ID ASC;

/* 김규연_문제03
 * 
 * MANAGER_ID와 JOB_ID를 이용해 내가 변경한 직업을 집계한다.
 *
 * 직업의 경우 앞에 두자리만 같으면 다 같은 직업으로 보이게 한다.
 * EX) AD_PRES와 AD_VP -> AD
 * (별칭은 "직업"이라고 칭한다)
 * 
 * 위에서 구한 직업과 MANAGER_ID를 그룹으로 묶는데 
 * 가능한 모든 조합 별로 집계한 결과가 나오게 한다.
 * 
 * 관리자가 관리하는 각 직업의 수와 전체 직업 수가 조회되도록 한다.
 * MANAGER_ID를 기준으로 오름차순으로 정렬이 되게 한다.
 */
SELECT * FROM EMPLOYEES;

SELECT MANAGER_ID 
	 , SUBSTR(JOB_ID,1,2) 직업
	 , COUNT(*) 총수 
FROM EMPLOYEES
GROUP BY CUBE(MANAGER_ID, SUBSTR(JOB_ID,1,2))
ORDER BY MANAGER_ID;


/*
 * 김재은_문제03
 * 
 * JOB_HISTORY 테이블에서 JOB_ID의 앞에 두 글자를 기준으로 GROUP으로 묶어서 나타내세요.
 *   - 각 그룹별로 몇명인지 나타내세요 (별칭 : 인원수)
 *   - 각 그룹별로 START_DATE에서 년도의 평균을 반올림해서 나타내세요(별칭 : 평균시작년도)
 *   - 각 그룹별로 END_DATE에서 년도의 평균을 반올림해서 나타내세요(별칭 : 평균퇴사년도)
 * 	 - 각 그룹내에서 EMPLOYEE_ID의 값이 가장 작은것을 출력하세요 (별칭: MIN_EMP)
 * 이때, 인원수를 기준으로 오름차순으로 정렬하세요.
 * (마지막줄에는 전체 그룹에 대한 집계결과를 반환하도록 해야한다. *결과사진참고)
 */

SELECT COUNT(*) 인원수
	 , SUBSTR(JOB_ID,1,2) 직업코드
	 , ROUND(AVG(EXTRACT(YEAR FROM START_DATE)) ,1) 평균시작년도
	 , ROUND(AVG(EXTRACT(YEAR FROM END_DATE)) ,1) 평균퇴사년도
	 , MIN(EMPLOYEE_ID) MIN_EMP
FROM JOB_HISTORY
GROUP BY ROLLUP(SUBSTR(JOB_ID,1,2))
ORDER BY COUNT(*);



/* 김경욱_문제03
 * 
 * employees 테이블에서 직책별 직원 수, 최대급여, 최소급여, 평균급여를 
 * 소수점 아래 첫째 자리까지 구하기 
 * 직책별로나열하시오.
 *
 */

SELECT JOB_ID 직책
	 , COUNT(*)
	 , TRUNC(MAX(SALARY), 1) 최대급여
	 , TRUNC(MIN(SALARY), 1) 최소급여
	 , TRUNC(AVG(SALARY), 1) 평균급여
FROM EMPLOYEES
GROUP BY JOB_ID;



