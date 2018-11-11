package aw222zr_Assignment4.BinHeap.PriorityQueue;

public class WorkTask implements Task {

	String task = "";
	int taskPriority = 0;
	
	public WorkTask(String taskInput, int priorityInput) {
		this.task = taskInput;
		this.taskPriority = priorityInput;
	}
	
	@Override
	public String toString() {
		return "Task: " + task + " , Priority: " + taskPriority;
	}

	@Override
	public void setTask(String taskInput) {
		this.task = taskInput;
	}

	@Override
	public String getTask() {
		return this.task;
	}

	@Override
	public void setPriority(int priorityInput) {
		this.taskPriority = priorityInput;
	}

	@Override
	public int getPriority() {
		return this.taskPriority;
	}
	
}
