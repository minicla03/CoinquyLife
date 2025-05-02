package minicla03.coinquylife.SelectionHouse.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class NewCoinquyHouseIDFragment extends Fragment {

    private EditText houseName;
    private SelectHouseViewModel selectHouseViewModel;

    public NewCoinquyHouseIDFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_new_coinquy_house, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewID = view.findViewById(R.id.textViewID);
        Button btnProceed = view.findViewById(R.id.btnProceed);
        houseName= view.findViewById(R.id.etHouseName);

        selectHouseViewModel= new ViewModelProvider(this).get(SelectHouseViewModel.class);

        textViewID.setText(selectHouseViewModel.generateHouseCode());
        User user = requireActivity().getIntent().getParcelableExtra("user");

        btnProceed.setOnClickListener(v ->
        {
            String name_house = houseName.getText().toString().trim();
            selectHouseViewModel.createHouse(name_house, user);
        });

        selectHouseViewModel.getHouseCreationResult().observe(getViewLifecycleOwner(), result ->
        {
            if (result.getStatus()==SelectHouseStatus.SUCCESS)
            {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", result.getUser());
                intent.putExtra("coinquyhouse", result.getCoinquyHouse());
                startActivity(intent);
            }
            else
            {
                Toast.makeText(requireContext(), "Error during the creation of the house", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
