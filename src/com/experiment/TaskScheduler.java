package com.experiment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {

		char[] input = new char[] { 'A','A','A','B','B','B' };
		System.out.println("minimum time = " + leastInterval(input, 2));

	}

	public static int leastInterval(char[] tasks, int n) {
		int result = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int[] tasksInt = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			tasksInt[tasks[i] - 'A']++;
		}

		for (Integer i : tasksInt) {
			if (i > 0)
				queue.add(i);
		}
		List<Integer> tempList = new ArrayList<Integer>();
		while (!queue.isEmpty()) {

			for (int i = 0; i < n; i++) {
				result++;
				if (!queue.isEmpty() && queue.peek() > 1) {
					tempList.add(queue.poll() - 1);
				} else {
					queue.poll();
				}
				if (tempList.isEmpty() && queue.isEmpty()) {
					break;
				}

			}

			for (int i : tempList) {
				queue.add(i);
			}
			tempList.clear();
		}

		return result;
	}

}
