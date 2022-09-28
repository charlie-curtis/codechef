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

//



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
    Set<Integer> s1 = getPrimeFactors(input[0]);
    Set<Integer> s2 = getPrimeFactors(input[1]);

    if (s1.size() != s2.size()) {
      return false;
    }

    s1.retainAll(s2);
    if (s1.size() == s2.size() && s1.size() == 1) {
      return true;
    }
    return false;
  }

  private static Set<Integer> getPrimeFactors(int num)
  {
    HashSet<Integer> answer = new HashSet<>();
    int i = 2;
    while (num != 1) {
      while (num % i == 0) {
        answer.add(i);
        num /= i;
      }
     i++;
    }
    return answer;
  }
}
