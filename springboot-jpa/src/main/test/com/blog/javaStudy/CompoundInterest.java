package com.blog.javaStudy;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CompoundInterest {

	public static void main(String[] args){
		dateTest();
		System.out.println();
		String b= "555555";
		String c= new String("555555");
		Abcd a  = new Abcd();
		a.setAa("555555");
		change(a,b,c);
		System.out.println(a.getAa());
		System.out.println(b);
		System.out.println(c);
	}
	
	private static void change(Abcd a,String b,String c) {
		a.setAa("666666");
		b="666666";
		c="666666";
	}

	private static void arrayTest(){
		final double STARTRATE=10;
		final int NRATES=6;
		final int NYEAR=10;
		double[] interestRate=new double[NRATES];
		for(int j=0;j<interestRate.length;j++)
			interestRate[j]=(STARTRATE+j)/100;
		double[][] balances = new double[NYEAR][NRATES];
		for(int j=0;j<balances[0].length;j++)
			balances[0][j]=10000;
		for(int i=1;i<balances.length;i++){
			for(int j=0;j<balances[i].length;j++){
				double oldBalances = balances[i-1][j];
				double interest=oldBalances*interestRate[j];
				balances[i][j]=oldBalances+interest;
			}
		}
		for(int j=0;j<interestRate.length;j++)
			System.out.printf("%9.0f%%", 100*interestRate[j]);
		System.out.println();
		for(double row[]:balances){
			for(double b:row)
				System.out.printf("%10.2f",b);
			System.out.println();
		}
	}
	
	private static void dateTest(){
		GregorianCalendar g = new GregorianCalendar();
		int today = g.get(Calendar.DAY_OF_MONTH);
		int month = g.get(Calendar.MONTH);
		g.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = g.get(Calendar.DAY_OF_WEEK);
		int fristWeekDay = g.getFirstDayOfWeek();
		int indent = 0;
		while(weekday!=fristWeekDay){
			indent++;
			g.add(Calendar.DAY_OF_MONTH, -1);
			weekday = g.get(Calendar.DAY_OF_WEEK);
		}
		String[] weekDayName = new DateFormatSymbols().getShortWeekdays();
		do{
			System.out.printf("%6s",weekDayName[weekday]);
			g.add(Calendar.DAY_OF_MONTH, 1);
			weekday = g.get(Calendar.DAY_OF_WEEK);
		}while(weekday!=fristWeekDay);
		System.out.println();
		for(int i=0;i<indent;i++){
			System.out.print("     ");
		}
		g.set(Calendar.DAY_OF_MONTH, 1);
		do{
			int day = g.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%5s",day);
			if(day==today)
				System.out.print("*");
			g.add(Calendar.DAY_OF_MONTH, 1);
			weekday = g.get(Calendar.DAY_OF_WEEK);
			fristWeekDay = g.getFirstDayOfWeek();
			if(weekday==fristWeekDay)
				System.out.println();
		}while(g.get(Calendar.MONTH)==month);
		
		
	}
}

class Abcd{
	private String aa;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}
	
}