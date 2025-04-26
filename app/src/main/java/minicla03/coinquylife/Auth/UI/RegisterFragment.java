package minicla03.coinquylife.Auth.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.Auth.ViewModel.AuthViewModel;
import minicla03.coinquylife.R;

public class RegisterFragment extends Fragment
{
    private AuthViewModel authViewModel;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText usernameEditText;
    private Button registerButton;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initializeUI(view);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        setupObservers();
        setupListeners();
        return view;
    }

    private void initializeUI(View view)
    {
        emailEditText = view.findViewById(R.id.etEmail);
        passwordEditText = view.findViewById(R.id.etPassword);
        nameEditText = view.findViewById(R.id.etNome);
        surnameEditText = view.findViewById(R.id.etCognome);
        usernameEditText = view.findViewById(R.id.etUsername);
        registerButton = view.findViewById(R.id.btnRegister);
    }

    private void setupObservers()
    {

        authViewModel.getRegistrationResult().observe(getViewLifecycleOwner(), registrationSuccessful -> {
            if (registrationSuccessful)
            {
                Toast.makeText(getContext(), "Registrazione riuscita", Toast.LENGTH_SHORT).show();
                // Navigate to the next Activity or Fragment
            }
            else
            {
                Toast.makeText(getContext(), "Errore nella registrazione", Toast.LENGTH_SHORT).show();
                // consider displaying the specific error here in the future
            }
        });
    }

    private void setupListeners()
    {
        registerButton.setOnClickListener(v -> attemptRegistration());
    }

    private void attemptRegistration()
    {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String name = nameEditText.getText().toString().trim();
        String surname = surnameEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();

        authViewModel.registerUser(email, password, name);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }
}