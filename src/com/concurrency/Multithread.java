package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithread {
  static int count = 0;
  

  public static void main(String[] args) {
    
    ExecutorService exec = Executors.newCachedThreadPool();
    
    for(int i=0; i<200; i++) {
      exec.submit(new Runnable() {
       public void run() {
         Connection.getInstance().connect();
       }
      });
    }
    exec.shutdown();
  }

}
