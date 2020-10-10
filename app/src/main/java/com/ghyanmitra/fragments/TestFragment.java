package com.ghyanmitra.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ghyanmitra.R;
import com.google.android.material.button.MaterialButton;

public class TestFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "TestFragment";

    private View view;
    private String titel;
    private RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    MaterialButton next;

    LinearLayout explaination, happy_layout, unhappy_layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.test_layout, container, false);

        Bundle bundle = this.getArguments();
        titel = bundle.getString("titel");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titel);

        next = view.findViewById(R.id.next);
        next.setOnClickListener(this);

        explaination = view.findViewById(R.id.explaination);
        happy_layout = view.findViewById(R.id.happy_layout);
        unhappy_layout = view.findViewById(R.id.unhappy_layout);

        radioGroup = view.findViewById(R.id.radio_group);
        option1 = addRadioButton("Option A");
        option2 = addRadioButton("Option B");
        option3 = addRadioButton("Option C");
        option4 = addRadioButton("Option D");

        return view;
    }

    private RadioButton addRadioButton(String text) {
        Integer id = View.generateViewId();
        RadioButton rdbtn = new RadioButton(getActivity());
        rdbtn.setId(id);
        rdbtn.setText(text);
        rdbtn.setTextColor(getResources().getColor(R.color.blue));
        rdbtn.setOnClickListener(this);
        radioGroup.addView(rdbtn);
        return rdbtn;
    }

    @Override
    public void onClick(View v) {


        if (v.getId() == option1.getId()) {

            option1.setTextColor(getResources().getColor(R.color.orange));
            option3.setTextColor(getResources().getColor(R.color.blue));
            option4.setTextColor(getResources().getColor(R.color.blue));
            unhappy_layout.setVisibility(View.VISIBLE);
            happy_layout.setVisibility(View.GONE);
        } else if (v.getId() == option2.getId()) {

            option1.setTextColor(getResources().getColor(R.color.blue));
            option3.setTextColor(getResources().getColor(R.color.blue));
            option4.setTextColor(getResources().getColor(R.color.blue));
            unhappy_layout.setVisibility(View.GONE);
            happy_layout.setVisibility(View.VISIBLE);

        } else if (v.getId() == option3.getId()) {

            option3.setTextColor(getResources().getColor(R.color.orange));
            option1.setTextColor(getResources().getColor(R.color.blue));
            option4.setTextColor(getResources().getColor(R.color.blue));
            unhappy_layout.setVisibility(View.VISIBLE);
            happy_layout.setVisibility(View.GONE);

        } else if (v.getId() == option4.getId()) {

            option4.setTextColor(getResources().getColor(R.color.orange));
            option1.setTextColor(getResources().getColor(R.color.blue));
            option3.setTextColor(getResources().getColor(R.color.blue));
            unhappy_layout.setVisibility(View.VISIBLE);
            happy_layout.setVisibility(View.GONE);

        }

        if (v.getId() == R.id.next) {

            Fragment fragment = new DashBoardFragment();

            Bundle bundle = new Bundle();
            bundle.putString("titel", "Score");

            fragment.setArguments(bundle);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            option2.setTextColor(getResources().getColor(R.color.green));
            explaination.setVisibility(View.VISIBLE);
        }

    }
}
