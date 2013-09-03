package com.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class CocktailSort extends Activity {
	public StringBuffer sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sb = new StringBuffer();
		Intent in = getIntent();
		Bundle b = in.getExtras();

		if (b != null) {
			TextView tv1 = new TextView(this);
			ArrayList<String> arr = (ArrayList<String>) b
					.getStringArrayList("Cocktail");
			int[] inputInt = new int[arr.size()];
			int n = 0;
			Iterator it = arr.iterator();
			while (it.hasNext()) {
				inputInt[n] = Integer.parseInt((String) it.next());
				n++;
			}
			sb.append("Input Data" + Arrays.toString(inputInt));
			int[] output = BubSort(inputInt);
			sb.append("\nOutput Sorted Data: " + Arrays.toString(output));
			tv1.setText(sb);

			setContentView(tv1);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cocktail_sort, menu);
		return true;
	}

	public int[] BubSort(int[] inp) {

		int[] input = inp;
		int i = 0;
		int flag = 1;
		sb.append("\nSorting Start");
		int pass = 0;
		while (flag == 1) {
			sb.append("\nPass: " + pass + ".");
			sb.append("\n" + Arrays.toString(input));
			pass++;
			flag = 0;
			i = 0;
			int j = input.length - 1;
			while (i < (input.length - 1)) {
				int temp = 0;
				if (input[i] > input[i + 1]) {
					temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
					flag = 1;
				}
				i++;
			}
			while (j > 0) {
				int temp2 = 0;
				if (input[j] > input[j - 1]) {
					temp2 = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp2;
					flag = 1;
				}
				j--;
			}
		}
		sb.append("\nSorting End.");
		return input;
	}
}
