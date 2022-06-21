SELECT * FROM STUDENT;
SELECT * FROM STUDENT_LEVEL;

/*
 * 이보슬_문제05
 * 
 * <STUDENT_CLUB> 테이블 (사진1-1), (사진1-2)
 * 1. STUDENT_CLUB 테이블을 생성하시오. 
 * 	  - CLUB_NO(동아리번호) 컬럼 -> 자료형 : NUMBER, 제약조건 : PRIMARY KEY (제약조건명은 테이블명과 컬럼명을 조합해서 지어준다.)
 *	  - CLUB_NAME(동아리명) 컬럼 -> 자료형 : VARCHAR2(30), 제약조건 : UNIQUE (제약조건은 테이블명과 컬럼명을 조합해서 지어준다.)
 *    - REMARK(비고) 컬럼 -> 자료형 : 한글이 100자 이하로 들어갈 수 있도록 설정
 *  
 * <STUDENT(학생)> 테이블 (사진2-1), (사진2-2)
 * 1. STUDENT 테이블에 STU_AGE(나이)컬럼을 추가하시오. 
 * 	  - 자료형은 NUMBER로 하고
 *    - NOT NULL 제약조건을 추가해준다. (제약조건명은 테이블명과 컬럼명을 조합해서 지어준다.) 
 *    - 컬럼을 만들어 준 뒤 DEFALUT 값을 17로 설정한다. 
 * 2. CLUB_NO(동아리번호) 컬럼을 추가하시오.
 * 	  - 자료형은 NUMBER로 하고
 *    - STUDENT_CLUB 테이블의 CLUB_NO컬럼을 참조할 수 있도록 FOREIGN KEY 제약조건을 추가해준다.  (사진2-3)
 *      (제약조건명은 테이블명과 컬럼명을 조합해서 지어준다.) 
 * 
 * <STUDENT_LEVEL(학년)> 테이블
 * 1. STUDENT_LEVEL 테이블의 LEVEL_NO(학년)컬럼의 DEFAULT값을 1로 설정하시오.(사진3-1)
 * 2. STUDENT_LEVEL 테이블의 CLASS(반)컬럼명을 CLASS_NO으로 변경하시오. (사진3-2)
 * 
 */  

-- STUDENT_CLUB 테이블 생성
CREATE TABLE STUDENT_CLUB (
	  CLUB_NO		NUMBER 			CONSTRAINT PK_STUDENT_CLUB_CLUB_NO PRIMARY KEY
	, CLUB_NAME 	VARCHAR2(30)	CONSTRAINT UQ_STUDENT_CLUB_CLUB_NAME UNIQUE
	, REMARK		VARCHAR2(300)
);
SELECT * FROM STUDENT_LEVEL;

-- STUDENT 테이블 STU_AGE 컬럼추가
ALTER TABLE STUDENT ADD (STU_AGE NUMBER CONSTRAINT NN_STUDENT_STU_AGE NOT NULL);
-- STUDENT 테이블 DEFAULT 값 추가
ALTER TABLE STUDENT MODIFY STU_AGE DEFAULT 17;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'STUDENT_LEVEL';
-- STUDENT 테이블에 STUDENT_CLUB의 CLUB_NO을 참조하는 외래키 추가
ALTER TABLE STUDENT ADD (CLUB_NO NUMBER CONSTRAINT FK_STUDENT_CLUB_NO REFERENCES STUDENT_CLUB(CLUB_NO));



-- STUDENT_LEVEL 테이블 DEFAULT 값 추가 & CLASS 컬럼명 변경
ALTER TABLE STUDENT_LEVEL MODIFY LEVEL_NO DEFAULT 1;
ALTER TABLE STUDENT_LEVEL RENAME COLUMN CLASS TO CLASS_NO;


/*
 * 홍유라_문제05
 * 
 * 홍유라_문제04에서 만든 subject_t 테이블을 활용해 문제를 해결한다.
 * 	 1. subject_t 테이블명을 score_t 로 변경한다.				 			(O)
 *   2. score_t 테이블에 '과목 점수 테이블' 이라고 주석을 달아준다.				(O)
 *   3. score_t 테이블의 sub_no 컬럼명을 math 로 수정한다.					(O)
 * 		위에서 수정한 math 컬럼의 데이터 타입을 NUMBER(3) DEFAULT(0)으로 변경한다. (O)
 *   4. score_t 테이블 eng 컬럼의 기존 제약조건을 삭제한다.     				(O)
 *   5. score_t 테이블의 sub_name 컬럼명을 eng 로 수정한다.					(O)
 * 		위에서 수정한 eng 컬럼의 데이터 타입을 NUMBER(3) DEFAULT(0)으로 변경한다.	(O)
 *   6. score_t 테이블의 sub_score 컬럼을 삭제한다.						(O)
 * 	 7. score_t 테이블에 kor, java 2개의 새로운 컬럼을 추가한다.				(O)
 * 		2개 컬럼의 데이터 타입은 동일하다 -> NUMBER(3) DEFAULT(0)	(O)
 *   8. score_t 테이블 컬럼들에 주석을 달아준다.						(O)
 * 		(stu_id - '학번', math - '수학', eng - '영어', kor - '국어', java - '자바')
 *   9. math, eng, kor, java 컬럼에는 0 ~ 100 사이의 숫자만 입력 및 수정
 *      될 수 있도록 적절한 제약조건과 제약조건명을 부여한다.
 */

ALTER TABLE SCORE_T DROP CONSTRAINT CK_SUBJECT_T_SUB_NAME;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SCORE_T';

SELECT * FROM SCORE_T;
ALTER TABLE SUBJECT_T RENAME TO SCORE_T;

COMMENT ON TABLE SCORE_T IS '과목 점수 테이블';
ALTER TABLE SCORE_T RENAME COLUMN SUB_NO TO MATH;
ALTER TABLE SCORE_T MODIFY MATH NUMBER(3) DEFAULT(0);

ALTER TABLE SCORE_T RENAME COLUMN SUB_NAME TO ENG;
ALTER TABLE SCORE_T MODIFY ENG NUMBER(3) DEFAULT(0);

ALTER TABLE SCORE_T DROP COLUMN SUB_SCORE;

ALTER TABLE SCORE_T ADD (KOR NUMBER(3) DEFAULT(0));
ALTER TABLE SCORE_T ADD (JAVA NUMBER(3) DEFAULT(0));

COMMENT ON COLUMN SCORE_T.STU_ID IS '학번';
COMMENT ON COLUMN SCORE_T.MATH IS '수학';
COMMENT ON COLUMN SCORE_T.ENG IS '영어';
COMMENT ON COLUMN SCORE_T.KOR IS '국어';
COMMENT ON COLUMN SCORE_T.JAVA IS '자바';

ALTER TABLE SCORE_T MODIFY MATH CONSTRAINT CK_SCORE_T_MATH CHECK(MATH BETWEEN 0 AND 100);
ALTER TABLE SCORE_T MODIFY ENG CONSTRAINT CK_SCORE_T_ENG CHECK(ENG BETWEEN 0 AND 100);
ALTER TABLE SCORE_T MODIFY KOR CONSTRAINT CK_SCORE_T_KOR CHECK(KOR BETWEEN 0 AND 100);
ALTER TABLE SCORE_T MODIFY JAVA CONSTRAINT CK_SCORE_T_JAVA CHECK(JAVA BETWEEN 0 AND 100);


/* 김규연_문제05
 * 1. 테이블을 생성(bread_t)하고 각 컬럼명, 자료형, 제약조건, 제약조건명을 부여하세요.
 * 컬럼 : 1) 재품번호(BREAD_NO, 숫자, 기본키)
 *       2) 빵이름(BREAD_NAME, 가변길이 20자, NOT NULL)
 * 		 3) 빵갯수(BREAD_NUM, 숫자, X -> 기본값(0))
 * 		 4) 빵가격(BREAD_PRICE, 숫자, X -> 기본값(0))
 * 2. 참조 태이블(bread_ref)을 생성하고 각 컬럼명, 자료형, 제약조건, 제약조건명을 부여하새요.
 * 컬럼 : 1) 재품번호(BREAD_NO, 숫자, 기본키)
 *       2) 비고(BREAD_TEXT, 가변길이 20자, NOT NULL)     					(O)
 * 3. 외래키를 사용하여 bread_ref 테이블에 BREAD_NO가 bread_t 테이블에 BREAD_NO을 참조할 수 있도록 하세요.
 * 4. bread_t와 bread_ref 테이블의 컬럼에 주석을 다세요. 
 * 5. bread_t 테이블에 빵종류(BREAD_TYPE) 컬럼을 추가하세요.
 * 		- 자료형 : 가변길이 20자
 * 		- 제약조건 : CHECK(식빵, 일반빵, 크림빵, 조리빵, 패스츄리빵, 도넛, 유럽건강빵 중에 확인) -> 제약조건명도 같이 추가
 * 		- 주석 : 빵종류
 * 6. bread_ref 테이블에 빵생산날짜(BREAD_PRODATE) 컬럼을 추가하세요.
 * 		- 자료형 : 날짜
 * 		- 기본값 : 오늘날짜
 * 		- 주석 : 빵생산날짜
 * 7. 비고의 컬럼명(BREAD_TEXT)을 BREAD_NOTE로 바꾸고 가변길이도 100자로 바꾸세요. 
 */

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'BREAD_REF';

CREATE TABLE BREAD_T(
	  BREAD_NO 			NUMBER 			CONSTRAINT BREAD_T_BREAD_NO PRIMARY KEY
	, BREAD_NAME 		VARCHAR2(20)	CONSTRAINT BREAD_T_BREAD_NAME NOT NULL
	, BREAD_NUM			NUMBER			DEFAULT(0)
	, BREAD_PRICE		NUMBER			DEFAULT(0)
);
CREATE TABLE BREAD_REF (
	  BREAD_NO 			NUMBER			CONSTRAINT BREAD_REF_BREAD_NO PRIMARY KEY
	, BREAD_TEXT		VARCHAR2(20)	CONSTRAINT BREAD_REF_BREAD_TEXT NOT NULL
);

ALTER TABLE BREAD_REF ADD CONSTRAINT FK_BREAD_REF_BREAD_NO FOREIGN KEY(BREAD_NO) REFERENCES BREAD_T(BREAD_NO);


COMMENT ON COLUMN BREAD_T.BREAD_NO IS '제품번호';
COMMENT ON COLUMN BREAD_T.BREAD_NAME IS '빵이름';
COMMENT ON COLUMN BREAD_T.BREAD_NUM IS '빵갯수';
COMMENT ON COLUMN BREAD_T.BREAD_PRICE IS '빵가격';

ALTER TABLE BREAD_T ADD (BREAD_TYPE VARCHAR2(20) CONSTRAINT CK_BREAD_T_BREAD_TYPE 
CHECK(BREAD_TYPE IN('식빵', '일반빵','크림빵','조리빵','패스츄리빵','도넛', '유럽건강빵')));
COMMENT ON COLUMN BREAD_T.BREAD_TYPE IS '빵종류';

ALTER TABLE BREAD_REF ADD (BREAD_PRODATE DATE DEFAULT(SYSDATE));

ALTER TABLE BREAD_REF RENAME COLUMN BREAD_TEXT TO BREAD_NOTE;

ALTER TABLE BREAD_REF MODIFY BREAD_NOTE VARCHAR2(100);
SELECT * FROM BREAD_REF;

/*
 * 김재은_문제05
 * 
 * 4주차에 생성한 MART_T 테이블을 사용하여 문제를 해결하시오.
 * 1. kind 컬럼의 크기를 가변길이20자로 늘리시오.
 * 2. sort 컬럼을 추가하시오.
 *    (타입은 숫자형, 제약조건은 primary key로 부여하시오)
 * 3. sort의 제약조건명을 PK_MART_T_SORT 로 변경하시오.
 * 4. ref_mart_t 테이블의 r_bar의 제약조건명을 PK_REF_MART_T_R_BAR로 변경하시오.
 * 5. EMP_MART_T 테이블을 생성하시오.
 *    ->name(가변길이 10자),  salary(숫자), manage_sort(숫자)
 *    (manage_sort는 MART_T의 sort를 외래키로 참조하도록 하시오.)
 * 6. 각 주석을 추가로 달아준다.
 * 	 - MART_T에 SORT에는 '분류코드'
 * 	 - EMP_MART_T에 NAME에는 '이름', SALARY에는 '연봉', MANAGE_SORT에는 '담당분류코드'를 작성한다.
 */
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'REF_MART_T';

SELECT * FROM MART_T;
ALTER TABLE MART_T MODIFY KIND VARCHAR2(20);
ALTER TABLE MART_T ADD (SORT NUMBER PRIMARY KEY);
ALTER TABLE MART_T RENAME CONSTRAINT PK_REF_MART_T_R_BAR TO PK_MART_T_SORT;

ALTER TABLE REF_MART_T RENAME CONSTRAINT SYS_C0010490 TO PK_REF_MART_T_R_BAR;

CREATE TABLE EMP_MART_T (
 	  NAME 			VARCHAR(10)
	, SALARY		NUMBER
	, MANAGE_SORT	NUMBER 		CONSTRAINT FK_EMP_MART_T_MANAGE_SORT REFERENCES MART_T(SORT)
);

COMMENT ON COLUMN MART_T.SORT IS '분류코드';
COMMENT ON COLUMN EMP_MART_T.NAME IS '이름';
COMMENT ON COLUMN EMP_MART_T.SALARY IS '연봉';
COMMENT ON COLUMN EMP_MART_T.MANAGE_SORT IS '담당분류코드';

SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'EMP_MART_T';
