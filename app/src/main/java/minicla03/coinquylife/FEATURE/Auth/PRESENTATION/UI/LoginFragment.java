package minicla03.coinquylife.FEATURE.Auth.PRESENTATION.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.FEATURE.Auth.Utility.AuthStatus;
import minicla03.coinquylife.FEATURE.Auth.PRESENTATION.ViewModel.AuthViewModel;
import minicla03.coinquylife.R;
import minicla03.coinquylife.FEATURE.SelectionHouse.PRESENTATION.UI.CoinquyHouseSelectionActivity;
import minicla03.coinquylife.FEATURE.dashboard.UI.DashboardActivity;

public class LoginFragment extends Fragment
{
    private AuthViewModel authViewModel;
    private TextView etEmail;
    private TextView etPassword;
    private View btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etEmail= view.findViewById(R.id.editTextUsernameEmail);
        etPassword=view.findViewById(R.id.editTextPassword);
        btnLogin= view.findViewById(R.id.buttonLogin);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();

            authViewModel.login(email, password);
        });

        authViewModel.getLoginResult().observe(getViewLifecycleOwner(), result ->
        {
            if (result.user != null && result.status == AuthStatus.NO_COINQUYHOUSE)
            {
                Intent intent = new Intent(requireActivity(), CoinquyHouseSelectionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", result.user.getId_user());
                startActivity(intent);
            }
            else if (result.user != null && result.status == AuthStatus.HAS_COINQUYHOUSE)
            {
                Intent intent = new Intent(this.getContext(), DashboardActivity.class);
                intent.putExtra("user", result.user.getId_user());
                startActivity(intent);
            } else if (result.user != null && result.status == AuthStatus.WRONG_PASSWORD) {
                Toast.makeText(getContext(), "Password errata!", Toast.LENGTH_SHORT).show();
            } else if (result.user != null && result.status == AuthStatus.USER_NOT_FOUND) {
                Toast.makeText(getContext(), "User not found!", Toast.LENGTH_SHORT).show();
            }
            else if(result.user != null && result.status == AuthStatus.INVALID_EMAIL) {
                Toast.makeText(getContext(), "Email non valida!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Login fallito!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
