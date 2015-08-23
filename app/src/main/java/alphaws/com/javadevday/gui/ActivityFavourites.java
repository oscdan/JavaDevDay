package alphaws.com.javadevday.gui;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Event;
import alphaws.com.javadevday.commons.Constant;
import alphaws.com.javadevday.commons.RecyclerItemClickListener;
import alphaws.com.javadevday.database.ControlEvent;
import alphaws.com.javadevday.database.DataBaseHandler;

public class ActivityFavourites extends ActionBarActivity{

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout Drawer;
    private Toolbar toolbar;
    private  static ArrayList<Event> events;
    protected RecyclerView recyclerView;
    protected TextView noContent;
    private static DataBaseHandler dh;
    private static ControlEvent controlEvent;
    private static  AdapterEvent adapter;
    private static int tam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        noContent = (TextView) findViewById(R.id.activity_favourites_no_content);
        setSupportActionBar(toolbar);

        tam = 0;
        recyclerView = (RecyclerView) findViewById(R.id.activity_favourites_recycler);
        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                       if(tam == events.size()) {
                           try {
                               Event event = events.get(position);
                               Intent detail = new Intent(ActivityFavourites.this, ActivityEventDetail.class);
                               detail.putExtra(Constant.EVENT_DETAIL_TAG, event);
                               startActivity(detail);
                           }catch(Exception e){}
                       }
                        tam = events.size();
                    }
                })
        );

        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };
        Drawer.setDrawerListener(mDrawerToggle);
        Drawer . setFocusableInTouchMode(false);
        mDrawerToggle.syncState();


        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    protected void onResume() {
        super.onResume();
        events = new ArrayList<>();
        dh = new DataBaseHandler(this);
        controlEvent = new ControlEvent(this);

        events = controlEvent.getEventsWhere(dh, DataBaseHandler.FAVOURITE + " = 1 ");

        adapter = new AdapterEvent(this, events);
        adapter.setActivity(0);
        recyclerView.setAdapter(adapter);

        showElements();
    }

    public void showElements(){
        if(events.size() > 0){
            noContent.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }else{
            noContent.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    public void deleteEvent(int pos){
        Event event = events.get(pos);
        controlEvent.updateEvent(dh, event, 0);
        events.remove(pos);
        adapter.notifyDataSetChanged();
        if(pos == tam-1){
            tam = events.size();
        }

        showElements();

    }

    @Override
    public  void onBackPressed ()
    {
        Drawer.closeDrawers();
        super.onBackPressed();
    }

}
