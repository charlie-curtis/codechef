package competitions.start58.REMOVEBAD;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;

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
      answers[i] = findDifference(input);
    }

    for (int i = 0; i < answers.length; i++) {
      System.out.println(answers[i]);
    }
  }

  private static int findDifference(int[] input)
  {
    HashMap<Integer, Integer> valueToCountMap = new HashMap<>();

    for (int i = 0; i < input.length; i++) {
      int currentCount = valueToCountMap.getOrDefault(input[i], 0);
      valueToCountMap.put(input[i], currentCount+1);
    }

    int maxValue = 0;
    int maxCount = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : valueToCountMap.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        maxValue = entry.getKey();
      }
    }

    return input.length - maxCount;
  }
}
