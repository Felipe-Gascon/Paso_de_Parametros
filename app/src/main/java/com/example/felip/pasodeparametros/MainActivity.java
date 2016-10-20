package com.example.felip.pasodeparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_dato;
    RadioButton rb_mascu,rb_feme;
    EditText et_nom;
    TextView tv_dato;

    final int SUBACTIVITY_2 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nom=(EditText)this.findViewById(R.id.et_nom);
        btn_dato= (Button)this.findViewById(R.id.btn_envDat);
        rb_mascu=(RadioButton)this.findViewById(R.id.rb_masc);
        rb_feme=(RadioButton)this.findViewById(R.id.rb_fem);
        tv_dato=(TextView)this.findViewById(R.id.tv_datos);
        btn_dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Activity2.class);
                Bundle b = new Bundle();
                String nomAPasar =et_nom.getText().toString();
                b.putString("nombre",nomAPasar);
                i.putExtras(b);
                startActivityForResult(i,SUBACTIVITY_2);

            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==SUBACTIVITY_2){
            et_nom.setEnabled(false);
            rb_feme.setEnabled(false);
            rb_mascu.setEnabled(false);
            btn_dato.setEnabled(false);

            Bundle bun = data.getExtras();
            int edades= bun.getInt("edad");
            if(edades >18 && edades < 25)
            {
                tv_dato.setText("Como tienes "+edades+" ya eres mayor de edad");
            }
            else{
                if(edades >=25 && edades <35 )
                {
                    tv_dato.setText("Como tienes "+edades+" estas en la flor de la vida");
                }

                else{
                    if(edades>=35)
                    {
                        tv_dato.setText("Tienes "+edades+" ay,ay,ay");
                    }
                }
            }





        }
    }
}
