import javax.swing.*;
import java.awt.*;
import java.util.*;

class NumberingSystem extends JFrame{
	private static String[] s1={
		"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
	};
	private static String[] s2={
		"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred", "thousand", "lakh", "crore", "arab" 
	};
	private static String op="";
	private static String numnum(long n) throws ArithmeticException{
		long a=0;
		int b=10, c=0, count=0;
		if(n<0 || n>99999999999L){
			throw new ArithmeticException("the number should not be less than 0 or greater than 99,99,99,99,999.");
		}
		if(n==0)
			return "zero";
		else if(n<100)
			tillHundred((int)n);
		else if(n<1000 && n>=100){
			tillThousand((int)n);
		}
		else if(n>=1000){
			a=n%1000;
			tillThousand((int)a);
			a=(n-a)/1000;
				b=(int)a%100;
				x:
				if(b!=0){
					if(b<=20)
						op=s1[b-1]+" thousand "+op;
					else{
						c=b%10;
						if(c!=0){
							op=s1[c-1]+" thousand "+op;
						}
						op=s2[((b-c)/10)-2]+" "+op;
					}
					b=(int)a%100;
					break x;
				}
		}
		return op;
	}
	private static void tillHundred(int n){
		int a=0;
		if(n!=0){
			if(n<=20)
				op=s1[n-1]+" "+op;
			else{
				a=n%10;
				if(a!=0)
					op=s1[a-1]+op;
				op=s2[((n-a)/10)-2]+" "+op;
			}
		}
	}
	private static void tillThousand(int n){
		int a=0;
		tillHundred(n%100);
		a=(n-(n%100))/100;
		if(a!=0)
			op=s1[a-1]+" hundred "+op;
	}
	/*NumberingSystem(){
		super("Number Converter");
		setSize();
	}*/
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		System.out.println(numnum(n));
	}
}
