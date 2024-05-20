package com.example.myproud.internetmodel;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.myproud.R;
import com.example.myproud.internetmodel.beans.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InternetManager {
    private String TAG = "zhangrui-saluo";
    private Retrofit retrofit = null;
    private IUserService iUserService = null;
    private User user = null;
    public InternetManager(String BASE_URL) {
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        if(iUserService == null){
            iUserService = retrofit.create(IUserService.class);
        }
    }
    /**
     * 发送GET请求
     */
    public void getRequest(TextView textView, RelativeLayout relative,ImageView imageView, Context context) {
        Call<User> call = iUserService.getUser("sj");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i(TAG, "request = " + call.request().toString());
                Log.i(TAG, "response = " + response);
                user = response.body();
                Log.i(TAG, "user.toString() = " + user.toString());
                if(textView != null) {
                    Picasso.get()
                            .load(user.getData().getPic())
                            //.placeholder(R.drawable.touming)
                            .noPlaceholder()
                            //.fit()
                            .error(R.drawable.image_default)
                            .resize(600, 400)
                            .into(imageView);
                    relative.setBackground(imageView.getDrawable());
                    textView.setText(user.getData().getZh()+"\n"+user.getData().getEn());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i(TAG, "t.getMessage() = " + t.getMessage());
            }
        });
    }

}
