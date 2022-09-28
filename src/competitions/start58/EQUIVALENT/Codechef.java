package competitions.start58.EQUIVALENT;
/* package codechef; // don't place package name! */

import java.math.BigInteger;
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



//Note, I didn't solve this during the contest, but I was pretty close. I solved this afterwards
class Codechef
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner sc = new Scanner(System.in);
    int testCases = Integer.parseInt(sc.nextLine());

    boolean[] answers = new boolean[testCases];
    for (int i = 0; i < testCases; i++) {
      String line = sc.nextLine();
      String[] nums = line.split(" ");
      int[] input = new int[2];
      input[0] = Integer.parseInt(nums[0]);
      input[1] = Integer.parseInt(nums[1]);
      answers[i] = findAnswer(input);
    }

    for (int i = 0; i < answers.length; i++) {
      if (!answers[i]) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }

  private static boolean findAnswer(int[] input)
  {
    HashMap<Integer, Integer> map1 = getPrimeFactors(input[0]);
    HashMap<Integer, Integer> map2 = getPrimeFactors(input[1]);

    int num1 = Math.max(input[0], input[1]);
    int num2 = Math.min(input[0], input[1]);



    Double ratio = null;
    for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
      int key = entry.getKey();
      int count = entry.getValue();

      if (!map2.containsKey(key)) {
        return false;
      }

      if (ratio == null) {
        ratio = (double)map2.get(key) / (double)count;
      } else if ((double)map2.get(key) / (double) count != ratio) {
        return false;
      }

    }
    return true;
  }

  private static HashMap<Integer, Integer> getPrimeFactors(int num)
  {
    HashMap<Integer, Integer> answer = new HashMap<>();
    int i = 2;
    while (num != 1) {
      int count = 0;
      while (num % i == 0) {
        count++;
        num /= i;
      }
      if (count != 0) {
        answer.put(i, count);
      }
      i++;
    }
    return answer;
  }
}

