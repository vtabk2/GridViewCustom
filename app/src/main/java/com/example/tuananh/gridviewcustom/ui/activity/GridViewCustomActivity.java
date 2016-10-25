package com.example.tuananh.gridviewcustom.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.tuananh.gridviewcustom.R;
import com.example.tuananh.gridviewcustom.data.Constant;
import com.example.tuananh.gridviewcustom.data.model.City;
import com.example.tuananh.gridviewcustom.ui.adapter.GridViewCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridViewCustomActivity extends AppCompatActivity {
    private GridView mGridViewCustom;
    private GridViewCustomAdapter mGridViewCustomAdapter;
    private List<City> mCityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_custom);
        createData();
        initViews();
    }

    private void createData() {
        mCityList = new ArrayList<>();
        mCityList.add(new City("01", "Hà Nội", R.drawable.image_ha_noi));
        mCityList.add(new City("02", "Hồ Chí Minh", R.drawable.image_ho_chi_minh));
        mCityList.add(new City("03", "Hải Phòng", R.drawable.image_hai_phong));
        mCityList.add(new City("04", "Đà Nẵng", R.drawable.image_da_nang));
        mCityList.add(new City("05", "Hà Giang", R.drawable.image_ha_giang));
        mCityList.add(new City("21", "Hải Dương", R.drawable.image_hai_duong));
        mCityList.add(new City("22", "Hưng Yên", R.drawable.image_hung_yen));
    }

    private void initViews() {
        mGridViewCustom = (GridView) findViewById(R.id.grid_view_custom);
        int typeCustom = getIntent().getFlags();
        switch (typeCustom) {
            case Constant.TYPE_GRID_VIEW_CUSTOM_TEXT_DEFAULT:
                List<String> arrNameCity = new ArrayList<>();
                for (City city : mCityList) {
                    arrNameCity.add(city.getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, arrNameCity);
                mGridViewCustom.setAdapter(adapter);
                break;
            default:
                mGridViewCustomAdapter = new GridViewCustomAdapter(this, mCityList, typeCustom);
                mGridViewCustom.setAdapter(mGridViewCustomAdapter);
                break;
        }
    }
}
