package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Sebastian on 29-05-18.
 */

public class QuestionRepository {
    private QuestionDao mQuestionDao;
    private LiveData<List<Question>> mAllQuestions;

    QuestionRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mQuestionDao = db.questionDao();
        mAllQuestions = mQuestionDao.getAllQuestions();
    }

    LiveData<List<Question>> getAllQuestions() {
        return mAllQuestions;
    }

    public void insert(List<Question> Questions) {
        Question[] questionsArray = new Question[Questions.size()];
        questionsArray = Questions.toArray(questionsArray);
        new QuestionRepository.insertAsyncTask(mQuestionDao).execute(questionsArray);
    }

    private static class insertAsyncTask extends AsyncTask<Question, Void, Void> {

        private QuestionDao mAsyncTaskDao;

        insertAsyncTask(QuestionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Question... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}

