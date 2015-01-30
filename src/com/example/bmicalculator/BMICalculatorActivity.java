package com.example.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculatorActivity extends Activity {
	
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void calculateClickHandler(View view) {
		if (view.getId() == R.id.calculateButton){
			
			EditText weightText = (EditText)findViewById(R.id.weightText);
			EditText heightText = (EditText)findViewById(R.id.heightText);
			TextView resultText = (TextView)findViewById(R.id.resultLabel);
			
			float weight = Float.parseFloat(weightText.getText().toString());
			float height = Float.parseFloat(heightText.getText().toString());
			
			float bmiValue = calculateBMI(weight, height);
			
			String bmiInterpretation = interpretBMI(bmiValue);
			
			resultText.setText(bmiValue + "-" + bmiInterpretation);
		}
	}
	
	
	private float calculateBMI (float weight, float height){
		return (float) (weight * 4.88 / (height * height));
	}
	
	
	private String interpretBMI(float bmiValue) {
		
		if (bmiValue < 16){
			return "underweight";
		}
		else if (bmiValue < 18.5){
			return "underweighter";
		}
		else if (bmiValue < 25){
			return "Normal";
		}
		else if (bmiValue < 30){
			return "overweight";
		}
		else{
			return "Shrek";
		}
	}
	
}