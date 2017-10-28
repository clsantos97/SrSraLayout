package carlos.srsralayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static carlos.srsralayout.R.id.tvResultado;

public class OtraVentana extends AppCompatActivity implements Button.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_ventana);

        Button btnVolver = (Button)findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);

        TextView tvResultado = (TextView)findViewById(R.id.tvResultado);
        Bundle extras = getIntent().getExtras();

        if(extras == null){
            finish();
        }else{
            String mensaje = extras.getString("mensaje");
            tvResultado.setText(mensaje);
        }
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
