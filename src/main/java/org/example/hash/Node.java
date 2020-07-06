package org.example.hash;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 虚拟节点
 */
public class Node {
	/**
	 * 最大hash值
	 */
	private static long max = 2 ^ 32;

	private String name;

	private ConcurrentHashMap<String, Object> data;

	public Node(String name) {
		this.name = name;
		data = new ConcurrentHashMap<>();
	}


	// TODO: 2020/7/3 一致性hash算法最大值是long，这里返回的是int，需要重写hash算法
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConcurrentHashMap<String, Object> getData() {
		return data;
	}

	public void setData(ConcurrentHashMap<String, Object> data) {
		this.data = data;
	}
}
