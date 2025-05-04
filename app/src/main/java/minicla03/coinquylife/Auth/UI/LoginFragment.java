package minicla03.coinquylife.Auth.UI;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.Auth.Utility.AuthStatus;
import minicla03.coinquylife.Auth.ViewModel.AuthViewModel;
import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.UI.CoinquyHouseSelectionActivity;
import minicla03.coinquylife.dashboard.UI.DashboardActivity;

public class LoginFragment extends Fragment
{
    public LoginFragment()
    {
        super(R.layout.fragment_login);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView etEmail = view.findViewById(R.id.etEmail);
        TextView etPassword = view.findViewById(R.id.etPassword);
        View btnLogin = view.findViewById(R.id.btnLogin);

        AuthViewModel authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();

            authViewModel.login(email, password);
        });

        authViewModel.getLoginResult().observe(getViewLifecycleOwner(), result ->
        {
            if (result.user!=null && result.status== AuthStatus.NO_COINQUYHOUSE)
            {
                Intent intent = new Intent(getContext(), CoinquyHouseSelectionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", result.user);
                startActivity(intent);
            }
            else if(result.user!=null && result.status== AuthStatus.HAS_COINQUYHOUSE)
            {
                Intent intent = new Intent(getContext(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", result.user);
                startActivity(intent);
            }
            else if(result.user!=null && result.status== AuthStatus.WRONG_PASSWORD)
            {
                Toast.makeText(getContext(), "Password errata!", Toast.LENGTH_SHORT).show();
            }
            else if(result.user!=null && result.status== AuthStatus.USER_NOT_FOUND)
            {
                Toast.makeText(getContext(), "User not found!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getContext(), "Login fallito!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
