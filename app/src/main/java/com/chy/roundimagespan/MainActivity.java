package com.chy.roundimagespan;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;

import com.chy.roundimagespan.span.CircleBlueBackgroundSpan;
import com.chy.roundimagespan.span.RoundedBackgroundSpan;
import com.chy.roundimagespan.util.Utils;

public class MainActivity extends Activity {

    TextView text_round,text_circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_round = (TextView) findViewById(R.id.text_round);
        text_circle = (TextView) findViewById(R.id.text_circle);

        // 需要以空格来调整和span的距离
        SpannableString ss = new SpannableString("测试     圆角背景的textview,因为换行无法对齐。圆角背景的textview,因为换行无法对齐。圆角背景的textview,因为换行无法对齐。");
        float textSize = 12 * getResources().getDisplayMetrics().scaledDensity; // sp to px
        ss.setSpan(new RoundedBackgroundSpan(this, 100, Utils.dip2px(this,20), textSize), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text_round.setText(ss);
        // 需要以空格来调整和span的距离
        String displayTitle = getResources().getString(R.string.question_text, 1, "我就是爱测试,圆形背景。主要是用于多行无法对其的事情");
        SpannableString ss_1 = new SpannableString(displayTitle);
        float textSize_1 = 17 * getResources().getDisplayMetrics().scaledDensity; // sp to px
        ss_1.setSpan(new CircleBlueBackgroundSpan(this, textSize_1), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text_circle.setText(ss_1);
    }
}
