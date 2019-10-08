package com.store.qa.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Testutil {
	 public static long PAGE_LOAD_TIMEOUT=20;
	 public static long IMPLICIT_WAIT=20;
	 static Date date=new Date(System.currentTimeMillis());
	 //Define utilities here like Test data sheet refrence and define method to read that sheet.
	 static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
	 public static String dateAsString = simpleDateFormat.format(date);
}
