package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

//Here we are storing excel data in 2-d array with the help of Excel utility class 

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviders {

	//DataProvider 1
	
	private static List<HashMap<String, String>> datamap;
	static List<HashMap<String,String>> data;
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility(this utility will fetch the data from cell)
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	
	public static List<HashMap<String, String>> getJsonData(String path) throws IOException
	{
		
		
		String jsonstring =FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);//read json to string
		
		//string to HashMap
		ObjectMapper mapper= new ObjectMapper();
		data=mapper.readValue(jsonstring, new TypeReference<List<HashMap<String,String>>>(){
		}); 
		
		return data;
	}
	
	@DataProvider(name="LoginDatawithJson")
	 public static Object[][] getJSonDatatest() throws IOException {
		   
		    
		    List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.json");
		    return new Object[][] {{data.get(0)},{data.get(1)}};
	        
		   
	   }

	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
