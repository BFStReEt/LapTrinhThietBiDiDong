package com.example.kiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private int quantity = 1;
    private double price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImage = findViewById(R.id.image_product);
        TextView productName = findViewById(R.id.text_product_name);
        TextView productPriceTextView = findViewById(R.id.text_product_price);
        TextView productQuantity = findViewById(R.id.text_quantity);
        TextView totalProductPrice = findViewById(R.id.text_total_price);
        Button decrementButton = findViewById(R.id.button_decrement);
        Button incrementButton = findViewById(R.id.button_increment);
        Button backButton = findViewById(R.id.button_back_to_products);

        Intent intent = getIntent();
        String name = intent.getStringExtra("product_name");
        String priceString = intent.getStringExtra("product_price").replaceAll("[^\\d.]", "");
        price = Double.parseDouble(priceString);
        int imageId = intent.getIntExtra("product_image_id", 0);

        productName.setText(name);
        productPriceTextView.setText(intent.getStringExtra("product_price"));
        productImage.setImageResource(imageId);
        productQuantity.setText(String.valueOf(quantity));
        updatePriceDisplay(totalProductPrice);

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity > 1) {
                    quantity--;
                    productQuantity.setText(String.valueOf(quantity));
                    updatePriceDisplay(totalProductPrice);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                productQuantity.setText(String.valueOf(quantity));
                updatePriceDisplay(totalProductPrice);
            }
        });
    }

    private void updatePriceDisplay(TextView totalProductPrice) {
        double total = price * quantity;
        totalProductPrice.setText("Total: " + String.format("%,.0f.000 đ", total));
    }



}
