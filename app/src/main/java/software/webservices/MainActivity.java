package software.webservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnEnviar(View vista){
        Intent intent = new Intent(MainActivity.this, LlamarAPI.class);
        EditText txtusuario = (EditText)findViewById(R.id.txtUser);
        EditText txtpass = (EditText)findViewById(R.id.txtPassword);

        Bundle elementos = new Bundle();
        elementos.putString("usuario", txtusuario.getText().toString());
        elementos.putString("pass", txtpass.getText().toString());

        intent.putExtras(elementos);
        startActivity(intent);
    }
}