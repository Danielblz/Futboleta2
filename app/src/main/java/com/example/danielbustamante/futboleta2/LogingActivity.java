package com.example.danielbustamante.futboleta2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogingActivity extends AppCompatActivity {
    TextView tregistrar;
    String mail, pass, correo, contra;
    Button blogin;
    EditText email, epass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);





    }
    public void log(View view){

        String email1,mail2,pass2, pass1;
        email=findViewById(R.id.email);
        epass=findViewById(R.id.epass);
        blogin=findViewById(R.id.blogin);
        email1 = email.getText().toString();
        pass1 = epass.getText().toString();


        if (email1.equals("")||pass1.equals("")){
            Toast.makeText(getApplicationContext(),"Digite todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            if (email1.equals(correo) && pass1.equals(contra) ){

                Intent intent1 =new Intent(this, MainActivity.class);
                intent1.putExtra("correo", correo);
                intent1.putExtra("pass", contra);
                startActivityForResult(intent1,321);
            }else {
                Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void reg(View view) {
        Intent intent =new Intent(this, RegistroActivity.class);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 &&   resultCode == RESULT_OK){
            correo = data.getStringExtra("correo");
            contra = data.getStringExtra("pass");

        }

        if (requestCode == 321 &&   resultCode == RESULT_OK){
            correo = data.getStringExtra("correo");
            contra = data.getStringExtra("pass");



        }if ( requestCode==321 && resultCode == RESULT_CANCELED){
            finish();
        }



    }
}
