package com.example.tuananh.gridviewcustom.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tuananh.gridviewcustom.R;
import com.example.tuananh.gridviewcustom.data.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.button_custom_text_with_layout_default).setOnClickListener(this);
        findViewById(R.id.button_custom_text_with_layout_custom_one_text).setOnClickListener(this);
        findViewById(R.id.button_custom_text_with_layout_custom_more_text).setOnClickListener(this);
        findViewById(R.id.button_custom_image).setOnClickListener(this);
        findViewById(R.id.button_custom_image_and_text).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, GridViewCustomActivity.class);
        switch (v.getId()) {
            case R.id.button_custom_text_with_layout_default:
                intent.setFlags(Constant.TYPE_GRID_VIEW_CUSTOM_TEXT_DEFAULT);
                break;
            case R.id.button_custom_text_with_layout_custom_one_text:
                intent.setFlags(Constant.TYPE_GRID_VIEW_CUSTOM_TEXT_CUSTOM_ONE_TEXT);
                break;
            case R.id.button_custom_text_with_layout_custom_more_text:
                intent.setFlags(Constant.TYPE_GRID_VIEW_CUSTOM_TEXT_CUSTOM_MORE_TEXT);
                break;
            case R.id.button_custom_image:
                intent.setFlags(Constant.TYPE_GRID_VIEW_CUSTOM_IMAGE);
                break;
            case R.id.button_custom_image_and_text:
                intent.setFlags(Constant.TYPE_GRID_VIEW_CUSTOM_IMAGE_AND_TEXT);
                break;
        }
        startActivity(intent);
    }
}
