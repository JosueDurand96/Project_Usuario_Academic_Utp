package com.example.analy.usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Registrar extends AppCompatActivity {
    String recuperado;
    TextView textView;
    Button btnRegistrar;
    EditText txtnombres,txtapellidos,txttelefono,txtdni,correo,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
//        Bundle recupera=getIntent().getExtras();
//        if(recupera!=null){
//            recuperado=recupera.getString("cod");
//        }



        txtnombres =(EditText)findViewById(R.id.txtnombres);

        correo=(EditText)findViewById(R.id.txtcorreo6);
        password=(EditText)findViewById(R.id.txtpassword6);


        btnRegistrar =(Button)findViewById(R.id.btnRegistrar3);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if ( validate()==false) {
                    Toast.makeText(Registrar.this, "Debe ingresar datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    Thread tr2 = new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            RegistrarPost(txtnombres.getText().toString(),

                                    correo.getText().toString(),
                                    password.getText().toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), " registro exitoso", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(),Login.class);
                                    startActivity(i);
                                }
                            });
                        }
                    };
                    tr2.start();
                }
            }
        });

    }
    //  String getNombreEmpresa = SessionFragment.getNombreEmpresa();

    public void RegistrarPost( String nombres, String correo, String password){

        String urlParameters="nombres="+nombres+"&correo="+
               correo+"&password="+password;
        HttpURLConnection conection=null;
        try {

            URL url = new URL("http://www.capacitasoft.com/site/Prueba/Usuario/registrar.php?");
            conection = (HttpURLConnection) url.openConnection();

            //estableciendo el metodo
            conection.setRequestMethod("POST");
            //longitud de datos que se envian
            conection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

            //comando para la salida de datos
            conection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            InputStream is = conection.getInputStream();
        } catch (Exception ex){ }
    }


    private boolean validate() {

        boolean valid=true;
        if (txtnombres.getText().toString().isEmpty()|| txtnombres.length()>32){
            txtnombres.setError("Ingrese su nombre");
            valid =false;
        }
        if (correo.getText().toString().isEmpty()|| correo.length()>32)
        {
            correo.setError("Ingrese su correo");
            valid = false;
        }if (password.getText().toString().isEmpty()|| password.length()>4) {
            password.setError("Ingrese su password");
            valid = false;

        }
        return valid;


    }



    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}

