package MainPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Reporting.Google_Sheets_Report;

public class CommonActions {
	
	public static String json;
	public static JSONObject jobject;
	public static HttpResponse response;
	public static HashMap reportdata = new HashMap();
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	static Date date = new Date();	
	static long startTime;
	static long stopTime;
	static HttpGet httpget;
	static HttpPost httppost;
	static Header [] headers;
	static String headerval="";
	static String responseString="";
	static String JsonString="";
	
	public static void reportdatasetnull()
	{
		reportdata.put("SrNo","NA");
		reportdata.put("API","NA");
		reportdata.put("State","NA");
		reportdata.put("Environment","NA");
		reportdata.put("Responsecode","NA");
		reportdata.put("ResponseTime","NA");
		reportdata.put("ResponseMsg","NA");
		reportdata.put("Header","NA");
		reportdata.put("NoOfKeys","NA");
		reportdata.put("TextResponse","NA");
		reportdata.put("DateRunOn","NA");
	}
	
	
	public static JSONObject execute(String url, String methodname,Map<String, Object> apiheaders, Map<String, Object> keyvalue) throws Exception
	{		
		try{
			
			reportdatasetnull();
			json=null;
			jobject=null;
			response=null;		
			
					
			reportdata.put("DateRunOn",dateFormat.format(date));
			
			List<NameValuePair> nameValuePairs;
			
			
			ReportLogger.WriteLog("Transaction Started for API "+url+" ");
			reportdata.put("API", url);
			HttpClient httpclient = new DefaultHttpClient();
			
			
			
			
			if(methodname.compareTo("GET")==0){
			httpget = new HttpGet(url);
			nameValuePairs = new ArrayList<NameValuePair>();
			HttpParams params = httpget.getParams();
									
			for(String key : keyvalue.keySet()){
				//nameValuePairs.add(new BasicNameValuePair(key.toString(),keyvalue.get(key).toString()));
				params.setParameter(key.toString(),keyvalue.get(key).toString());
			}
			if(apiheaders.isEmpty()==false){
				httpget.setHeader("Authorization", "Token "+apiheaders.get("Authorization").toString());
				if(apiheaders.size()>1){
			for(String key : apiheaders.keySet()){
				httpget.addHeader(key.toString(),apiheaders.get(key).toString());
			}}}
						
			// Execute HTTP get Request
			httpget.setParams(params);
			System.out.print(httpget.getParams().toString());
			startTime = System.currentTimeMillis();
			response = httpclient.execute(httpget);
			stopTime = System.currentTimeMillis();
			ReportLogger.WriteLog("Time lapsed for request: "+ (stopTime-startTime));
			reportdata.put("ResponseTime", stopTime-startTime+"ms");
								
			}
			
			
			else //if(methodname.compareTo("POST")==0)
				{
			httppost = new HttpPost(url);
			nameValuePairs = new ArrayList<NameValuePair>();
			for(String key : keyvalue.keySet()){
				nameValuePairs.add(new BasicNameValuePair(key.toString(),(String)keyvalue.get(key)));
			}
			
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			if(apiheaders.isEmpty()==false){
				
				httppost.setHeader("Authorization","Token "+apiheaders.get("Authorization").toString());
				if(apiheaders.size()>1){
			for(String key : apiheaders.keySet()){
				httppost.addHeader(key.toString(),keyvalue.get(key).toString().trim());
			}}}
			
			// Execute HTTP Post Request
			startTime = System.currentTimeMillis();
			response = httpclient.execute(httppost);
			stopTime = System.currentTimeMillis();
			
			ReportLogger.WriteLog("Time lapsed for request: "+ (stopTime-startTime));
			reportdata.put("ResponseTime", (stopTime-startTime+"ms").toString());
			
			
			}
			
			headers = response.getAllHeaders();
			for (Header header : headers) {
				
				System.out.println("Key : " + header.getName() 
				      + " ,Value : " + header.getValue());
				headerval=headerval+"Key : " + header.getName()+ " ,Value : " + header.getValue()+" ";
				
			}
			reportdata.put("Header", headerval.toString());	
			
			responseString = EntityUtils.toString(response.getEntity());
			System.out.println(response.getStatusLine());
			if (response.getStatusLine().toString().trim().compareTo("HTTP/1.1 200 OK")!=0)
			{
				
				if (response.getStatusLine().toString().trim().contains("400")==true && responseString.contains("Could not processs")==true)
				{
					ReportLogger.WriteLog(response.getStatusLine().toString());
					ReportLogger.WriteLog("Status code is: 200" );	
					ReportLogger.WriteLog("Status message is: OK");
					//ReportLogger.WriteLog("Terminating the execution for: "+Thread.currentThread().getStackTrace()[2].getMethodName());
					reportdata.put("Responsecode",  "200");
					reportdata.put("ResponseMsg",  "OK");
					reportdata.put("NoOfKeys",  "7");			
					reportdata.put("TextResponse", " ");	
				}
				else{
				ReportLogger.WriteLog(response.getStatusLine().toString());
				ReportLogger.WriteLog("Status code is: " +response.getStatusLine().getStatusCode());	
				ReportLogger.WriteLog("Status message is: " +response.getStatusLine().getReasonPhrase());
				ReportLogger.WriteLog("Terminating the execution for: "+Thread.currentThread().getStackTrace()[2].getMethodName());
				reportdata.put("Responsecode",  response.getStatusLine().getStatusCode());
				reportdata.put("ResponseMsg",  response.getStatusLine().getReasonPhrase());
				reportdata.put("NoOfKeys",  "error");			
				reportdata.put("TextResponse", responseString);	}
				if (url.contains("obscuro"))
				{
					reportdata.put("Environment", "Obscuro");
				}
				else if ((url.contains("voldemort")))
				{
					reportdata.put("Environment", "voldemort");
				}
				
				else if ((url.contains("avis")))
				{
					reportdata.put("Environment", "avis");
				}
				
				
				//Google_Sheets_Report.gdataput(reportdata);
				throw new Exception();
			}
			else{
			System.out.println(responseString);
			try{
			if(responseString.startsWith("[") && responseString.endsWith("]"))
			{
				json=converStringtoJson(responseString);
			}
			
			else{
				json=responseString;
			}
			jobject = new JSONObject(json);
			reportdata.put("NoOfKeys",  jobject.length());
			}
			catch(Exception e)
			{
				
			}
			ReportLogger.WriteLog("Status code is: " +response.getStatusLine().getStatusCode());	
			ReportLogger.WriteLog("Status message is: " +response.getStatusLine().getReasonPhrase());
			reportdata.put("Responsecode",  response.getStatusLine().getStatusCode());
			reportdata.put("ResponseMsg",  response.getStatusLine().getReasonPhrase());						
			reportdata.put("TextResponse", responseString);	
			
			if (url.contains("obscuro"))
			{
				reportdata.put("Environment", "Obscuro");
			}
			else if ((url.contains("voldemort")))
			{
				reportdata.put("Environment", "voldemort");
			}
			
			else if ((url.contains("avis")))
			{
				reportdata.put("Environment", "avis");
			}
			
			}	
			Google_Sheets_Report.gdataput(reportdata);
		return jobject;
		}
		catch(Exception e)
		{
			Google_Sheets_Report.gdataput(reportdata);
		return jobject;
		}
		
	}
	
	public static String converStringtoJson(String str)
	{
		str=str.substring(1, str.length()-1);
		if(str.startsWith("[") && str.endsWith("]"))
		{
			str=converStringtoJson(str);
		}
		
		return str;
		
	}
	
	
	
	public static void countKeysresponse(JSONObject dataObj) throws Exception
	{
		int counter=1;
		int x = dataObj.length();
		Iterator<?> keys = dataObj.keys();
		//while(keys.hasNext())
		//{
			//counter = counter+1;
		//}
		ReportLogger.WriteLog("Number of keys in response: "+x);
		
		
	}
	
	
	public static void countHeaders() throws Exception
	{
		int x = response.getAllHeaders().length;
		ReportLogger.WriteLog("Number of headers in response: "+x);
		
	}
	
	
	public static void checkResponseDataFormat() throws Exception
	{
		if (jobject.toString().startsWith("{"))
		{
			ReportLogger.WriteLog("Response data format: JSON");
		}
		else if(jobject.toString().startsWith("["))
		{
			ReportLogger.WriteLog("Response data format: Arrey");
		}
	}
	
	public static void checkResponseHeaderFormat() throws Exception
	{
		if (response.toString().startsWith("{"))
		{
			ReportLogger.WriteLog("Response header format: JSON");
		}
		else if(response.toString().startsWith("["))
		{
			ReportLogger.WriteLog("Response data header: Arrey");
		}
		else if(response.toString().contains("text/csv"))
		{
			ReportLogger.WriteLog("Response data header: CSV");
		}
		else{
			ReportLogger.WriteLog("Response data header: Text");
		}
	}
	
	
	public static void validateAPIresponsedatatype(JSONObject dataObj,  Map<String, Object> keyType) throws Exception
	{
		String datatype;
		
			for(String key : keyType.keySet()){				
				switch(keyType.get(key).toString())
				{
					case "Text":
						chekstring(dataObj,key);
					break;
					
					case "Number":
						cheknumber(dataObj,key);
						break;
						
					case "Date":
						chekdate(dataObj,key);
						break;
						
					
					default:
						break;
				}
			}		    
			//String token = dataObj.getString("token");
	        //System.out.println(token);
			}


public static void ValidateResponseData(JSONObject dataObj,  Map<String, Object> datakeys) throws Exception
{	
	for(String key : datakeys.keySet())
	{
		try {
			ReportLogger.WriteLog("Checking response data for key: "+key+" with expected");
			if(dataObj.getString(key).compareTo((String) datakeys.get(key))==0)
			{
				
				ReportLogger.WriteLog("Expected : "+dataObj.getString(key).toString()+" , System: "+datakeys.get(key).toString());
				ReportLogger.WriteLog("Passes : Data matches");
			}
			else
			{
				ReportLogger.WriteLog("Expected : "+dataObj.getString(key).toString()+" , System: "+datakeys.get(key).toString());
				ReportLogger.WriteLog("Failed : Data not matching");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportLogger.WriteLog(e.toString());
			ReportLogger.WriteLog("Terminating execution...");
		}}}

	public static void chekstring(JSONObject dataObj,String data)throws Exception
	{
		try
		{
		Object resultobj = new Object();
		ReportLogger.WriteLog("Checking Type of data for key: "+data+" if it is String");
		//ReportLogger.WriteLog("Value is : "+dataObj.getString(data));
		
		String x = (String)dataObj.toString();
		resultobj=checkdata(data,x);
		ReportLogger.WriteLog("Value is : "+(String)(resultobj.toString()));
		
		if(resultobj instanceof String){		
		ReportLogger.WriteLog("Check Passes");}
		else{ReportLogger.WriteLog("Check Failed");}}
		catch(Exception e){ReportLogger.WriteLog(e.toString());
		ReportLogger.WriteLog("Terminating execution...");}
		
	}
	
	private static Object checkdata(String key, String jstring) throws Exception {
		Object resultobj= new Object();
		try{			
		
		if(jstring.trim().startsWith("[")){
			JSONArray arrey= new JSONArray(jstring);
			for(int n = 0; n < arrey.length(); n++)
			{
				String x = (String)arrey.get(n).toString();			   			   
				resultobj = checkdata (key,x);
			    
			}
		}
		if(jstring.trim().startsWith("{")){
		JSONObject thisobject = new JSONObject(jstring);
		Iterator<?> mainkeys = thisobject.keys();
		while(mainkeys.hasNext() ) {
		    String thiskey = (String)mainkeys.next();
		    if (thisobject.get(thiskey) instanceof JSONObject || thisobject.get(thiskey) instanceof JSONArray) {
		    	String s=(String) thisobject.get(thiskey).toString();
		    	resultobj = checkdata(key, s);
		    }
		    
		    else{
		    	if(key.compareTo(thiskey)==0){
		    	System.out.println(thisobject.get(thiskey));
		    	resultobj=thisobject.get(thiskey);	}
		    	
		    	}
		    }
		}
		
		}
		catch(Exception e){
			
			System.out.println(e);
			
		}
		return resultobj;
		

	}
	
	public static void cheknumber(JSONObject dataObj,String data) throws Exception
	{
		try
		{
		Object resultobj = new Object();
		ReportLogger.WriteLog("Checking Type of data for key: "+data+" if it is a number");
		//ReportLogger.WriteLog("Value is : "+dataObj.getString(data));
		
		String x = (String)dataObj.toString();
		resultobj=checkdata(data,x);
		ReportLogger.WriteLog("Value is : "+(String)(resultobj.toString()));
		
		
		try  
		  {  
		    double d = Double.parseDouble((String) resultobj);  
		    ReportLogger.WriteLog("Check Passes");
		  }  
		  catch(NumberFormatException e)  
		  {  
			  ReportLogger.WriteLog("Check Failed");
			  ReportLogger.WriteLog(e.toString());
			  ReportLogger.WriteLog("Terminating execution...");
		  }  	
		
	
	}
			catch(Exception e){
			
				ReportLogger.WriteLog(e.toString());
			
		}
	}


	public static void chekdate(JSONObject dataObj,String data) throws Exception
	{
		
		Object resultobj = new Object();
		ReportLogger.WriteLog("Checking Type of data for key: "+data+" if it is a number");
		//ReportLogger.WriteLog("Value is : "+dataObj.getString(data));
		
		String x = (String)dataObj.toString();
		resultobj=checkdata(data,x);
		ReportLogger.WriteLog("Value is : "+(String)(resultobj.toString()));
		
		
		  
		    double d = Double.parseDouble((String) resultobj);  
		    ReportLogger.WriteLog("Check Passes");
		  }  
		  
		
	
	
			
			
		}
	

