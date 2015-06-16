package com.eva.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eva.R;
import com.eva.events.EvaEvents;
import com.eva.ui.CountryPicker;
import com.eva.ui.HomeActivity;
import com.eva.ui.interfaces.CountryPickerListener;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by Dell on 6/12/2015.
 */
public class GetVerificationCodeFragment extends Fragment {



    EvaEvents.UpdateActionBarTitleEvent updateActionBarTitleEvent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.get_verification_code, container, false);
        ButterKnife.inject(this, view);
        updateActionBarTitleEvent = new EvaEvents.UpdateActionBarTitleEvent("Verification Code", "", "Done");
        EventBus.getDefault().post(updateActionBarTitleEvent);
        updateActionBarTitleEvent.setRightActionUiClass(new HomeActivity().getClass());
        return view;
    }
}
