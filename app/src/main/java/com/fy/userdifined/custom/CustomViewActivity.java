package com.fy.userdifined.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fy.userdifined.R;
import com.fy.userdifined.widget.PieChart;
import com.fy.userdifined.widget.PieData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 自定义 View 展示 Activity
 * Created by fangs on 2018/4/26.
 */
public class CustomViewActivity extends AppCompatActivity{

    @BindView(R.id.pieChart)
    PieChart pieChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);

        pieChart.setmData(initData());
    }

    private List<PieData> initData(){
        List<PieData> data = new ArrayList<>();
        data.add(new PieData("数学", 119));
        data.add(new PieData("语文", 108));
        data.add(new PieData("英语", 67));
        data.add(new PieData("物理", 92));

        return data;
    }
}
