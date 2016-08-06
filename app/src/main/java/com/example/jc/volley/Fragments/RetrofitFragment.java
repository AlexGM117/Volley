package com.example.jc.volley.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jc.volley.R;
import com.example.jc.volley.interfaces.ClienteService;
import com.example.jc.volley.interfaces.Service;
import com.example.jc.volley.models.Cliente;
import com.example.jc.volley.models.Greeting;
import com.example.jc.volley.utils.Const;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitFragment extends Fragment {

    private String TAG = RetrofitFragment.class.getSimpleName();

    private TextView msgRetrofit;
    private TextView msgRetrofit2;
    private TextView msgRetrofit3;
    private ProgressDialog pDialog;

    private String responseRetrofit;

    public RetrofitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retrofit, container, false);

        msgRetrofit = (TextView)view.findViewById(R.id.msgRetrofit);

        msgRetrofit2 = (TextView)view.findViewById(R.id.msgRetrofit2);

        msgRetrofit3 = (TextView)view.findViewById(R.id.msgRetrofit3);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Cargando...");
        pDialog.setCancelable(false);

        getRetrofitObject();

        getRetrofitArray();

        //getNutriClientRequest();

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

    public void getRetrofitObject() {
        showProgressDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        Call<Greeting> call = service.getGreeting();

        call.enqueue(new Callback<Greeting>() {
            @Override
            public void onResponse(Call<Greeting> call, Response<Greeting> response) {
                Log.d(TAG, response.toString());
                Greeting greeting = response.body();
                msgRetrofit.setText(greeting.getId());
                msgRetrofit3.setText(greeting.getContent());
                hideProgressDialog();
            }

            @Override
            public void onFailure(Call<Greeting> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }

    public void getRetrofitArray(){
        showProgressDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClienteService service = retrofit.create(ClienteService.class);

        Call<List<Cliente>> call = service.getClientDetails();

        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                Log.d(TAG, response.toString());
                try {
                    List<Cliente> clientes = response.body();
                    responseRetrofit = "";
                    for (int i =0; i < clientes.size(); i++){
                        int id = clientes.get(i).getId();
                        String name = clientes.get(i).getName();
                        String user = clientes.get(i).getUsername();
                        String email = clientes.get(i).getEmail();
                        String phone = clientes.get(i).getPhone();
                        String web = clientes.get(i).getWebsite();
                        String foto = clientes.get(i).getPhoto();

                        responseRetrofit += "ID: " + id + "\n\n";
                        responseRetrofit += "Nombre: " + name + "\n\n";
                        responseRetrofit += "User: " + user + "\n\n";
                        responseRetrofit += "E-mail: " + email + "\n\n";
                        responseRetrofit += "Tel: " + phone + "\n\n";
                        responseRetrofit += "Pagina: " + web + "\n\n";
                        responseRetrofit += "Foto: " + foto + "\n\n";
                    }
                    msgRetrofit2.setText(responseRetrofit);
                    hideProgressDialog();

                } catch (Exception e) {
                    Log.e(TAG, "Error: "+e.getMessage());
                    hideProgressDialog();
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }

}
