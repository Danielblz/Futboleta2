package com.example.danielbustamante.futboleta2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    Button bregistar;
    EditText email, epass, erepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        email= findViewById(R.id.email);
        epass = findViewById(R.id.epass);
        erepass = findViewById(R.id.erepass);
        bregistar = findViewById(R.id.bregistrar);
    }



    public void rok(View view) {
        String mail, pass, repass;
        email= findViewById(R.id.email);
        epass = findViewById(R.id.epass);
        erepass = findViewById(R.id.erepass);
        bregistar = findViewById(R.id.bregistrar);

        mail =email.getText().toString();
        pass =epass.getText().toString();
        repass=erepass.getText().toString();
        if (mail.equals("")|| epass.equals("")||erepass.equals("")){
            Toast.makeText(getApplicationContext(), "Digite todos los campos",Toast.LENGTH_SHORT).show();
        }else {
            if (pass.equals(repass)){
                Intent intent =new Intent();

                intent.putExtra("correo", mail);
                intent.putExtra("pass", pass);

                setResult(RESULT_OK, intent);
                finish();

            }else {
                Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
            }


        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent();
        setResult(RESULT_CANCELED, intent);
        Toast.makeText(getApplicationContext(), "Registro cancelado", Toast.LENGTH_SHORT).show();
        finish();
    }
}
