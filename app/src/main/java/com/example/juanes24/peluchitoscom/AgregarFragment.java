package com.example.juanes24.peluchitoscom;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {
    private EditText eId, eNombre, eCantidad, ePrecio;
    private Button bGuardar;
    Comunicador interfaz;


    public AgregarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_agregar, container, false);

        eId = view.findViewById(R.id.eCode);
        eNombre = view.findViewById(R.id.eName);
        eCantidad = view.findViewById(R.id.eCant);
        ePrecio = view.findViewById(R.id.ePrecio);
        bGuardar= view.findViewById(R.id.bGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.enviarDatos(Integer.parseInt(eId.getText().toString()),
                        eNombre.getText().toString(),
                        (Integer.parseInt(eCantidad.getText().toString())),
                        (Integer.parseInt(ePrecio.getText().toString())));

            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        interfaz = (Comunicador) activity;
    }
}
