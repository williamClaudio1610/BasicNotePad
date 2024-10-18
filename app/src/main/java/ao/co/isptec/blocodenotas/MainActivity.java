package ao.co.isptec.blocodenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewNotes;
    private Button buttonNewNote;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNotes = findViewById(R.id.listViewNotes);
        buttonNewNote = findViewById(R.id.buttonNewNote);

        // Inicializar lista de notas
        notes = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listViewNotes.setAdapter(adapter);

        // Evento de clique no botão para adicionar nova nota
        buttonNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateNoteActivity.class);
                startActivityForResult(intent, 1);  // Código de requisição 1 para criar nota
            }
        });

        // Evento de clique na lista de notas
        listViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String note = notes.get(position);
                Intent intent = new Intent(MainActivity.this, ReadNoteActivity.class);
                intent.putExtra("noteContent", note);  // Passar conteúdo da nota
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String newNote = data.getStringExtra("noteContent");
            notes.add(newNote);
            adapter.notifyDataSetChanged();
        }
    }
}
