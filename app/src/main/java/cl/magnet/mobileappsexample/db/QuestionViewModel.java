package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Sebastian on 29-05-18.
 */

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRepository mRepository;

    private LiveData<List<Question>> mAllQuestions;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QuestionRepository(application);
        mAllQuestions = mRepository.getAllQuestions();
    }

    public LiveData<List<Question>> getAllQuestions() {
        return mAllQuestions;
    }

    public void insert(List<Question> Questions) {
        mRepository.insert(Questions);
    }
}