package HW;
import java.io.*;
import java.util.Scanner;
public class work {	
	private static Scanner input;
	public static void work1 () {										//����Ĥ@���u�@
		int year;
		leapyear leapyear=new leapyear();
		input = new Scanner(System.in);
		System.out.print("�п�J�~���G\n");
		year=input.nextInt();												//���o�~��
		if (leapyear.isleapyear(year)==1) System.out.printf("%d�~���|�~\n",year);		//�P�_�O�_���|�~
		else System.out.printf("%d�~�����|�~\n",year);
	}
    public static void work2 () throws IOException{						//����ĤG���u�@
    	int data,year,month,day;
    	
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
    	cal cal=new cal();
		System.out.println("Please input (year/month)");
		       
	    String keyin = input.readLine();					//���o��J�r��
		if(keyin.indexOf('/')==0)                       
			data = keyin.indexOf(' ');   
		else  
			data = keyin.indexOf('/');   
		String stryear = keyin.substring(0, data);
		String strmonth = keyin.substring(data+1);   
		year = Integer.parseInt(stryear);            //�Ѧr���ର�Ʀr
		month = Integer.parseInt(strmonth);
		day=cal.secwork(year, month);					//�p��
		System.out.printf("��%d��\n",day);	   
	}
    public static void work3 () throws IOException{					//����ĤT���u�@
    	int weekday,year,month,day;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
        cal cal=new cal();
		System.out.println("Please input (year/month/day)");
		       
	    String keyin = input.readLine();					//���o��J�r��		
	     
		String stryear = keyin.substring(0,4);
		String strmonth = keyin.substring(5,7);   
		String strday = keyin.substring(8,10); 
		
		year = Integer.parseInt(stryear);            //�Ѧr���ର�Ʀr
		month = Integer.parseInt(strmonth);
		day = Integer.parseInt(strday);
		weekday=cal.thirdwork(year, month, day);		//�p��
		if (weekday==1) System.out.println("�o�ѬO�P���@");			//�P�_�ƭȬ��P���X
		else if (weekday==2) System.out.println("�o�ѬO�P���G");
		else if (weekday==3) System.out.println("�o�ѬO�P���T");
		else if (weekday==4) System.out.println("�o�ѬO�P���|");
		else if (weekday==5) System.out.println("�o�ѬO�P����");
		else if (weekday==6) System.out.println("�o�ѬO�P����");
		else if (weekday==0) System.out.println("�o�ѬO�P����");	
	}
    public static void work4 () throws IOException{					//����ĥ|���u�@
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
    	int data,year,month;
		System.out.println("Please input (year/month)");
		cal cal=new cal();       
	    String keyin = input.readLine();					//���o��J�r��
		if(keyin.indexOf('/')==0)                       
			data = keyin.indexOf(' ');   
		else  
			data = keyin.indexOf('/');   
		String stryear = keyin.substring(0, data);
		String strmonth = keyin.substring(data+1);   
		year = Integer.parseInt(stryear);            //�Ѧr���ର�Ʀr
		month = Integer.parseInt(strmonth);
		cal.print(year, month);						//�p��æL�X
	}
    public static void work5 () {						//����Ĥ����u�@
    	int year;
    	cal cal=new cal();
    	System.out.print("�п�J�~���G\n");
		year=input.nextInt();							//���o�~��
		cal.fifwork(year);								//�p��
	}

}
