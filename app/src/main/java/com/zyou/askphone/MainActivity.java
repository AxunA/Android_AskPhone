package com.zyou.askphone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zyou.askphone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ask_phone:
                startActivity(new Intent(this,AskPhoneActivity.class));
                break;
            case R.id.btn_show_big_text:
                String text=mBinding.etInputText.getText().toString();
                if(TextUtils.isEmpty(text)){
                    Toast.makeText(this,R.string.click_input_content,Toast.LENGTH_SHORT).show();
                    return ;
                }
                BigTextActivity.startActivity(this,text);
                break;
        }
    }
}
