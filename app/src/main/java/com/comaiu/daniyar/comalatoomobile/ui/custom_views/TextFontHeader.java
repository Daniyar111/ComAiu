package com.comaiu.daniyar.comalatoomobile.ui.custom_views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextFontHeader extends AppCompatTextView{

    public TextFontHeader(Context context) {
        super(context);
        init();
    }

    public TextFontHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextFontHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        if(!isInEditMode()){
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/FFF_Tusj.ttf");
            setTypeface(typeface);
        }
    }
}
