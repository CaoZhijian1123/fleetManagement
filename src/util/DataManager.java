package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import constant.ValueString;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.Time;
import model.Work;

public class DataManager {
	private static ArrayList<Work> works;
	public static ArrayList<Work> readData(){
		works=new ArrayList<Work>();
		File file=new File(ValueString.DATA_FILEPATH);
		
		//读取数据
		try {
			Workbook workbook=Workbook.getWorkbook(file);
			Sheet sheet=workbook.getSheet(0);
			for (int i = 1;i<197 ; i++) {
				Cell cell=sheet.getCell(0, i);
				if (cell.getContents()==null) {
					break;
				}
				int id=Integer.parseInt(cell.getContents());
				Work work=new Work();
				work.setId(id);
				int h1=Integer.parseInt(sheet.getCell(1, i).getContents());
				int m1=Integer.parseInt(sheet.getCell(2, i).getContents());
				int h2=Integer.parseInt(sheet.getCell(3, i).getContents());
				int m2=Integer.parseInt(sheet.getCell(4, i).getContents());
				work.setDispatch_time(new Time(h1, m1));
				work.setReturn_time(new Time(h2, m2));
				works.add(work);
			}
			
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return works;
	}

	public  static void   writeData() {
		File file=new File(ValueString.RESULT_FILEPATH);
		try {
			WritableWorkbook book=Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("Sheet1", 0);
			Label label0=new Label(0, 0, "线路编号");
			Label label1=new Label(1, 0, "发车时间");
			Label label2=new Label(2, 0, "返回时间");
			Label label3=new Label(3, 0, "公交车编号");
	
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			for (int i = 0; i <works.size(); i++) {
				sheet.addCell(new Label(0, i+1, ""+works.get(i).getId()));
				sheet.addCell(new Label(1, i+1, ""+works.get(i).getDispatch_time()));
				sheet.addCell(new Label(2, i+1, ""+works.get(i).getReturn_time()));
				sheet.addCell(new Label(3, i+1, ""+works.get(i).getBusId()));
			}
			book.write();
			book.close();
			System.out.println("输出完成");
			JOptionPane.showMessageDialog(null, "输出完成", "System info", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
