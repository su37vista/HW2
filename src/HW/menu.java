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
			System.out.print("�п�ܥH�U�\��G\n1.�P�_�O�_���|�~\n2.��J�~��Ǧ^���X��\n3.��J�~���Ǧ^�P���X\n4.��J�~��Ǧ^���\n5.��J�~ �Ǧ^���X�Ӥ���\n");
			select=input.nextInt();														//��ܤu�@	
			if (select==1) {
				work.work1();															//����Ĥ@���u�@
			}
			else if (select==2) {
				work.work2();															//����ĤG���u�@
			}
			else if (select==3) {
				work.work3();															//����ĤT���u�@
			}
			else if (select==4) {
                work.work4();															//����ĥ|���u�@
			}
			else if (select==5) {
				work.work5();															//����Ĥ����u�@
			}
			else	System.out.print("\n��J���~�A�Э��s��J\n");		
		
			
			
		}
	}
}
