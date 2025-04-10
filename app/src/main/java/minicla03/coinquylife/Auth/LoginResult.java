package minicla03.coinquylife.Auth;

public class LoginResult
{
    private boolean success;

    public LoginResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
