package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.Survey;

@Dao
public interface SurveyDao {

    @Insert
    void insertSurvey(Survey survey);

    @Update
    void updateSurvey(Survey survey);

    @Delete
    void deleteSurvey(Survey survey);

    @Query("SELECT * FROM Survey WHERE id_survey = :idSurvey")
    Survey getSurveyById(String idSurvey);

    @Query("SELECT * FROM Survey")
    List<Survey> getAllSurveys();
}