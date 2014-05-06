package org.dutchaug.workshop.beginners.intentions;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity implements View.OnClickListener {

    private EditText mEmailAddress;

    private EditText mEmailSubject;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mEmailAddress = (EditText) findViewById(R.id.email_address);
        mEmailSubject = (EditText) findViewById(R.id.email_subject);

        mButton = (Button) findViewById(R.id.next);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Exercise 03.01
    }

}