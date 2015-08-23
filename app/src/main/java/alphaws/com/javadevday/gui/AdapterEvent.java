package alphaws.com.javadevday.gui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Event;
import alphaws.com.javadevday.commons.AndroidUtils;

/**
 * Created by oscarvargas on 06/08/15.
 */
public class AdapterEvent extends RecyclerView.Adapter<AdapterEvent.EventViewHolder> {

    private ArrayList<Event> events;
    private Context context;
    private int activity;

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventName;
        TextView speakerName;
        TextView eventSchedule;
        ImageView favourite;
        ImageView englishFlag;

        EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.item_favourite_card);
            eventName = (TextView) itemView.findViewById(R.id.item_favourite_event);
            speakerName = (TextView) itemView.findViewById(R.id.item_favourite_speaker);
            eventSchedule = (TextView) itemView.findViewById(R.id.item_favourite_schedule);
            favourite = (ImageView) itemView.findViewById(R.id.item_favourite_star);
            englishFlag = (ImageView) itemView.findViewById(R.id.item_favourite_flag);
        }
    }

    AdapterEvent(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public AdapterEvent.EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_favourite, viewGroup, false);
        EventViewHolder pvh = new EventViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final EventViewHolder eventViewHolder, final int i) {
        eventViewHolder.eventName.setText(events.get(i).getDetail());
        eventViewHolder.speakerName.setText(events.get(i).getSpeakers());
        eventViewHolder.eventSchedule.setText(events.get(i).getStartHour() + " - " + events.get(i).getFinalHour());
        if (!events.get(i).isFavourite()) {
            eventViewHolder.favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.white_star));
        }else{
            eventViewHolder.favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.favourite));
        }

       if(events.get(i).getIdEvent() == 3 || events.get(i).getIdEvent() == 7 || events.get(i).getIdEvent() == 10 || events.get(i).getIdEvent() == 17
               || events.get(i).getIdEvent() == 19 || events.get(i).getIdEvent() == 19 || events.get(i).getIdEvent() == 20
               || events.get(i).getIdEvent() == 21 || events.get(i).getIdEvent() == 22 || events.get(i).getIdEvent() == 23
               || events.get(i).getIdEvent() == 24 || events.get(i).getIdEvent() == 25 || events.get(i).getIdEvent() == 27
               || events.get(i).getIdEvent() == 31 || events.get(i).getIdEvent() == 35 || events.get(i).getIdEvent() == 38
               || events.get(i).getIdEvent() == 40 || events.get(i).getIdEvent() == 34 ||  events.get(i).getIdEvent() == 33){
           eventViewHolder.englishFlag.setVisibility(View.VISIBLE);
       }
        else{
           eventViewHolder.englishFlag.setVisibility(View.INVISIBLE);
       }

        eventViewHolder.favourite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (activity == 0) {
                    //ActivityFavourites.deleteEvent(i);
                    ((ActivityFavourites) context).deleteEvent(i);
                    //eventViewHolder.favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.estrella));
                } else if (activity == 1) {
                    FragmentEvent.flag = 1;
                    if (events.get(i).isFavourite()) {
                        eventViewHolder.favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.white_star));
                        //events.get(i).setFavourite(true);
                    } else {
                        eventViewHolder.favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.favourite));
                        //events.get(i).setFavourite(false);
                    }
                    //eventViewHolder.favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.favourite));
                }
                return false;
            }
        });


        AndroidUtils.setRobotoFontRegular(context, eventViewHolder.eventName);
        AndroidUtils.setRobotoFont(context, eventViewHolder.speakerName);
        AndroidUtils.setRobotoFont(context, eventViewHolder.eventSchedule);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
