package com.example.ui_navigationeditor.ui_fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ui_navigationeditor.R;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {

    private NavController navController;
    private TextView textView;
    private String recipient;
    private int amountVal;
    private TextInputEditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        textView = view.findViewById(R.id.recipient);
        editText = view.findViewById(R.id.input_amount);

        amountVal = Integer.parseInt(editText.getText().toString());

        recipient = getArguments().getString("recipientName");
        textView.setText(String.format("Send data to %s", recipient));
        view.findViewById(R.id.send_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view != null){
            switch (view.getId()){
                case R.id.send_btn:
                    if (amountVal > 0){
                        Bundle bundle = new Bundle();
                        bundle.putInt("amounts", amountVal);
                        bundle.putString("recipientName", recipient);
                        navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle);
                    }
                    break;

                case R.id.cancel_btn:
                    getActivity().onBackPressed();
                    break;
            }
        }
    }
}
