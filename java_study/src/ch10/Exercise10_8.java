package ch10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class Exercise10_8 {


	public static void main(String[] args) {
//[10-8] 서울과 뉴욕간의 시차가 얼마인지 계산하여 출력하시오.
		/*
		 * LocalDateTime = LocalDate + LocalTime
		 * ZonedDateTime = LocalDateTime + Time Zone
		 */
		ZonedDateTime nowSeoul = ZonedDateTime.now();
		ZonedDateTime nowNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(nowSeoul);
		System.out.println(nowNewYork);
		
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS z VV";

		ZoneOffset krOffset = nowSeoul.getOffset();
		int koOffsetInsec = krOffset.get(ChronoField.OFFSET_SECONDS);
		ZoneOffset nyOffset = nowNewYork.getOffset();
		int nyOffsetInsec = nyOffset.get(ChronoField.OFFSET_SECONDS);
		
		int diff = (koOffsetInsec - nyOffsetInsec) / (60*60);
		
		System.out.println("diff = " + diff + "hrs");
	}
}
