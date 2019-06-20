package model;

public class Work {
	private int id;
	private Time dispatch_time;
	private Time return_time;
	private int busId;
	
	
	public Work() {
		id=-1;
		busId=-1;
	}
	
	
	/**
	 * @return the busId
	 */
	public int getBusId() {
		return busId;
	}
	/**
	 * @param busId the busId to set
	 */
	public void setBusId(int busId) {
		this.busId = busId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the dispatch_time
	 */
	public Time getDispatch_time() {
		return dispatch_time;
	}
	/**
	 * @param dispatch_time the dispatch_time to set
	 */
	public void setDispatch_time(Time dispatch_time) {
		this.dispatch_time = dispatch_time;
	}
	/**
	 * @return the return_time
	 */
	public Time getReturn_time() {
		return return_time;
	}
	/**
	 * @param return_time the return_time to set
	 */
	public void setReturn_time(Time return_time) {
		this.return_time = return_time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "route id\t"+id+"\t"+dispatch_time+"->"+return_time+" bus id\t"+busId+"";
	}

}
