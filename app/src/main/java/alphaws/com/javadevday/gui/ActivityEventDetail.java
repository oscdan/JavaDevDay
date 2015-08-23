package alphaws.com.javadevday.gui;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Event;
import alphaws.com.javadevday.commons.AndroidUtils;
import alphaws.com.javadevday.commons.Constant;

/**
 * Created by Daniel on 04/08/2015.
 */
public class ActivityEventDetail extends AppCompatActivity {
    TextView eventName;
    TextView by;
    TextView speakerName;
    TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        eventName = (TextView) findViewById(R.id.activity_event_detail_name);
        by = (TextView) findViewById(R.id.activity_event_detail_by);
        speakerName = (TextView) findViewById(R.id.activity_event_detail_speaker);
        detail = (TextView) findViewById(R.id.activity_speakers_detail_detail);

        AndroidUtils.setRobotoFontRegular(this, eventName);
        AndroidUtils.setRobotoFontThin(this, by);
        AndroidUtils.setRobotoFontThin(this, speakerName);
        AndroidUtils.setRobotoFontRegular(this, detail);

        Event event = getIntent().getParcelableExtra(Constant.EVENT_DETAIL_TAG);
        eventName.setText(event.getDetail());

        if(event.getSpeakers().length() > 0) {
            by.setText(this.getResources().getString(R.string.event_detail_by));
            speakerName.setText(event.getSpeakers());
        }else{
            by.setVisibility(View.GONE);
            speakerName.setVisibility(View.GONE);
        }
        detail.setText(event.getDescription());
    }
}
