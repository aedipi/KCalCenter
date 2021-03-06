package com.example.kcalcenter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kcalcenter.model.DBHelper;
import com.example.kcalcenter.model.User;

public class RegisterActivity extends AppCompatActivity {
    Button btn_RegisterScreen_Login;
    Button btn_RegisterScreen_Register;
    EditText txt_register_Name;
    EditText txt_register_Surname;
    EditText txt_register_Email;
    EditText txt_register_Password;
    EditText txt_register_Repassword;
    DBHelper dbHelper;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper();

        txt_register_Name = (EditText) findViewById(R.id.txt_register_Name);
        txt_register_Surname = (EditText) findViewById(R.id.txt_register_Surname);
        txt_register_Email= (EditText) findViewById(R.id.txt_register_Email);
        txt_register_Password = (EditText) findViewById(R.id.txt_register_Password);
        txt_register_Repassword = (EditText) findViewById(R.id.txt_register_Repassword);

        btn_RegisterScreen_Register = (Button) findViewById(R.id.btn_RegisterScreen_Register);
        btn_RegisterScreen_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt_register_Name.getText().toString().trim();
                String surname = txt_register_Surname.getText().toString().trim();
                String email = txt_register_Email.getText().toString().trim();
                String password = txt_register_Password.getText().toString().trim();
                String repassword = txt_register_Repassword.getText().toString().trim();

                if (name.equals("")){
                    // ad bo?? b??rak??lamaz
                    //Toast.makeText(context,"ad bo?? b??rak??lamaz",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("ad bo?? b??rak??lamaz");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    return;
                }
                if (surname.equals("")){
                    // soyad bo?? b??rak??lamaz
                    //Toast.makeText(context,"soyad bo?? b??rak??lamaz",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("soyad bo?? b??rak??lamaz");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    return;
                }
                if (email.equals("")){
                    // email bo?? b??rak??lamaz
                    //Toast.makeText(context,"email bo?? b??rak??lamaz",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("email bo?? b??rak??lamaz");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    return;
                }
                if (password.equals("")){
                    // ??ifre bo?? b??rak??lamaz
                    //Toast.makeText(context,"??ifre bo?? b??rak??lamaz",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("??ifre bo?? b??rak??lamaz");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    return;
                }
                if (repassword.equals("")){
                    // ??ifre tekrar bo?? b??rak??lamaz
                    //Toast.makeText(context,"ifre tekrar bo?? b??rak??lamaz",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("tekrar ??ifresi bo?? b??rak??lamaz");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    return;
                }
                if (!password.equals(repassword)){
                    // ??ifre ve ??ifre tekrar?? ayn?? olmal??.
                    //Toast.makeText(context,"??ifre ve ??ifre tekrar?? ayn?? olmal??",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("??ifreler uyu??muyor");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    return;
                }
                User user = new User();
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setPassword(password);
                if (dbHelper.AddUser(user)){
                    //kay??t ba??ar??l??
                    //Toast.makeText(context,"kay??t ba??ar??l??",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Kay??t Ba??ar??l??");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("B??yle bir kullan??c?? bulunmaktad??r.");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();
                }
            }
        });



        btn_RegisterScreen_Login = (Button) findViewById(R.id.btn_RegisterScreen_Login);
        btn_RegisterScreen_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}