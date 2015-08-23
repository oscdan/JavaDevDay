package alphaws.com.javadevday.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Event;
import alphaws.com.javadevday.commons.Constant;
import alphaws.com.javadevday.commons.RecyclerItemClickListener;
import alphaws.com.javadevday.database.ControlEvent;
import alphaws.com.javadevday.database.DataBaseHandler;

/**
 * Created by osvargas on 8/12/15.
 */
public class FragmentEvent extends Fragment{
    private ArrayList<Event> events;
    public static int flag;
    private DataBaseHandler dh;
    private ControlEvent controlEvent;
    private AdapterEvent adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource that'll be returned
        View rootView = inflater.inflate(R.layout.fragment_event, container, false);

        // Get the arguments that was supplied when
        // the fragment was instantiated in the
        // CustomPagerAdapter
        dh = new DataBaseHandler(getActivity());
        controlEvent = new ControlEvent(getActivity());
        Bundle args = getArguments();
        RecyclerView rv = ((RecyclerView) rootView.findViewById(R.id.fragment_event_list));  //.setText(args.getString("title"));
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        events = args.getParcelableArrayList("events");
        adapter = new AdapterEvent(getActivity(), events);
        adapter.setActivity(1);
        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Event event = null;
                        try{event = events.get(position);}catch(Exception e){}
                        if(event == null) return;
                        if (flag != 1) {
                            Intent detail = new Intent(getActivity(), ActivityEventDetail.class);
                            detail.putExtra(Constant.EVENT_DETAIL_TAG, event);
                            startActivity(detail);
                        } else {
                            if (event.isFavourite()) {
                                controlEvent.updateEvent(dh, event, 0);
                                event.setFavourite(false);
                            } else {
                                controlEvent.updateEvent(dh, event, 1);
                                event.setFavourite(true);
                            }
                            //adapter.notifyDataSetChanged();
                        }
                        flag = 0;
                    }
                })
        );

        return rootView;
    }

    public void notifyDataSetChanged(){
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}

