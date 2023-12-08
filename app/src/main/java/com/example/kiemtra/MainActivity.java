package com.example.kiemtra;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        productList.add(new Product("Gấu", "335.000đ", R.drawable.gau));
        productList.add(new Product("Điện thoại", "436.000đ",R.drawable.ao));
        productList.add(new Product("Đồng hồ", "230.000đ",R.drawable.dongho));
        productList.add(new Product("Guốc phụ nữ", "200.000đ",R.drawable.guoc));
        productList.add(new Product("Ghế trẻ em", "105.000đ",R.drawable.ghetreem));
        productList.add(new Product("Sách", "95.000đ",R.drawable.sach));
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
