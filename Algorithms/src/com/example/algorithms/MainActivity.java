package com.example.algorithms;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public static String INPUT = "com.example.algorithms.INPUT";
	public static ArrayList<String> passData;
	public Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void bubbleSort(View view) {
		intent = new Intent(this, BubbleSort.class);
		sort("Bubble", intent);
	}
	
	public void insertionSort(View view){
		intent = new Intent(this, InsertionSort.class);
		sort("Insert",intent);
	}
	
	public void selectionSort(View view){
		intent = new Intent(this, SelectionSort.class);
		sort("Selection",intent);
	}
	
	public void cocktailSort(View view){
		intent = new Intent(this,CocktailSort.class);
		sort("Cocktail",intent);
	}
	
	
	private void sort(String sort, Intent in){
		EditText et = (EditText) findViewById(R.id.editText1);
		String input = et.getText().toString();
		passData = new ArrayList<String>();
		if (input.length() == 0) {
			et.requestFocus();
			et.setError("Length cannot be left blank");
		} else {
			if (input.matches("^[1-9][0-9]*(,[1-9][0-9]*)*$")) {
				Pattern p = Pattern.compile("(\\d+)(,?)");
				Matcher m = p.matcher(input);

				while (m.find()) {
					passData.add(m.group(1));
				}

				in.putExtra(sort, passData);
				startActivity(in);
			} else {
				et.requestFocus();
				et.setError("Invalid string format");
			}
		}
	
	}

}
