package id.ac.poliban.mi.firda.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        final EditText etNim = findViewById(R.id.etNim);
        final EditText etNama = findViewById(R.id.etNama);
        final EditText etAlamat = findViewById(R.id.etAlamat);
        final EditText etTelp = findViewById(R.id.etTelp);
        Button btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("nim", etNim.getText().toString());
                intent.putExtra("nama", etNama.getText().toString());
                intent.putExtra("alamat", etAlamat.getText().toString());
                intent.putExtra("telp", etTelp.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Input Data");
    }
}