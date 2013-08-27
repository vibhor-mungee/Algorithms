package com.example.algorithms;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static String INPUT = "com.example.algorithms.INPUT";
	public static ArrayList<String> passData = new ArrayList<String>();

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
		Intent intent = new Intent(this, BubbleSort.class);
		EditText et = (EditText) findViewById(R.id.editText1);
		String input = et.getText().toString();
		if (input.length() == 0) {
			et.requestFocus();
			et.setError("Length cannot be left blank");
		} else {
			if (input.matches("^[0-9,]+$")) {
				Pattern p = Pattern.compile("(\\d+)(,?)");
				Matcher m = p.matcher(input);

				while (m.find()) {
					passData.add(m.group(1));
				}

				intent.putExtra("Input", passData);
				startActivity(intent);
			} else {
				et.requestFocus();
				et.setError("Invalid string format");
			}
		}
	}

}
