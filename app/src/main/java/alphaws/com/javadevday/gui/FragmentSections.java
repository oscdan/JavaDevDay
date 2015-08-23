package alphaws.com.javadevday.gui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Section;
import alphaws.com.javadevday.commons.Constant;

/**
 * Created by oscarvargas on 05/08/15.
 */
public class FragmentSections extends Fragment {

    private ListView mDrawerList;
    private ArrayList<Section> sections;
    private AdapterSection adapterSection;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Section section1 = new Section(Constant.SECTION_AGENDA, getString(R.string.section_agenda));
        Section section2 = new Section(Constant.SECTION_SCHEDULE, getString(R.string.section_schedule));
        Section section3 = new Section(Constant.SECTION_SPEAKERS, getString(R.string.section_speaker));
        sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        sections.add(section3);


        adapterSection = new AdapterSection(getActivity(), sections);

        mDrawerList = (ListView) getView().findViewById(R.id.fragment_sections_list);
        mDrawerList.setAdapter(adapterSection);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case Constant.SECTION_AGENDA:
                        Intent agenda = new Intent(getActivity(), ActivityMain.class);
                        startActivityForResult(agenda, Constant.SECTION_AGENDA);
                        break;
                    case Constant.SECTION_SPEAKERS:
                        Intent intent = new Intent(getActivity(), ActivitySpeakers.class);
                        startActivityForResult(intent, Constant.SECTION_AGENDA);
                        break;
                    case Constant.SECTION_SCHEDULE:
                        Intent favourites = new Intent(getActivity(), ActivityFavourites.class);
                        startActivityForResult(favourites, Constant.SECTION_AGENDA);
                        break;
                }
            }
        });

    }

   // @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sections,container,false);
        return  view ;
    }
}
