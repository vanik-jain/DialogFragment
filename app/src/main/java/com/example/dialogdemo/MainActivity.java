package com.example.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CustomDialog.CustomDialogListener
{
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.email);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog();
                customDialog.show(getSupportFragmentManager(),"CustomDialog");
            }
        });

    }

    @Override
    public void onSignInClick(DialogFragment dialogFragment)
    {
        if (dialogFragment.getDialog().findViewById(R.id.username) != null)
        {
            EditText editText = dialogFragment.getDialog().findViewById(R.id.username);
            String email = editText.getText().toString();
            textView.setText(email);
        }

    }



}
