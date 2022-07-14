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
-- '컴잘알'동아리와 '독서왕'동아리에 가입한 학생들의 학번, 이름, 나이, 전화번호, 학년, 반, 동아리명, 동아리 담당 교사 을 출력하시오. 
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
  
-- '컴잘알' 동아리에 가입한 학생 중 가장 나이 많은 학생의 학생명, 나이, 학년, 반, 담당 교사명 을 출력하시오.
-- WITH 를 사용하는 법도 있다.반복되는 서브쿼리를 줄이기 위해서 사용됨
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
  	AND S.STU_AGE = (SELECT MAX(STU_AGE)   -- 동아리명이 컴잘알인 사람들 중 가장 나이가 많은 사람의 나이를 가지고 옴
  	                   FROM STUDENT_TB 
  	                  WHERE CLUB_ID = (SELECT CLUB_ID
  					  				     FROM CLUB_TB
  					 					WHERE CLUB_NAME = '컴잘알'));
  	

/*
 * 홍유라_문제08
 * 
 * 1. student_t 테이블과 score_t 을 JOIN 하여 사진과 같이
 * 	  stu_id, stu_name, class_name, score_avg, stu_gpa 를 조회하시오. [사진1]
 *    - stu_gpa 는 CASE WHEN ... THEN 문법을 사용하며
 *    	score_avg 가 100 이하, 90 이상일 경우 'A'
 * 		90 미만, 80 이상일 경우 'B'
 * 		80 미만, 70 이상일 경우 'C'
 * 		70 미만, 60 이상일 경우 'D'
 * 		60 미만일 경우 'F' 그 외는 ''로 처리한다.
 * 
 * 2. 전학생 2명이 왔다.
 * 	  student_t 테이블과 score_t 테이블에 값을 추가하시오.
 * 	  student_t - (2206, '장인서', NULL, '여', NULL), (2207, '서준영', NULL, '남', NULL)
 * 	  score_t   - 학번은 위와 동일하며 모든 시험은 아직 보지 않았다. [사진2-1] [사진2-2]
 * 
 * 3. student_t 와 score_t 테이블의 모든 행들을 조회하시오.
 *    단, class_name 을 기준으로 오름차순으로 조회되게 한다. [사진3]
 */
SELECT * FROM STUDENT_T;
SELECT * FROM SCORE_T;

-- 1번
SELECT ST.STU_ID
  	 , ST.STU_NAME 
  	 , ST.CLASS_NAME
	 , SC.SCORE_AVG
	 , CASE WHEN SC.SCORE_AVG >= 90 AND SC.SCORE_AVG <=100 THEN 'A'
	        WHEN SC.SCORE_AVG >= 80 AND SC.SCORE_AVG < 90 THEN 'B'
	      	WHEN SC.SCORE_AVG >= 70 AND SC.SCORE_AVG < 80 THEN 'C'
	      	WHEN SC.SCORE_AVG >= 60 AND SC.SCORE_AVG < 70 THEN 'D'
	      	WHEN SC.SCORE_AVG >= 50 AND SC.SCORE_AVG < 60 THEN 'E'
	      	WHEN SC.SCORE_AVG < 60 THEN 'F'
	      	ELSE '' 
	      	END AS STU_GPA
  FROM STUDENT_T ST
  JOIN SCORE_T SC
    ON ST.STU_ID = SC.STU_ID;

-- 2번
INSERT INTO STUDENT_T VALUES (2206, '장인서', NULL, '여', NULL);
INSERT INTO STUDENT_T VALUES (2207, '서준영', NULL, '남', NULL);

INSERT INTO SCORE_T(STU_ID) VALUES (2206);
INSERT INTO SCORE_T(STU_ID) VALUES (2207);

-- 3번 
SELECT * 
  FROM STUDENT_T ST
  JOIN SCORE_T SC 
    ON ST.STU_ID = SC.STU_ID 
 ORDER BY CLASS_NAME ASC;
COMMIT;
/*
 * <김규연>
 * 1. 두 개의 테이블을 생성하세요
 * 		(1) 기사정보(pastry_chef_tb) 테이블을 생성하고 각 컬럼명, 자료형, 제약조건, 제약조건명을 부여하세요.
 * 			 - 제품번호(bread_id, 숫자)
 * 			 - 빵담당기사(pc_name, VARCHAR2(20), NOT NULL)
 * 			 - 담당기사 주소(pc_address, VARCHAR2(50))
 * 			 - 담당기사 전화번호(pc_phone, VARCHAR2(20), CHECK('010'을 포함하고 있는지 확인))
 *  		 - 담당기사 고용일(pc_hiredate, DATE, 기본값(오늘날짜))
 * 			 - 회사 이름(pc_company, VARCHAR2(20), NOT NULL)
 * 			 - 외래키를 이용하여 company_tb의 company_name을 참조할 수 있도록 하세요.
 * 			 - 외래키를 이용하여 bread_tb의 bread_id를 참조할 수 있도록 하세요.
 * 
 * 		(2) 회사 정보(company_tb) 테이블을 생성하고 각 컬럼명, 자료형, 제약조건, 제약조건명을 부여하세요.
 * 			 - 회사이름(company_name, VARCHAR2(20), 기본키)
 * 			 - 회사 주소(company_address, VARCHAR2(50), UNIQUE)
 * 			 - 회사 전화번호(company_address, VARCHAR2(20), UNIQUE)
 * 
 * 2. 다음의 값들을 추가하세요.
 * 		(1) company_tb 애 다음 값들을 추가하세요.
 * 			 - (  뚜레쥬르,  부산시 연제구, 051-439-1532)
 * 			 - (파리바게트,   서울시 강남구, 02-568-8756)
 *			 - (   성심당, 대구광역시 남구, 053-854-4594)
 * 			 - (  자연드림,  제주시 구좌읍, 064-359-2588)
 * 		(2) pastry_chef_tb 에 다음 값들을 추가하세요.
 * 			 - (1, 김담이, 경기도 안산시 단원구, 010-5466-8892, 20120506, 뚜레쥬르);
 *			 - (2, 송강호,   대구광역시 달서구, 010-4372-8577, 19950102, 파리바게트);
 *			 - (3, 최우식, 경기도 안산시 단원구, 010-7534-3257, 19941125, 파리바게트);
 *			 - (3, 신민아,  서울특별시 동대문구, 010-5534-5687, 19941125, 뚜레쥬르);
 *			 - (5, 조정석,   대구광역시 수성구, 010-6379-9656, 20190718, 성심당);
 * 			 - (6, 유연석, 부산광역시 해운대구,  010-1256-3658,  20210607, 자연드림);
 *			 - (7, 유연석,    충청남도 천안시,             '', 20220309, 자연드림);
 *
 * 3. JOIN을 이용하여 다음 조건에 맞춰서 조회하세요.
 * 		- bread_tb 와 pastry_chef_tb 와 company_tb 테이블을 서로 조인하세요.
 * 		- 다음의 컬럼들이 조회되게 하고 각각의 컬럼에 별칭을 부여해주세요.
 * 				제품번호 -> 현재 년도 + bread_id
 * 				빵이름 -> bread_name
 * 				빵담당기사 -> pc_name
 * 				담당기사 주소 -> pc_address
 * 				담당기사 전화번호 -> pc_phone(해당 값이 NULL 이면 010-0000-0000 이 출력되도록 하세요)
 * 				담당기사 고용일 -> pc_hiredate
 * 				회사 이름 -> company_name
 * 				회사 주소 -> company_address
 * 				회사 전화번호 -> company_phone
 * 		- 담당기사 고용일이 2000년도 이상인 것들만 조회되도록 하세요.
 */


-- 1번				 	
CREATE TABLE pastry_chef_tb (
	  bread_id 		NUMBER	
	, pc_name 		VARCHAR2(20)	 CONSTRAINT NN_PASTRY_CHEF_TB_PC_NAME NOT NULL
	, pc_address	VARCHAR2(50)
	, pc_phone		VARCHAR2(20) 	 CONSTRAINT CK_PASTRY_CHEF_TB_PC_PHONE CHECK(SUBSTR(pc_phone, 0,3)= '010')
	, pc_hiredate	DATE			 DEFAULT(SYSDATE)
	, pc_company 	VARCHAR2(20)	 CONSTRAINT NN_PASTRY_CHEF_TB_PC_COMPANY NOT NULL
	, CONSTRAINT FK_PASTRY_CHEF_TB_PC_COMPANY FOREIGN KEY(pc_company) REFERENCES company_tb(company_name)
	, CONSTRAINT FK_PASTRY_CHEF_TB_BREAD_ID FOREIGN KEY(bread_id) REFERENCES bread_t(bread_id)
);
CREATE TABLE company_tb(
	  company_name 		VARCHAR2(20) 	CONSTRAINT PK_COMPANY_TB_COMPANY_NAME PRIMARY KEY
	, company_address 	VARCHAR2(50) 	CONSTRAINT UQ_COMPANY_TB_COMPANY_ADDRESS UNIQUE
	, company_phone 	VARCHAR2(20) 	CONSTRAINT UQ_COMPANY_TB_COMPANY_PHONE UNIQUE
	);
-- 2번
INSERT INTO company_tb VALUES ( '뚜레쥬르', 	'부산시 연제구', 	'051-439-1532');
INSERT INTO company_tb VALUES ( '파리바게트',	'서울시 강남구', 	'02-568-8756');
INSERT INTO company_tb VALUES ( '성심당',  	'대구광역시 남구', 	'053-854-4594');
INSERT INTO company_tb VALUES ( '자연드림', 	'제주시 구좌읍', 	'064-359-2588');

INSERT INTO pastry_chef_tb VALUES (1, '김담이', 	'경기도 안산시 단원구', 	'010-5466-8892', 	'20120506', '뚜레쥬르');
INSERT INTO pastry_chef_tb VALUES (2, '송강호',  	'대구광역시 달서구', 	'010-4372-8577', 	'19950102', '파리바게트');
INSERT INTO pastry_chef_tb VALUES (3, '최우식', 	'경기도 안산시 단원구', 	'010-7534-3257', 	'19941125', '파리바게트');
INSERT INTO pastry_chef_tb VALUES (4, '신민아',  	'서울특별시 동대문구', 	'010-5534-5687', 	'19941125', '뚜레쥬르');
INSERT INTO pastry_chef_tb VALUES (5, '조정석',  	'대구광역시 수성구', 	'010-6379-9656', 	'20190718', '성심당');
INSERT INTO pastry_chef_tb VALUES (6, '유연석', 	'부산광역시 해운대구',  	'010-1256-3658',  	'20210607',	'자연드림');
INSERT INTO pastry_chef_tb VALUES (7, '유연석',  	'충청남도 천안시',             		 '', 	'20220309', '자연드림');
COMMIT;

-- 3번
SELECT CONCAT(EXTRACT(YEAR FROM SYSDATE), B.BREAD_ID) 제품번호
	 , B.BREAD_NAME "빵이름"
	 , P.PC_NAME "빵담당기사"
	 , P.PC_ADDRESS "담당기사주소"
	 , NVL(P.PC_PHONE,'010-0000-0000') "담당기사전화번호"
	 , P.PC_HIREDATE  "담당기사고용일"
	 , C.COMPANY_NAME "회사이름"
	 , C.COMPANY_ADDRESS "회사주소"
	 , C.COMPANY_PHONE "회사 전화번호"
  FROM BREAD_T B
  JOIN PASTRY_CHEF_TB P  
    ON B.BREAD_ID = P.BREAD_ID
  JOIN COMPANY_TB C
    ON P.PC_COMPANY = C.COMPANY_NAME 
 WHERE P.PC_HIREDATE >= '20000101';


/*
 * 김재은_문제08
 * 
 * 1. emp_mart_tb에 hire_date 컬럼을 추가하시오. (자료형 date)
 * 2. 각 매니저별로 입사일을 추가하시오.
 *   (김봉지 => 2021-10-10), (최박스 => 2020-04-30), (다니엘소스 => 2022-02-13)
 *   (오젤리 => 2022-04-13), (이민트 => 2020-12-20), (윤아리 => 2019-09-29)
 * 3. 각 테이블에 값을 추가하시오.
 * 	  - mart_tb 에 ('손소독제', 4000, '배스앤바디웍', '바디용품', 'O', 3231, 7)
 *    - emp_mart_tb ('한세정', 4300, 7, '2018-07-05')
 * 4. JOIN을 이용하여 emp_mart_tb의 name과 hire_date, mart_tb의 kind을 출력하시오.
 *    이때, 조건을 emp_mart_tb의 manage_sort와 mart_tb의 sort가 같은값으로 찾을 수 있도록 지정하시오.
 *    - hire_date는 00년 00월 00일 형식으로 출력되게 하시오.
 * 	  - 각 별칭은 사진을 참조하시오.
 * 5. 테이블명 변경에 따라 제약조건명을 변경해준다.
 *    - mart_tb에서 (CK_MART_T_POSSIBLE => CK_MART_TB_POSSIBLE), (PK_MART_T_SORT => PK_MART_TB_SORT)
 * 	  - emp_mart_tb에서 (FK_EMP_MART_T_MANAGE_SORT => FK_EMP_MART_TB_MANAGE_SORT)
 */
SELECT * FROM EMP_MART_TB;
SELECT * FROM MART_TB;

SELECT * FROM EMP_MART_TB;
-- 1번 2번 
ALTER TABLE EMP_MART_TB ADD (HIRE_DATE DATE);
UPDATE EMP_MART_TB SET HIRE_DATE = '20211010' WHERE NAME = '김봉지';
UPDATE EMP_MART_TB SET HIRE_DATE = '2020-04-30' WHERE NAME = '최박스';
UPDATE EMP_MART_TB SET HIRE_DATE = '2022-02-13' WHERE NAME = '다니엘소스';
UPDATE EMP_MART_TB SET HIRE_DATE = '2022-04-13' WHERE NAME = '오젤리';
UPDATE EMP_MART_TB SET HIRE_DATE = '2020-12-20' WHERE NAME = '이민트';
UPDATE EMP_MART_TB SET HIRE_DATE = '2019-09-29' WHERE NAME = '윤아리';

-- 3번
INSERT INTO MART_TB	 	VALUES ('손소독제', 4000, '배스앤바디웍', '바디용품', 'O', 3231, 7);
INSERT INTO emp_mart_tb VALUES ('한세정', 4300, 7, '2018-07-05');

UPDATE EMP_MART_TB SET HIRE_DATE = '2021-10-10' WHERE NAME = '김봉지';
UPDATE EMP_MART_TB SET HIRE_DATE = '2020-04-30' WHERE NAME = '최박스';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MART_TB';
-- 4번
SELECT EM.NAME 매니저이름
	 , M.KIND 담당상품
	 , TO_CHAR(EM.HIRE_DATE, 'YY"년" MM"월" DD"일"') 고용일
  FROM EMP_MART_TB EM
  JOIN MART_TB M
    ON EM.MANAGE_SORT = M.SORT;
  
-- 5번
ALTER TABLE MART_TB RENAME CONSTRAINT CK_MART_T_POSSIBLE TO CK_MART_TB_POSSIBLE;
ALTER TABLE MART_TB RENAME CONSTRAINT PK_MART_T_SORT TO PK_MART_TB_SORT;

ALTER TABLE EMP_MART_TB RENAME CONSTRAINT FK_EMP_MART_T_MANAGE_SORT TO FK_EMP_MART_TB_MANAGE_SORT;

COMMIT;

