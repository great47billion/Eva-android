package com.eva.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.content.Context;

import com.eva.R;
import com.eva.events.EvaEvents;
import com.eva.ui.fragment.NewEventFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;

/**
 * Created by dell on 6/8/2015.
 */
public class HomeActivity extends AppCompatActivity {

    @InjectView(R.id.tool_bar)
    Toolbar toolbar;

    @InjectView(R.id.toolbar_left_action)
    TextView leftActionText;

    @InjectView(R.id.toolbar_title)
    TextView CenterActionText;

    @InjectView(R.id.toolbar_right_action)
    TextView rightActionText;

    EvaEvents.UpdateActionBarTitleEvent event;

    @InjectView(android.R.id.tabhost)
    FragmentTabHost mTabHost;

    EvaEvents.UpdateActionBarTitleEvent updateActionBarTitleEvent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.inject(this);
        setTabs() ;
        EventBus.getDefault().register(this);
    }

    public void onEvent(EvaEvents.UpdateActionBarTitleEvent event) {
        this.event = event;
        leftActionText.setText(event.getLeftActionText());
        CenterActionText.setText(event.getTitle());
        rightActionText.setText(event.getRightActionText());
    }

    private void setTabs() {
        //mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator(getTabIndicator(this,R.string.new_event,R.drawable.ic_launcher)),
                NewEventFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator(getTabIndicator(this,R.string.upcoming,R.drawable.ic_launcher)),
                NewEventFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator(getTabIndicator(this,R.string.settings,R.drawable.ic_launcher)),
                NewEventFragment.class, null);
    }


    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        ImageView iv = (ImageView) view.findViewById(R.id.tab_img);
        iv.setImageResource(icon);
        TextView tv = (TextView) view.findViewById(R.id.tab_txt);
        tv.setText(title);
        return view;
    }

}
