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
      int arrayLength = Integer.parseInt(sc.nextLine());
      int[] input = new int[arrayLength];
      String line = sc.nextLine();
      String[] nums = line.split(" ");
      for (int j = 0; j < arrayLength; j++) {
        input[j] = Integer.parseInt(nums[j]);
      }
      answers[i] = computeParity(input);
    }

    for (int i = 0; i < answers.length; i++) {
      System.out.println(answers[i]);
    }
  }

  private static int computeParity(int[] input)
  {
    //even + even = even;
    //even + odd = odd
    //odd + odd = even;

    //If we have an odd number, we can't ever get rid of it by breaking it down. This is because
    //an odd number breaks down into odd = odd + even, so we didn't really get rid of anything
    int countOfEvenNumbers = 0;

    for (int i = 0; i < input.length; i++) {
      if (input[i] % 2 == 0) {
        countOfEvenNumbers ++;
      }
    }
    if (countOfEvenNumbers == input.length) {
      //if all numbers are even, we're good
      return 0;
    }
    return countOfEvenNumbers;
  }
}
