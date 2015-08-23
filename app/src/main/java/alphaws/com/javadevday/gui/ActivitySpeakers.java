package alphaws.com.javadevday.gui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Member;
import alphaws.com.javadevday.commons.Constant;
import alphaws.com.javadevday.database.ControlMember;
import alphaws.com.javadevday.database.DataBaseHandler;


/**
 * Created by Daniel on 23/07/2015.
 */
public class ActivitySpeakers extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private ListView speakersList;
    private ArrayList<Member> members;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout Drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);
        speakersList = (ListView) findViewById(R.id.activity_speakers_listView);
        speakersList.setOnItemClickListener(this);

        ControlMember memberControl = new ControlMember(this);
        DataBaseHandler dh = DataBaseHandler.getInstance(this);
        members = new ArrayList<>();
        members = memberControl.getMembersWhere(dh, null);

        AdapterSpeakers speakerAdapter = new AdapterSpeakers(this, members);
        speakersList.setAdapter(speakerAdapter);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

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
        mDrawerToggle.syncState();

    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Member member = members.get(position);
        Intent detail = new Intent(ActivitySpeakers.this, ActivitySpeakersDetail.class);
        detail.putExtra(Constant.DETAIL_TAG, member);
        startActivity(detail);
    }
}
