package HW;

public class leapyear {
	public static int isleapyear(int value) {							//§PÂ_¬O§_¬°¶|¦~
		if ((value%400==0) || ((value%4==0) && (value%100!=0))) {
			return 1;
		}
		else return 0;
	}		

}
