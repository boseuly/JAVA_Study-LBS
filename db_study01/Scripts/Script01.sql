/*
 * 이보슬 문제
 * EMPLOYEES 테이블에서 2000년대 이후에 고용되었으며 SALARY가 5000이상인 사람들의 모든 정보를 출력하시오.
 * 	- FIRST_NAME과 LAST_NAME 은 NAME으로 출력한다. 
 * 	- PHONE_NUMBER 는 '.' 대신 '-'으로 출력한다.
 *   
 */
SELECT * FROM EMPLOYEES;
SELECT EMPLOYEE_ID
	 , FIRST_NAME||LAST_NAME NAME
	 , EMAIL
	 , REPLACE(PHONE_NUMBER,'.','-') PHONE_NUMBER
	 , HIRE_DATE
	 , JOB_ID
	 , SALARY
	 , COMMISSION_PCT
	 , MANAGER_ID
	 , DEPARTMENT_ID
FROM EMPLOYEES
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2000 
 	  AND SALARY >= 5000;
/*
 * 홍유라 문제 
 */

/*
 * 김규연 문제 
 */


/*
 * 김재은 문제
 */


/*
 * 김경욱 문제 
<<<<<<< HEAD
 */ 
=======
 */
>>>>>>> branch 'main' of https://github.com/boseuly/Study_LBS.git
