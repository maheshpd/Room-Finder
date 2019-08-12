package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arfeenkhan.roomfinder.Adapter.WalkthroughPagerAdapter;
import com.arfeenkhan.roomfinder.R;

public class Walkthrough extends AppCompatActivity implements View.OnClickListener {
    //Widget
    TextView privacy_text;
    Button guest_btn, fb_btn, next_btn, prev_btn;
    LinearLayout dot_layout;
    ViewPager viewPager;

    private WalkthroughPagerAdapter walkthroughPagerAdapter;


    private int[] layout = {R.layout.first_slider, R.layout.second_slider, R.layout.third_slider, R.layout.four_slider};
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        getSupportActionBar().hide();
        //init widget
        initWidget();
    }

    private void initWidget() {
        privacy_text = findViewById(R.id.privacy_text);
        guest_btn = findViewById(R.id.guestBtn);
        fb_btn = findViewById(R.id.facebook_btn);

        String startofprivacy = "<font color='#D1CACA'>By continuing you are agreeing to our</font>";
        String endofprivacy = "<font color='#FFFFFF'> Privacy Policy & Terms of Use</font>";

        privacy_text.setText(Html.fromHtml(startofprivacy + "\n" + endofprivacy));

        viewPager = findViewById(R.id.walkthrough_viewPager);
        walkthroughPagerAdapter = new WalkthroughPagerAdapter(layout, this);
        viewPager.setAdapter(walkthroughPagerAdapter);
        dot_layout = findViewById(R.id.dotsLayout);
        createDots(0);

        next_btn = findViewById(R.id.nextBtn);
        prev_btn = findViewById(R.id.prevBtn);

        next_btn.setOnClickListener(this);
        prev_btn.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);

                if (position == layout.length - 1) {
                    next_btn.setText("Start");
                    next_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            loadLoginActivity();

                        }
                    });
                } else {
                    next_btn.setText("Next");
                    prev_btn.setVisibility(View.VISIBLE);
                    prev_btn.setText("Prev");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void loadLoginActivity() {
        startActivity(new Intent(Walkthrough.this, Login.class));
        finish();
    }

    private void createDots(int current_position) {
        if (dot_layout != null) {
            dot_layout.removeAllViews();
            dots = new ImageView[layout.length];

            for (int i = 0; i < layout.length; i++) {
                dots[i] = new ImageView(this);

                if (i == current_position) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
                } else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dot));
                }

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4, 0, 4, 0);
                dot_layout.addView(dots[i], params);
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.nextBtn) {
            int next_slider = viewPager.getCurrentItem() + 1;
            prev_btn.setVisibility(View.VISIBLE);
            if (next_slider < layout.length) {
                viewPager.setCurrentItem(next_slider);
            } else {
                loadLoginActivity();
            }

        } else if (id == R.id.prevBtn) {
            int prev_slider = viewPager.getCurrentItem() - 1;

            if (prev_slider < layout.length+1) {
                prev_btn.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(prev_slider);
            } else {

            }
        }
    }
}
