package competitions.start58.EQUIVALENT;
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



//Note, I didn't solve this during the contest, but I was pretty close.
class Codechef
{
  public static void main (String[] args) throws java.lang.Exception
  {
    gcd(100, 20);
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
    int num1 = Math.max(input[0], input[1]);
    int num2 = Math.min(input[0], input[1]);

    HashMap<Integer, Integer> map1 = findPrimeFactors(num1);
    HashMap<Integer, Integer> map2 = findPrimeFactors(num2);
    Integer gcd = null;

    if (map1.size() != map2.size()) {
      return false;
    }

    for (Map.Entry<Integer, Integer> map : map1.entrySet()) {
      if (!map2.containsKey(map.getKey())) {
        return false;
      }
      if (gcd == null) {
        gcd = gcd(map2.get(map.getKey()), map.getValue());
        //Double ratio = map.getValue();
      }
    }


    for (Map.Entry<Integer, Integer> map : map1.entrySet()) {
    }


    return true;

  }

  private static int gcd(int a, int b)
  {
    System.out.printf("A = %d, B = %d%n", a, b);
    if (b == 0) {
      return a;
    }
    return gcd(b, a%b);
  }

  private static int gcd2(int a, int b)
  {
    if (b == 0) {
      return a;
    }
    return gcd(b, Math.abs(a-b));
  }

  private static HashMap<Integer,Integer> findPrimeFactors(int num)
  {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    int i = 2;
    while (num > 1) {
      int count = 0;
      while (num % i == 0)  {
        num /= i;
        count++;
      }
      hashMap.put(i, count);
      i++;
    }
    return hashMap;
  }
}

