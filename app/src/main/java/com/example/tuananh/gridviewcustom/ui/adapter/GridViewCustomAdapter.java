package com.example.tuananh.gridviewcustom.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuananh.gridviewcustom.R;
import com.example.tuananh.gridviewcustom.data.Constant;
import com.example.tuananh.gridviewcustom.data.model.City;

import java.util.List;

/**
 * Created by framgia on 24/10/2016.
 */
public class GridViewCustomAdapter extends BaseAdapter {
    private List<City> mCityList;
    private LayoutInflater mLayoutInflater;
    private int mTypeCustom;

    public GridViewCustomAdapter(Context context, List<City> cityList, int typeCustom) {
        mLayoutInflater = LayoutInflater.from(context);
        mCityList = cityList;
        mTypeCustom = typeCustom;
    }

    @Override
    public int getCount() {
        // quy định số lượng hiển thị
        return mCityList == null ? 0 : mCityList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(mCityList.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (mTypeCustom) {
            case Constant.TYPE_GRID_VIEW_CUSTOM_TEXT_CUSTOM_ONE_TEXT:
                return getViewTextCustomOneText(position, convertView, parent);
            case Constant.TYPE_GRID_VIEW_CUSTOM_TEXT_CUSTOM_MORE_TEXT:
                return getViewTextCustomMoreText(position, convertView, parent);
            case Constant.TYPE_GRID_VIEW_CUSTOM_IMAGE:
                return getViewImageCustom(position, convertView, parent);
            case Constant.TYPE_GRID_VIEW_CUSTOM_IMAGE_AND_TEXT:
                return getViewImageTextCustom(position, convertView, parent);
            default:
                return getViewTextCustomOneText(position, convertView, parent);
        }
    }

    private View getViewImageTextCustom(int position, View convertView, ViewGroup parent) {
        ViewImageTextHolder viewImageTextHolder;
        if (convertView == null) {
            convertView =
                mLayoutInflater
                    .inflate(R.layout.item_grid_view_custom_image_and_text, parent, false);
            viewImageTextHolder = new ViewImageTextHolder();
            viewImageTextHolder.mTextViewIdCity = (TextView) convertView.findViewById(
                R.id.text_id_city_item);
            viewImageTextHolder.mTextViewNameCity = (TextView) convertView.findViewById(
                R.id.text_name_city_item);
            viewImageTextHolder.mImageViewCity = (ImageView) convertView.findViewById(
                R.id.image_city_item);
            convertView.setTag(viewImageTextHolder);
        } else {
            viewImageTextHolder = (ViewImageTextHolder) convertView.getTag();
        }
        City city = mCityList.get(position);
        String idCity = city.getId();
        String nameCity = city.getName();
        int idImageCity = city.getIdImage();
        viewImageTextHolder.mTextViewIdCity.setText(
            new StringBuilder().append(Constant.ID_PROVINCE).append(idCity).toString());
        viewImageTextHolder.mTextViewNameCity.setText(nameCity);
        viewImageTextHolder.mImageViewCity.setImageResource(idImageCity);
        return convertView;
    }

    private View getViewImageCustom(int position, View convertView, ViewGroup parent) {
        ImageView imageViewCity;
        if (convertView == null) {
            convertView =
                mLayoutInflater.inflate(R.layout.item_grid_view_custom_image, parent, false);
            imageViewCity = (ImageView) convertView.findViewById(R.id.image_item);
            convertView.setTag(imageViewCity);
        } else {
            imageViewCity = (ImageView) convertView.getTag();
        }
        imageViewCity.setImageResource(mCityList.get(position).getIdImage());
        return convertView;
    }

    private View getViewTextCustomMoreText(int position, View convertView, ViewGroup parent) {
        ViewTextHolder viewTextHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_grid_view_custom_more_text,
                parent, false);
            viewTextHolder = new ViewTextHolder();
            viewTextHolder.mTextViewNameCity =
                (TextView) convertView.findViewById(R.id.text_name_city);
            viewTextHolder.mTextViewIdCity = (TextView) convertView.findViewById(R.id.text_id_city);
            convertView.setTag(viewTextHolder);
        } else {
            viewTextHolder = (ViewTextHolder) convertView.getTag();
        }
        String nameCity = mCityList.get(position).getName();
        String idCity = mCityList.get(position).getId();
        viewTextHolder.mTextViewNameCity.setText(nameCity);
        viewTextHolder.mTextViewIdCity.setText(
            new StringBuilder().append(Constant.ID_PROVINCE).append(idCity).toString());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }

    private View getViewTextCustomOneText(int position, View convertView, ViewGroup parent) {
        String nameCity = mCityList.get(position).getName();
        TextView textViewNameCity;
        if (convertView == null) {
            convertView =
                mLayoutInflater.inflate(R.layout.item_grid_view_custom_one_text, parent, false);
            textViewNameCity = (TextView) convertView.findViewById(R.id.text_custom_one_text);
        } else {
            textViewNameCity = (TextView) convertView;
        }
        textViewNameCity.setText(nameCity);
        return textViewNameCity;
    }

    private class ViewImageTextHolder {
        private TextView mTextViewIdCity;
        private TextView mTextViewNameCity;
        private ImageView mImageViewCity;
    }

    private class ViewTextHolder {
        private TextView mTextViewNameCity;
        private TextView mTextViewIdCity;
    }
}
