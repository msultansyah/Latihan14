package id.ac.poliban.mi.sultan.latihan14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);

        btLoad.setOnClickListener(v -> startActivity(new Intent(this, Second.class)));
        btSave.setOnClickListener(v -> {
            String file = "Sultan";
            SharedPreferences sp = getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            String lname = etLastName.getText().toString();
            String fname = etFirstName.getText().toString();

            editor.putString("fname", fname);
            editor.putString("lname", lname);
            editor.apply();

            Toast.makeText(this, "Save It", Toast.LENGTH_SHORT).show();
        });
    }
}
