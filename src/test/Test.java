package test;

import java.util.ArrayList;

import model.Work;
import util.DataManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Work> works=DataManager.readData();
		System.out.println(works);
	}

}
