package minicla03.coinquylife.SelectionHouse.UI;

import android.content.Intent;
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

import minicla03.coinquylife.Auth.UI.DashboardActivity;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseStatus;
import minicla03.coinquylife.SelectionHouse.ViewModel.SelectHouseViewModel;

public class JoinCoinquyHouseFragment extends Fragment
{
    private EditText etHouseID;
    private Button btnConfirm;

    public JoinCoinquyHouseFragment() {  }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_existing_house, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        etHouseID = view.findViewById(R.id.etHouseID);
        btnConfirm = view.findViewById(R.id.btnConfirmHouseID);
        User user= requireActivity().getIntent().getParcelableExtra("user");
        SelectHouseViewModel selectHouseViewModel = new ViewModelProvider(this).get(SelectHouseViewModel.class);

        btnConfirm.setOnClickListener(v -> {
            String houseId = etHouseID.getText().toString().trim();

            if (houseId.isEmpty())
            {
                Toast.makeText(requireContext(), "Insert a valid id", Toast.LENGTH_SHORT).show();
            }
            else
            {
                selectHouseViewModel.joinHouse(etHouseID.getText().toString().trim(), user);
            }
        });

        selectHouseViewModel.getJoinHouseResult().observe(getViewLifecycleOwner(), result->
        {
            if (result.getStatus() == SelectHouseStatus.SUCCESS)
            {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", result.getUser());
                intent.putExtra("coinquyhouse", result.getCoinquyHouse());
                startActivity(intent);
            }

            else if (result.getStatus() == SelectHouseStatus.HOUSE_NOT_FOUND)
            {
                Toast.makeText(requireContext(), "House not found", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(requireContext(), "Error joining house", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
