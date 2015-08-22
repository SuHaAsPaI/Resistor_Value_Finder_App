package com.example.resisttorvaluefinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

 
public class MainActivity extends Activity {
	
	 
	Button bt;
	TextView kh;
	EditText et;
	MediaPlayer mysound;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 
		
		bt = (Button) findViewById(R.id.button1);
		kh=(TextView) findViewById(R.id.textView12);
		et=(EditText) findViewById(R.id.editText1);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("UseValueOf") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String str = et.getText().toString();
				
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
				
				mysound=MediaPlayer.create(MainActivity.this, R.raw.click );
				mysound.start();
				
				if(str.length()==0 || str.length() > 8)
				{
				    kh.setText("Enter Resistor Value");
				}

				else{
					
					float data,temp1,temp2;
					double ans1,ans2,ans3;
					data = new Float(str);
					
					temp1=data %10;
					temp2=data-temp1;
					temp2=temp2/10;
					
					ans1 = temp2*(Math.pow(10,temp1));
					ans2=ans1/1000;
					ans3=ans2/1000;
					
					if(ans1<=1000){
					kh.setText(""+ans1+"ohm");
					}
					else if(ans2>1 & ans2<=1000){
						kh.setText(""+ans2+"Kohm");
					}
					else if(ans3>1){
						kh.setText(""+ans3+"Mohm");
					}
					
				}
			}
		});
		
		
	}
        
        
        
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.about_apps) {
        	Intent sread1=new Intent("com.example.resisttorvaluefinder.ABOUT_APP");
    		startActivity(sread1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
