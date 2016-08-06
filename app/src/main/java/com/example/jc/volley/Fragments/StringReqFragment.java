package com.example.jc.volley.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.jc.volley.R;
import com.example.jc.volley.StringRequestActivity;
import com.example.jc.volley.application.AppController;
import com.example.jc.volley.utils.Const;


/**
 * A simple {@link Fragment} subclass.
 */
public class StringReqFragment extends Fragment {

    private String TAG = StringReqFragment.class.getSimpleName();
    private Button btnStringReq;
    private TextView msgResponse;
    private ProgressDialog pDialog;

    private String tag_string_req = "string_req";

    public StringReqFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_string, container, false);

        btnStringReq = (Button)view.findViewById(R.id.btnStringReq);
        msgResponse = (TextView)view.findViewById(R.id.msgResponse);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Cargando...");
        pDialog.setCancelable(false);

        btnStringReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeStringReq();
            }
        });
        return view;
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    private void makeStringReq() {
        showProgressDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                Const.URL_STRING_REQ, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                msgResponse.setText(response.toString());
                hideProgressDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hideProgressDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }

}
