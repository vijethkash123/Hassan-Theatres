package com.example.vijeth.hassantheatres;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.accounts.AccountManager.KEY_PASSWORD;

/**
 * Created by Vijeth on 4/10/2017.
 */

public class Events extends Fragment {
    private static final String URL_DATA1 = "https://hassanmovies.000webhostapp.com/events.txt";
    private RecyclerView recyclerView1;
    private RecyclerView.Adapter adapter1;

    private List<ListItem1> listItems1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Cultural Events in Hassan");
        View view = inflater.inflate(R.layout.events, container, false);
        ConnectivityManager cmanager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cmanager.getActiveNetworkInfo();
        if (nInfo != null && nInfo.isConnected()) {
            recyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView1);
            recyclerView1.setHasFixedSize(true);
            recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));

            listItems1 = new ArrayList<>();

            loadRecyclerViewData();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Turn on internet connection to use Hassan Theatres", Toast.LENGTH_LONG).show();
            return inflater.inflate(R.layout.nc, container, false);
        }
        return view;
    }
    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Onde nimisha " +
                "\n" +
                "ಸ್ವಲ್ಪ ತಾಳ್ಮೆ");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA1, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray array = jsonObject.getJSONArray("events");

                    for(int i = 0;i<array.length();i++) {
                        JSONObject o = array.getJSONObject(i);
                        ListItem1 item = new ListItem1(
                                o.getString("name"),
                                o.getString("about"),
                                o.getString("image")
                        );
                        listItems1.add(item);
                    }

                    adapter1 = new MyAdapter1(listItems1,getActivity().getApplicationContext());
                    recyclerView1.setAdapter(adapter1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @SuppressLint("ShowToast")
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity().getApplicationContext(),volleyError.getMessage(),Toast.LENGTH_LONG);
                    }

                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}
