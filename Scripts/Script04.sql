/*
 * 이보슬_문제04
 * 
 * 간단한 학생 관리 테이블을 생성해본다.
 *
 * <STUDENT 테이블>
 * 1. STUDENT 테이블에는 STU_NO, STU_NAME 컬럼을 생성한다. (글자는 10자 이상으로 한다.)
 * 		- 컬럼타입은 <STUDENT 테이블 생성 사진>을 확인한다.
 * 		- STU_NO은 제약조건을 PRIMARY KEY로 설정하고, STU_NAME은 NOT NULL로 설정한다. (제약조건명은 따로 설정하지 않는다.)
 * 		- STUDENT 테이블의 STU_NO 컬럼은 STUDENT_LEVEL 테이블의 STU_NO 컬럼을 참조하도록 한다.  
 * 2. 테이블 생성이 끝난 뒤
 * 		- STU_NO의 PRIMARY KEY 제약조건명을 PK_STUDENT_STU_NO 으로 변경해준다.
 * 		- STU_NO의 FOREIGN KEY 제약조건명을 FK_STUDENT_STU_NO 으로 변경해준다.
 * 	 	- STU_NAME의 NOT NULL 제약조건명은 NN_STUDENT_STU_NAME 으로 변경해준다. <STUDENT 테이블 제약조건 사진> 참고
 * 
 *  <STUDENT_LEVEL 테이블>
 * 1. STUDENT_LEVEL 테이블은 STU_NO, LEVEL_NO, CLASS, TEACHER 컬럼을 갖도록 한다. (제약조건은 따로 설정하지 않는다.)
 * 		- STU_NO 컬럼에 PRIMARY KEY 제약조건을 설정해주고 제약조건명은 PK_STUDENT_LEVEL_STU_NO 로 지어준다.
 * 		- 컬럼타입은 <STUDENT_LEVEL 테이블 생성 사진>을 확인한다.
 * 2. 테이블 생성이 끝난 뒤 
 * 		- LEVEL_NO 컬럼에는 값이 1,2,3만 들어올 수 있도록 CHECK 제약조건을 추가해주고 제약조건명은 CK_STUDENT_LEVEL_LEVEL_NO 로 지어준다.
 * 
 */

-- 1. STUDENT 테이블 생성
CREATE TABLE STUDENT (
	  STU_NO NUMBER 		PRIMARY KEY
	, STU_NAME VARCHAR2(30)	NOT NULL
	, FOREIGN KEY (STU_NO) REFERENCES STUDENT_LEVEL(STU_NO)
);

-- 2. 제약조건명 변경
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'STUDENT_LEVEL';
ALTER TABLE STUDENT RENAME CONSTRAINT SYS_C0010196 TO NN_STUDENT_STU_NAME;
ALTER TABLE STUDENT RENAME CONSTRAINT SYS_C0010197 TO PK_STUDENT_STU_NO;
ALTER TABLE STUDENT RENAME CONSTRAINT SYS_C0010198 TO FK_STUDENT_STU_NO;

-- 1. STUDENT_LEVEL 테이블 생성
CREATE TABLE STUDENT_LEVEL( 
	  STU_NO NUMBER		CONSTRAINT PK_STUDENT_LEVEL_STU_NO PRIMARY KEY 
	, LEVEL_NO NUMBER 
	, CLASS NUMBER
	, TEACHER VARCHAR2(30)
);

ALTER TABLE STUDENT_LEVEL MODIFY LEVEL_NO CONSTRAINT CK_STUDENT_LEVEL_LEVEL_NO CHECK(LEVEL_NO BETWEEN 1 AND 3);





/*
 * 홍유라_문제04
 * 학생 정보를 관리하는 테이블인 student_t 테이블과
 * 과목 정보를 관리하는 테이블인 subject_t 테이블을 만들어 본다.
 *  1. student_t 테이블
 * 		- 아래의 사진을 참고하여 컬럼명과 데이터 타입을 설정한다.
 * 		  (데이터 타입 크기 : stu_id - 없음	/ stu_name - 20 / class_name - 20)
 * 
 * 		- 아래의 사진을 참고하여 모든 컬럼에 주석(코멘트)을 달아준다.
 * 
 * 		- stu_id 객체를 식별값으로 사용하며 stu_name 은 NULL 값을 허용하지 않도록 한다.
 * 		  (단, 제약조건 설정 시 암묵적으로 정해진 제약조건명을 부여하도록 한다.
 * 		   제약조건은 컬럼 레벨, 테이블 레벨 상관 없이 설정한다.)
 * 
 *  2. subject_t 테이블
 * 		- 아래의 사진을 참고하여 컬럼명과 데이터 타입을 설정한다.
 * 		  (데이터 타입 크기 : stu_id - 없음 / sub_no - 10 / sub_name - 10  / sub_score - 3)
 * 
 * 		- 아래의 사진을 참고하여 모든 컬럼에 주석(코멘트)을 달아준다.
 * 
 * 		- stu_id 를 student_t 의 식별값과 외래키 관계가 될 수 있도록 한다.
 * 		- sub_name 에는 '국어', '영어', '수학', '과학' 만 입력 및 수정 될 수 있도록 한다.
 * 		- sub_score 에는 0 ~ 100 사이의 숫자만 입력 및 수정 될 수 있도록 한다.
 * 		  (단, 제약조건 설정 시 암묵적으로 정해진 제약조건명을 부여하도록 한다.
 * 		   제약조건은 컬럼 레벨, 테이블 레벨 상관 없이 설정한다.)
 * 
 * 		- 두 테이블의 제약조건들이 잘 적용 됐는지 확인한다.
 */

CREATE TABLE STUDENT_T (
	  stu_id		NUMBER			CONSTRAINT PK_STUDENT_T_STU_ID PRIMARY KEY
	, stu_name	VARCHAR2(20)	CONSTRAINT NN_STUDENT_T_STU_NAME NOT NULL
	, class_name	VARCHAR2(20)
);
COMMENT ON COLUMN STUDENT_T.STU_ID IS '학번';
COMMENT ON COLUMN STUDENT_T.stu_name IS '학생명';
COMMENT ON COLUMN STUDENT_T.class_name IS '학급(반)';

CREATE TABLE SUBJECT_T (
	  stu_id		NUMBER CONSTRAINT FK_SUBJECT_T_STU_ID REFERENCES STUDENT_T(STU_ID)
	, sub_no		VARCHAR2(10)
	, sub_name	VARCHAR2(10)	CONSTRAINT CK_SUBJECT_T_SUB_NAME CHECK(SUB_NAME IN('국어', '영어', '수학', '과학'))
	, sub_score	NUMBER 
);
COMMENT ON COLUMN SUBJECT_T.STU_ID IS '학번';
COMMENT ON COLUMN SUBJECT_T.sub_no IS '과목코드';
COMMENT ON COLUMN SUBJECT_T.sub_name IS '과목명';
COMMENT ON COLUMN SUBJECT_T.sub_score IS '점수';

ALTER TABLE SUBJECT_T MODIFY sub_score CONSTRAINT CK_SUBJECT_T_SUB_SCORE CHECK(SUB_SCORE BETWEEN 1 AND 100);
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SUBJECT_T';

DROP TABLE SUBJECT_T;

/*
 * <김규연>
 * 1. 사원번호(EMP_NO), 이름(EMP_NAME), 소속부서명(EMP_DEP), 급여(EMP_SAL), 입사일(HIRE_DATE)
 *    을 컬럼으로 하는 태이블을 생성하세요. 테이블명은 EMP202205, 자료형은 알아서 부여하세요.
 *    입사일의 경우 기본값을 SYSDATE로 설정하세요.
 * 2. 서브쿼리를 이용하여 1에 생성한 테이블의 구조와 데이터를 복사하여 EMO202206 테이블을 생성하세요.
 * 3. EMP202206 컬럼이 참조하는 테이블 "EMP202206_REF" 라는 테이블을 만드세요.
 * 	  컬럼은 사원번호(EMP_NO), 비고(EMP_TEXT)로 하시고 자료형은 알아서 지정하세요.
 * 	  사원번호는 기본키로 설정 하세요.
 * 4. EMP202206 테이블에 이메일(EMAIL)과 핸드폰(PHONE) 컬럼을 추가하세요.(자료형도 같이 추가하세요)
 * 
 * 5. EMP202206 테이블에 이메일 컬럼을 삭제하세요.
 * 6. EMP202206 테이블에 국적을 나타내는 COUNTRY 컬럼을 추가하고 기본값을 'KOREA'로 지정하세요.
 * 7. EMP202206 테이블 각 컬럼에 입사일과 국적 빼고 제약조건을 추가하세요. 제약조건 이름도 함께 지정해 주세요.
 *    사원번호 : PRIMARY KEY, 이름 : NOT NULL, 소속부서명 : CHECK(AD, IT, ST, FI, PU 중에 있는지 확인), 급여 : NOT NULL, 핸드폰 : UNIQUE
 * 8. EMP202206 테이블에 EMP_NO가 EMP202206_REF을 참조할 수 있도록 외래키를 지정하고 제약조건 이름도 함께 지정해주세요.
 * 9. 마지막으로 컬럼과 제약조건이 잘들어갔는지 확인하세요.
 */
SELECT * FROM EMP202206;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP202206';

-- 7번
ALTER TABLE EMP202206 MODIFY EMP_NO CONSTRAINT PK_EMP202206_EMP_NO PRIMARY KEY;
ALTER TABLE EMP202206 MODIFY EMP_NAME CONSTRAINT NN_EMP202206_EMP_NAME NOT NULL;
ALTER TABLE EMP202206 MODIFY EMP_DEP CONSTRAINT CK_EMP202206_EMP_DEP CHECK(EMP_DEP IN('AD', 'IT','ST','FI','PU'));
ALTER TABLE EMP202206 MODIFY EMP_SAL CONSTRAINT NN_EMP202206_EMP_SAL NOT NULL;
ALTER TABLE EMP202206 MODIFY PHONE CONSTRAINT NN_EMP202206_PHONE NOT NULL;
ALTER TABLE EMP202206 ADD CONSTRAINT FK_EMP202206_EMP_NO FOREIGN KEY(EMP_NO) REFERENCES EMP202206_REF(EMP_NO);

-- 6번 
ALTER TABLE EMP202206 ADD(COUNTRY VARCHAR2(30) DEFAULT('KOREA'));

-- 5번
ALTER TABLE EMP202206 DROP COLUMN EMAIL;

--4번
ALTER TABLE EMP202206 ADD(EMAIL VARCHAR2(30));
ALTER TABLE EMP202206 ADD(PHONE VARCHAR2(20));


CREATE TABLE EMP202205(
	EMP_NO		NUMBER 
	, EMP_NAME  VARCHAR2(20)
	, EMP_DEP	VARCHAR2(30)
	, EMP_SAL	NUMBER
	, HIRE_DATE	DATE 	DEFAULT(SYSDATE)
);

CREATE TABLE EMP202206
	AS  SELECT *
		FROM EMP202205
		WHERE 1=0;

SELECT * FROM EMP202206;

--3번
CREATE TABLE EMP202206_REF (
	EMP_NO		NUMBER 			CONSTRAINT PK_EMP202206_REF_EMP_NO PRIMARY KEY
	, EMP_TEXT	VARCHAR2(100)

);

/*
 * 김재은_문제04
 *  1. MART_T 테이블을 생성한다.
 *   ->  name(가변길이 20자), price(숫자), company(가변길이 20자)
 *     , kind(고정길이 1자), possible(고정길이 1자), barcode(숫자)로 생성해준다.
 * 
 *  2. ref_mart_t 테이블을 생성한다. [참조에 사용될 테이블이다.]
 *   -> r_bar(숫자), note(가변길이 20자)
 *      r_bar는 primary key를 부여한다.
 * 
 * - 이때, company의 값에 입력이 없다면 '없음'이 출력되게 하시오.
 * - possible에서 'O'와 'X'로 입력되었는지 확인하는 제약조건을 추가하시오.
 * - name에는 PK_MART_T_NAME이라는 primary key 제약조건을 부여하시오.
 * - barcode는 ref_mart_t 테이블에서 r_bar을 외래키로 참조 할 수 있게 하시오.
 * - MART_T테이블에서 각 컬럼에는 주석을 달아준다.
 *   (name-상품명, price-가격, company-제조사, kind-종류, 
 *    possible-구매가능여부, barcode-바코드)
 */

ALTER TABLE MART_T MODIFY POSSIBLE CONSTRAINT CK_MART_T_POSSIBLE CHECK(POSSIBLE IN ('O', 'X'));
ALTER TABLE MART_T MODIFY NAME CONSTRAINT PK_MART_T_NAME PRIMARY KEY;
ALTER TABLE MART_T MODIFY BARCODE CONSTRAINT FK_MART_T_BARCODE REFERENCES REF_MART_T(R_BAR);

COMMENT ON COLUMN MART_T.NAME IS '상품명';
COMMENT ON COLUMN MART_T.PRICE IS '가격';
COMMENT ON COLUMN MART_T.COMPANY IS '제조사';
COMMENT ON COLUMN MART_T.KIND IS '종류';
COMMENT ON COLUMN MART_T.POSSIBLE IS '구매가능여부';
COMMENT ON COLUMN MART_T.BARCODE IS '바코드';

SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'MART_T';

CREATE TABLE MART_T (
	name 		VARCHAR2(20)
	, price 	NUMBER 
	, company 	VARCHAR2(20)	DEFAULT('없음')
	, kind 		CHAR(1)
	, possible 	CHAR(1)
	, barcode	NUMBER
	
);
SELECT * FROM MART_T;
DROP TABLE MART_T;
CREATE TABLE REF_MART_T(
	R_BAR	NUMBER 			PRIMARY KEY
	, NOTE 	VARCHAR2(20)
);




/* 4주차 김경욱_문제04
 * 
 * 운동부 TABLE을 작성하라. 
 * TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지
 * PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디
 * TEAM을 두 개만 등록합니다.
 * 두 개의 TEAM에 선수를 각각 3명씩 등록(추가)합니다.
 * 선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록 합니다.
 */
CREATE TABLE TEAM (
	TEAM_ID			NUMBER			CONSTRAINT PK_TEAM_TEAM_ID PRIMARY KEY
	, TEAM_REGION	VARCHAR2(20)
	, TEAM_NAME 	VARCHAR2(20)
	, CREATE_DATE	DATE
	, PHONE_NUMBER 	VARCHAR2(20)
	, HOME_PAGE		VARCHAR2(20)

);
CREATE TABLE PLAYER(
	PLAYER_NO			NUMBER
	, PLAYER_NAME		VARCHAR2(20)
	, REGIST_DATE		DATE
	, PLAYER_POSITION	VARCHAR2(20)
	, PLAYER_HEIGHT		NUMBER
	, TEAM_ID			NUMBER		CONSTRAINT FK_PLAYER_TEAM_ID REFERENCES TEAM(TEAM_ID)
);

SELECT  TEAM_NAME		
		, PHONE_NUMBER
		, HOME_PAGE
FROM TEAM
WHERE TEAM_ID = (SELECT TEAM_ID
					FROM PLAYER 	-- 이름이 이홍길인 사람의 TEAM_ID 를 추출 -> TEAM_ID랑 비교
					WHERE PLAYER_NAME='이홍길');	


-- INTERSECT : 교집합
SELECT PLAYER_NAME 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 100
INTERSECT
SELECT *
FROM EMPLOYEES
WHERE SALARY = 9000;

INSERT INTO TEAM(TEAM_ID, TEAM_NAME, PHONE_NUMBER, HOME_PAGE)
VALUES (1, '자이언트', '010-1011-1011', 'GG@GMAIL.COM');

INSERT INTO TEAM(TEAM_ID, TEAM_NAME, PHONE_NUMBER, HOME_PAGE)
VALUES (2, '두산', '010-1011-1012', 'GE@GMAIL.COM');


INSERT INTO PLAYER(PLAYER_NO, PLAYER_NAME, PLAYER_POSITION, TEAM_ID)
VALUES (10, '이홍길', '골키퍼', 1);

INSERT INTO PLAYER(PLAYER_NO, PLAYER_NAME, PLAYER_POSITION, TEAM_ID)
VALUES (20, '김민중', '공격수', 1);

INSERT INTO PLAYER(PLAYER_NO, PLAYER_NAME, PLAYER_POSITION, TEAM_ID)
VALUES (30, '박길영', '수비수', 1);

INSERT INTO PLAYER(PLAYER_NO, PLAYER_NAME, PLAYER_POSITION, TEAM_ID)
VALUES (40, '이민기', '골키퍼', 2);

INSERT INTO PLAYER(PLAYER_NO, PLAYER_NAME, PLAYER_POSITION, TEAM_ID)
VALUES (50, '남주혁', '공격수', 2);

INSERT INTO PLAYER(PLAYER_NO, PLAYER_NAME, PLAYER_POSITION, TEAM_ID)
VALUES (60, '이수혁', '수비수', 2);


SELECT * FROM PLAYER;
SELECT * FROM TEAM;



