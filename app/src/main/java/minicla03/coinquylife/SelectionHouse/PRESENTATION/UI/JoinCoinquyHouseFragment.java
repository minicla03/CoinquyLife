package minicla03.coinquylife.SelectionHouse.PRESENTATION.UI;

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

import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseStatus;
import minicla03.coinquylife.SelectionHouse.PRESENTATION.ViewModel.SelectHouseViewModel;
import minicla03.coinquylife.dashboard.UI.DashboardActivity;

public class JoinCoinquyHouseFragment extends Fragment
{
    private EditText etHouseID;
    private Button btnConfirm;
    private User user;
    private SelectHouseViewModel selectHouseViewModel;

    public JoinCoinquyHouseFragment() {  }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_existing_house, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        etHouseID = view.findViewById(R.id.etHouseID);
        btnConfirm = view.findViewById(R.id.btnConfirmHouseID);
        selectHouseViewModel = new ViewModelProvider(requireActivity()).get(SelectHouseViewModel.class);

        selectHouseViewModel.getIntentData().observe(getViewLifecycleOwner(), data -> {
            if (data != null) {
                String idUser = (String) data.get("USER");
                if (idUser == null) {
                    Toast.makeText(requireContext(), "User data is missing", Toast.LENGTH_SHORT).show();
                } else {
                    selectHouseViewModel.retriveUser(idUser);
                }
            }
        });

        selectHouseViewModel.getRetriveUserResult().observe(getViewLifecycleOwner(), user -> {
            this.user = user;
        });

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
                Intent intent = new Intent(requireActivity(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", user.getId_user());
                intent.putExtra("coinquyhouse", result.getCoinquyHouse().getId_house());
                startActivity(intent);
            }
            else if (result.getStatus() == SelectHouseStatus.HOUSE_NOT_FOUND)
            {
                Toast.makeText(requireContext(), "House not found", Toast.LENGTH_SHORT).show();
            }
            else if (result.getStatus() == SelectHouseStatus.NOT_IN_HOUSE)
            {
                Toast.makeText(requireContext(), "User is not in a house", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(requireContext(), "Error joining house", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
