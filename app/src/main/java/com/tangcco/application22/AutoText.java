package com.tangcco.application22;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tangcco.application22.ui.AutoScrollTextView;


public class AutoText extends Activity {
    private AutoScrollTextView autoScrollTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text);
        autoScrollTextView = (AutoScrollTextView) findViewById(R.id.auto);
        autoScrollTextView.init(getWindowManager());
        autoScrollTextView.startScroll();
    }


}
