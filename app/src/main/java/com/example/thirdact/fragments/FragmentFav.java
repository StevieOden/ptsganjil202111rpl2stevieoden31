package com.example.thirdact.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdact.DetailFavActivity;
import com.example.thirdact.R;
import com.example.thirdact.adapter.FavAdapter;
import com.example.thirdact.models.SportModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentFav extends Fragment{

    private RecyclerView output;
    private ArrayList<SportModel> sportModels;
    private FavAdapter favAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        output = view.findViewById(R.id.rv_show);
        sportModels = new ArrayList<>();
        return view;
    }

    }



