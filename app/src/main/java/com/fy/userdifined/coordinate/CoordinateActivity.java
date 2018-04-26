package com.fy.userdifined.coordinate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fy.userdifined.R;
import com.fy.userdifined.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 安卓中的坐标系 demo
 * 参考：https://github.com/GcsSloop/AndroidNote/blob/master/CustomView/Base/%5B01%5DCoordinateSystem.md
 * Created by fangs on 2018/4/25.
 */
public class CoordinateActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.rlGroup)
    RelativeLayout rlGroup;
    @BindView(R.id.tvTestCoordinate)
    TextView tvTestCoordinate;
    @BindView(R.id.imgMotionEvent)
    ImageView imgMotionEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        ButterKnife.bind(this);

        Log.e("屏幕像素密度", ScreenUtils.getScreenDensity(this) + "");
        Log.e("屏幕像素密度dpi", ScreenUtils.getScreenDensityDpi(this) + "");
        Log.e("屏幕宽度", ScreenUtils.getScreenWidth(this) + "");
        Log.e("状态栏 高度", ScreenUtils.getStatusHeight(this) + "");

        /**
         *  MotionEvent中 get 和 getRaw 的区别
         *  event.getX();
         *  event.getY();       触摸点相对于其所在组件坐标系的坐标
         *  ------------------------------------------------------
         *  event.getRawX();
         *  event.getRawY();    触摸点相对于屏幕默认坐标系的坐标
         */
        imgMotionEvent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == motionEvent.ACTION_DOWN){

                    Log.e("MotionEvent x -->", "" + motionEvent.getX() + " --> "
                            + motionEvent.getRawX());

                    Log.e("MotionEvent Y -->", "" + motionEvent.getY() + " --> "
                        + motionEvent.getRawY());
                }

                return true;
            }
        });
    }

    @OnClick({R.id.tvTestCoordinate})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvTestCoordinate:
                /**
                 * getTop();       //获取子View左上角距父View顶部的距离
                 * getLeft();      //获取子View左上角距父View左侧的距离
                 * getBottom();    //获取子View右下角距父View顶部的距离
                 * getRight();     //获取子View右下角距父View左侧的距离
                 */
                Log.e("TextView 左上右下-->", tvTestCoordinate.getLeft() + " --> "
                        + tvTestCoordinate.getTop() + " --> "
                        + tvTestCoordinate.getRight() + " --> "
                        + tvTestCoordinate.getBottom());
                Log.e("TextView 高 宽 -->", "" + tvTestCoordinate.getHeight() + " --> "
                        + tvTestCoordinate.getWidth());


                Log.e("Group 左上右下-->", rlGroup.getLeft() + " --> "
                        + rlGroup.getTop() + " --> "
                        + rlGroup.getRight() + " --> "
                        + rlGroup.getBottom());
                Log.e("Group 高 宽 -->", "" + rlGroup.getHeight() + " --> "
                        + rlGroup.getWidth());


                Log.e("img 左上右下-->", imgMotionEvent.getLeft() + " --> "
                        + imgMotionEvent.getTop() + " --> "
                        + imgMotionEvent.getRight() + " --> "
                        + imgMotionEvent.getBottom());
                Log.e("img 高 宽 -->", "" + imgMotionEvent.getHeight() + " --> "
                        + imgMotionEvent.getWidth());
                break;
        }
    }
}
