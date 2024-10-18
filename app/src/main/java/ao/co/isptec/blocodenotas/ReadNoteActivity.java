package ao.co.isptec.blocodenotas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadNoteActivity extends AppCompatActivity {
    private TextView textViewTitle, textViewContent;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewContent = findViewById(R.id.textViewContent);
        buttonBack = findViewById(R.id.buttonBack);

        // Recuperar dados da Intent
        String title = getIntent().getStringExtra("noteTitle");
        String content = getIntent().getStringExtra("noteContent");

        // Exibir dados
        textViewTitle.setText(title);
        textViewContent.setText(content);

        // Botão Voltar
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Voltar à atividade anterior
            }
        });
    }
}
