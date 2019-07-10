package alirezat775.lib.kesho.factory

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


class SharedPreferencesManager(private val context: Context) : IKesho {

    private companion object {
        private val preferences: String? = null

        @Volatile
        private var sharedPreferences: SharedPreferences? = null

        fun getSharedPreferences(context: Context): SharedPreferences {
            return sharedPreferences ?: synchronized(this) {
                context.getSharedPreferences(preferences, Activity.MODE_PRIVATE).also { sharedPreferences = it }
            }
        }
    }

    override fun push(key: String, value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun push(key: String, value: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun push(key: String, value: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun push(key: String, value: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun push(key: String, value: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun push(key: String, value: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String, defaultValue: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String, defaultValue: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String, defaultValue: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String, defaultValue: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String, defaultValue: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pull(key: String, defaultValue: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}