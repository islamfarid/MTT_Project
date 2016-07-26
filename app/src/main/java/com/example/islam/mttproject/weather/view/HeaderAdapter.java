package com.example.islam.mttproject.weather.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.islam.mttproject.R;
import com.example.islam.mttproject.beans.Weather;
import com.example.islam.mttproject.beans.WeatherData;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by islam on 7/25/16.
 */
public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    WeatherData weatherData;
    Context context;

    public HeaderAdapter(Context context, WeatherData weatherData) {
        this.weatherData = weatherData;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
            return new VHItem(item);
        } else if (viewType == TYPE_HEADER) {
            View titleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_title, parent, false);
            return new VHHeader(titleView);
        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHItem) {
            Weather weather = weatherData.getData().getWeather().get(position - 1);
            ((VHItem) holder).maxTemp.setText("Max " + weather.getMaxtempC() + " C");
            ((VHItem) holder).minTemp.setText("Min " + weather.getMintempC() + " C");
            ((VHItem) holder).date.setText(weather.getDate());
            Glide.with(context).load(weather.getHourly().get(0).getWeatherIconUrl().get(0).getValue())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(((VHItem) holder).weatherImage);
        } else if (holder instanceof VHHeader) {
            if (weatherData != null && weatherData.getData() != null && weatherData.getData().getRequest() != null
                    && weatherData.getData().getRequest().size() != 0) {
                ((VHHeader) holder).title.setText(weatherData.getData().getRequest().get(0).getQuery());
            }else {
                ((VHHeader) holder).title.setText(context.getResources().getString(R.string.error_no_data));
            }
        }
    }

    @Override
    public int getItemCount() {
        return weatherData.getData().getWeather().size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


    class VHItem extends RecyclerView.ViewHolder {
        @Bind(R.id.max_temp_textview)
        TextView maxTemp;
        @Bind(R.id.min_temp_textview)
        TextView minTemp;
        @Bind(R.id.weather_imageview)
        ImageView weatherImage;
        @Bind(R.id.date_textview)
        TextView date;

        public VHItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class VHHeader extends RecyclerView.ViewHolder {
        @Bind(R.id.title_textview)
        TextView title;
        public VHHeader(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}