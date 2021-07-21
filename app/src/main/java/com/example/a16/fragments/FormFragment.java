package com.example.a16.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a16.R;
import com.example.a16.Task;
import com.example.a16.databinding.FragmentFormBinding;


public class FormFragment extends Fragment {

   private FragmentFormBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(v -> {
            save();
        });
    }

    private void save() {
        Bundle bundle = new Bundle();
        String text1 = binding.etName.getText().toString();
        String text2 = binding.etSurname.getText().toString();
        Task task = new Task(text1,text2);
        bundle.putSerializable("task",task);
        FormFragment.this.getActivity().getSupportFragmentManager().setFragmentResult("requestKey",bundle);
        FormFragment.this.getActivity().getSupportFragmentManager().popBackStack();
    }
}
