package com.zyou.askphone;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;


public class AlwaysMarqueeTextView extends android.support.v7.widget.AppCompatTextView {

    public AlwaysMarqueeTextView(Context context){
        super(context);
        init();
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setMarqueeRepeatLimit(-1);
        setSingleLine(true);
        setHorizontallyScrolling(true);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}

