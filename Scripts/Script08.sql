/*
 * 이보슬_문제08
 * 1. '컴잘알'동아리와 '독서왕'동아리에 가입한 학생들의 학번, 이름, 나이, 전화번호, 학년, 반, 동아리명, 동아리 담당 교사 을 출력하시오. 
 *   		- INNER JOIN을 사용하여 문제를 해결하도록 한다.
 * 			- STUDENT_TB, LEVEL_TB, CLUB_TB를 사용한다.
 * 
 * 2. '컴잘알' 동아리에 가입한 학생 중 가장 나이 많은 학생의 학생명, 나이, 학년, 반, 담당 교사명 을 출력하시오.
 * 			- JOIN과 서브쿼리를 사용하여 문제를 해결하도록 한다.
 *			- 테이블 세 개를 조인한다.
 *			- 가장 나이 많은 학생을 구할 때 이중 서브쿼리가 필요하다. (만약 다른 방법을 해도 정답이 나온다면 다른 방법을 사용해도 무관)
 * 
 */
SELECT * FROM LEVEL_TB;
SELECT * FROM CLUB_TB;
SELECT * FROM STUDENT_TB;
/*
 * INNER JOIN : 특정 기준으로 매칭된 행들만 추출한다. (A와 B의 교집합)
 * JOIN이라는 키워드는 생략가능하다. 
 * 
 * OUTER JOIN 
 * (1) LEFT JOIN : A LEFT OUTTER JOIN B 인 경우에는 A는 다 출력되고 B는 A에 존재하는 행들만 출력된다. 
 * (2) RIGHT OUTER JOIN :  A LEFT OUTTER JOIN B를 기준으로 출력된다.
 * 
 */

SELECT S.STU_ID
	 , S.STU_NAME
	 , S.STU_AGE 
	 , S.STU_PHONE 
	 , L.LEVEL_NO 
	 , L.CLASS_NO 
	 , C.CLUB_NAME
	 , C.CLUB_TEACHER
  FROM STUDENT_TB S, LEVEL_TB L, CLUB_TB C 
 WHERE S.CLUB_ID = C.CLUB_ID
   AND S.STU_ID = L.STU_ID;

  
 SELECT S.STU_NAME 
 	  , S.STU_AGE 
 	  , L.LEVEL_NO 
 	  , L.CLASS_NO 
 	  , L.STU_TEACHER 
   FROM STUDENT_TB S 
   JOIN CLUB_TB C
     ON C.CLUB_ID = S.CLUB_ID
   JOIN LEVEL_TB L
     ON L.STU_ID = S.STU_ID
  WHERE S.CLUB_ID = (SELECT CLUB_ID
  					  FROM CLUB_TB
  					 WHERE CLUB_NAME = '컴잘알')
  	AND S.STU_AGE = (SELECT MAX(STU_AGE)
  	                   FROM STUDENT_TB 
  	                  WHERE CLUB_ID = (SELECT CLUB_ID
  					  				     FROM CLUB_TB
  					 					WHERE CLUB_NAME = '컴잘알'));
  	
