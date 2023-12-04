package com.lucaspaniago.avaliacaofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lucaspaniago.avaliacaofirebase.databinding.VisualizarBinding;

import java.util.ArrayList;

public class VisualizarActivity extends AppCompatActivity {
private VisualizarBinding binding;
DatabaseReference root = FirebaseDatabase.getInstance().getReference();
DatabaseReference node = root.child("pedido");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = VisualizarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        node.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> data = new ArrayList<>();
                for (DataSnapshot item: snapshot.getChildren()){
                    String row = "\n";
                    row += "----- Pedido " + item.child("id").getValue().toString() + " -----";
                    row += "\nNome do Cliente: " + item.child("nomcli").getValue().toString();
                    row += "\nTelefone: " + item.child("telefone").getValue().toString();
                    row += "\nCódigo da Roupa: " + item.child("codRoupa").getValue().toString();
                    row += "\nDescrição: " + item.child("nome").getValue().toString();
                    row += "\nCor: " + item.child("cor").getValue().toString();
                    row += "\nTamanho: " + item.child("tamanho").getValue().toString();
                    row += "\nQuantidade: " + item.child("quantidade").getValue().toString();
                    row += "\nSituação de Pagamento: " + item.child("sitpag").getValue().toString();
                    row += "\n";
                    data.add(row);
                }
                ArrayAdapter<String> ad3 = new ArrayAdapter<>(VisualizarActivity.this, android.R.layout.simple_list_item_1, data);
                binding.listapedido.setAdapter(ad3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void voltar(View v){
        finish();
    }
}