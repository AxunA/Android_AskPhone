package com.zyou.askphone;

import android.content.Context;
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

public class MainActivity extends AppCompatActivity {

    private EditText mInputPhoneEt;
    private LinearLayout mAskLl;
    private LinearLayout mThanksLl;
    private TextView mInputContentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mInputPhoneEt=(EditText)findViewById(R.id.et_input_phone);
        mAskLl=(LinearLayout)findViewById(R.id.ll_ask);
        mThanksLl=(LinearLayout)findViewById(R.id.ll_thanks);
        mInputContentTv=(TextView)findViewById(R.id.tv_phone);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_save:
                String inputContent=mInputPhoneEt.getText().toString();
                if(TextUtils.isEmpty(inputContent)){
                    Toast.makeText(this,"输入不能为空哦",Toast.LENGTH_LONG).show();
                    return;
                }

                mInputContentTv.setText(inputContent);
                mAskLl.setVisibility(View.GONE);
                mThanksLl.setVisibility(View.VISIBLE);

                hideKeyboard(this,mInputPhoneEt);

                break;
        }
    }

    @Override
    public void onBackPressed() {
    }

    /**
     * 隐藏输入面板
     * @param context
     * @param input
     */
    public static void hideKeyboard(final Context context, final EditText input) {
        final InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
    }
}
