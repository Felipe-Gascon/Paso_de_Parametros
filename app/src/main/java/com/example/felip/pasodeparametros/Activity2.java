package com.example.felip.pasodeparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends MainActivity {

    Button btn_enviar;
    EditText et_edades;
    TextView nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // para recibir el Bundle
        Bundle bundleRecibido =this.getIntent().getExtras();

        btn_enviar=(Button)findViewById(R.id.btn_cont);

        et_edades = (EditText) findViewById(R.id.et_edad);
        String datoRecibido;
        if(bundleRecibido!=null)
        {

            datoRecibido=bundleRecibido.getString("nombre");
            nom=(TextView) findViewById(R.id.tv_nombre);
            nom.setText("Hola "+datoRecibido+" introduzca los siguientes datos"  );
        }



        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                Bundle b = new Bundle();
                //String edad = et_edades.getText().toString();
                int edade = Integer.parseInt(String.valueOf(et_edades.getText()));
                b.putInt("edad", edade);
                //b.putString("edad",edad);
                i.putExtras(b);

                setResult(RESULT_OK,i);
                finish();
            }
        });

    }


}
