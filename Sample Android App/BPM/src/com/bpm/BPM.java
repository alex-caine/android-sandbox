package com.bpm;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;

public class BPM extends Activity {
	
	long[] pushTimes = new long[5];
	int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm);
        
    }
    
    
    public void btnPressed(View view) {
		
    	if (counter > 0){
    		pushTimes[counter-1] = System.currentTimeMillis();
    		counter--;
    	} else {
    		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    		alertDialog.setTitle("BPM Found.");
    		alertDialog.setMessage("BPM is equal to: " + pushTimes[3]);
    		alertDialog.show();
    	}
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bpm, menu);
        return true;
    }
    
    
    
}
