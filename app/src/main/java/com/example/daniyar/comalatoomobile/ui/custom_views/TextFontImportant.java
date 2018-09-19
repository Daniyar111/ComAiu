package com.example.daniyar.comalatoomobile.ui.custom_views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextFontImportant extends AppCompatTextView{

    public TextFontImportant(Context context) {
        super(context);
        init();
    }

    public TextFontImportant(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextFontImportant(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        if(!isInEditMode()){
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Important.ttf");
            setTypeface(typeface);
        }
    }
}
