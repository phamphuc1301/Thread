package com.edu.vn;

import java.util.List;

public class Worker extends Thread {
	private String nameWorker;
	private List<String> listTask;

	public String getNameWorker() {
		return nameWorker;
	}

	public void setNameWorker(String name) {
		this.nameWorker = name;
	}

	public Worker(String name) {
		super();
		this.nameWorker = name;
		listTask = Application.listTask;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (listTask) {
				int doTask = listTask.size() - 1;
				try {
					if (listTask.size() == 0) {
						System.out.println("List task empty. Wait manager add task.");
						listTask.notifyAll();
						listTask.wait();
					} else {
						System.out.println(nameWorker + " doing " + listTask.get(doTask));
						listTask.remove(doTask);
						listTask.notifyAll();
						listTask.wait();
					}
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

}
