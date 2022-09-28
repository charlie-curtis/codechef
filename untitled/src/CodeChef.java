/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
//1 3 2 4 5
//1 2 3 4 5

//+2 +1 +1 +2


// 8 4 // passes
// 5 10 fails
// 12 24 // fails

// 2*2*2 vs 2*2  -> 1,8,4,2 vs 1,2,4
// 5 vs 2*5 -> 5, 1 vs 1,2,5,10
// 2*2*3 vs 2*2*2*3 vs 1, 2, 3, 4, 6, 12 vs 1, 2, 3, 4, 6, 8, 12, 24

//2*2*3 vs 2*2*3*3

// 8 vs 24

// a^x = b ^ y

//8 4
//2^(2*2) 2^(2*1)

//2*2*2 vs 2*2

//8^2 = 4

// 1 1 2 3 3 4


// 1 2 3 1 2 1 3 3 4

//input 1 2 3 4 5 6 7



class Codechef {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int testCases = Integer.parseInt(sc.nextLine());

    int[] answers = new int[testCases];
    for (int i = 0; i < testCases; i++) {
      int length = Integer.parseInt(sc.nextLine());
      String line = sc.nextLine();
      String[] nums = line.split(" ");
      int[] input = new int[length];
      for (int j = 0; j < length; j++) {
        input[j] = Integer.parseInt(nums[j]);
      }
      initializeMap(input);
      answers[i] = getMinCut(input, 0, length-1);
    }

    for (int i = 0; i < answers.length; i++) {
      System.out.println(answers[i]);
    }
  }

  private static HashMap<Integer, HashMap<Integer, Boolean>> map;
  private static void initializeMap(int[] input) {
    map = new HashMap<>();

    for(int i = 0; i < input.length; i++) {
      for (int j = 0; j < input.length; j++) {
        boolean hasDupe = false;
        for (int k = i; !hasDupe && k <= j; k++) {
          for (int l = i; !hasDupe && l <= j; l++) {
            if (input[l] == input[k] && k != l) {
              hasDupe = true;
            }
          }
        }
        HashMap<Integer, Boolean> temp = map.getOrDefault(i, new HashMap<>());
        temp.put(j, hasDupe);
        map.put(i, temp);
      }
    }

  }

  //endIndex is exclusive
  // 1 2 1 3 4 5

  private static HashMap<String, Integer> hashMap = new HashMap<>();
  private static int getMinCut(int[] input, int startIndex, int endIndex) {

    if (hashMap.containsKey(String.format("%d:%d", startIndex, endIndex))) {
      return hashMap.get(String.format("%d:%d", startIndex, endIndex));
    }
    if (!containsDupe(startIndex, endIndex)) {
      hashMap.put(String.format("%d:%d", startIndex, endIndex), 0);
      return 0;
    }

    int minValue = Integer.MAX_VALUE;
    for (int i = startIndex; i < endIndex; i++) {
      int potentialMin = 1 + getMinCut(input, startIndex, i) + getMinCut(input, i+1, endIndex);
      minValue = Math.min(minValue, potentialMin);
    }

    hashMap.put(String.format("%d:%d", startIndex, endIndex), minValue);
    return minValue;
  }

  private static boolean containsDupe(int startIndex, int endIndex)
  {
    return map.get(startIndex).get(endIndex);
  }

}
