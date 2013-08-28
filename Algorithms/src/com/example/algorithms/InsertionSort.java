package com.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class InsertionSort extends Activity {

	StringBuffer sb;
	Intent in;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sb = new StringBuffer();
		in = getIntent();
		Bundle b = in.getExtras();
		
		if(b!=null){
			TextView tv1 = new TextView(this);
			ArrayList<String> arr = b.getStringArrayList("Insert");
			int[] inputInt = new int[arr.size()];
			int n = 0;
			Iterator it = arr.iterator();
			while (it.hasNext()) {
				inputInt[n] = Integer.parseInt((String) it.next());
				n++;
			}
			sb.append("Input Data" + Arrays.toString(inputInt));
			int[] output = InsSort(inputInt);
			sb.append("\nOutput Sorted Data: " + Arrays.toString(output));
			tv1.setText(sb);
			
			setContentView(tv1);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertion_sort, menu);
		return true;
	}
	
	public int[] InsSort(int[] inp){
		sb.append("\nSorting Start");
		int n = inp.length;
		int pass = 0;
		for (int j = 1; j < n; j++) {
			int key = inp[j];
			int i = j - 1;
			while ((i > -1) && (inp[i] > key)) {
				inp[i + 1] = inp[i];
				i--;
			}
			inp[i + 1] = key;
			sb.append("\nPass: " + pass + ".");
			sb.append("\n" + Arrays.toString(inp));
			pass++;
		}
		
		sb.append("\nSorting Start");
		return inp;
	}

}
