package cl.magnet.mobileappsexample.db;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Sebastian on 29-05-18.
 */

public class Question {
    @PrimaryKey public final int id;
    public final String text;
    public final int formId;
    public final String type;
    public Question(final int id, final String text,
                  final int formId) {
        this.id = id;
        this.text = text;
        this.formId = formId;
        this.type = "TextQuestion";
    }
}
