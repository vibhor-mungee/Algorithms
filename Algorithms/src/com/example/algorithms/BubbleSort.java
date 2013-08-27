package com.example.algorithms;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BubbleSort extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		StringBuffer sb = new StringBuffer();
		Intent in = getIntent();
		Bundle b = in.getExtras();
		if(b!=null){
			TextView tv1 = new TextView(this);
			ArrayList<String> arr = (ArrayList<String>)b.getStringArrayList("Input");
			Iterator it = arr.iterator();
			while(it.hasNext()){
				sb.append(it.next() + " ");
			}
			tv1.setText(sb);
			setContentView(tv1);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bubble_sort, menu);
		return true;
	}

}
