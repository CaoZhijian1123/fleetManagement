package model;

public class Vehicle {
	
	public static int WAITTING =0;
	public static int SERVICE=1;
	
	private int id;
	private int state;
	private Work work;
	
	
	
	/**
	 * @return the work
	 */
	public Work getWork() {
		return work;
	}
	/**
	 * @param work the work to set
	 */
	public void setWork(Work work) {
		this.work = work;
	}
	public Vehicle(int num) {
		this.id=num;
		this.state=WAITTING;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	
	public int getState() {
		return state;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 if (this == obj) {
	            return true;
	        }
	        if (obj instanceof Vehicle) {
	        	Vehicle vTemp=(Vehicle)obj;
	        	if (vTemp.id==this.id) {
					return true;
				}
	        }
	        return false;     
	}
	

}
