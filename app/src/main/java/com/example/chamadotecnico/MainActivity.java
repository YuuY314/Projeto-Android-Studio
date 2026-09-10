package com.example.chamadotecnico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout ilEquipamento, ilPatrimonio, ilEmail;
    private TextInputEditText edtEquipamento, edtPatrimonio, edtEmail;
    private Button btnAbrirChamado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ilEquipamento = findViewById(R.id.ilEquipamento);
        ilPatrimonio = findViewById(R.id.ilPatrimonio);
        ilEmail = findViewById(R.id.ilEmail);
        edtEquipamento = findViewById(R.id.edtEquipamento);
        edtPatrimonio = findViewById(R.id.edtPatrimonio);
        edtEmail = findViewById(R.id.edtEmail);
        btnAbrirChamado = findViewById(R.id.btnAbrirChamado);

        btnAbrirChamado.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                String equipamento = edtEquipamento.getText().toString().trim();
                String patrimonio = edtPatrimonio.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                ilEquipamento.setError(null);
                ilPatrimonio.setError(null);
                ilEmail.setError(null);

                if(equipamento.isEmpty()){
                    ilEquipamento.setError("Informe o equipamento");
                    return;
                }

                if(patrimonio.isEmpty()){
                    ilPatrimonio.setError("Informe o número do patrimônio");
                    return;
                }

                if(patrimonio.length() < 4){
                    ilPatrimonio.setError("Patrimônio deve possuir pelo menos 4 dígitos");
                    return;
                }

                if(!email.contains("@")){
                    ilEmail.setError("Email inválido");
                    return;
                }

                Toast.makeText(MainActivity.this, "Chamado aberto com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
    }
}