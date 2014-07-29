package HW;
import java.io.IOException;
import java.util.Scanner; 
public class menu {
	private static Scanner input;
    public static void inputone () {
    	
    }
    
	public static void main(String[] args) throws IOException   {
		input = new Scanner(System.in);
		int select;
		work work = new work();
		while(true) {
			System.out.print("請選擇以下功能：\n1.判斷是否為閏年\n2.輸入年月傳回有幾天\n3.輸入年月日傳回星期幾\n4.輸入年月傳回整月\n5.輸入年 傳回有幾個六日\n");
			select=input.nextInt();														//選擇工作	
			if (select==1) {
				work.work1();															//執行第一項工作
			}
			else if (select==2) {
				work.work2();															//執行第二項工作
			}
			else if (select==3) {
				work.work3();															//執行第三項工作
			}
			else if (select==4) {
                work.work4();															//執行第四項工作
			}
			else if (select==5) {
				work.work5();															//執行第五項工作
			}
			else	System.out.print("\n輸入錯誤，請重新輸入\n");		
		
			
			
		}
	}
}
