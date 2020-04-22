import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    EditText nome;
    Button imprimir;
    TextView seuNome;
    String nomeusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        imprimir = findViewById(R.id.imprimir);
        seuNome = findViewById(R.id.seuNome);

        //busca por um arquivo existente armazenado no dispostivo
        preferences = getSharedPreferences("arquivo",Context.MODE_PRIVATE);
        //busca no arquivo um valor para a chave nome, se não existir recebe nulo
        nomeusuario = preferences.getString("nome",null);
        seuNome.setText(nomeusuario);

        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nome.getText().toString().equals("")){
                    //cria um arquivo de preferência com o nome "arquivo" com modo de leitura "privado".
                    preferences = getSharedPreferences("arquivo",Context.MODE_PRIVATE);
                    //permite editar o arquivo
                    SharedPreferences.Editor editor = preferences.edit();
                    //inclui ao arquivo, uma String com "chave/valor".
                    editor.putString("nome",nome.getText().toString());
                    //faz com que a informação seja salva no arquivo
                    editor.commit();
                    //atualiza o TextView com o nome armazenado
                    nomeusuario = preferences.getString("nome",null);
                    seuNome.setText(nomeusuario);
                }else{
                    Toast.makeText(MainActivity.this,"Digite seu nome!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
