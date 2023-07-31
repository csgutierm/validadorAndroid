package com.csgm.validadordomingo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FragmentOne extends Fragment {
    private Button nextButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        nextButton = view.findViewById(R.id.nextButton);

        TextInputLayout textInputLayout = view.findViewById(R.id.text_input_layout_password);

        EditText editText = textInputLayout.getEditText();

        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    String inputText = editText.getText().toString();
                    nextButton.setEnabled(isValidText(inputText));

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


        nextButton.setOnClickListener(v -> {
            String inputText = null;
            if (editText != null) {
                inputText = editText.getText().toString();
            }
            if (inputText != null && isValidText(inputText)) {
                // Navegar al Fragmento 2
                FragmentTwo fragmentTwo = new FragmentTwo();
                Bundle bundle = new Bundle();
                bundle.putString("message", inputText);
                fragmentTwo.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, fragmentTwo)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    private boolean isValidText(String text) {

        boolean isButtonEnabled;
        isButtonEnabled = text.length() >= 6;

        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(text);
        boolean hasUppercase = matcher.find();

        isButtonEnabled = isButtonEnabled && hasUppercase;

        return isButtonEnabled;
    }
}