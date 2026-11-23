

//mohammed_abdelrazeq
//1320230659

package com.example.mid_mohammed_abdelrazeq;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mid_mohammed_abdelrazeq.databinding.ActivityArtworkDetailsBinding;

public class ArtworkDetailsActivity extends AppCompatActivity {

    private ActivityArtworkDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityArtworkDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        binding.detailTitle.setText(intent.getStringExtra("title"));
        binding.detailArtist.setText(intent.getStringExtra("artist"));
        binding.detailYear.setText(intent.getStringExtra("year"));

        binding.btnReturn.setOnClickListener(v -> {
            finish();
        });

        binding.btnWebsite.setOnClickListener(v -> {
            String url = "https://www.google.com/search?q="
                    + binding.detailTitle.getText().toString().replace(" ", "+");

            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(websiteIntent);
        });
    }
}
