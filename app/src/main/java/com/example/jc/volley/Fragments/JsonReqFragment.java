package com.example.jc.volley.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jc.volley.JsonRequestActivity;
import com.example.jc.volley.R;
import com.example.jc.volley.application.AppController;
import com.example.jc.volley.utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class JsonReqFragment extends Fragment {
    private String TAG = JsonReqFragment.class.getSimpleName();
    private Button btnJsonObj, btnJsonArray, btnJsonUnparse, btnJsonArryUp;
    private TextView msgResponse;
    private ProgressDialog pDialog;
    private String jsonResponse;

    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";


    public JsonReqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_json_request, container, false);

        btnJsonUnparse = (Button)view.findViewById(R.id.btnJsonUnparse);
        btnJsonArryUp = (Button) view.findViewById(R.id.btnJsonArryUp);
        btnJsonObj = (Button) view.findViewById(R.id.btnJsonObj);
        btnJsonArray = (Button) view.findViewById(R.id.btnJsonArray);
        msgResponse = (TextView) view.findViewById(R.id.msgResponse);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Cargando...");
        pDialog.setCancelable(false);

        btnJsonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjReq();
            }
        });

        btnJsonArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArryReq();
            }
        });

        btnJsonUnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObj();
            }
        });

        btnJsonArryUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArry();
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

    private void makeJsonObjReq() {
        showProgressDialog();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,       //Constructor correcto para mcxiaoke
                Const.URL_JSON_OBJECT, (JSONObject)null, new Response.Listener<JSONObject>() {
            //JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,       //Constructor correcto para volley oficial de google(.jar)
            //Const.URL_JSON_OBJECT, (JSONObject)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
//                Muestra el codigo json
//                msgResponse.setText(response.toString());

                try{
                    jsonResponse = "";
                    int id = Integer.parseInt(response.getString("id"));
                    String name = response.getString("name");
                    String username = response.getString("username");
                    String email = response.getString("email");
                    JSONObject address = response.getJSONObject("address");
                    String street = address.getString("street");
                    String suite = address.getString("suite");
                    String city = address.getString("city");
                    String zipcode = address.getString("zipcode");
//                    JSONObject geo = response.getJSONObject("geo");
//                    String lat = geo.getString("lat");
//                    String lng = geo.getString("lng");
                    String phone = response.getString("phone");
                    String website = response.getString("website");
                    JSONObject company = response.getJSONObject("company");
                    String wname = company.getString("name");
                    String catchPhrase = company.getString("catchPhrase");
                    String bs = company.getString("bs");

                    jsonResponse += "Id: " +id+ "\n\n";
                    jsonResponse += "Nombre:: " +name+ "\n\n";
                    jsonResponse += "User: " +username+ "\n\n";
                    jsonResponse += "e-mail: " +email+ "\n\n";
                    jsonResponse += "Direccion: \n\n";
                    jsonResponse += "Calle:: " +street+ "\n\n";
                    jsonResponse += "Suite: " +suite+ "\n\n";
                    jsonResponse += "Ciudad: " +city+ "\n\n";
                    jsonResponse += "CP: " +zipcode+ "\n\n";
//                    jsonResponse += "Geolocalizacion: \n\n";
//                    jsonResponse += "Lat: " +lat+ "\n\n";
//                    jsonResponse += "Long: " +lng+ "\n\n";
                    jsonResponse += "Tel: " +phone+ "\n\n";
                    jsonResponse += "Pagina web: " +website+ "\n\n";
                    jsonResponse += "Empresa: \n\n";
                    jsonResponse += "Nombre: " +wname+ "\n\n";
                    jsonResponse += "catchPhrase: " +catchPhrase+ "\n\n";
                    jsonResponse += "bs: " +bs+ "\n\n";
                    msgResponse.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();

                }
                hideProgressDialog();
            }
        } , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                hideProgressDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_obj);
    }

    private void makeJsonObj() {
        showProgressDialog();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,       //Constructor correcto para mcxiaoke
                Const.URL_JSON_OBJECT, (JSONObject)null, new Response.Listener<JSONObject>() {
            //JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,       //Constructor correcto para volley oficial de google(.jar)
            //Const.URL_JSON_OBJECT, (JSONObject)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
//                Muestra el codigo json
                msgResponse.setText("");
                msgResponse.setText(response.toString());
                hideProgressDialog();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                hideProgressDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_obj);
        hideProgressDialog();
    }

    private void makeJsonArryReq() {
        showProgressDialog();
        JsonArrayRequest request = new JsonArrayRequest(Const.URL_JSON_ARRAY,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        //Aqui solo hacemos la lectura del archivo json
//                        msgResponse.setText(response.toString());
                        //Se crea un ciclo para que parsee cada objeto que se encuentre en el json
                        try {
                            jsonResponse = "";
                            for (int i = 0;  i < response.length(); i++){
                                JSONObject contacto = (JSONObject) response.get(i);
                                int id = Integer.parseInt(contacto.getString("id"));
                                String name = contacto.getString("name");
                                String username = contacto.getString("username");
                                String email = contacto.getString("email");
                                JSONObject address = contacto.getJSONObject("address");
                                String street = address.getString("street");
                                String suite = address.getString("suite");
                                String city = address.getString("city");
                                String zipcode = address.getString("zipcode");
                                String phone = contacto.getString("phone");
                                String website = contacto.getString("website");
                                JSONObject company = contacto.getJSONObject("company");
                                String wname = company.getString("name");
                                String catchPhrase = company.getString("catchPhrase");
                                String bs = company.getString("bs");

                                jsonResponse += "Id: " +id+ "\n\n";
                                jsonResponse += "Nombre:: " +name+ "\n\n";
                                jsonResponse += "User: " +username+ "\n\n";
                                jsonResponse += "e-mail: " +email+ "\n\n";
                                jsonResponse += "Direccion: \n\n";
                                jsonResponse += "Calle:: " +street+ "\n\n";
                                jsonResponse += "Suite: " +suite+ "\n\n";
                                jsonResponse += "Ciudad: " +city+ "\n\n";
                                jsonResponse += "CP: " +zipcode+ "\n\n";
                                jsonResponse += "Tel: " +phone+ "\n\n";
                                jsonResponse += "Pagina web: " +website+ "\n\n";
                                jsonResponse += "Empresa: \n\n";
                                jsonResponse += "Nombre: " +wname+ "\n\n";
                                jsonResponse += "catchPhrase: " +catchPhrase+ "\n\n";
                                jsonResponse += "bs: " +bs+ "\n\n";

                            }
                            msgResponse.setText(jsonResponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hideProgressDialog();

            }
        });

        AppController.getInstance().addToRequestQueue(request, tag_json_arry);
        hideProgressDialog();
    }

    private void makeJsonArry() {
        showProgressDialog();
        JsonArrayRequest request = new JsonArrayRequest(Const.URL_JSON_ARRAY,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        //Aqui solo hacemos la lectura del archivo json
                        msgResponse.setText("");
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

        AppController.getInstance().addToRequestQueue(request, tag_json_arry);
        hideProgressDialog();
    }

}
