package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Sebastian on 29-05-18.
 */

public class AnswerRepository {
    private AnswerDao mAnswerDao;
    private LiveData<List<Answer>> mAllAnswers;

    AnswerRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mAnswerDao = db.answerDao();
        mAllAnswers = mAnswerDao.getAllAnswers();
    }

    LiveData<List<Answer>> getAllAnswers() {
        return mAllAnswers;
    }

    public void insert (List<Answer> answers) {
        Answer[] answersArray = new Answer[answers.size()];
        answersArray = answers.toArray(answersArray);
        new AnswerRepository.insertAsyncTask(mAnswerDao).execute(answersArray);
    }

    private static class insertAsyncTask extends AsyncTask<Answer, Void, Void> {

        private AnswerDao mAsyncTaskDao;

        insertAsyncTask(AnswerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Answer... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}
