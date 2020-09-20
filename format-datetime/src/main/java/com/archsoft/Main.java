package com.archsoft;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fh = new SimpleDateFormat("hh:mm:ss a");
		
		out.println(now.toString());
		out.println(fd.format(now));
		out.println(fh.format(now));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate1 = LocalDate.of(2020, 9, 20);
		out.println(dateTimeFormatter.format(localDate1));

		LocalDate localDate2 = LocalDate.of(2020, Month.SEPTEMBER, 20);
		out.println(dateTimeFormatter.format(localDate2));

		LocalDate localDate3 = LocalDate.ofYearDay(2020, 125);
		out.println(dateTimeFormatter.format(localDate3));

		LocalDate localDate4 = LocalDate.parse("2020-09-20");
		out.println(dateTimeFormatter.format(localDate4));
	}

}
