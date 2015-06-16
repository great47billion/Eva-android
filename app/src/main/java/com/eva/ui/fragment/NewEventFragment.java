package com.eva.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eva.R;
import com.eva.events.EvaEvents;
import com.eva.ui.HomeActivity;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by Dell on 6/12/2015.
 */
public class NewEventFragment extends Fragment {



    EvaEvents.UpdateActionBarTitleEvent updateActionBarTitleEvent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.new_event, container, false);
        ButterKnife.inject(this, view);
        updateActionBarTitleEvent = new EvaEvents.UpdateActionBarTitleEvent("New Event", "", "Done");
        EventBus.getDefault().post(updateActionBarTitleEvent);
        //updateActionBarTitleEvent.setRightActionUiClass(new HomeActivity().getClass());
        return view;
    }
}
