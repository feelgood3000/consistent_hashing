package org.example.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体服务器
 */

public class Server {

	private final static String seporator = "#";

	/**
	 * 服务的名字
	 */
	private String name;

	private List<Node> nodes;

	public Server(String name, int nodeCount) {
		this.name = name;
		nodes = new ArrayList<>(nodeCount);
		for (int i = 0; i < nodeCount; i++) {
			Node node = new Node(this.name + seporator + i);
			nodes.add(node);
		}
	}

	public long keys() {
		long count = 0;
		for (Node node : nodes) {
			count += node.getData().size();
		}
		return count;
	}

	@Override
	public String toString() {
		return "Server{" +
				"name='" + name + '\'' +
				"keys:" + keys() +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
}
