package com.fy.userdifined;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fy.userdifined.coordinate.CoordinateActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tvCoordinate})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvCoordinate://坐标系
                startActivity(new Intent(this, CoordinateActivity.class));
                break;
        }
    }

}
