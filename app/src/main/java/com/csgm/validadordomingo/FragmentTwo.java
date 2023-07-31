package com.csgm.validadordomingo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class FragmentTwo extends Fragment {

    private TextView messageTextView;

    private ImageButton backButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);


        messageTextView = view.findViewById(R.id.messageTextView);

        backButton = view.findViewById(R.id.backButton);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String message = arguments.getString("message");
            messageTextView.setText(getString(R.string.contraseñaValida) + " " + message);
        }

        backButton.setOnClickListener(v -> {
            // Regresar al Fragmento 1
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}