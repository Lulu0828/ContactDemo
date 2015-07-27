package com.xylu.contactdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.ListView;

public class MainActivity extends Activity {

	/** 联系人名称 **/
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	private static final String[] PHONES_PROJECTION = new String[] {Phone.DISPLAY_NAME, Phone.NUMBER};

	/** 联系人显示名称 **/
	private static final int PHONES_DISPLAY_NAME_INDEX = 0;

	/** 电话号码 **/
	private static final int PHONES_NUMBER_INDEX = 1;
	
	private ListView contactListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getPhoneContacts();
		
		contactListView = (ListView)findViewById(R.id.contact_list);
		contactListView.setAdapter(new ContactListAdapter(this, contacts));
	}

	private void getPhoneContacts() {
		
		ContentResolver resolver = getContentResolver();
		
		try {
			
			// 获取手机联系人
			Cursor phoneCursor = resolver.query(Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
			
			if (phoneCursor != null) {
				
				while (phoneCursor.moveToNext()) {
					
					// 得到手机号码
					String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
					
					// 得到联系人名称
					String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);
					
					Contact contact = new Contact(contactName, phoneNumber);
					contacts.add(contact);
				}
				
				phoneCursor.close();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
}
