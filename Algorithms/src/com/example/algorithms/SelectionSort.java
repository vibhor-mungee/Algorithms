package com.example.algorithms;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SelectionSort extends Activity {

	StringBuffer sb; 
	Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sb = new StringBuffer();
		in = getIntent();
		Bundle b = in.getExtras();

		if (b != null) {
			TextView tv1 = new TextView(this);
			ArrayList<String> arr = b.getStringArrayList("Selection");
			ArrayList<Integer> inputInt = new ArrayList<Integer>();
			Iterator<String> it = arr.iterator();
			while (it.hasNext()) {
				inputInt.add(Integer.parseInt((String) it.next()));
			}
			sb.append("Input Data" + inputInt.toString());
			ArrayList<Integer> output = selectionSort(inputInt);
			sb.append("\nOutput Sorted Data: " + output.toString());
			tv1.setText(sb);

			setContentView(tv1);
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selection_sort, menu);
		return true;
	}

	public ArrayList<Integer> selectionSort(ArrayList<Integer> arrList) {
		Iterator it = arrList.iterator();
		ArrayList<Integer> outputArr = new ArrayList<Integer>();
		int smallestPosition;
		while (!arrList.isEmpty()) {
			smallestPosition = findSmallest(arrList);
			outputArr.add(arrList.get(smallestPosition));
			arrList.remove(smallestPosition);
			sb.append("\n"+outputArr.toString());
		}

		return outputArr;
	}

	public static int findSmallest(ArrayList<Integer> a) {

		int temp = a.get(a.size() - 1);
		int lowestIndex = a.size() - 1;
		for (int i = (a.size() - 1); i > 0; i--) {
			if ( a.get(i) < temp) {
				temp = a.get(i);
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}

}
