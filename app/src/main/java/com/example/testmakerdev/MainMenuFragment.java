package com.example.testmakerdev;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainMenuFragment extends Fragment {

    private Button moveToTestEditor;
    private Button moveToLectures;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MainMenuFragment() {
    }

    public static MainMenuFragment newInstance(String param1, String param2) {
        MainMenuFragment fragment = new MainMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moveToTestEditor = view.findViewById(R.id.toTestEditorActivity);
        moveToLectures = view.findViewById(R.id.toLecturesActivity);

        moveToTestEditor.setOnClickListener(v -> goToTestEditor());
        moveToLectures.setOnClickListener(v -> goToLectures());
    }

    private void goToTestEditor() {
        Intent intent = new Intent(getActivity(), TestEditorActivity.class);
        startActivity(intent);
    }

    private void goToLectures() {
        Intent intent = new Intent(getActivity(), LectureEditorActivity.class);
        startActivity(intent);
    }
}