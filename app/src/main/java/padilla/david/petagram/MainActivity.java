package padilla.david.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        GridLayoutManager glm = new GridLayoutManager(this, 1);

        rvMascotas.setLayoutManager(glm);
        inicializarMascotas();
        inicializarAdaptador();

        ImageView ivFavoritos = (ImageView) findViewById(R.id.ivFavoritos);
        ivFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MsscotaFavoritos.class);
                startActivity(intent);
            }
        });
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Marcus", 5, R.drawable.perro1));
        mascotas.add(new Mascota("Chop", 6, R.drawable.perro2));
        mascotas.add(new Mascota("Bonnie", 7, R.drawable.perro3));
        mascotas.add(new Mascota("Charlie", 6, R.drawable.perrro4));
        mascotas.add(new Mascota("Malteada", 8, R.drawable.perro5));
    }
}
