package model;

public class Time implements Comparable<Time> {
	public int hour;
	public int min;
	
	public Time() {
		// TODO Auto-generated constructor stub
	}
	public Time(int hour, int min) {
		this.hour=hour;
		this.min=min;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (min<10) {
			return hour+":0"+min;
		}
		return hour+":"+min;
	}
	
	public void addMin() {
		// TODO Auto-generated method stub
		if (++min==60) {
			this.min=0;
			hour++;
		}
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		if (this.hour>o.hour) {
			return 1;
		}
		
		if (this.hour<o.hour) {
			return -1;
		}
		
		if (this.min>o.min) {
			return 1;
		}
		
		if (this.min<o.min) {
			return -1;
		}
		return 0;
	}
	
	
}
