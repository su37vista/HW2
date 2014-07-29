package HW;
import java.io.*;
import java.util.Scanner;
public class work {	
	private static Scanner input;
	public static void work1 () {										//執行第一項工作
		int year;
		leapyear leapyear=new leapyear();
		input = new Scanner(System.in);
		System.out.print("請輸入年份：\n");
		year=input.nextInt();												//取得年份
		if (leapyear.isleapyear(year)==1) System.out.printf("%d年為閏年\n",year);		//判斷是否為閏年
		else System.out.printf("%d年不為閏年\n",year);
	}
    public static void work2 () throws IOException{						//執行第二項工作
    	int data,year,month,day;
    	
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
    	cal cal=new cal();
		System.out.println("Please input (year/month)");
		       
	    String keyin = input.readLine();					//取得輸入字串
		if(keyin.indexOf('/')==0)                       
			data = keyin.indexOf(' ');   
		else  
			data = keyin.indexOf('/');   
		String stryear = keyin.substring(0, data);
		String strmonth = keyin.substring(data+1);   
		year = Integer.parseInt(stryear);            //由字串轉為數字
		month = Integer.parseInt(strmonth);
		day=cal.secwork(year, month);					//計算
		System.out.printf("有%d天\n",day);	   
	}
    public static void work3 () throws IOException{					//執行第三項工作
    	int weekday,year,month,day;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
        cal cal=new cal();
		System.out.println("Please input (year/month/day)");
		       
	    String keyin = input.readLine();					//取得輸入字串		
	     
		String stryear = keyin.substring(0,4);
		String strmonth = keyin.substring(5,7);   
		String strday = keyin.substring(8,10); 
		
		year = Integer.parseInt(stryear);            //由字串轉為數字
		month = Integer.parseInt(strmonth);
		day = Integer.parseInt(strday);
		weekday=cal.thirdwork(year, month, day);		//計算
		if (weekday==1) System.out.println("這天是星期一");			//判斷數值為星期幾
		else if (weekday==2) System.out.println("這天是星期二");
		else if (weekday==3) System.out.println("這天是星期三");
		else if (weekday==4) System.out.println("這天是星期四");
		else if (weekday==5) System.out.println("這天是星期五");
		else if (weekday==6) System.out.println("這天是星期六");
		else if (weekday==0) System.out.println("這天是星期日");	
	}
    public static void work4 () throws IOException{					//執行第四項工作
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
    	int data,year,month;
		System.out.println("Please input (year/month)");
		cal cal=new cal();       
	    String keyin = input.readLine();					//取得輸入字串
		if(keyin.indexOf('/')==0)                       
			data = keyin.indexOf(' ');   
		else  
			data = keyin.indexOf('/');   
		String stryear = keyin.substring(0, data);
		String strmonth = keyin.substring(data+1);   
		year = Integer.parseInt(stryear);            //由字串轉為數字
		month = Integer.parseInt(strmonth);
		cal.print(year, month);						//計算並印出
	}
    public static void work5 () {						//執行第五項工作
    	int year;
    	cal cal=new cal();
    	System.out.print("請輸入年份：\n");
		year=input.nextInt();							//取得年份
		cal.fifwork(year);								//計算
	}

}
