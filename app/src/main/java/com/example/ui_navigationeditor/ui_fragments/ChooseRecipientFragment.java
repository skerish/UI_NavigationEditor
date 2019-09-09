package com.example.ui_navigationeditor.ui_fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ui_navigationeditor.R;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRecipientFragment extends Fragment implements View.OnClickListener{

    private NavController navController;
    private TextInputEditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        editText = view.findViewById(R.id.input_recipient);
        view.findViewById(R.id.next_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view != null){
            switch (view.getId()){
                case R.id.next_btn:
                    String recipient = editText.getText().toString();
                    if(!TextUtils.isEmpty(recipient)){
                        Bundle bundle = new Bundle();
                        bundle.putString("recipientName", recipient);
                        navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle);
                    }
                    break;

                case R.id.cancel_btn:
                    getActivity().onBackPressed();
                    break;
            }
        }
    }
}
