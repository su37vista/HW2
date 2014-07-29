package HW;
import java.io.*;
import java.io.IOException;
public class cal {
	private static int[] days={31,28,31,30,31,30,31,31,30,31,30,31};    //建立月份天數
	public static void isleapyear(int value) {							//判斷是否為閏年，再對2月做調整
		leapyear leapyear=new leapyear();
		if (leapyear.isleapyear(value)==1) {
			days[1]=29;
		}
		else days[1]=28;
	}		
	public static int secwork(int year,int month) {						//回傳該年該月份有幾天
		isleapyear(year);
		int day=days[month-1];
		return day;
	}
	public static int thirdwork(int year,int month,int day) {			//計算該日為星期幾
		int weekday=5;													//以2000年1月1日開始來算
		if (year>2000) {												//計算過程
			for(int i=2000;i<year;i++) {
				isleapyear(i);
				if (days[1]==28) weekday++;
				else if (days[1]==29) weekday+=2;
			}
			for(int i=1;i<month;i++) {
				if (month!=1)
				weekday=weekday+days[i-1]%7;
			}
		}
		else if (year<2000) {
			for(int i=2000;i>year;i--) {
				isleapyear(i-1);
				if (days[1]==28) weekday--;
				else if (days[1]==29) weekday-=2;
			}
			for(int i=1;i<month;i++) {
				if (month!=1)
				weekday=weekday+days[i-1]%7;
			}
		}
		else {
			isleapyear(2000);
			for(int i=1;i<month;i++) {
				if (month!=1)
				weekday=weekday+days[i-1]%7;
			}
		}
        weekday+=day;
        weekday%=7;													
		return weekday;											//傳回星期幾
	}
	public static void fifwork(int year){						//先判定是否為閏年，再來計算幾個六日
		int count;
		int sat=0,sun=0;
		int day=thirdwork(year,1,1);
		if (days[1]==28) count=365;
		else count=366;
		for (int i=0;i<=count;i++) {
			if (day%7==0) sun++;
			if (day%7==6) sat++;
			day++;
		}
		System.out.printf("星期六有%d天，星期日有%d天\n", sat,sun);
	
	}
	public static void print(int year,int month) {                  //推算該月份1日為星期幾 		
		int weekday=5;
		if (year>2000) {											//以2000年1月1日開始來算
			for(int i=2000;i<year;i++) {							//計算過程
				isleapyear(i);
				if (days[1]==28) weekday++;
				else if (days[1]==29) weekday+=2;
			}
			for(int i=1;i<month;i++) {
				if (month!=1)
				weekday=weekday+days[i-1]%7;
			}
		}
		else if (year<2000) {
			for(int i=2000;i>year;i--) {
				isleapyear(i-1);
				if (days[1]==28) weekday--;
				else if (days[1]==29) weekday-=2;
			}
			for(int i=1;i<month;i++) {
				if (month!=1)
				weekday=weekday+days[i-1]%7;
			}
		}
		else {
			isleapyear(2000);
			for(int i=1;i<month;i++) {
				if (month!=1)
				weekday=weekday+days[i-1]%7;
			}
		}
		weekday = (weekday+1) % 7 ;														//以星期日為開始  做版面調整
		System.out.println("Sun Mon Tue wed Thr Fri Sat");                              //月曆第一排輸出
		for (int i=0 ; i<weekday ; i++)
		    System.out.print("    ");                                                   //開頭無日期處輸出空白
		for (int i=1 ; i<=days[month-1] ; i++)											//輸出日期
	    {
	     System.out.printf("%3d ",i);
	     if(weekday %7 == 6)    
		 System.out.println();      	     
	     weekday++;
	    }		
		System.out.println(); 															//結束跳行
	}	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int data;
		System.out.println("Please input (year/month)");
		while(true){
			   String keyin = input.readLine();					//取得輸入字串
			   if(keyin.indexOf('/')==0)                       
			      data = keyin.indexOf(' ');   
			   else  
				      data = keyin.indexOf('/');   
			   String year = keyin.substring(0, data);
			   String month = keyin.substring(data+1);   
			   int intyear = Integer.parseInt(year);            //由字串轉為數字
			   int intmonth = Integer.parseInt(month);			   
			isleapyear(intyear);
			print(intyear,intmonth);
		}
	}
}