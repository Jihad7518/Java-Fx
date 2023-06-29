package application;

public class Calculator_2020_3_60_087 {

public static float calculateGPA(Integer bengaliMark, Integer englishMark, Integer mathMark){
	Integer[] marks = {bengaliMark, englishMark, mathMark};
	int total = 0;
	for (int i=0; i<3; i++){
       if(marks[i] >= 90)
        total = total + 5;
        else if(marks[i] >= 80)
        total = total + 4;
        else if(marks[i] >= 70)
        total = total + 3;
        else if(marks[i] >= 60)
        total = total + 2;
        else if(marks[i] >= 50)
        total = total + 1;
        
        else
        total = total + 0;

	}

	float result = (float) total/3;

	return result;

	}

}