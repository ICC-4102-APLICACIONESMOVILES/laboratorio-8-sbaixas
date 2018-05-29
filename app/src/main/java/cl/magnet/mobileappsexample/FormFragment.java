package cl.magnet.mobileappsexample;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {
    private FormViewModel formViewModel;

    public FormFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        formViewModel = ViewModelProviders.of(getActivity()).get(FormViewModel.class);
        Button sendButton = view.findViewById(R.id.senFormButton);
        final EditText nameField =  view.findViewById(R.id.formName);
        final Random rn = new Random();
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Form f = new Form(rn.nextInt(), nameField.getText().toString(), "Today");
                List<Form> lf = new ArrayList<>();
                lf.add(f);
                formViewModel.insert(lf);
            }
        });

    }
}
