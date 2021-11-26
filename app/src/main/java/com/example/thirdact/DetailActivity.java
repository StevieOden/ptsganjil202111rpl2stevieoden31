package com.example.thirdact;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar mTopToolbar;
    ImageView poster, fav;
    TextView detaiDesc, detailTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_onclick);

        mTopToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        String strSport = intent.getStringExtra("poster");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("description");
        String format = intent.getStringExtra("format");

        fav = (ImageView) findViewById(R.id.addfav);
        poster = (ImageView) findViewById(R.id.detail_poster);
        detailTitle = (TextView) findViewById(R.id.detail_title);
        detaiDesc = (TextView) findViewById(R.id.detail_description);

        detailTitle.setText(title);
        detaiDesc.setText(desc);
        Picasso.get().load(strSport).into(poster);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        DocumentReference documentReference = db.collection("sport").document("SportDb");
                        Map<String, Object> sport = new HashMap<>();
                        sport.put("title", detailTitle);
                        sport.put("poster", poster);
                        documentReference.set(sport).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(DetailActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

