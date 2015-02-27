package com.jcl.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jcl.R;

public class MainActivity extends Activity {
	private Button a;
	private Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		a = (Button) findViewById(R.id.a);
		b = (Button) findViewById(R.id.b);
		a.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						LayoutActivity.class);
				startActivity(intent);
			}
		});
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						ListViewActivity.class);
				startActivity(intent);
			}
		});
	}
}
