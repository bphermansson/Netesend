package nu.paheco.patrik.netesend;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    String baseUrL = "http://192.168.1.7/hc/sendCommand.php?port=serial/by-id/usb-Telldus_Homeautomation_USB-Dongle_TS000007-if00-port0&proto=NEXA&";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        String houses[] = {"C", "P", "X"};
        Integer channels[] = {3,2,1,0};
        int switches = 0;
        for (switches=0; switches<=2; switches++) {
            String curSwitch = "switch" + String.valueOf(switches) + ":" + houses[switches] + String.valueOf(channels[switches]);
            Log.d("curSwitch:", curSwitch);
            curSwitch = "switch" + String.valueOf(switches);
            Switch switchX = (Switch) findViewById(R.id.curSwitch);

        }
*/
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=C&channel=3&onoff=on");
                    new NexaSend().execute(getUrl);
                } else {
                    // The toggle is disabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=C&channel=3&onoff=off");
                    new NexaSend().execute(getUrl);
                }
            }
        });
        Switch switch2 = (Switch) findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=P&channel=2&onoff=on");
                    new NexaSend().execute(getUrl);
                } else {
                    // The toggle is disabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=P&channel=2&onoff=off");
                    new NexaSend().execute(getUrl);
                }
            }

        });

        Switch switch3 = (Switch) findViewById(R.id.switch3);
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=C&channel=2&onoff=on");
                    new NexaSend().execute(getUrl);
                } else {
                    // The toggle is disabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=C&channel=2&onoff=off");
                    new NexaSend().execute(getUrl);
                }
            }

        });

        Switch switch4 = (Switch) findViewById(R.id.switch4);
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=B&channel=3&onoff=on");
                    new NexaSend().execute(getUrl);
                } else {
                    // The toggle is disabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=B&channel=3&onoff=off");
                    new NexaSend().execute(getUrl);
                }
            }

        });

        Switch switch5 = (Switch) findViewById(R.id.switch5);
        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=P&channel=2&onoff=on");
                    new NexaSend().execute(getUrl);
                } else {
                    // The toggle is disabled
                    buttonView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    String getUrl = baseUrL.concat("house=P&channel=2&onoff=off");
                    new NexaSend().execute(getUrl);
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Log.d("Call ","settings");
            Intent intent = new Intent(this, settings.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
