package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.entity.Note;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("SELECT * FROM Note WHERE id_note = :idNote")
    Note getNoteById(String idNote);

    @Query("SELECT * FROM Note")
    List<Note> getAllNotes();
}