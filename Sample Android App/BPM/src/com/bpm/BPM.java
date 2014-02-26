package com.bpm;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BPM extends Activity {
	
	//pushTimes = array of times button was pushed (in milliseconds)
	//sumWait initialized to 0 (only ever increases), averageWait not initialized
	long[] pushTimes = new long[5];
	int counter = 0;
	double sumWait = 0;
	double averageWait;

<<<<<<< HEAD
	//int curNum = 5; may be unncessary. Original purpose was for # of taps remaining
	String disp = " taps remaining.";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        
    }
=======
	
	int counter2 = 4;
    
    /**********************************************
     * Just playing around with functionality here!
     **********************************************/
    /*public void btnPressed(View view) {
    	
    	if (counter2 > 0) {
    		
    		AlertDialog bpmInfoAlert = new AlertDialog.Builder(this).create();
    		bpmInfoAlert.setTitle("Test");
    		bpmInfoAlert.setMessage("BPM is: " + counter2);
    		bpmInfoAlert.show();
    		bpmInfoAlert.setCanceledOnTouchOutside(true);
    		counter2--;
    		
    	}
    	else {
    		AlertDialog bpmInfoAlert = new AlertDialog.Builder(this).create();
    		
    		bpmInfoAlert.setMessage("0");
    		bpmInfoAlert.setCanceledOnTouchOutside(true);
    		bpmInfoAlert.show();
    		
    	}
    		
    	
    }*/
>>>>>>> FETCH_HEAD
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm);
        
    }
>>>>>>> parent of f220ba2... Added one line that lets people cancel dialog message with outside touch
    
    
    public void btnPressed(View view) {
    	
    	//For 4 presses, add time of press to pushTimes
    	//On 5th press, add final time to pushTimes and display bpm data
    	if (counter < 4){
    		pushTimes[counter] = System.currentTimeMillis();
    		counter++;
    	} else {
    		
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
    		
    	}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bpm, menu);
        return true;
    }
    
    
    
}
