package com.fy.userdifined.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.fy.userdifined.util.ResourceUtils;

import java.util.List;

/**
 * 绘制基本图形 & 自定义 饼图 demo
 * 参考：https://github.com/GcsSloop/AndroidNote/blob/master/CustomView/Advance/%5B02%5DCanvas_BasicGraphics.md
 * Created by fangs on 2018/4/26.
 */
public class PieChart extends View {

    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private List<PieData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public PieChart(Context context) {
        this(context, null);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
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

    @Override //(没有子view 不关心此回调)
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData || mData.size() == 0) return;


        canvas.translate(mWidth / 2, mHeight / 2);

        float r = (float) (Math.min(mWidth, mHeight) / 2);  // 饼状图半径

        RectF rect = new RectF(-r, -r, r, r);               // 饼状图绘制区域

        float currentStartAngle = mStartAngle;  // 当前起始角度
        for (PieData pieData : mData){
            mPaint.setColor(pieData.getColor());

            canvas.drawArc(rect, currentStartAngle, pieData.getAngle(), true, mPaint);

            currentStartAngle += pieData.getAngle();
        }
    }


    public void setmStartAngle(float mStartAngle) {
        this.mStartAngle = mStartAngle;

        invalidate();   // 刷新
    }

    public void setmData(List<PieData> mData) {
        this.mData = mData;

        initData(mData);
    }

    private void initData(List<PieData> mData){
        if (null == mData || mData.size() == 0) return;

        float sumValue = 0;
        for (PieData pieData : mData){
            sumValue += pieData.getValue();

            pieData.setColor(ResourceUtils.getRandomColor());
        }

        for (PieData pieData : mData){
            float percentage = pieData.getValue() / sumValue;   // 百分比
            pieData.setPercentage(percentage);
            pieData.setAngle(percentage * 360);
        }

        invalidate();   // 刷新
    }
}
