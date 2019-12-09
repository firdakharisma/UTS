package id.ac.poliban.mi.firda.mahasiswa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1000;
    private String mahasiswa;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); assert data != null;

        if (requestCode==REQUEST_CODE && resultCode == Activity.RESULT_OK && data.getExtras() != null)
            mahasiswa = "NIM        : " + data.getStringExtra("nim") + "\n";
            mahasiswa += "Nama       : " + data.getStringExtra("nama") + "\n";
            mahasiswa += "ALamat     : " + data.getStringExtra("alamat") + "\n";
            mahasiswa += "Telp       : " + data.getStringExtra("telp") + "\n";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btShowinput);
        Button btShowData = findViewById(R.id.btShowdata);

        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(this, DataMahasiswa.class);
            startActivityForResult(intent, REQUEST_CODE);
        });

        btShowData.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(mahasiswa)
                    .setPositiveButton("OK",null).show();

        });
    }
}


