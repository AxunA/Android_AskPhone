package com.zyou.askphone;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.zyou.askphone.databinding.ActivityAskPhoneBinding;

public class AskPhoneActivity extends AppCompatActivity {

    private ActivityAskPhoneBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBinding=ActivityAskPhoneBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_save:
                String inputContent=mBinding.etInputPhone.getText().toString();
                if(TextUtils.isEmpty(inputContent)){
                    Toast.makeText(this,"输入不能为空哦",Toast.LENGTH_LONG).show();
                    return;
                }
                mBinding.tvPhone.setText(inputContent);
                mBinding.llAsk.setVisibility(View.GONE);
                mBinding.llThanks.setVisibility(View.VISIBLE);
                hideKeyboard(this,mBinding.etInputPhone);
                break;
        }
    }

//    @Override
//    public void onBackPressed() {
//        //防止误触
//    }

    /**
     * 隐藏输入面板
     */
    public static void hideKeyboard(final Context context, final EditText input) {
        final InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
    }
}
