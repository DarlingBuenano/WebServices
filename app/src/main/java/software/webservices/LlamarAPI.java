package software.webservices;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONException;
import java.util.HashMap;
import java.util.Map;

import software.webservices.WebService.Asynchtask;
import software.webservices.WebService.WebService;

public class LlamarAPI extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar_a_p_i);

        TextView txtcredenciales = (TextView)findViewById(R.id.txtCredenciales);

        Bundle elementos = this.getIntent().getExtras();
        txtcredenciales.setText("Usuario: " + elementos.getString("usuario") + ", Contraseña: " + elementos.getString("pass"));

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://uealecpeterson.net/ws/login.php?usr="
                + elementos.getString("usuario") + "&pass="
                + elementos.getString("clave"), datos, LlamarAPI.this, LlamarAPI.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Bundle elementos = this.getIntent().getExtras();
        TextView txtAPI = (TextView)findViewById(R.id.txtDatos);

        txtAPI.setText("Respuesta: \n" + result);
    }
}