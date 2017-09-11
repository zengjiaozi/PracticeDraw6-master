package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw6.Utils;

import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

/**
 * @author
 * @time 2017/9/11  11:39
 * @desc ${TODD}
 */
public class Practice08ObjectAnimatorView extends View {


    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF arcRectF = new RectF();
    //     圆的半径
    private float radius1 = Utils.dpToPixel(80);
    float process = 0;

    public float getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
//        刷新界面
        invalidate();
    }

    public Practice08ObjectAnimatorView(Context context) {
        super(context, null);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(dpToPixel(50));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        先画出一个圆  获取到当前的圆心
        float currentX = getWidth() / 2;
        float currentY = getHeight() / 2;

//        设置画圆的颜色
        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(dpToPixel(15));
        arcRectF.set(currentX - radius1, currentY - radius1, currentX + radius1, currentY + radius1);
        canvas.drawArc(arcRectF, 0, process * 2.7f, false, paint);
//       canvas.drawRect(arcRectF,paint);
//        画一个文字说明
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) process + "%", currentX, currentY - (paint.ascent() + paint.descent()) / 2, paint);

    }
}
