package ra1vi2.saveme;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jaihanuman on 7/4/16.
 */
public class MyReceiver extends BroadcastReceiver {
    static int countPowerOff = 0;
    private Activity activity = null;

    public MyReceiver()
    {}

    public MyReceiver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("onReceive", "Power button is pressed.");


        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            countPowerOff++;
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            if (countPowerOff == 3) {
                Intent i = new Intent(activity, MainActivity.class);
                activity.startActivity(i);

            }
            else
            {
                countPowerOff++;
            }

        }

    }
}