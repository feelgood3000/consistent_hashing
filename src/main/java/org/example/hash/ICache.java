package org.example.hash;

public interface ICache {
	/**
	 * 获取
	 * @param key
	 * @return
	 */
	Object get(String key);

	/**
	 * 添加
	 * @param key
	 * @return
	 */
	Object put(String key, Object object);

	/**
	 * 删除
	 * @param key
	 * @return
	 */
	void del(String key);

	/**
	 * 判断是否存在
	 * @param key
	 * @return
	 */
	boolean exist(String key);
}
