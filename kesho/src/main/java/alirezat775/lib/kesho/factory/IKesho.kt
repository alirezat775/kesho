package alirezat775.lib.kesho.factory

internal interface IKesho {

    fun push(key: String, value: String?)
    fun push(key: String, value: Boolean)
    fun push(key: String, value: Float)
    fun push(key: String, value: Int)
    fun push(key: String, value: Long)

    fun pull(key: String, defaultValue: String): String?
    fun pull(key: String, defaultValue: Boolean): Boolean
    fun pull(key: String, defaultValue: Float): Float
    fun pull(key: String, defaultValue: Int): Int
    fun pull(key: String, defaultValue: Long): Long

    fun remove(key: String)
    fun clear()

    fun isExist(key: String): Boolean
}