package ao.co.isptec.blocodenotas;

import static android.content.Intent.getIntent;

import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ReadNoteActivity extends AppCompatActivity {
    private TextView textViewNote;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        textViewNote = findViewById(R.id.textViewNote);
        buttonBack = findViewById(R.id.buttonBack);

        // Receber o conteúdo da nota
        String noteContent = getIntent().getStringExtra("noteContent");
        textViewNote.setText(noteContent);

        // Botão Voltar
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Voltar à atividade anterior
            }
        });
    }
}

