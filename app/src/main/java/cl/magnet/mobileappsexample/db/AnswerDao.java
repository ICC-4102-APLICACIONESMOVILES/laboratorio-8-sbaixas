package cl.magnet.mobileappsexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Sebastian on 29-05-18.
 */

public interface AnswerDao {
    @Query("SELECT * FROM answer")
    LiveData<List<Answer>> getAllAnswers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Answer... answers);

    @Query("DELETE FROM answer")
    void deleteAll();
}
