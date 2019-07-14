package alirezat775.lib.kesho

import alirezat775.lib.kesho.factory.IKesho
import alirezat775.lib.kesho.factory.SharedPreferencesManager
import android.content.Context

class Kesho(private val context: Context, @KeshoType type: String) : IKesho {

    companion object {

        internal const val NONE_EXPIRE_TIME = 0L
        internal const val EXPIRE_TIME = -1L

        const val SHARED_PREFERENCES_MANAGER: String = "SharedPreferencesManager"

        const val ONE_SECOND = 1000L
        const val ONE_MINUTES = 60 * ONE_SECOND
        const val ONE_HOURS = 60 * ONE_MINUTES
        const val ONE_DAYS = 24 * ONE_HOURS
        const val ONE_WEEKS = 7 * ONE_DAYS
        const val ONE_MONTH = 30 * ONE_DAYS
        const val ONE_YEAR = 365 * ONE_DAYS
    }

    private lateinit var kesho: IKesho

    init {
        when (type) {
            SHARED_PREFERENCES_MANAGER -> kesho = SharedPreferencesManager(context)
        }
    }

    override fun push(key: String, value: String?,@TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Boolean,@TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Float,@TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Int,@TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Long,@TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
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