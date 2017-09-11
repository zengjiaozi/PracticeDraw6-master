package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

/**
 * @author
 * @time 2017/9/11  11:31
 * @desc ${TODD}
 */
public class Practice08ObjectAnimatorLayout extends RelativeLayout {


    private Button animateBt8;
    private EditText editText8;
    private Practice08ObjectAnimatorView  view8;


    public Practice08ObjectAnimatorLayout(Context context) {
        super(context, null);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        获取控件
        animateBt8 = (Button) findViewById(R.id.animateBt8);
        view8 = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView8);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = editText8.getText().toString();
                int process2 = 0;
                if (!TextUtils.isEmpty(str)) {
                    process2 = Integer.parseInt(str);

                }
                Log.i("zeng ", "process2 =" + process2);
                view8.setProcess(process2);
            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });

        animateBt8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zeng ", "点击了");
                int progress = (int) view8.getProcess();
                Log.i("zeng", "process  =" + progress);

                ObjectAnimator animator = ObjectAnimator.ofFloat(view8, "progress", 0, progress);
                animator.setDuration(1000);
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.start();

            }
        });


    }


}
