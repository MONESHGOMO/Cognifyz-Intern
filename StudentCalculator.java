import java.util.Scanner;
class StudentCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the student name : ");
        String student_name = input.next();
        System.out.print("Enter the number of grade  : ");
        int grade_count = input.nextInt();
        
        System.out.println(gradeCalculator(student_name, grade_count));
        input.close();

    }

    public static String gradeCalculator(String student_name, int grade_count) {
        Scanner input = new Scanner(System.in);

        int length=grade_count;
        int grade_tracker[] = new int[length];
        
        for (int i = 0; i < length; i++) {
            System.out.println("Enter your grade " + (i + 1) + " : ");
            int grade_value = input.nextInt();
            grade_tracker[i] = grade_value;
        }
        
        float average = getAverage(grade_tracker, student_name);
        String result = student_name + " " + "your grade average is " + " " + average;
        input.close();
        return result;
    }

    public static float getAverage(int[] grade_tracker, String name) {
        
        int n=grade_tracker.length;
        if (n == 1) {
            return grade_tracker[0];
        }

        float   grade_total = 0;
        for (int i : grade_tracker) {
            grade_total += i;
        }

        return grade_total / n;
    }
}