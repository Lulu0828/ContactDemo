package com.xylu.contactdemo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactListAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	class ContactListView {
		TextView nameTv;
		TextView numberTv;
	}
	
	public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
		this.context = context;
		this.contacts = contacts;
	}
	
	@Override
	public int getCount() {
		
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		
		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ContactListView contactListView = null;
		
		if (convertView == null) {
			contactListView = new ContactListView();
			convertView = LayoutInflater.from(context).inflate(R.layout.contact_list_item, null);
			contactListView.nameTv = (TextView)convertView.findViewById(R.id.name_tv);
			contactListView.numberTv = (TextView)convertView.findViewById(R.id.number_tv);
			convertView.setTag(contactListView);
		} else {
			contactListView = (ContactListView)convertView.getTag();
		}
		
		Contact contact = contacts.get(position);
		contactListView.nameTv.setText(contact.getName());
		contactListView.numberTv.setText(contact.getNumber());
		
		return convertView;
	}

}
