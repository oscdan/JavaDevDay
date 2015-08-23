package alphaws.com.javadevday.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Member;
import alphaws.com.javadevday.commons.AndroidUtils;
import alphaws.com.javadevday.commons.Constant;

/**
 * Created by Daniel on 28/07/2015.
 */
public class ActivitySpeakersDetail extends AppCompatActivity {
    ImageView speakerImage;
    TextView speakerName;
    TextView speakerDetail;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers_detail);
        bar = getSupportActionBar();

        speakerImage = (ImageView) findViewById(R.id.activity_speakers_detail_image);
        speakerName = (TextView) findViewById(R.id.activity_speakers_detail_name);
        speakerDetail = (TextView) findViewById(R.id.activity_speakers_detail_detail);

        AndroidUtils.setRobotoFontRegular(this, speakerDetail);
        AndroidUtils.setRobotoFontBold(this, speakerName);

        Member member = getIntent().getParcelableExtra(Constant.DETAIL_TAG);
        bar.setTitle(member.getName());

        try {
            //speakerName.setText(member.getName());
        }catch(Exception e){

        }
        speakerDetail.setText(member.getDetail());

        Bitmap bitmap = ((BitmapDrawable)getDrawable(this, member.getIdMember())).getBitmap();

        speakerImage.setImageBitmap(Constant.getCircleBitmap(bitmap));
    }

    public Drawable getDrawable(Context context, int idSpeaker){

        String name = "ponente" + idSpeaker;

        return Constant.getDrawable(context, name);
    }
}
