package com.example.analy.usuario;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.analy.usuario.Cajas.AulaLaboratorio;
import com.example.analy.usuario.Cajas.Grado;
import com.example.analy.usuario.Cajas.TipoDeEquipo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Bitmap bitmap;

    private int PICK_IMAGE_REQUEST = 1;
    public  static String idclie;

    private  String KEY_DESCRIPCION = "descripcion";
    private String KEY_IMAGEN = "imagen";
    private String KEY_NROAULA = "nroaula";
    private String KEY_Cliente_idcliente = "Cliente_idcliente";
    private String KEY_Grado_idgrado = "Grado_idgrado";
    private String KEY_TipoDeEquipo_idtipoequipo = "TipoDeEquipo_idtipoequipo";
    private String KEY_AulaLaboratorio_idaulla = "AulaLaboratorio_idaulla";
    EditText txtnroaula,txtdescripcion;
    private Session session;
    //SPINNER
    Spinner  spgrados,sptipoequipos,spaula;

    List<Grado> lista;
    List<TipoDeEquipo> lista2;
    List<AulaLaboratorio>lista3;
    String grados,tipo,aulalaboratorio;
    String grados1,tipo1,aulalaboratorio1;
    public static String idcliente;
    public static final String id="id";

    TextView editText3;
    Button btnSubir,btnBuscar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Bundle recupera=getIntent().getExtras();

        if (recupera != null) {
            idcliente = recupera.getString(id);
        }
        editText3=(TextView)findViewById(R.id.editText3) ;

        txtnroaula=(EditText)findViewById(R.id.txtnroaula);
        txtdescripcion=(EditText)findViewById(R.id.txtdescripcion);
        imageView  = (ImageView) findViewById(R.id.imageView);
        btnBuscar = (Button) findViewById(R.id.btnSelect);
        btnSubir = (Button) findViewById(R.id.btnUpload);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
        btnSubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();

                Intent p = new Intent(MenuPrincipal.this,MenuPrincipal.class);
                startActivity(p);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //SPINNER
        spgrados=(Spinner)findViewById(R.id.spgrados);
        lista = new ArrayList<Grado>();
        lista.add(new Grado("1","Emergencia"));
        lista.add(new Grado("2","Normal"));
        lista.add(new Grado("3","Urgente"));
        lista.add(new Grado("4","Derivado"));

        ArrayAdapter<Grado> arrayAdapter = new ArrayAdapter<Grado>(this, android.R.layout.simple_list_item_1, lista );
        spgrados.setAdapter(arrayAdapter);

        spgrados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Grado selectedItem = lista.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                grados=selectedItem.getIdestado();
               // editText3.setText(grados);
                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        sptipoequipos=(Spinner)findViewById(R.id.sptipoequipos);
        lista2 = new ArrayList<TipoDeEquipo>();
        lista2.add(new TipoDeEquipo("1","PC"));
        lista2.add(new TipoDeEquipo("2","Proyector"));
        lista2.add(new TipoDeEquipo("3","CPU"));
        lista2.add(new TipoDeEquipo("4","Equipo de sonido"));

        ArrayAdapter<TipoDeEquipo> arrayAdapter2 = new ArrayAdapter<TipoDeEquipo>(this, android.R.layout.simple_list_item_1, lista2 );
        sptipoequipos.setAdapter(arrayAdapter2);

        sptipoequipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                TipoDeEquipo selectedItem = lista2.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                tipo=selectedItem.getIdestado();



                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spaula=(Spinner)findViewById(R.id.spaula);
        lista3 = new ArrayList<AulaLaboratorio>();
        lista3.add(new AulaLaboratorio("1","Aula"));
        lista3.add(new AulaLaboratorio("2","Laboratorio"));


        ArrayAdapter<AulaLaboratorio> arrayAdapter3 = new ArrayAdapter<AulaLaboratorio>(this, android.R.layout.simple_list_item_1, lista3 );
        spaula.setAdapter(arrayAdapter3);

        spaula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                AulaLaboratorio selectedItem = lista3.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                aulalaboratorio=selectedItem.getIdaulla();
                Log.i("aula",aulalaboratorio);



                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);

        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(getApplicationContext(),Resumen.class);
            startActivity(i);

        }  else if (id == R.id.cerrarsesion) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la App?");
            builder.setTitle("Alerta!");
            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cerrandoSesion();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void cerrandoSesion(){
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        logout();
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MenuPrincipal.this,MainActivity.class));
    }

////////////////////////
public static String getIdclientes() {

    idclie= idcliente;
    return idclie;
}
    private void uploadImage(){
        //Mostrar el diálogo de progreso
        String UPLOAD_URL ="http://www.capacitasoft.com/site/Prueba/Usuario/agregarIncidencia.php?";
        final ProgressDialog loading = ProgressDialog.show(this,"Subiendo...","Espere por favor...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();
                        //Mostrando el mensaje de la respuesta
                        Toast.makeText(MenuPrincipal.this, s , Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(MenuPrincipal.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Convertir bits a cadena
                //String imagen = getStringImagen(bitmap);

                //Obtener el nombre de la imagen



                String descripcion = txtdescripcion.getText().toString();
                String imagen = getStringImagen(bitmap);
                String nroaula = txtnroaula.getText().toString();
                String idclient=idcliente;
                String idgrado = grados;
                String tipoequipo = tipo;
                String idaula = aulalaboratorio;


                //Creación de parámetros
                Map<String,String> params = new Hashtable<String, String>();

                //Agregando de parámetros
                params.put(KEY_DESCRIPCION,descripcion);
                params.put(KEY_IMAGEN, imagen);
                params.put(KEY_NROAULA, nroaula);
                params.put(KEY_Cliente_idcliente,idclient);
                params.put(KEY_Grado_idgrado,idgrado);
                params.put(KEY_TipoDeEquipo_idtipoequipo,tipoequipo);
                params.put(KEY_AulaLaboratorio_idaulla,idaula);
                //Parámetros de retorno
                return params;
            }
        };

        //Creación de una cola de solicitudes
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Agregar solicitud a la cola
        requestQueue.add(stringRequest);
    }

    public String getStringImagen(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Imagen"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Configuración del mapa de bits en ImageView
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
