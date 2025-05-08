package minicla03.coinquylife.Factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.Auth.ViewModel.AuthViewModel;
import minicla03.coinquylife.SelectionHouse.ViewModel.SelectHouseViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory
{
    private final AppContainer appContainer;

    public ViewModelFactory(AppContainer appContainer)
    {
        this.appContainer = appContainer;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
    {
        if (modelClass.isAssignableFrom(AuthViewModel.class))
        {
            return new AuthViewModel(appContainer.getUserUseCase());
        }
        else if (modelClass.isAssignableFrom(ViewModelFactory.class))
        {
            return new ViewModelFactory(appContainer.getProductListUseCase());
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

