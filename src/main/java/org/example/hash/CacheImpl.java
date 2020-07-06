package org.example.hash;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class CacheImpl implements ICache {

	TreeMap<Long, Node> nodes;

	public CacheImpl(List<Server> servers) {
		nodes = new TreeMap<>();
		for (Server server : servers) {
			for (int i = 0; i < server.getNodes().size(); i++) {
				Node node = server.getNodes().get(i);
				long hashcode = HashUtils.hash(node.getName(), 0);
				System.out.println(hashcode);
				nodes.put(hashcode, node);
			}
		}
	}

	@Override
	public Object get(String key) {
		Node node = getNode(key);
		System.out.println(node.getName());
		if (node == null) {
			return null;
		}
		return node.getData().get(key);
	}

	@Override
	public Object put(String key, Object object) {
		Node node = getNode(key);
		if (node == null) {
			return null;
		}
		return node.getData().put(key, object);
	}

	@Override
	public void del(String key) {
		Node node = getNode(key);
		if (node == null) {
			return;
		}
		node.getData().remove(key);
	}

	@Override
	public boolean exist(String key) {
		Node node = getNode(key);
		if (node == null) {
			return false;
		}
		return node.getData().containsKey(key);
	}

	private Node getNode(String key) {
		Map.Entry<Long, Node> entry = nodes.ceilingEntry((long) HashUtils.hash(key, 0));
		if (entry == null) {
			entry = nodes.firstEntry();
		}
		return entry.getValue();
	}
}
