package com.jcl.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.jcl.R;
import com.jcl.view.AutoTextView;
import com.jcl.view.AutoTextView.ChangeLayoutListener;

public class ListViewActivity extends Activity{
	private ListView listView;
	private List<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_layout);
		listView = (ListView) findViewById(R.id.auto_list);
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<5;i++) {
			buffer.append("我能自动调整宽度");
			list.add(buffer.toString());
		}
		MyAdapter adapter = new MyAdapter();
		listView.setAdapter(adapter);
	}
	
	private class MyAdapter extends BaseAdapter implements ChangeLayoutListener{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Holder holder = null;
			if(convertView == null) {
				convertView = LayoutInflater.from(ListViewActivity.this).inflate(R.layout.cell, null);
				holder = new Holder();
				holder.auto = (AutoTextView)convertView.findViewById(R.id.text);
				holder.auto.setChangeLayoutListener(this, convertView);
				convertView.setTag(holder);
			}else {
				holder = (Holder) convertView.getTag();
			}
			holder.index = position;
			holder.auto.setText(list.get(position));
			return convertView;
		}
		class Holder {
			AutoTextView auto;
			int index;
		}
		@Override
		public void isChange(View view, String text) {
			// TODO Auto-generated method stub
			Holder holder = (Holder)view.getTag();
			if(holder!=null) {
				holder.auto.setText(list.get(holder.index));
			}
		}

		@Override
		public boolean isOk(View view) {
			// TODO Auto-generated method stub
			return true;
		}
		
	}
}
