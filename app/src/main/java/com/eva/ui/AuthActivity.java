package com.eva.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.support.v4.app.Fragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.eva.R;
import android.support.v7.widget.Toolbar;

import de.greenrobot.event.EventBus;

import com.eva.events.EvaEvents;
import com.eva.ui.fragment.GetPhoneNoFragment;

/**
 * Created by dell on 6/8/2015.
 */
public class AuthActivity extends AppCompatActivity {

    @InjectView(R.id.tool_bar)
    Toolbar toolbar;

    @InjectView(R.id.toolbar_left_action)
    TextView leftActionText;

    @InjectView(R.id.toolbar_title)
    TextView CenterActionText;

    @InjectView(R.id.toolbar_right_action)
    TextView rightActionText;

    EvaEvents.UpdateActionBarTitleEvent event;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        EventBus.getDefault().register(this);
        if (savedInstanceState == null) {
            GetPhoneNoFragment fragment = new GetPhoneNoFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
        }
    }

    public void onEvent(EvaEvents.UpdateActionBarTitleEvent event) {
        this.event = event;
        leftActionText.setText(event.getLeftActionText());
        CenterActionText.setText(event.getTitle());
        rightActionText.setText(event.getRightActionText());
    }


    public void onRightAction(View view){
        if(event.getRightActionUiClass() !=null) {
            try{
                if(event.getRightActionUiClass().newInstance() instanceof Fragment) {
                    Fragment fragment = (Fragment) event.getRightActionUiClass().newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }else if(event.getRightActionUiClass().newInstance() instanceof Activity){
                    Intent intent = new Intent(getApplicationContext(),event.getRightActionUiClass());
                    startActivity(intent);
                }
            }
            catch (InstantiationException e) {}
            catch (IllegalAccessException e) {}

        }

    }


}
