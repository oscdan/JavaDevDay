package alphaws.com.javadevday.gui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Member;
import alphaws.com.javadevday.commons.AndroidUtils;
import alphaws.com.javadevday.commons.Constant;

/**
 * Created by Daniel on 23/07/2015.
 */
public class AdapterSpeakers extends BaseAdapter{

    static class ViewHolder{
        ImageView speakerImage;
        TextView name;
    }

    private ArrayList<Member> memberList;
    private LayoutInflater inflater = null;
    private Context context;

    public AdapterSpeakers(Activity activity, ArrayList<Member> memberList){
        this.memberList = memberList;
        this.context = activity.getBaseContext();
        this.inflater =  LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Object getItem(int position) {
        return memberList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Member member = memberList.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_speakers, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.item_speakers_speaker_name);
            holder.speakerImage = (ImageView) convertView.findViewById(R.id.item_speakers_speaker_image);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(member.getName());

        Bitmap bitmap = ((BitmapDrawable)getDrawable(context, member.getIdMember())).getBitmap();
        holder.speakerImage.setImageBitmap(Constant.getCircleBitmap(bitmap));

        AndroidUtils.setRobotoFontRegular(context, holder.name);

        return convertView;
    }

    public Drawable getDrawable(Context context, int idSpeaker){
        String name = "ponente" + idSpeaker;
        return Constant.getDrawable(context, name);
    }

}
