package net.emobilis;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	double conv_rate=2.2;
	double weightEnterd;
	double conv_weight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final EditText weight=(EditText)findViewById(R.id.txtWeight);
		final RadioButton toPounds=(RadioButton)findViewById(R.id.rdToP);
		final RadioButton toKg=(RadioButton) findViewById(R.id.rdToKg);
		final TextView result=(TextView)findViewById(R.id.lbResult);
		Button convert=(Button)findViewById(R.id.btnConvert);
		
	
		convert.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				weightEnterd=Double.parseDouble(weight.getText().toString());
				DecimalFormat f=new DecimalFormat("##.##");
				
				if(toPounds.isChecked())
				{
					if(weightEnterd<=500)
					{
						conv_weight=weightEnterd*conv_rate;
						result.setText("Converted weight"+f.format(conv_weight)+"pounds");
					}
					
					else
					{
						Toast.makeText(getApplicationContext(), "overweight", Toast.LENGTH_SHORT).show();
					}
				}
				else if(toKg.isChecked())
				{
					if(weightEnterd>=0)
					{
						conv_weight=weightEnterd/conv_rate;
						result.setText("Converted weight"+f.format(conv_weight)+"Kgs");
					}
					else
					{
						Toast.makeText(getApplicationContext(), "weight cant be below zero", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					conv_weight=weightEnterd/conv_rate;
				}
				result.setText("Converted Weight: "+conv_weight);
			}
		});
			
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
