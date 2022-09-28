package competitions.start59.RANKLISTPAGE;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
//1 3 2 4 5
//1 2 3 4 5

//+2 +1 +1 +2

class Codechef
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner sc = new Scanner(System.in);
    int testCases = Integer.parseInt(sc.nextLine());

    int[] answers = new int[testCases];
    for (int i = 0; i < testCases; i++) {
      double finishedRank = Double.parseDouble(sc.nextLine());
      answers[i] = (int) Math.ceil(finishedRank / 25);
    }

    for (int i = 0; i < answers.length; i++) {
      System.out.println(answers[i]);
    }
  }
}
