package com.example.daniyar.comalatoomobile.ui.custom_views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextFonItemName extends AppCompatTextView {
    public TextFonItemName(Context context) {
        super(context);
        init();
    }

    public TextFonItemName(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextFonItemName(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        if(!isInEditMode()){
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DancingScript-Regular.otf"));
        }
    }
}
