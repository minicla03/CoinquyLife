package minicla03.coinquylife.Factory;

import minicla03.coinquylife.Auth.Repository.AuthRepository;

public class AppContainerViewModel
{
    private final AppContainerViewModel appContainerViewModel;

    public AppContainerViewModel(AuthRepository authRepository)
    {
        this.appContainerViewModel = authRepository;
    }

    public AuthRepository getUserUseCase()
    {
        return appContainerViewModel;
    }
}
