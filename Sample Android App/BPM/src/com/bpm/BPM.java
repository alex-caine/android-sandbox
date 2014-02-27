package com.bpm;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

//Hello from alex


public class BPM extends Activity {
	
	//pushTimes = array of times button was pushed (in milliseconds)
	//sumWait initialized to 0 (only ever increases), averageWait not initialized
	long[] pushTimes;
	int counter;
	double sumWait;
	double averageWait;
	int curNum;
	String disp = " taps remaining.";
	
	private void initializeVariables() {
		TextView text = (TextView) findViewById(R.id.tapsRemaining);
    	text.setText("5 taps remaining.");
    	pushTimes = new long[5];
    	counter=0;
    	curNum = 4;
    	sumWait = 0;
    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm);
        initializeVariables();
        
    }
    
    
    public void resetButtonPressed(View view) {
    	initializeVariables();
    }
    
    public void btnPressed(View view) {
    	
    	TextView text = (TextView) findViewById(R.id.tapsRemaining);
    	text.setText(curNum + disp);
    	
    	//For 4 presses, add time of press to pushTimes
    	//On 5th press, add final time to pushTimes and display bpm data
    	if (counter < 4){
    		pushTimes[counter] = System.currentTimeMillis();
    		counter++;
    		curNum--;
    	} else if (counter==5){
    		AlertDialog resetAlert = new AlertDialog.Builder(this).create();
    		resetAlert.setTitle("Reset.");
    		resetAlert.setMessage("BPM was found to be: " + (averageWait*60) + ". Please press reset to find another tempo.");
    		resetAlert.show();
    	} else {
    		
    		curNum = 0;
    		pushTimes[counter] = System.currentTimeMillis();
    				
    		//Finds total time between first and last button push and
    		//divides by number of clicks 
    		sumWait = (double)(pushTimes[4] - pushTimes[0]);
    		averageWait = ((sumWait/1000)/4);
    		
    		//Creates and displays AlertDialog 'bpmInfo' with BPM info
    		AlertDialog bpmInfoAlert = new AlertDialog.Builder(this).create();
    		bpmInfoAlert.setTitle("BPM Found.");
    		bpmInfoAlert.setMessage("BPM is: " + (averageWait*60));
    		bpmInfoAlert.show();
    		counter++;
    		
    	}	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bpm, menu);
        return true;
    }
    
    
    
    
}
