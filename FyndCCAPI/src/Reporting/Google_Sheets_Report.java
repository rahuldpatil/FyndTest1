package Reporting;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Google_Sheets_Report  {
	static GoogleCredential credential = new GoogleCredential();
	static SpreadsheetFeed feed;
	static URL SPREADSHEET_FEED_URL;
	static int srNo=0;
	
	public static void gdataput(Map<String, Object> reportdata) throws Exception
	
	
	{
		SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
		
		File p12 = new File("ProductReliability-25cc23978dce.p12");
		//File p12 = new File("D:\\TempProj\\ProductReliability-25cc23978dce.p12");
		HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        String[] SCOPESArray = {"https://spreadsheets.google.com/feeds", "https://spreadsheets.google.com/feeds/spreadsheets/private/full", "https://docs.google.com/feeds"};
        final List SCOPES = Arrays.asList(SCOPESArray);
        
        credential = new GoogleCredential.Builder()
		        .setTransport(httpTransport)
		        .setJsonFactory(jsonFactory)
		        .setServiceAccountId("product-reliability@appspot.gserviceaccount.com")
		        .setServiceAccountScopes(SCOPES)
		        .setServiceAccountPrivateKeyFromP12File(p12)
		        .build();
        
        SpreadsheetService service = new SpreadsheetService("Test1");
        service.setOAuth2Credentials(credential);
        
        feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
               
        
        List<SpreadsheetEntry> spreadsheets = feed.getEntries();
        if (spreadsheets.size() == 0) {
            System.out.println("No spreadsheets found.");
        }
        //srNo=srNo+1;
        reportdata.put("SrNo",srNo);
        SpreadsheetEntry spreadsheet = null;
        for (int i = 0; i < spreadsheets.size(); i++) {
            if (spreadsheets.get(i).getTitle().getPlainText().startsWith("Api_test_report_v1")) {
                spreadsheet = spreadsheets.get(i);
                System.out.println("Name of editing spreadsheet: " + spreadsheets.get(i).getTitle().getPlainText());
                System.out.println("ID of SpreadSheet: " + i);
                URL worksheetFeedUrl= spreadsheet.getWorksheetFeedUrl ();
                
                
				WorksheetFeed worksheetFeed= service.getFeed(worksheetFeedUrl, WorksheetFeed.class);
				
				List <WorksheetEntry> worksheetEntrys= worksheetFeed.getEntries ();
                WorksheetEntry worksheetEntry= worksheetEntrys.get (0);
                
               
                //This Code block can be used to write titles for each column in sheet
                /*URL cellFeedUrl= worksheetEntry.getCellFeedUrl ();
                CellFeed cellFeed= service.getFeed (cellFeedUrl,CellFeed.class);
                
                CellEntry cellEntry= new CellEntry (1, 1, "HEAD");
                cellFeed.insert (cellEntry);
                cellEntry= new CellEntry (1, 2, "HEADLINE2");
                cellFeed.insert (cellEntry);
                cellEntry= new CellEntry (1, 3, "headline2");
                cellFeed.insert (cellEntry);
                */
                
                URL listFeedUrl = worksheetEntry.getListFeedUrl();
                ListFeed listFeed =service.getFeed(listFeedUrl, ListFeed.class);
                ListEntry row = new ListEntry();
                srNo=(listFeed.getEntries().size())+1;
                reportdata.put("SrNo",srNo);
                reportdata.put("State","Active");
                String value;
                for (String key: reportdata.keySet()){
                	
                	value=(String)reportdata.get(key).toString().trim();
                	
                	if(value.length()>50000)
                	{
                		value=value.substring(0, 50000-2);
                	}
                	
                	row.getCustomElements().setValueLocal((String)key.toString().trim(), value);
                	
               }
                
               // row.getCustomElements().setValueLocal("State", "ok");
                //row.getCustomElements().setValueLocal("HEADLINE2", "Smith2");
               // row.getCustomElements().setValueLocal("headline2", "bhanu2");
                service.insert(listFeedUrl, row);
                
                

            }
        }


	}

}
