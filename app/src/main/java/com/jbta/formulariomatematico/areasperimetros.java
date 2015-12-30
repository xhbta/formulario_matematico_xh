package com.jbta.formulariomatematico;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class areasperimetros extends AppCompatActivity {

    private String figuras[]=new String[]{"Cuadrado","Rectangulo","Triangulo" ,
            "Trapecio","Circulo","Rombo","Romboide","Poligono","Más Figuras"};

    private Integer[] imgid={
            R.drawable.cuadrado,
            R.drawable.rectangulo,
            R.drawable.triangulo,
            R.drawable.trapecio,
            R.drawable.circulo,
            R.drawable.rombo,
            R.drawable.romboide,
            R.drawable.poligono,
            R.drawable.perimetro
    };
    private final String urlFiguras = "http://www.vitutor.net/1/24.html";
    private final String urlCalculadora = "http://www.calculadora.net";
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areasperimetros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //codigo para el boton flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlCalculadora));
                startActivity(intent);
            }
        });
      




        //parte del codigo para abrir alguna figura
        TemasListAdapter adapter=new TemasListAdapter(this,figuras,imgid);
        lista=(ListView)findViewById(R.id.mi_lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Slecteditem = figuras[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent intent = null;
                switch (Slecteditem){
                    case "Cuadrado":
                        intent = new Intent(getApplicationContext(), cuadrado.class);
                        startActivity(intent);
                        break;
                    case "Rectangulo":
                        intent = new Intent(getApplicationContext(), rectangulo.class);
                        startActivity(intent);
                        break;
                    case "Triangulo":
                        intent = new Intent(getApplicationContext(), triangulo.class);
                        startActivity(intent);
                        break;
                    case "Trapecio":
                        intent = new Intent(getApplicationContext(), trapecio.class);
                        startActivity(intent);
                        break;
                    case "Circulo":
                        intent = new Intent(getApplicationContext(), circulo.class);
                        startActivity(intent);
                        break;
                    case "Rombo":
                        intent = new Intent(getApplicationContext(), rombo.class);
                        startActivity(intent);
                        break;
                    case "Romboide":
                        intent = new Intent(getApplicationContext(), romboide.class);
                        startActivity(intent);
                        break;
                    case "Poligono":
                        intent = new Intent(getApplicationContext(), poligono.class);
                        startActivity(intent);
                        break;
                    case "Más Figuras":
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(urlFiguras));
                        startActivity(intent);
                        break;
                }


            }

        });
    }

}
