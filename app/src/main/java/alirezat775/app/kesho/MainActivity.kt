package alirezat775.app.kesho

import alirezat775.lib.kesho.Kesho
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.name

    private val KEY_INT = "KEY_INT"
    private val KEY_STRING = "KEY_STRING"
    private val KEY_FLOAT = "KEY_FLOAT"
    private val KEY_LONG = "KEY_LONG"
    private val KEY_BOOLEAN = "KEY_BOOLEAN"
    private val KEY_IS_EXIST = "KEY_IS_EXIST"
    private val KEY_OBJECT = "KEY_OBJECT"
    private val KEY_STRING_WITH_TTL = "KEY_STRING_WITH_TTL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kesho = Kesho(this, Kesho.SHARED_PREFERENCES_MANAGER)

        kesho.push(KEY_INT, 1)
        kesho.push(KEY_STRING, "hello world")
        kesho.push(KEY_FLOAT, 1.0f)
        kesho.push(KEY_LONG, 1L)
        kesho.push(KEY_BOOLEAN, true)
        kesho.push(KEY_OBJECT, SampleModel(1, "hello"))

        Log.d(TAG, "value : " + kesho.pull(KEY_INT, 0))
        Log.d(TAG, "value : " + kesho.pull(KEY_STRING, ""))
        Log.d(TAG, "value : " + kesho.pull(KEY_FLOAT, 0.0f))
        Log.d(TAG, "value : " + kesho.pull(KEY_LONG, 0L))
        Log.d(TAG, "value : " + kesho.pull(KEY_BOOLEAN, false))
        Log.d(TAG, "value : " + kesho.pull(KEY_OBJECT, SampleModel::class.java.name, SampleModel::class))
        Log.d(TAG, "value : " + kesho.has(KEY_IS_EXIST))

        kesho.push(KEY_STRING_WITH_TTL, "hello world", Kesho.ONE_SECOND * 10)
        Log.d(TAG, "value : " + kesho.pull(KEY_STRING_WITH_TTL, "default"))

        Handler().postDelayed({
            Log.d(TAG, "value : " + kesho.pull(KEY_STRING_WITH_TTL, "default"))
        }, Kesho.ONE_SECOND * 12)
    }
}
