/*Hetvi Patel
Design and implement an application that reads student scores, gets the best score and then assigns grades based on the following scheme:
•	Grade A: Score >= best - 10
•	Grade B: Score >= best - 20
•	Grade C: Score >= best - 30
•	Grade D: Score >= best - 40
•	Grade F: All other scores
Date completed: 4/21/2020
*/
import java.util.Scanner;
public class ScoresMain
{
     /*this is the main method where it calls the run method and runs the program and then calls a program which asks the user whether 
     they want to run the program again or not.*/
     public static void main(String[] args)
     {
         Scanner s = new Scanner(System.in);
         boolean repeat = true;
         while(true)
         {
            runProgram(s);
            repeat = ScoresHelper.getRunAgain(s);
         }
     }
     /*this method calls the method which display the introduction and then calls the method which finds the maximum score and outputs the 
     results by calling the output method*/
     public static void runProgram(Scanner s)
     {
         s = new Scanner(System.in);
         printIntroduction();
         int[] scores = ScoresHelper.createArray(s);
         int maxgrade = ScoresHelper.findMaxGrade(scores);
         outputResults(scores,maxgrade);
     }
     //this method displays the introduction of the program
     public static void printIntroduction()
     {
          System.out.println("     Welcome to the Grading Program!");
          System.out.println("=========================================");
          System.out.println("You will be prompted to enter the number");
          System.out.println("of students that you have to grade. Next,");
          System.out.println("you need to enter the scores. The results");
          System.out.println("will print in a table with the weighted");
          System.out.println("grades.");
          System.out.println();
          System.out.println();
     }
     //this mehod displays the final output ina tabular form
     public static void outputResults(int[] scores, int best)
     {
          System.out.println("Here are your results: ");
          System.out.printf("%10s%10s%10s\n", "Student", "Score", "Grade");
          char grade;
          for(int i=0;i<scores.length;i++)
          {
              grade = ScoresHelper.getLetterGrade(scores[i],best);
              System.out.printf("%10d%9d%10c\n", i + 1, scores[i], grade);         
          }
     }
}