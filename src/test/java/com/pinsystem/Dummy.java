package com.pinsystem;

import com.pinsystem.utils.ObjectReader;
import com.pinsystem.utils.PropertyReader;

public class Dummy {

	public static void main(String[] args) {
		ObjectReader.reader = new PropertyReader();

		System.out.println(ObjectReader.reader.invalidUsername() + " invalidUsername");
		System.out.println(ObjectReader.reader.invalidPassword()+ " invalidPassword");
		System.out.println(ObjectReader.reader.getUserName()+ " getUserName");
		System.out.println(ObjectReader.reader.getPassword()+" getPassword");
		System.out.println(ObjectReader.reader.getExplicitWait()+ " getExplicitWait");
		System.out.println(ObjectReader.reader.getImpliciteWait()+ " getImpliciteWait");
		System.out.println(ObjectReader.reader.getPageLoadTime() + "getPageLoadTime");
		System.out.println(ObjectReader.reader.leftframe());
		System.out.println(ObjectReader.reader.rightframe());
		System.out.println(ObjectReader.reader.topframe());
		System.out.println(ObjectReader.reader.ACCOUNTS());
		System.out.println(ObjectReader.reader.FINANCE());
		System.out.println(ObjectReader.reader.CORPORATE_INFO());
		System.out.println(ObjectReader.reader.MEDIA());
		System.out.println(ObjectReader.reader.HOME());
		System.out.println(ObjectReader.reader.IT_DEPT()+ " IT DEPT");
		System.out.println(ObjectReader.reader.SALES()+ "Sales");
		System.out.println(ObjectReader.reader.HR_ADMIN() + " HR admin");
		System.out.println(ObjectReader.reader.TRAFFIC());
	}
}
