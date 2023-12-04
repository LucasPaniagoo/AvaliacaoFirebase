package com.lucaspaniago.avaliacaofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lucaspaniago.avaliacaofirebase.databinding.CadastroBinding;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {
private CadastroBinding binding;
DatabaseReference root = FirebaseDatabase.getInstance().getReference();
DatabaseReference noPrincipal = root.child("pedido");

    String PREF = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FirebaseApp.initializeApp(this);
        preencheTam();
        preencheSitpag();

        binding.btcad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences config = getSharedPreferences(PREF, 0);
                int id = 0;
                if (config.contains("id")){
                    id = config.getInt("id", 0);
                }
                Pedido p = new Pedido();
                p.setId(id);
                p.setCodRoupa(binding.etcod.getText().toString());
                p.setNomcli(binding.etnomcli.getText().toString());
                p.setTelefone(binding.ettel.getText().toString());
                p.setNome(binding.etdescroupa.getText().toString());
                p.setCor(binding.etcor.getText().toString());
                p.setQuantidade(binding.etquantidade.getText().toString());
                p.setTamanho(binding.sptamanho.getSelectedItem().toString());
                p.setSitpag(binding.spsitpag.getSelectedItem().toString());
                noPrincipal.child(String.valueOf(p.getId())).setValue(p);

                binding.etquantidade.setText("");
                binding.etcor.setText("");
                binding.etdescroupa.setText("");
                binding.etnomcli.setText("");
                binding.ettel.setText("");
                binding.etcod.setText("");
                binding.spsitpag.setSelection(0);
                binding.sptamanho.setSelection(0);

                id++;
                SharedPreferences.Editor edit = config.edit();
                edit.putInt("id", id);
                edit.commit();
                Toast.makeText(CadastroActivity.this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void preencheTam(){
        List<String> dados = new ArrayList<>();
        dados.add("Tamanho");
        dados.add("PP");
        dados.add("P");
        dados.add("M");
        dados.add("G");
        dados.add("GG");
        dados.add("XG");
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);
        binding.sptamanho.setAdapter(ad);
    }
    public void preencheSitpag(){
        List<String> dados2 = new ArrayList<>();
        dados2.add("Situação de Pagamento");
        dados2.add("Pago");
        dados2.add("Pagamento pendente");
        ArrayAdapter<String> ad2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados2);
        binding.spsitpag.setAdapter(ad2);
    }
    public void voltar(View v){
        finish();
    }
}