package com.ghyanmitra.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ghyanmitra.R;

public class CartFragment extends Fragment {

    private View view;
    private String titel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.cart_layout, container, false);

        Bundle bundle = this.getArguments();
        titel = bundle.getString("titel");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titel);

        return view;
    }
}
