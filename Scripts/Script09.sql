
/*
 * 1. student_tb 테이블에 값을 추가한다.
 * 		(202207, '아이유', 19, '010-2233-4912', '서울시 광진구', NULL)
 * 		(202208, '강호동', 17, '010-0292-8778', '경기도 파주시', NULL)
 * 		(202209, '김샛별', 19, '010-7789-9072', '서울시 성북구', 2)
 *		(202210, '김영철', 18, '010-9760-5674', '경기도 고양시', NULL)
 * 
 * 2. level_tb 테이블을 삭제한다.
 * 
 * 
 * 3. department_tb(소속) 테이블을 생성한다.
 * 		dept_code (소속 코드)		NUMBER		제약조건 : 기본키 
 * 		dept_evel(학년)			NUMBER		
 * 		dept_class(반)			NUMBER
 * 
 * 4. department 테이블의 값을 추가한다. 
 * 		(1001, 1, 1)	(1002, 1, 2) 	(1003, 1, 3) 		(2001, 2, 1)	(2002, 2, 2)
 *		(2003, 2, 3) 	(3001, 3, 1) 	(3002, 3, 2) 		(3003, 3, 3)
 * 
 * 5. teacher_tb(교사) 테이블을 생성한다. (제약조건명은 테이블명과 컬럼명을 조합하여 짓는다.)
 * 		teacher_id (교사 아이디)	NUMBER  		제약조건 : 기본키
 * 		teacher_name(교사명)	 	VARCHAR(20) 
 * 		subject(과목)				VARCHAR(20) 	
 * 		dept_code(담당 교실)		VARCHAR2(10) 	제약조건 : 외래키 (department_tb의 dept_code를 참조)
 * 		charge_club(담당 동아리)		NUMBER		제약조건 : 외래키 (club_tb 의 club_id를 참조)
 * 
 * 
 * 6. student_tb 테이블에 컬럼을 추가한다. (제약조건명은 테이블명과 컬럼명을 조합하여 짓는다.)
 * 		teacher_id  				NUMBER 			제약조건 : 외래키 (teacher_tb 테이블의 teacher_id 컬럼 참조)
 * 		dept_code					NUMBER			제약조건 : 외래키 (department 테이블의 dept_code 컬럼 참조)
 * 
 * 
 * 7. teacher_tb 테이블의 값을 추가한다.
 * INSERT INTO TEACHER_TB VALUES (1, '한예슬', '국어', '1001', 1);
 * INSERT INTO TEACHER_TB VALUES (2, '공유', '수학', '1002', 2);
 * INSERT INTO TEACHER_TB VALUES (3, '송중기', '영어', '1003', NULL);
 * INSERT INTO TEACHER_TB VALUES (4, '박보영', '과학', '2001', NULL);
 * INSERT INTO TEACHER_TB VALUES (5, '남주혁', '한국사', '2002', NULL);
 * INSERT INTO TEACHER_TB VALUES (6, '김우빈', '물리', '2003', NULL);
 * INSERT INTO TEACHER_TB VALUES (7, '이광수', '체육', '3001', NULL);
 * INSERT INTO TEACHER_TB VALUES (8, '송지효', '음악', '3002', NULL);
 * INSERT INTO TEACHER_TB VALUES (9, '한지민', '미술', '3003', NULL);
 * 
 * 
 * 8. student_tb 테이블에 값을 추가한다.
 * UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1  WHERE STU_NAME = '김태리';
 * UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1 WHERE STU_NAME = '박보검';
 * UPDATE STUDENT_TB SET dept_code = 1002, teacher_id = 2 WHERE STU_NAME = '한소희';
 * UPDATE STUDENT_TB SET dept_code = 1003, teacher_id = 3 WHERE STU_NAME = '강호동';
 * 
 * UPDATE STUDENT_TB SET dept_code = 2001, teacher_id = 4 WHERE STU_NAME = '강동원';
 * UPDATE STUDENT_TB SET dept_code = 2002, teacher_id = 5 WHERE STU_NAME = '김영철';
 * 
 * UPDATE STUDENT_TB SET dept_code = 3001, teacher_id = 7 WHERE STU_NAME = '수지';
 * UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '송강';
 * UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '아이유';
 * UPDATE STUDENT_TB SET dept_code = 3003, teacher_id = 9 WHERE STU_NAME = '김샛별';
 * 
 * 9. STUDENT_TB, DEPARTMENT_TB, TEACHER_TB 테이블을 조인하여 VIEW 테이블을 생성하시오.
 * 		- VIEW 테이블명은 V_STUDENT_TB 로 한다.
 * 		- STU_ID, STU_NAME, STU_PHONE, STU_ADDRESS, TEACHER_NAME, DEPT_LEVEL, DEPT_CLASS 컬럼을 조회한다.
 * 
 * 10. 9번에서 생성한 V_STUDENT 테이블에서 1학년이면서 경기도에 거주하는 학생 정보를 조회하시오.
 * 		- STU_ID, STU_NAME, STU_PHONE, STU_ADDRESS, TEACHER_NAME 컬럼을 조회하시오.
 * 
 */

-- 1번
INSERT INTO STUDENT_TB VALUES  (202207, '아이유', 19, '010-2233-4912', '서울시 광진구', NULL);
INSERT INTO STUDENT_TB VALUES  (202208, '강호동', 17, '010-0292-8778', '경기도 파주시', NULL);
INSERT INTO STUDENT_TB VALUES  (202209, '김샛별', 19, '010-7789-9072', '서울시 성북구', 2);
INSERT INTO STUDENT_TB VALUES  (202210, '김영철', 18, '010-9760-5674', '경기도 고양시', NULL);

-- 2번
DROP TABLE LEVEL_TB;

-- 3번
CREATE TABLE department_tb (
	  dept_code				NUMBER		CONSTRAINT PK_DEPARTMENT_TB_DEPT_CODE PRIMARY KEY
 	, dept_level			NUMBER		
 	, dept_class			NUMBER
);

-- 4번
INSERT INTO DEPARTMENT_TB VALUES (1001, 1, 1);
INSERT INTO DEPARTMENT_TB VALUES (1002, 1, 2);
INSERT INTO DEPARTMENT_TB VALUES (1003, 1, 3);
INSERT INTO DEPARTMENT_TB VALUES (2001, 2, 1);
INSERT INTO DEPARTMENT_TB VALUES (2002, 2, 2);
INSERT INTO DEPARTMENT_TB VALUES (2003, 2, 3);
INSERT INTO DEPARTMENT_TB VALUES (3001, 3, 1);
INSERT INTO DEPARTMENT_TB VALUES (3002, 3, 2);
INSERT INTO DEPARTMENT_TB VALUES (3003, 3, 3);

-- 5번 TEACHER_TB 테이블 생성
CREATE TABLE teacher_tb (
	  teacher_id 		NUMBER			CONSTRAINT PK_TEACHER_TB_TEACHER_ID PRIMARY KEY
	, teacher_name		VARCHAR(20)	
	, subject 			VARCHAR(20)
	, dept_code			NUMBER		CONSTRAINT FK_TEACHER_TB_DEPT_CODE REFERENCES DEPARTMENT_TB(DEPT_CODE)
	, charge_club		NUMBER
);

-- 6번 TEACHER_TB 테이블에 컬럼추가
ALTER TABLE STUDENT_TB ADD (dept_code NUMBER CONSTRAINT FK_STUDENT_TB_DEPT_CODE REFERENCES DEPARTMENT_TB(DEPT_CODE));
ALTER TABLE STUDENT_TB ADD (teacher_id NUMBER CONSTRAINT FK_STUDENT_TB_TEACHER_ID REFERENCES TEACHER_TB(TEACHER_ID));

-- 추가하는 거 깜빡해서 나는 여기로 넣었습니다..ㅎ후ㅜ
ALTER TABLE TEACHER_TB MODIFY CHARGE_CLUB CONSTRAINT FK_TEACHER_TB_CHARGE_CLUB REFERENCES CLUB_TB(CLUB_ID);

-- 테이블 확인
SELECT * FROM STUDENT_TB;
SELECT * FROM CLUB_TB; 
SELECT * FROM DEPARTMENT_TB;
SELECT * FROM TEACHER_TB;

-- 7번 teacher_tb 테이블에 값 추가
INSERT INTO TEACHER_TB VALUES (1, '한예슬', '국어', '1001', 1);
INSERT INTO TEACHER_TB VALUES (2, '공유', '수학', '1002', 2);
INSERT INTO TEACHER_TB VALUES (3, '송중기', '영어', '1003', NULL);
INSERT INTO TEACHER_TB VALUES (4, '박보영', '과학', '2001', NULL);
INSERT INTO TEACHER_TB VALUES (5, '남주혁', '한국사', '2002', NULL);
INSERT INTO TEACHER_TB VALUES (6, '김우빈', '물리', '2003', NULL);
INSERT INTO TEACHER_TB VALUES (7, '이광수', '체육', '3001', NULL);
INSERT INTO TEACHER_TB VALUES (8, '송지효', '음악', '3002', NULL);
INSERT INTO TEACHER_TB VALUES (9, '한지민', '미술', '3003', NULL);


-- 8번 STUDENT_TB 테이블에 컬럼 값 추가
UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1  WHERE STU_NAME = '김태리';
UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1 WHERE STU_NAME = '박보검';
UPDATE STUDENT_TB SET dept_code = 1002, teacher_id = 2 WHERE STU_NAME = '한소희';
UPDATE STUDENT_TB SET dept_code = 1003, teacher_id = 3 WHERE STU_NAME = '강호동';

UPDATE STUDENT_TB SET dept_code = 2001, teacher_id = 4 WHERE STU_NAME = '강동원';
UPDATE STUDENT_TB SET dept_code = 2002, teacher_id = 5WHERE STU_NAME = '김영철';

UPDATE STUDENT_TB SET dept_code = 3001, teacher_id = 7 WHERE STU_NAME = '수지';
UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '송강';
UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '아이유';
UPDATE STUDENT_TB SET dept_code = 3003, teacher_id = 9 WHERE STU_NAME = '김샛별';


-- 9번 

CREATE OR REPLACE VIEW V_STUDENT_TB
AS SELECT ST.STU_ID
		, ST.STU_NAME 
		, ST.STU_PHONE 
		, DT.DEPT_LEVEL
		, DT.DEPT_CLASS
		, CT.CLUB_NAME
		, CT.CLUB_TEACHER
	 FROM STUDENT_TB ST
	 JOIN DEPARTMENT_TB DT 
	   ON ST.DEPT_CODE = DT.DEPT_CODE
	 JOIN TEACHER_TB TT
	   ON ST.TEACHER_ID = TT.TEACHER_ID
	 JOIN CLUB_TB CT 
	   ON ST.CLUB_ID = CT.CLUB_ID;
	   
SELECT * FROM V_STUDENT_TB;

-- 조인 뷰에 의하여 하나 이상의 기본 테이블을 수정할 수 없다.
CREATE OR REPLACE VIEW V_STUDENT_TB
AS SELECT ST.STU_ID
		, ST.STU_NAME 
		, ST.STU_PHONE 
		, ST.STU_ADDRESS 
		, TT.TEACHER_NAME
		, DT.DEPT_LEVEL
		, DT.DEPT_CLASS
	 FROM STUDENT_TB ST
	 LEFT JOIN DEPARTMENT_TB DT 
	USING (DEPT_CODE)
	 LEFT JOIN TEACHER_TB TT
	USING (TEACHER_ID);

SELECT * FROM V_STUDENT_TB ORDER BY 1;
-- 1학년 학생 중 STU_ADDRESS는 경기도만 출력
SELECT STU_ID
	 , STU_NAME
	 , STU_PHONE
	 , STU_ADDRESS
	 , TEACHER_NAME
  FROM V_STUDENT_TB
 WHERE DEPT_LEVEL = 1
   AND STU_ADDRESS LIKE '%경기도%';
