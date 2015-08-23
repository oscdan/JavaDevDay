package alphaws.com.javadevday.gui;

import android.app.Activity;
import android.content.Context;
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
import alphaws.com.javadevday.beans.Section;
import alphaws.com.javadevday.commons.AndroidUtils;
import alphaws.com.javadevday.commons.Constant;

/**
 * Created by Daniel on 23/07/2015.
 */
public class AdapterSection extends BaseAdapter{

    static class ViewHolder{
        ImageView sectionImage;
        TextView name;
    }

    private ArrayList<Section> sectionList;
    private LayoutInflater inflater = null;
    private Context context;

    public AdapterSection(Activity activity, ArrayList<Section> sectionList){
        this.sectionList = sectionList;
        this.context = activity.getBaseContext();
        this.inflater =  LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sectionList.size();
    }

    @Override
    public Object getItem(int position) {
        return sectionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Section section = sectionList.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_section, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.item_section_text);
            holder.sectionImage = (ImageView) convertView.findViewById(R.id.item_section_image);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(section.getName());

        switch(section.getSection()){
            case Constant.SECTION_AGENDA:
                holder.sectionImage.setImageResource(R.drawable.ic_action_event);
                break;
            case Constant.SECTION_SPEAKERS:
                holder.sectionImage.setImageResource(R.drawable.ic_action_person);
                break;
            case Constant.SECTION_SCHEDULE:
                holder.sectionImage.setImageResource(R.drawable.ic_action_important);
                break;
        }

        AndroidUtils.setRobotoFontRegular(context, holder.name);

        return convertView;
    }

}
