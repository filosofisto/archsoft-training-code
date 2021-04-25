package com.archsoft;

import static java.lang.System.out;

/**
 * Objeto que utiliza uma conexao.
 * 
 * @author eduardo
 *
 */
public class ConnUse extends Thread {

	private ConnectionPool pool;
	
	public ConnUse(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		try {
			out.printf("Thread: %d - obtendo conexao\n", getId());
			Connection conn = pool.getConnection();
			out.printf("Thread: %d - conexao obtida\n", getId());

			//Simula tempo de utilizacao da conexao
			useConn(conn);
			
			out.printf("Thread: %d - retornando conexao ao pool\n", getId());
			pool.releaseConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void useConn(Connection conn) throws InterruptedException {
		Thread.sleep(1000);
	}
}
