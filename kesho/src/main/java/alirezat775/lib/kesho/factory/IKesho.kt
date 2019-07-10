package alirezat775.lib.kesho.factory

interface IKesho {

    fun push(key: String, value: String)
    fun push(key: String, value: Boolean)
    fun push(key: String, value: Double)
    fun push(key: String, value: Float)
    fun push(key: String, value: Int)
    fun push(key: String, value: Long)

    fun pull(key: String)

    fun pull(key: String, defaultValue: String)
    fun pull(key: String, defaultValue: Boolean)
    fun pull(key: String, defaultValue: Double)
    fun pull(key: String, defaultValue: Float)
    fun pull(key: String, defaultValue: Int)
    fun pull(key: String, defaultValue: Long)
}