package com.zyou.askphone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.zyou.askphone.databinding.ActivityBigTextBinding;

public class BigTextActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityBigTextBinding mBinding;
    public final static String INTENT_TEXT="intent_text";

    public static void startActivity(Context context,String text){
        Intent intent=new Intent(context,BigTextActivity.class);
        intent.putExtra(INTENT_TEXT,text);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBinding= ActivityBigTextBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent=getIntent();
        String text=intent.getStringExtra(INTENT_TEXT);
        Log.d("fzy","text:"+text);

        mBinding.tvBigText.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                finish();
                break;
        }
    }
}
