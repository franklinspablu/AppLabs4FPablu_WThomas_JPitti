package com.example.applabs4fpablu_wthomas_jpitti;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applabs4fpablu_wthomas_jpitti.Adapter.InstagramListviewAdapter;
import com.example.applabs4fpablu_wthomas_jpitti.Adapter.Chat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstagramActivity extends AppCompatActivity {
    List<Chat> options = new ArrayList<>();
    ListView lstChats;
    Date time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeControls();
        this.LoadListViewTemplate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuNewchat:
                this.AgregarNuevoChat();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void AgregarNuevoChat() {
        options.add(new Chat("user", "message",R.drawable.user,"3"));
        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, options);
        lstChats.setAdapter(adapter);
    }

    private void InitializeControls()
    {
        lstChats = findViewById(R.id.lstOpciones);

        lstChats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada = ((Chat)a.getItemAtPosition(position)).getUsername();

                Toast.makeText(InstagramActivity.this,"Chat seleccionado: " + opcionSeleccionada, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void LoadListViewTemplate()
    {
        List<Chat> opciones = this.GetElementsToListViewTemplate();

        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, opciones);
        lstChats.setAdapter(adapter);
    }

    private List<Chat> GetElementsToListViewTemplate()
    {
        options.add(new Chat("joseu.private", "Mano va el karaoke siempre?",R.drawable.joseu_private, "3"));
        options.add(new Chat("drd_bs", "Yo nama miro", R.drawable.drd_bs,"5"));
        options.add(new Chat("jozimmermann15", "Teteo el sábado?",R.drawable.jozimmermann15, "2"));
        options.add(new Chat("kathia_0.0", "Oye Franklin manda la tarea",R.drawable.kathia_0_0,"1"));
        return options;
    }
}