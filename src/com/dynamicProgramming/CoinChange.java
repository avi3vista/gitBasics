package com.dynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5 };
		int balance = 40;
		/*for(int i=0; i<=balance; i++) {
		StopWatch s = new StopWatch();
		s.start();
		coinChangeRecursive(i, coins);
		s.stop();
		System.out.print("i = " + i +"   Recursive took " + s.getNanoTime()/1000/1000);
		s.reset();
		s.start();

		coinChangeDP(i, coins);
		s.stop();
		System.out.print("     DP took " + s.getNanoTime()/1000/1000);
		System.out.println();
		}*/
		
		
		System.out.println(coinChangeRec02(15, coins));
		
	}
	
	
	

	private static int coinChangeDP(int balance, int[] coins) {
		int[] memo = new int[balance + 1];

		for (int i = 1; i < memo.length; i++) {
			int min=-1; int current =-1;
			for (int coin : coins) {
				if(i-coin>=0 && memo[i-coin]!=-1) {
						current=1+memo[i-coin];
				}
				if(min!=-1) {
					min = Math.min(min, current);
				} else {
					min = current;
				}
			}
			memo[i] = min;
		}

		return memo[memo.length - 1];

	}
	
	
	private static int coinChangeRec02 (int balance, int[] coins) {
      if(balance<0) {
        return -1;
      }
      if(balance==0) {
        return 0;
      }
      
      int current =0;
      int temp = 0;
      for(int coin: coins) {
        temp = coinChangeRec02(balance-coin, coins);
        if(temp==-1) {
          continue;
        }
        if(current==0) {
          current=temp;
        }
        else {
          current = Math.min(current, temp);
        }
        
      }
      return current+1;
    }

	private static int coinChangeRecursive(int balance, int[] coins) {
		if (balance < 0) {
			return -1;
		}
		if (balance == 0) {
			return 0;
		}
		int min = -1, current = -1;

		for (int coin : coins) {
			current = coinChangeRecursive(balance - coin, coins);
			if (min == -1) {
				min = current;
			}
			if (current != -1) {
				min = Math.min(min, current);
			}
		}
		if (min != -1) {
			return min + 1;
		}
		return -1;

	}

}
