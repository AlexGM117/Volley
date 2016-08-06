package com.example.jc.volley.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.jc.volley.R;
import com.example.jc.volley.application.AppController;
import com.example.jc.volley.utils.Const;

import java.io.UnsupportedEncodingException;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    private static final String TAG = ImageFragment.class.getSimpleName();

    private Button btnImageReq;
    private NetworkImageView imgNetwork;
    private ImageView imgView;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        btnImageReq = (Button) view.findViewById(R.id.btnImageReq);
        imgNetwork = (NetworkImageView) view.findViewById(R.id.imgNetwork);
        imgView = (ImageView) view.findViewById(R.id.imgView);

        btnImageReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeImageRequest();
            }
        });

        return view;
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
