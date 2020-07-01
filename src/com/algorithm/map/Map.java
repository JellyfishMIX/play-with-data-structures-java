package com.algorithm.map;

/**
 * @author JellyfishMIX
 * @date 2020/6/30 20:06
 */
public interface Map<K, V> {
    /**
     * 添加元素
     *
     * @param key key
     * @param value value
     */
    void add(K key, V value);

    /**
     * 删除key对应的Node
     *
     * @param key key
     * @return key对应的value，如果key不存在，则返回null
     */
    V remove(K key);

    /**
     * key是否存在
     *
     * @param key key
     * @return true/false
     */
    boolean contains(K key);

    /**
     * 根据key获取value
     *
     * @param key key
     * @return key对应的value
     */
    V get(K key);

    /**
     * 把key值的value设置为newValue，如果Key不存在会报错
     *
     * @param key key
     * @param newValue newValue
     */
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
