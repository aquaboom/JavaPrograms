package com.auburnuniversity.www.educationalApp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by Sonali on 11/16/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();
    }
    @Test
    public void onClickOfMainMenuButton() throws Exception {

        View view = mActivity.findViewById(R.id.button);
        assertNotNull(view);
    }
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
