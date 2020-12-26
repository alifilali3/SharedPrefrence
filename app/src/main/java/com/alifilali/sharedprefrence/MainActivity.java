package com.alifilali.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPrefrences;
    private SharedPreferences.Editor mEditor;
    private EditText mEmail , mPass;
    private CheckBox mRemebre;
    private Button mbtnlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mEmail = (EditText) findViewById(R.id.email);
            mPass = (EditText) findViewById(R.id.pass);
            mRemebre = (CheckBox) findViewById(R.id.checkbox);
            mbtnlog = (Button) findViewById(R.id.login);
            mPrefrences = PreferenceManager.getDefaultSharedPreferences(this);

            mEditor = mPrefrences.edit();
checkSharedPreferences();
mbtnlog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(mRemebre.isChecked())
        {
       mEditor.putString(getString(R.string.checkbox), "True");
       mEditor.commit();

            String email = mEmail.getText().toString();
            mEditor.putString(getString(R.string.email), email);
            mEditor.commit();

            String pass = mPass.getText().toString();
            mEditor.putString(getString(R.string.pass), pass);
            mEditor.commit();
        }else{
            mEditor.putString(getString(R.string.checkbox), "False");
            mEditor.commit();


            mEditor.putString(getString(R.string.checkbox), "");
            mEditor.commit();


            mEditor.putString(getString(R.string.pass), "");
            mEditor.commit();

        }
        Toast.makeText(MainActivity.this, "Information Saved !" , Toast.LENGTH_LONG).show();

    }
});
                   /*

                     boolean checked = mRemebre.isChecked();
                     //SharedPreferences.Editor editor = sharedPreferences.edit();


                     mEditor.putBoolean("CHECKBOX", checked);
                     mEditor.apply();

                    Toast.makeText(MainActivity.this, "Information Saved !" , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
                   startActivity(intent);
                   finish();*/
    }

    private  void   checkSharedPreferences(){
   String checkbox = mPrefrences.getString(getString(R.string.checkbox), "False");
   String email = mPrefrences.getString(getString(R.string.email), "");
   String pass = mPrefrences.getString(getString(R.string.pass), "");
        mEmail.setText(email);
        mPass.setText(pass);
        if(checkbox.equals("True"))
        {
            mRemebre.setChecked(true);
        }else{
            mRemebre.setChecked(false);

        }
    }
            };

