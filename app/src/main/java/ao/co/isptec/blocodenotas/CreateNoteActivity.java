package ao.co.isptec.blocodenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNoteActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextContent;
    private Button buttonOk, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonOk = findViewById(R.id.buttonOk);
        buttonCancel = findViewById(R.id.buttonCancel);

        // Evento do botão OK
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();
                String note = title + "\n" + content;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("noteContent", note);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        // Evento do botão Cancelar
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
