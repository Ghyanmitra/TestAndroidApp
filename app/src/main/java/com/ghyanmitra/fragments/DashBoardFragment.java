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

public class DashBoardFragment extends Fragment implements View.OnClickListener {

    private View view;
    private String titel;
    MaterialButton retake, got_to_practice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dashboard_layout, container, false);

        Bundle bundle = this.getArguments();
        titel = bundle.getString("titel");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titel);

        retake = view.findViewById(R.id.go_to_practice);
        got_to_practice = view.findViewById(R.id.retake);

        retake.setOnClickListener(this);
        got_to_practice.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.retake:

            case R.id.go_to_practice:
                gotoTestFragment();
                break;

            default:
                break;
        }
    }

    public void gotoTestFragment() {
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


}


