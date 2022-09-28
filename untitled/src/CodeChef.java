/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner sc = new Scanner(System.in);
    int testCases = Integer.parseInt(sc.nextLine());

    int[] answers = new int[testCases];
    for (int i = 0; i < testCases; i++) {
      int[] inputs = new int[2];
      String line = sc.nextLine();
      String[] nums = line.split(" ");
      inputs[0] = Integer.parseInt(nums[0]);
      inputs[1] = Integer.parseInt(nums[1]);
      answers[i] = inputs[0] - inputs[1];
    }

    for (int i = 0; i < answers.length; i++) {
      System.out.println(answers[i]);
    }
  }
}
