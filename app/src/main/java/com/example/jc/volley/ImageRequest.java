package com.example.jc.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.jc.volley.application.AppController;
import com.example.jc.volley.utils.Const;

import java.io.UnsupportedEncodingException;

public class ImageRequest extends AppCompatActivity {

    private static final String TAG = ImageRequest.class.getSimpleName();

    private Button btnImageReq;
    private NetworkImageView imgNetwork;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_request);

        btnImageReq = (Button) findViewById(R.id.btnImageReq);
        imgNetwork = (NetworkImageView) findViewById(R.id.imgNetwork);
        imgView = (ImageView) findViewById(R.id.imgView);

        btnImageReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeImageRequest();
            }
        });
    }

    private void makeImageRequest() {
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

//Si queremos usar NetworkImageView
//        imgNetwork.setImageUrl(Const.URL_IMAGE, imageLoader);

//        Si queremos usar ImageView
        imageLoader.get(Const.URL_IMAGE, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null){
                    imgView.setImageBitmap(response.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Image Load error: " + error.getMessage());
            }
        });

//        Dependiendo del elemnto que usemos (ImageView o NetworkImageView)
//        cambiaremos el primer parametro del constructor getImageListener
        imageLoader.get(Const.URL_IMAGE, ImageLoader.
                getImageListener(imgView, R.mipmap.ic_loading, R.mipmap.ic_error));

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(Const.URL_IMAGE);
        if (entry != null){
            try {
                String data = new String (entry.data, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {

        }
    }
}
