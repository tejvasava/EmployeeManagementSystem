package com.kcs.ems.utils.programms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nString;
		ArrayList<String> studentMarks = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		System.out.println("How many string with student wants to entter");
		nString = sc.nextInt();
		for (int i = 0; i < nString; i++) {
			System.out.println("Enter student" + i + " name with marks:");
			// String marks=sc.nextLine();
			studentMarks.add(sc.next());
		}
		System.out.println(highestScorer(studentMarks));
		sc.close();

	}

	private static char[] highestScorer(ArrayList<String> studentMarks) {
		// TODO Auto-generated method stub
		int m1, m2, m3;
		String name = null, ss = null;
		int maxscore, count, sum = 0;

		for (int i = 0; i < studentMarks.size(); i++) {
			ss = studentMarks.get(i);
			StringTokenizer st = new StringTokenizer(ss, "-");

			while (st.hasMoreTokens()) {
				name = st.nextToken();
				m1 = Integer.parseInt(st.nextToken());
				m2 = Integer.parseInt(st.nextToken());
				m3 = Integer.parseInt(st.nextToken());
				sum = m1 + m2 + m3;

			}

			return null;

		}
		return null;
	}
}