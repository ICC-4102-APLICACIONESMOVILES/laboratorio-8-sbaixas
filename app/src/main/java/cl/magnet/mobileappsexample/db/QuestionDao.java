package cl.magnet.mobileappsexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Sebastian on 29-05-18.
 */

public interface QuestionDao {
    @Query("SELECT * FROM question")
    LiveData<List<Question>> getAllQuestions();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Question... questions);

    @Query("DELETE FROM question")
    void deleteAll();
}
