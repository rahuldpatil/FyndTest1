package MainPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


class MyFormatter extends Formatter {
	
	
	    //
	    // Create a DateFormat to format the logger timestamp.
	    //
	    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

	    public String format(LogRecord record) {
	        StringBuilder builder = new StringBuilder(1000);
	        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
	        //builder.append("[").append(record.getSourceClassName()).append(".");
	        //builder.append(record.getSourceMethodName()).append("] - ");
	        builder.append("[").append(record.getLevel()).append("] - ");
	        builder.append(formatMessage(record));
	        builder.append("\n");
	        return builder.toString();
	    }

	    public String getHead(Handler h) {
	        return super.getHead(h);
	    }

	    public String getTail(Handler h) {
	        return super.getTail(h);
	    }
	}



	public class ReportLogger {
		
		public static Logger logger;  
		public static FileHandler fh;
		
		public static void GenerateLogs()
		{
			try
			{
			logger = Logger.getLogger("FyndCC"); 
		    // This block configure the logger with handler and formatter 
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyyHH-mm-ss");
			 //get current date time with Date()
			Date date = new Date();
			String filename = date.toString();
			filename = filename.replace(":","-");
			String filepath = "AutomationLogs\\"+"API"+filename+".log";
			//String filepath = "D:\\Automation Logs\\"+"API"+filename+".log";
	    	fh = new FileHandler(filepath.trim());  
	        logger.addHandler(fh);
	        MyFormatter formatter = new MyFormatter();  
	        fh.setFormatter(formatter);  
	        // the following statement is used to log any messages  
	        //logger.info("My first log");  
	        //logger.info("Hi How r u?");  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}


	}
		
		public static void WriteLog(String msg)
		{
			logger.info(msg);
		}
		
		public static void Close_logs()
		{
			fh.close();
			
		}
		

	}


