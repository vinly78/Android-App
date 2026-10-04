package com.example.andriodhw;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.andriodhw.databinding.FragmentLoginBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private boolean isPasswordVisible = false;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.imgPasswordToggle.setOnClickListener(v -> {
            if (isPasswordVisible) {
                binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                binding.imgPasswordToggle.setImageResource(R.drawable.ic_eye_slash);
                isPasswordVisible = false;
            } else {
                binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                binding.imgPasswordToggle.setImageResource(R.drawable.ic_eye);
                isPasswordVisible = true;
            }
            binding.etPassword.setSelection(binding.etPassword.getText().length());
        });


        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etUsername.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Welcome " + email, Toast.LENGTH_SHORT).show();
                Snackbar.make(binding.getRoot(), "Log In Successful", Snackbar.LENGTH_SHORT).show();
            }
        });


        binding.tvForgotPassword.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
        );


        binding.tvSignUpPrompt.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment)
        );


        binding.btnGoogle.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Google Log In Clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnFacebook.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Facebook Log In Clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnGithub.setOnClickListener(v ->
                Toast.makeText(requireContext(), "GitHub Log In Clicked", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
