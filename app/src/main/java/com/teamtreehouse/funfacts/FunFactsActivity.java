package com.teamtreehouse.funfacts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private TextView mFactLabel;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private String mFact = mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);

        outState.putInt(KEY_COLOR, mColor);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);

        mRelativeLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);
        mFactLabel.setText(mFact);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign them the Views from the layout file
        mFactLabel = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = mFactBook.getFact();
                mFactLabel.setText(mFact);

                mColor = mColorWheel.getColor();
                mRelativeLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }
}
