package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import model.Time;
import model.Vehicle;
import model.VehicleFleets;
import model.Work;
import util.DataManager;

public class Main2 {

	private static ArrayList<Work> works = DataManager.readData();
	private static VehicleFleets vehicleFleets = new VehicleFleets();
	private static int index_work = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		works = DataManager.readData();
		Time time = new Time(5, 0);
		for (int i = 0; i < 18 * 60 && index_work < works.size(); i++) {
			updateList(time);
			time.addMin();
		}
		System.out.println(vehicleFleets.vehicles.size());
		DataManager.writeData();

		
		
		
		int i = 1;
		for (Work work : works) {
			System.out.println("No." + i++ + "\t\t" + work);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("规模：" + vehicleFleets.vehicles.size());
		DataManager.writeData();
	}

	private static void updateList(Time time) {
		HashSet<Vehicle> vehicles = vehicleFleets.vehicles;
		ArrayList<Vehicle> serviceList = vehicleFleets.serviceList;
		LinkedList<Vehicle> waitList = vehicleFleets.waitList;

		// 更新队列
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		for (Vehicle v : serviceList) {
			if (v.getWork().getReturn_time().compareTo(time) < 0) {
				waitList.addLast(v);
				temp.add(v);
			}
		}
		serviceList.removeAll(temp);

		// 对到时的班次发车
		Work work = works.get(index_work);
		while (work.getDispatch_time().compareTo(time) == 0) {
			Vehicle vehicle = null;
			try {
				vehicle = waitList.getLast();
			} catch (Exception e) {
			}

			if (vehicle != null) {
				waitList.removeLast();
			}

			if (vehicle == null) {
				vehicle = new Vehicle(vehicles.size() + 1);
				vehicles.add(vehicle);
			}

			vehicle.setWork(work);
			work.setBusId(vehicle.getId());
			serviceList.add(vehicle);
			index_work++;
			if (index_work >= works.size() - 1) {
				break;
			}
			work = works.get(index_work);
		}
	}

}
