package minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.SelectHouseResult;
import retrofit2.Call;
import retrofit2.Callback;

public class NewHouseUseCase implements INewHouseUseCase
{
    private final ISelectHouseRepository repository;
    private final Executor executor;

    public NewHouseUseCase(ISelectHouseRepository repository, Executor executor)
    {
        this.executor = executor;
        this.repository = repository;
    }

    public void execute(String houseName, String address, String token, Consumer<SelectHouseResult> callback)
    {
        Call<SelectHouseResult> remoteCall = repository.createHouseRemote(houseName, address, token);

        remoteCall.enqueue(new Callback<>()
        {
            @Override
            public void onResponse(Call<SelectHouseResult> call, retrofit2.Response<SelectHouseResult> response)
            {
                SelectHouseResult result;
                try
                {
                    if (code == 200) {
                        String houseCode = extractCodeFromJson(responseBody);
                        result = new SelectHouseResult(SelectHouseResult.Status.HOUSE_CREATED_AND_LINKED, houseCode);
                    } else if (code == 404) {
                        result = new SelectHouseResult(SelectHouseResult.Status.USER_NOT_FOUND, "User not found");
                    } else if (code == 409) {
                        if (responseBody.contains("already linked")) {
                            result = new SelectHouseResult(SelectHouseResult.Status.USER_ALREADY_LINKED, "User already linked to a house");
                        } else if (responseBody.contains("esiste già")) {
                            result = new SelectHouseResult(SelectHouseResult.Status.HOUSE_ALREADY_EXISTS, "House already exists");
                        } else {
                            result = new SelectHouseResult(SelectHouseResult.Status.CONFLICT, "Conflict occurred");
                        }
                    } else if (code == 500) {
                        result = new SelectHouseResult(SelectHouseResult.Status.SERVER_ERROR, "Server error: " + responseBody);
                    } else {
                        result = new SelectHouseResult(SelectHouseResult.Status.ERROR, "Unexpected error (" + code + ")");
                    }
                }
                catch (Exception e)
                {
                    result = new SelectHouseResult(SelectHouseResult.Status.ERROR, "Parsing error: " + e.getMessage());
                }

               callback.accept(result);
            }

            @Override
            public void onFailure(Call<SelectHouseResult> call, Throwable t)
            {
                SelectHouseResult result = new SelectHouseResult(SelectHouseResult.Status.ERROR, "Network failure: " + t.getMessage());
                callback.accept(result);
            }
        });
    }

    private String extractCodeFromJson(String json)
    {
        try
        {
            JSONObject obj = new JSONObject(json);
            return obj.getString("code");
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
