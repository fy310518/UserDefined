package com.fy.userdifined.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * canvas 位移 操作
 * translate是坐标系的移动，可以为图形绘制选择一个合适的坐标系</br>
 * 注意：位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动
 * Created by fangs on 2018/4/27.
 */
public class CanvasTranslateDemo extends View {

    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public CanvasTranslateDemo(Context context) {
        this(context, null);
    }

    public CanvasTranslateDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //初始化 画笔
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth  = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.GREEN);
        canvas.translate(100, 100);
        canvas.drawCircle(0, 0, 50, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawPoint(0,0, mPaint);

        mPaint.setColor(Color.RED);
        canvas.translate(50, 50);
        canvas.drawCircle(0, 0, 30, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawPoint(0,0, mPaint);

        /**
         * 此处 执行了两次位移操作，两次移动是可叠加的【即：第二次位移操作后 坐标系原点在 屏幕坐标系的（150,150）位置】
         */
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
