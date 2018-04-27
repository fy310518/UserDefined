package com.fy.userdifined.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fy.userdifined.R;
import com.fy.userdifined.widget.CanvasTranslateDemo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Canvas基本操作
 * Created by fangs on 2018/4/27.
 */
public class CanvasOperationActivity extends AppCompatActivity{


    @BindView(R.id.canvasDemo)
    CanvasTranslateDemo canvasTranslateDemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_operation);
        ButterKnife.bind(this);

        canvasTranslateDemo.invalidate();
    }
}
