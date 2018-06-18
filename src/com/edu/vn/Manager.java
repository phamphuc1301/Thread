package com.edu.vn;

import java.util.List;

public class Manager extends Thread {
	private String nameManager;
	private List<String> listTask;
	private static int count = 0 ;
	public Manager(String nameManager) {
		super();
		this.nameManager = nameManager;
		this.listTask = Application.listTask;
	}

	public String getNameManager() {
		return nameManager;
	}

	public void setNameManager(String nameManager) {
		this.nameManager = nameManager;
	}

	public List<String> getListTask() {
		return listTask;
	}

	public void setListTask(List<String> listTask) {
		this.listTask = listTask;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (listTask) {
				try {
					if (listTask.size() > 10) {
						System.out.println("Too many task. wait on a minute ");
						listTask.notifyAll();
						listTask.wait();
					} else {
						System.out.println(nameManager + " add task " +count);
						listTask.add("task"+count);
						count++;
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
