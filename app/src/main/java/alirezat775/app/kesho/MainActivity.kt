package alirezat775.app.kesho

import alirezat775.lib.kesho.Kesho
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.name

    private val KEY_INT = "KEY_INT"
    private val KEY_STRING = "KEY_STRING"
    private val KEY_FLOAT = "KEY_FLOAT"
    private val KEY_LONG = "KEY_LONG"
    private val KEY_BOOLEAN = "KEY_BOOLEAN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kesho = Kesho(this, Kesho.SHARED_PREFRENCES_MANAGER)

        kesho.push(KEY_INT, 1)
        kesho.push(KEY_STRING, "hello world")
        kesho.push(KEY_FLOAT, 1.0f)
        kesho.push(KEY_LONG, 1L)
        kesho.push(KEY_BOOLEAN, true)

        Log.d(TAG, "value : " + kesho.pull(KEY_INT, 0))
        Log.d(TAG, "value : " + kesho.pull(KEY_STRING, ""))
        Log.d(TAG, "value : " + kesho.pull(KEY_FLOAT, 0.0f))
        Log.d(TAG, "value : " + kesho.pull(KEY_LONG, 0L))
        Log.d(TAG, "value : " + kesho.pull(KEY_BOOLEAN, false))
    }
}
