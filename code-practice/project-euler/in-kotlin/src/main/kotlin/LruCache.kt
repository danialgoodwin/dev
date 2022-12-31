class LruCache<K, V>(private val maxEntries: Int) : LinkedHashMap<K, V>(maxEntries, 0.75f, true) {

//    private val cache = object : LinkedHashMap<K, V>(maxEntries, 0.75f, true) {
//        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
//            return size > maxEntries
//        }
//    }

    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
        return size > maxEntries
    }

    inline fun getOrPut(key: K, defaultValue: () -> V) : V {
        val value = get(key)
        return if (value == null) {
            val answer = defaultValue()
            put(key, answer)
            answer
        } else {
            value
        }
    }

}
