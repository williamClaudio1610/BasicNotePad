package ao.co.isptec.blocodenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNoteActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextContent;
    private Button buttonSaveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSaveNote = findViewById(R.id.buttonSaveNote);

        // Evento de clique no botão para salvar a nota
        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("noteTitle", title);
                resultIntent.putExtra("noteContent", content);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
