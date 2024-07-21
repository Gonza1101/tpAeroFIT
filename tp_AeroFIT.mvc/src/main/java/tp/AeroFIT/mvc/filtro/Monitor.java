package tp.AeroFIT.mvc.filtro;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tp.AeroFIT.mvc.controller.VentaController;


public class Monitor {
	
	
	private int cantConsulta;
	private Lock lock;
	private Condition limiteConsulta;

	public Monitor() {
		super();
		this.cantConsulta = 0;
		this.lock = new ReentrantLock();
		this.limiteConsulta = this.lock.newCondition();
		
	}
	
	public void doConsulta() {
		try {
			this.lock.lock();
			if(cantConsulta > 5) {
				this.limiteConsulta.await();
			}
			this.cantConsulta ++;	
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.lock.unlock();
		}
		
	}
	
	public void exitConsulta() {
		this.lock.lock();
		this.cantConsulta --;
		this.limiteConsulta.signalAll();
		this.lock.unlock();
	}
	
	
}
