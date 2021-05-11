import java.util.Scanner;
public class ScoresHelper
{
     /*this method asks the user the number of sudents they want to calculate the score of and then asks the score of that many students
     and then also evaluates whether it is integer or not*/
     public static int[] createArray(Scanner s)
     {
         s = new Scanner(System.in);
         int numstd;
         String prompt;
         prompt = "Enter the number of students: ";
         numstd = getValidInt(s,prompt);
         int[] score = new int[numstd];
         System.out.println("Enter " + numstd + " scores:");
         for(int i=0;i<numstd;i++)
         {
            prompt = "Score " + (i+1) + ": ";
            score[i] = getValidInt(s,prompt);
         }
         return score;
     }
     //this method finds the max score and then return the maximum
     public static int findMaxGrade(int[] scores)
     {
         int max=scores[0];
         for(int i=0;i<scores.length;i++)
         {
             if(scores[i]>max)
             {
                 max=scores[i];
             }
         }
         return max;
     }
     //this method calculates the grade as per the criteria given and then returns the grade
     public static char getLetterGrade(int score, int best)
     {
         if(score>=best-10)
            return 'A';
         else if(score>=best-20)
            return 'B';
         else if(score>=best-30)
            return 'C';
         else if(score>=best-40)
            return 'D';
         else
            return 'F';
     }
     //the below method calculates whether the the score and the number of students are integer or not and i not it asks to enter again
     public static int getValidInt(Scanner s, String prompt)
     {
         System.out.print(prompt);
         int input;
         while(!s.hasNextInt())
         {
             System.out.print(prompt);
             s.next();
         }
         input = s.nextInt();
         return input;
     }
     //this method asks the user whether they want to run the program again after caclulating the grades
     public static boolean getRunAgain(Scanner s)
     {
         s = new Scanner(System.in);
         boolean answer= true;
         String ans;
         System.out.print("Do you have another test to score? ");
         while(answer)
         {
            ans = s.nextLine();
            if(ans.equals("yes"))
            {
                return true;
                //answer = false;
            }
            else if(ans.equals("no"))
            {
                System.exit(0);
            }            
            else
            {
                System.out.print("Please enter yer or no.");
                System.out.print("Do you have another test to score? ");
            }  
         }
         return false;
     }
}