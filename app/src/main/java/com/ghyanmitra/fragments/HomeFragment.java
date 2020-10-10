package com.ghyanmitra.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ghyanmitra.R;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    private View view;
    private String titel;
    private MaterialButton button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        Bundle bundle = this.getArguments();
        titel = bundle.getString("titel");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titel);

        button = view.findViewById(R.id.start_test);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new TestFragment();

                Bundle bundle = new Bundle();
                bundle.putString("titel", "Test Page");

                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}
