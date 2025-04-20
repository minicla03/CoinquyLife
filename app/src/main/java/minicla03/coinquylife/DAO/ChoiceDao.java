package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.entity.Choice;

@Dao
public interface ChoiceDao
{
    @Insert void insertChoice(Choice choice);

    @Update void updateChoice(Choice choice);

    @Delete void deleteChoice(Choice choice);

    @Query("SELECT * FROM Choice WHERE id_choice = :idChoice") Choice getChoiceById(String idChoice);

    @Query("SELECT * FROM Choice") List<Choice> getAllChoices();
}