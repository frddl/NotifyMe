package app.faridmammadov.notifyme;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nTitle, nDescription;
    Button create, reset;
    ImageButton error, highPriority, alarmClock, plusOne;
    int icon = 0;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nTitle = (EditText) findViewById(R.id.nTitle);
        nDescription = (EditText) findViewById(R.id.nDescription);
        create = (Button) findViewById(R.id.create);
        reset = (Button) findViewById(R.id.reset);
        error = (ImageButton) findViewById(R.id.error);
        highPriority = (ImageButton) findViewById(R.id.highPriority);
        alarmClock = (ImageButton) findViewById(R.id.alarmClock);
        plusOne = (ImageButton) findViewById(R.id.plusOne);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pushTitle = StringOf(nTitle);
                String pushDescription = StringOf(nDescription);

                if (pushTitle.equalsIgnoreCase("") || pushDescription.equalsIgnoreCase(""))
                    Toast.makeText(MainActivity.this, "Please, fill in all gaps", Toast.LENGTH_SHORT).show();
                else if (icon == 0) Toast.makeText(MainActivity.this, "Pick up an icon", Toast.LENGTH_SHORT).show();
                else {
                    NotificationCompat.Builder mBuilder =
                            new NotificationCompat.Builder(view.getContext())
                                    .setSmallIcon(icon)
                                    .setContentTitle(pushTitle)
                                    .setContentText(pushDescription);

                    NotificationManager mNotificationManager =
                            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                    mNotificationManager.notify(counter, mBuilder.build());
                    counter++;

                    Toast.makeText(MainActivity.this, "Notification Created!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = R.drawable.ic_error_outline_white_48dp;
                error.setImageResource(R.drawable.ic_check_white_48dp);
                highPriority.setImageResource(R.drawable.ic_priority_high_white_48dp);
                alarmClock.setImageResource(R.drawable.ic_notifications_active_white_48dp);
                plusOne.setImageResource(R.drawable.ic_plus_one_white_48dp);
            }
        });

        highPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = R.drawable.ic_priority_high_white_48dp;
                highPriority.setImageResource(R.drawable.ic_check_white_48dp);
                alarmClock.setImageResource(R.drawable.ic_notifications_active_white_48dp);
                error.setImageResource(R.drawable.ic_error_outline_white_48dp);
                plusOne.setImageResource(R.drawable.ic_plus_one_white_48dp);
            }
        });

        alarmClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = R.drawable.ic_notifications_active_white_48dp;
                alarmClock.setImageResource(R.drawable.ic_check_white_48dp);
                highPriority.setImageResource(R.drawable.ic_priority_high_white_48dp);
                error.setImageResource(R.drawable.ic_error_outline_white_48dp);
                plusOne.setImageResource(R.drawable.ic_plus_one_white_48dp);
            }
        });

        plusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = R.drawable.ic_plus_one_white_48dp;
                plusOne.setImageResource(R.drawable.ic_check_white_48dp);
                highPriority.setImageResource(R.drawable.ic_priority_high_white_48dp);
                error.setImageResource(R.drawable.ic_error_outline_white_48dp);
                alarmClock.setImageResource(R.drawable.ic_notifications_active_white_48dp);
            }
        });
    }

    private void reset(){
        nTitle.setText("");
        nDescription.setText("");
        plusOne.setImageResource(R.drawable.ic_plus_one_white_48dp);
        highPriority.setImageResource(R.drawable.ic_priority_high_white_48dp);
        error.setImageResource(R.drawable.ic_error_outline_white_48dp);
        alarmClock.setImageResource(R.drawable.ic_notifications_active_white_48dp);
    }

    private String StringOf(EditText editText) {
        String string = String.valueOf(editText.getText());
        return string;
    }
}
