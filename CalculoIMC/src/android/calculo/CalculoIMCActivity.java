package android.calculo;

import org.w3c.dom.Text;
import org.xml.sax.Parser;

import android.app.Activity;
import android.calculo.R.string;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculoIMCActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnCalcula=(Button) findViewById(R.id.btnCalcula);
        final EditText txtAltura = (EditText) findViewById(R.id.txtAltura);
        final EditText txtMassa = (EditText) findViewById(R.id.txtMassa);
        final EditText txtResultado = (EditText) findViewById(R.id.txtResultado);
        final EditText txtInfo = (EditText) findViewById(R.id.txtInfo);
        
        btnCalcula.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
				double altura = Double.parseDouble(txtAltura.getText().toString());
		        double peso = Double.parseDouble(txtMassa.getText().toString());
		       
		        double valor = calcula(altura, peso);
		        
		        String resultado=resulado(valor);
		        
		        txtResultado.setText(String.valueOf(valor) );
		        txtInfo.setText(resultado);
		        
			}
		});
        
        }
    public double calcula(double altura, double massa)
    {   
        return massa/(altura*altura);
    }
    
    public String resulado(double imc)
    {
    	String resultado = null;
    	if(imc<17)
    	{
    		resultado="Desnutrição";
    	}
    	if(imc>17 && imc<=18.49)
    	{
    		resultado="Peso abaixo normal";
    	}
    	if(imc>18.49 && imc<=24.99)
    	{
    		resultado="Peso normal";
    	}
    	if(imc>=25 && imc<29.99)
    	{
    		resultado  = "Peso acima do normal";
    	}
    	if(imc>=30 && imc<=29.99)
    	{
    		resultado = "Obesidade";
    	}
    		
    	return resultado;
    }
}