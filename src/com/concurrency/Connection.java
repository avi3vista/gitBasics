package com.concurrency;

import java.util.concurrent.Semaphore;

public class Connection {

  public static int connections = 0;
  private Connection() {
    
  }
  private Semaphore sem= new Semaphore(10);
  private static Connection instance = new Connection();
  
  
  public static Connection getInstance () {
    return instance;
  }
  
  public  void connect() {
    try {
      sem.acquire();
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    synchronized (this) {
      connections++;
      System.out.println("Connected successfully   " + connections);
      
    }
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    synchronized (this) {
      connections--;
    }
    
    
    
    sem.release();
  }
}
