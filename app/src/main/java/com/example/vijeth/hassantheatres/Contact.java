package com.example.vijeth.hassantheatres;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vijeth on 4/10/2017.
 */

public class Contact extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView l= (ListView) view.findViewById(R.id.contact);
        getActivity().setTitle("Theatre phone numbers");
        String[] items={"Prithvi","SBG","Bhaanu","Guru","Picture palace","Sahyaadri"};
        final List<String> number =Arrays.asList("08172260982","08172268740","08172268577","08172269064","08172268595","08172268572");
        ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,items);
        l.setAdapter(adapter);
        l.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String items = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(getActivity(), items, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:"+ number.get(position)));
                        startActivity(intent);
                    }

                }

        );
    }
}
