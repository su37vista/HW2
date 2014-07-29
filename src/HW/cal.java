package HW;
import java.io.*;
import java.io.IOException;
public class cal {
	private static int[] days={31,28,31,30,31,30,31,31,30,31,30,31};    //�إߤ���Ѽ�
	public static void isleapyear(int value) {							//�P�_�O�_���|�~�A�A��2�밵�վ�
		leapyear leapyear=new leapyear();
		if (leapyear.isleapyear(value)==1) {
			days[1]=29;
		}
		else days[1]=28;
	}		
	public static int secwork(int year,int month) {						//�^�ǸӦ~�Ӥ�����X��
		isleapyear(year);
		int day=days[month-1];
		return day;
	}
	public static int thirdwork(int year,int month,int day) {			//�p��Ӥ鬰�P���X
		int weekday=5;													//�H2000�~1��1��}�l�Ӻ�
		if (year>2000) {												//�p��L�{
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
		return weekday;											//�Ǧ^�P���X
	}
	public static void fifwork(int year){						//���P�w�O�_���|�~�A�A�ӭp��X�Ӥ���
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
		System.out.printf("�P������%d�ѡA�P���馳%d��\n", sat,sun);
	
	}
	public static void print(int year,int month) {                  //����Ӥ��1�鬰�P���X 		
		int weekday=5;
		if (year>2000) {											//�H2000�~1��1��}�l�Ӻ�
			for(int i=2000;i<year;i++) {							//�p��L�{
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
		weekday = (weekday+1) % 7 ;														//�H�P���鬰�}�l  �������վ�
		System.out.println("Sun Mon Tue wed Thr Fri Sat");                              //���Ĥ@�ƿ�X
		for (int i=0 ; i<weekday ; i++)
		    System.out.print("    ");                                                   //�}�Y�L����B��X�ť�
		for (int i=1 ; i<=days[month-1] ; i++)											//��X���
	    {
	     System.out.printf("%3d ",i);
	     if(weekday %7 == 6)    
		 System.out.println();      	     
	     weekday++;
	    }		
		System.out.println(); 															//��������
	}	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int data;
		System.out.println("Please input (year/month)");
		while(true){
			   String keyin = input.readLine();					//���o��J�r��
			   if(keyin.indexOf('/')==0)                       
			      data = keyin.indexOf(' ');   
			   else  
				      data = keyin.indexOf('/');   
			   String year = keyin.substring(0, data);
			   String month = keyin.substring(data+1);   
			   int intyear = Integer.parseInt(year);            //�Ѧr���ର�Ʀr
			   int intmonth = Integer.parseInt(month);			   
			isleapyear(intyear);
			print(intyear,intmonth);
		}
	}
}