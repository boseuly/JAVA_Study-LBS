
/* 이보슬_문제06
 * 
 * <테이블 삭제>
 * 1. STUDENT, STUDENT_LEVEL, STUDENT_CLUB 테이블을 삭제하시오.
 * 
 * 
 * <테이블 생성>
 * "모든 제약조건명은 테이블명과 컬럼명 조합해서 짓는다."
 * 1. level_tb(학년) 테이블을 생성하시오. 
 * 		- stu_id(학번) 	-> 자료형 : NUMBER			제약조건 -> PRIMARY KEY
 * 		- level_no(학년)	-> 자료형 : NUMBER 			DEFAULT(1)
 * 		- class_no(반)	-> 자료형 : NUMBER
 * 
 * 2. club_tb 테이블을 생성하시오.
 * 		- club_id(동아리id)		-> 자료형 : NUMBER 		제약조건 -> PRIMARY KEY
 * 		- club_name(동아리명) 		-> 자료형 : VARCHAR2(30)	제약조건 -> UNIQUE
 * 		- club_president(회장)	-> 자료형 : VARCHAR2(10)
 * 		- club_total(총인원)		-> 자료형 : NUMBER
 * 		- club_teacher(담당선생님)	-> 자료형 : VARCHAR2(10)
 * 		
 * 
 * 3. student_tb 테이블을 생성하시오.
 * 	    - stu_id(학번) 			-> 자료형 : NUMBER  				제약조건 -> PRIMARY KEY
 * 		- stu_name(학생명)		-> 자료형 : VARCHAR2(10)	
 * 		- stu_age(나이)			-> 자료형 : NUMBER				제약조건 -> CHECK : 값이 17,18,19 중 하나인지 확인
 * 		- stu_phone(전화번호)		-> 자료형 : VARCHAR2(20)			제약조건 -> CHECK : 전화번호 형식이 010-0000-0000 형식인지 확인
 * 		- stu_address(주소)		-> 자료형 : VARCHAR2(50)
 * 		- club_id(동아리id)		-> 자료형 : NUMBER				제약조건 -> FOREIGN KEY : club_tb 테이블의 club_id를 참조
 * 
 * <값 추가>

 * 1. level_tb 테이블
 * 		- 학번 : 202201, 학년 : 1, 반 : 1
 * 		- 학번 : 202202, 학년 : 2, 반 : 2
 * 		- 학번 : 202203, 학년 : 3, 반 : 2
 * 		- 학번 : 202204, 학년 : 1, 반 : 2
 *		- 학번 : 202205, 학년 : 3, 반 : 3 
 * 		- 학번 : 202206, 학년 : 1, 반 : 1
 * 
 * 2. club_tb 테이블
 * 		- 동아리id : 1, 동아리명 : '컴잘알', 회장 : '김태리', 총인원 : 3명, 한예슬
 * 		- 동아리id : 2, 동아리명 : '독서왕', 회장 : '박보검', 총인원 : 2명, 공유
 * 
 * 3. student_tb 테이블
 * 		- 학번 : 202201, 학생명 : 김태리, 나이 : 17, 전화번호 : 010-1234-5678, 주소 : 서울시 강남구, 동아리id : 1
 * 		- 학번 : 202202, 학생명 : 강동원, 나이 : 18, 전화번호 : 010-1212-1212, 주소 : 서울시 마포구, 동아리id : 1
 * 		- 학번 : 202203, 학생명 : 수지 , 나이 : 19, 전화번호 : 010-0909-0110, 주소 : 서울시 영등포구, 동아리id : 2
 * 		- 학번 : 202204, 학생명 : 박보검, 나이 : 17, 전화번호 : 010-3040-5060, 주소 : 서울시 마포구, 동아리id : 2
 * 		- 학번 : 202205, 학생명 : 송강, 	 나이 : 19, 전화번호 : 010-9112-2323, 주소 : 경기도 하남시, 동아리id : 1
 * 		- 학번 : 202206, 학생명 : 한소희, 나이 : 17, 전화번호 : 010-6233-6970, 주소 : 경기도 구리시
 * 
 */


-- 테이블 삭제
DROP TABLE T_LEVEL; 
DROP TABLE T_CLUB; 
DROP TABLE T_STUDENT;
SELECT * FROM student_tb; SELECT * FROM level_tb; SELECT * FROM club_tb;
-- 테이블 생성
CREATE TABLE level_tb (
	  stu_id 		NUMBER			CONSTRAINT PK_LEVEL_TB_STU_ID PRIMARY KEY 
	, level_no		NUMBER 			DEFAULT(1)
 	, class_no		NUMBER 
);

CREATE TABLE club_tb (
	  club_id			NUMBER 			CONSTRAINT PK_CLUB_TB_CLUB_ID PRIMARY KEY
	, club_name 		VARCHAR2(30)	CONSTRAINT UQ_CLUB_TB_CLUB_NAME UNIQUE
	, club_president	VARCHAR2(10)
	, club_total		NUMBER
	, club_teacher		VARCHAR2(10)
);

CREATE TABLE student_tb (
	  stu_id		NUMBER			CONSTRAINT PK_STUDENT_TB_STU_ID PRIMARY KEY
	, stu_name		VARCHAR2(10)	
	, stu_age		NUMBER			CONSTRAINT CK_STUDENT_TB_STU_AGE CHECK(stu_age IN (17,18,19))
	, stu_phone		VARCHAR2(20)	
	, stu_address	VARCHAR2(50)	
	, club_id		NUMBER			CONSTRAINT FK_STUDENT_TB_CLUB_ID REFERENCES club_tb(club_id)
);	

SELECT * FROM level_tb; SELECT * FROM club_tb; SELECT * FROM student_tb;

-- level_tb 테이블 값추가
INSERT INTO level_tb
VALUES(202201, 1, 1);
INSERT INTO level_tb
VALUES(202202, 2, 2);
INSERT INTO level_tb
VALUES(202203, 3, 2);
INSERT INTO level_tb
VALUES(202204, 1, 2);
INSERT INTO level_tb
VALUES(202205, 3, 3);
INSERT INTO level_tb
VALUES(202206, 1, 1);

-- club_tb 테이블 값추가
INSERT INTO club_tb
VALUES (1,'컴잘알', '김태리', 3, '한예슬');
INSERT INTO club_tb
VALUES (2,'독서왕', '박보검', 2, '공유');


-- student_tb 값추가
INSERT INTO student_tb
VALUES(202201, '김태리', 17, '010-1234-5678', '서울시 강남구', 1);
INSERT INTO student_tb
VALUES(202202, '강동원', 18, '010-1212-1212', '서울시 마포구', 1);
INSERT INTO student_tb
VALUES(202203, '수지', 19, '010-0909-0110', '서울시 영등포구', 2);
INSERT INTO student_tb
VALUES(202204, '박보검', 17, '010-3040-5060', '서울시 마포구', 2);
INSERT INTO student_tb
VALUES(202205, '송강', 19, '010-9112-2323', '경기도 하남시', 1);
INSERT INTO student_tb(stu_id, stu_name, stu_age, stu_phone, stu_address)
VALUES(202206, '한소희', 17, '010-6233-6970', '경기도 구리시');

