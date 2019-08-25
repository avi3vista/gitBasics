package com.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

  public static void main(String[] args) {

    List<Interval> intervals = new ArrayList<Interval>();

    intervals.add(new Interval(3, 5));
    intervals.add(new Interval(12,15));
    // intervals.add(new Interval(6,7));
    // intervals.add(new Interval(8,10));
    // intervals.add(new Interval(12,16));
    Interval newInterval = new Interval(1, 20);
    System.out.println(intervals);
    insert(intervals, newInterval);
    System.out.println(intervals);
  }

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals == null || intervals.size() == 0) {
      List<Interval> res = new ArrayList<Interval>();
      res.add(newInterval);
      return res;
    }
    int i = 0;
    boolean isMerged = false;
    while (i < intervals.size()) {
      if (intervals.get(i).start > newInterval.end && !isMerged) {
        intervals.add(i, newInterval);
        break;
      } else if (intervals.get(i).end >= newInterval.start) {
        intervals.get(i).start = Math.min(intervals.get(i).start, newInterval.start);
        intervals.get(i).end = Math.max(intervals.get(i).end, newInterval.end);
        merge(intervals, newInterval, i);
        isMerged=true;
        break;
      }
      else {
        i++;
      }
    }
    if (i == intervals.size()&& !isMerged) {
      intervals.add(newInterval);
    }
    return intervals;
  }
  private static void merge(List<Interval> intervals, Interval newInterval, int i) {
    int j = i + 1;
    while (j < intervals.size()) {
      if (intervals.get(i).end >= intervals.get(j).start) {
        intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j).end);
        intervals.remove(j);
      } else {
        break;
      }
    }

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
