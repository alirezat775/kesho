package alirezat775.lib.kesho

import alirezat775.lib.kesho.factory.IKesho
import alirezat775.lib.kesho.factory.SharedPreferencesManager
import android.content.Context

class Kesho(private val context: Context, @KeshoType type: String) : IKesho {

    companion object {
        const val SHARED_PREFRENCES_MANAGER: String = "SharedPreferencesManager"
    }

    private lateinit var kesho: IKesho

    init {
        when (type) {
            SHARED_PREFRENCES_MANAGER -> kesho = SharedPreferencesManager(context)
        }
    }

    override fun push(key: String, value: String?) {
        kesho.push(key, value)
    }

    override fun push(key: String, value: Boolean) {
        kesho.push(key, value)
    }

    override fun push(key: String, value: Float) {
        kesho.push(key, value)
    }

    override fun push(key: String, value: Int) {
        kesho.push(key, value)
    }

    override fun push(key: String, value: Long) {
        kesho.push(key, value)
    }

    override fun pull(key: String, defaultValue: String): String? {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Boolean): Boolean {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Float): Float {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Int): Int {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Long): Long {
        return kesho.pull(key, defaultValue)
    }

    override fun remove(key: String) {
        kesho.remove(key)
    }

    override fun clear() {
        kesho.clear()
    }

    override fun isExist(key: String): Boolean {
        return kesho.isExist(key)
    }
}