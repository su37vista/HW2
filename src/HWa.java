import java.io.*;
public class HWa {
	private static int[] days={31,28,31,30,31,30,31,31,30,31,30,31};    //建立月份天數
	public static void isleapyear(int value) {							//判斷是否為閏年，再對2月做調整
		if ((value%400==0) || ((value%4==0) && (value%100!=0))) {
			days[1]=29;
		}
		else days[1]=28;
	}		
	public static void print(int year,int month) {                   //使用公式計算
		int calmonth=0;
		if(month==1||month==2){                                      //建立計算用月份及年份
			calmonth=month+12;
			year--;
		}
		else calmonth=month;
		int weekday= (1+2*calmonth+3*(calmonth+1)/5+year+year/4-year/100+year/400) % 7;   //公式計算取得第一天星期幾
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
