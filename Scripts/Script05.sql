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




