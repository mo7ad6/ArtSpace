package com.example.mid_mohammed_abdelrazeq;


//mohammed_abdelrazeq
//1320230659


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mid_mohammed_abdelrazeq.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int index = 0;
    int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6
    };
    String[] titles = {
            "Starry Night",
            "Mona Lisa",
            "The Scream",
            "Girl with a Pearl Earring",
            "The Persistence of Memory",
            "The Great Wave"
    };
    String[] artists = {
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Edvard Munch",
            "Johannes Vermeer",
            "Salvador Dalí",
            "Katsushika Hokusai"
    };
    String[] years = {
            "1889",
            "1503",
            "1893",
            "1665",
            "1931",
            "1831"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(savedInstanceState != null){
            index = savedInstanceState.getInt("index");

        }

        binding.Artwork.setImageResource(images[index]);
        binding.Count.setText((index + 1) + " / 6");
        binding.Title.setText(titles[index]);
        binding.Artist.setText(artists[index] + " - " + years[index]);
        updateButtons();
        binding.Count.setVisibility(View.VISIBLE);
        binding.Title.setVisibility(View.VISIBLE);
        binding.Artist.setVisibility(View.VISIBLE);
        binding.btnNext.setVisibility(View.VISIBLE);
        binding.btnPrevious.setVisibility(View.VISIBLE);

        binding.btnNext.setOnClickListener(v -> {
            if (index < 5) {
                index++;
                binding.Artwork.setImageResource(images[index]);
                binding.Count.setText((index + 1) + " / 6");
                binding.Title.setText(titles[index]);
                binding.Artist.setText(artists[index] + " - " + years[index]);
                updateButtons();
            }
        });


        binding.btnPrevious.setOnClickListener(v -> {
            if (index > 0) {
                index--;
                binding.Artwork.setImageResource(images[index]);
                binding.Count.setText((index + 1) + " / 6");
                binding.Title.setText(titles[index]);
                binding.Artist.setText(artists[index] + " - " + years[index]);
                updateButtons();
            }
        });


        binding.Artwork.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);

            intent.putExtra("title", titles[index]);
            intent.putExtra("artist", artists[index]);
            intent.putExtra("year", years[index]);

            startActivity(intent);

        });


    }

        private void updateButtons() {
            if (index == 0) {
                binding.btnPrevious.setEnabled(false);
            } else {
                binding.btnPrevious.setEnabled(true);
            }

            if (index == 5) {
                binding.btnNext.setEnabled(false);
            } else {
                binding.btnNext.setEnabled(true);
            }
        }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }
}