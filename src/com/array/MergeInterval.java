package com.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.array.InsertInterval.Interval;

public class MergeInterval {

  public static void main(String[] args) {
    List<Interval> intervals = new ArrayList<Interval>();

    intervals.add(new Interval(1, 3));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(2,8));
    intervals.add(new Interval(15,18));
    intervals.add(new Interval(17,17));
    
    
    System.out.println(merge(intervals));
    
    

  }
  public static List<Interval> merge(List<Interval> intervals) {
    
    int i=0;
    Comparator<Interval> comparator = new Comparator<MergeInterval.Interval>() {
      
      @Override
      public int compare(com.array.MergeInterval.Interval o1, com.array.MergeInterval.Interval o2) {
        return o1.start>o2.start ? 1 : -1;
      }
    };
    
    intervals.sort(comparator);
    while(i<intervals.size()-1) {
      if(intervals.get(i).end>=intervals.get(i+1).start) {
        if(intervals.get(i+1).end>intervals.get(i).end) {
          intervals.get(i).end=intervals.get(i+1).end;
        }
        intervals.remove(i+1);
      }
      else {
        i++;
      }
    }
    
    return intervals;
  }
  
  public static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }

    @Override
    public String toString() {
      return "(" + this.start + "," + this.end + ")";
    }
  }

}
