package com.jcl.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jcl.R;
import com.jcl.view.AutoTextView;
import com.jcl.view.AutoTextView.ChangeLayoutListener;

public class LayoutActivity extends Activity implements ChangeLayoutListener{
	AutoTextView textview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_layout);
		textview = (AutoTextView) findViewById(R.id.auto);
		textview.setChangeLayoutListener(this, textview);
	}

	@Override
	public void isChange(View view, String text) {
		// TODO Auto-generated method stub
		if(text!=null&&text.length()>0) {
			textview.setText(text);   //重新更新textview
		}
	}

	@Override
	public boolean isOk(View view) {
		// TODO Auto-generated method stub
		
		return true;  //返回true 否则不会计算
	}
}
