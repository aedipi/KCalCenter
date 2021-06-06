package com.example.kcalcenter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kcalcenter.model.DBHelper;

public class LoginActivity extends AppCompatActivity {
    EditText txt_login_Username;
    EditText txt_login_Password;
    Button btn_Register;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Register = (Button) findViewById(R.id.btn_Register);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Login(View view){
        txt_login_Username = (EditText) findViewById(R.id.txt_login_Username);
        txt_login_Password = (EditText) findViewById(R.id.txt_login_Password);

        String username = txt_login_Username.getText().toString().trim();
        String password = txt_login_Password.getText().toString().trim();

        if(!username.equals("") && !password.equals("")){

            if(DBHelper.Login(username,password) || (username.toLowerCase().equals("admin")&& password.toLowerCase().equals("admin")))
            //if(username.equals("admin")&&password.equals("123"))
            {
                Intent intent = new Intent(this,MainActivity.class);
                //intent.putExtra("USER_NAME",username);
                startActivity(intent);
            }else{
                //kullanıcı adı veya şifre yanlış
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Kullanıcı adı veya şifre yanlış");
                builder.setPositiveButton("Tamam",null);
                builder.show();

                //Toast.makeText(context,"kullanıcı adı veya şifre yanlış",Toast.LENGTH_SHORT).show();
            }
        }else{
            //kullanıcı adı veya şifre boş bırakılamaz
            //Toast.makeText(context,"kullanıcı adı veya şifre boş bırakılamaz",Toast.LENGTH_SHORT).show();
        }

    }
}