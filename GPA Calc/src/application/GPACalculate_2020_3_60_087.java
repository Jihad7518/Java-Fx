package application;

public class GPACalculate_2020_3_60_087 {
	 public static double main(String num) {
	        int mark = Integer.parseInt(num);

	        if (mark <= 100) {
	            if (mark >= 90) {
	                return 5.0;
	            } else if (mark >= 80) {
	                return 4.0;
	            } else if (mark >= 70) {
	                return 3.0;
	            } else if (mark >= 60) {
	                return 2.0;
	            } else if (mark >= 50) {
	                return 1.0;
	            }
	            return 0.0;
	        }
	        return 0.0;
	    }

}
