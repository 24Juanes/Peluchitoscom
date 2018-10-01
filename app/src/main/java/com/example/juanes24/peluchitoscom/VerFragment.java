package com.example.juanes24.peluchitoscom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerFragment extends Fragment {
    private TextView tVista;
    Comunicador interfaz;


    public VerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ver, container, false);

        tVista= view.findViewById(R.id.tInventario);

        Bundle data= getArguments();
        tVista.setText(data.getString("info"));

        return view;
    }

}
