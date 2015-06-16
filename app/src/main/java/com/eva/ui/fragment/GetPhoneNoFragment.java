package com.eva.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eva.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.InjectView;

import android.support.v4.app.Fragment;

import com.eva.events.EvaEvents;
import com.eva.ui.CountryPicker;
import com.eva.ui.interfaces.CountryPickerListener;

import de.greenrobot.event.EventBus;

/**
 * Created by Dell on 6/12/2015.
 */
public class GetPhoneNoFragment extends Fragment {

    @InjectView(R.id.country_name)
    TextView countryName;

    @InjectView(R.id.country_code)
    TextView countryCode;

    EvaEvents.UpdateActionBarTitleEvent updateActionBarTitleEvent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.get_phone_no, container, false);
        ButterKnife.inject(this, view);
        updateActionBarTitleEvent = new EvaEvents.UpdateActionBarTitleEvent("Phone Number", "", "Done");
        EventBus.getDefault().post(updateActionBarTitleEvent);
        return view;
    }

    @OnClick(R.id.country_name)
    public void onCountryPick(View view) {
        final CountryPicker picker = CountryPicker.newInstance("SelectCountry");
        picker.show(getFragmentManager(), "COUNTRY_CODE_PICKER");
        picker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(String name, String code, String dialCode) {
                countryName.setText(name);
                countryCode.setText(dialCode);
                picker.dismiss();
                updateActionBarTitleEvent.setRightActionUiClass(new GetVerificationCodeFragment().getClass());
            }
        });
    }
}
