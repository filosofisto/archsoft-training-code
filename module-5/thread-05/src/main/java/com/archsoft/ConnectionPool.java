package com.archsoft;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ConnectionPool {

	private List<Connection> connections;
	private int maxConn;

	public ConnectionPool(int maxConn) {
		this.maxConn = maxConn;
		createConnections();
	}

	private void createConnections() {
		connections = new ArrayList<Connection>(maxConn);

		for (int i = 0; i < maxConn; i++) {
			connections.add(new Connection());
		}
	}

	public Connection getConnection() throws InterruptedException {
		synchronized (connections) {
			while (connections.isEmpty()) {
				out.println("wait - " + Thread.currentThread().getId());
				connections.wait();
			}
			return connections.remove(0);
		}
	}

	public void releaseConnection(Connection conn) {
		synchronized (connections) {
			connections.add(conn);
			//connections.notify();
			connections.notifyAll();
		}
	}

}
