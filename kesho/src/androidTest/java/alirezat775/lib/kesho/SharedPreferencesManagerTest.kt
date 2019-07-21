package alirezat775.lib.kesho

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SharedPreferencesManagerTest {

    lateinit var instrumentationContext: Context
    lateinit var kesho: Kesho

    @Before
    fun setUp() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
        kesho = Kesho(
            instrumentationContext,
            Kesho.SHARED_PREFERENCES_MANAGER,
            Kesho.Encrypt.DESEDE_ENCRYPT,
            "_hello_world_secret_key_v"
        )
    }

    @Test
    fun checkPushAndPullLong() {
        val KEY = "LONG"
        assert(kesho.pull(KEY, 0L) == 1L) { kesho.push(KEY, 1L) }
    }

    @Test
    fun checkPushAndPullInt() {
        val KEY = "INT"
        assert(kesho.pull(KEY, 0) == 1) { kesho.push(KEY, 1) }
    }

    @Test
    fun checkPushAndPullFloat() {
        val KEY = "FLOAT"
        assert(kesho.pull(KEY, 0.0f) == 1.0f) { kesho.push(KEY, 1.0f) }
    }

    @Test
    fun checkPushAndPullString() {
        val KEY = "STRING"
        assert(kesho.pull(KEY, "null!!") == "hello world") { kesho.push(KEY, "hello world") }
    }

    @Test
    fun checkPushAndPullBoolean() {
        val KEY = "BOOLEAN"
        assert(kesho.pull(KEY, false)) { kesho.push(KEY, true) }
    }
}