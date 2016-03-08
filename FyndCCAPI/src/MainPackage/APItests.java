package MainPackage;

import org.json.JSONObject;

import Reporting.Google_Sheets_Report;

public class APItests extends CommonActions {
	
	
	public static JSONObject essentialHeaders ;
	public static void saperator()
	{
		ReportLogger.WriteLog("*************************************************************************");
	}
	//Validate Login and response data
	public static void LoginAPICase1()
	{ try { saperator();
		APIdata.loginAPIdata();
		jobject =execute("http://obscuro-staging.gofynd.com/api/login","POST",APIdata.headers, APIdata.keyval);
		essentialHeaders=jobject;
		countKeysresponse(jobject);
		countHeaders();
		checkResponseDataFormat();
		checkResponseHeaderFormat();
		Google_Sheets_Report.gdataput(reportdata);
		
		//validateAPIresponsedatatype(jobject,APIdata.responseDtype);
		//ValidateResponseData(jobject,APIdata.responseData); 
		saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator(); 
		System.exit(0);
		}
					
	}
	
	public static void DiscountsAPICase1()
	{
		//Positive flow where all data is correct
		try{
		saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/discounts/?page_no=1&page_size=9","GET",APIdata.discountsAPIdata().get(0), APIdata.discountsAPIdata().get(1));
		countKeysresponse(jobject);
		//System.out.println(jobject);
		//validateAPIresponsedatatype(jobject,APIdata.responseDtype);
		//ValidateResponseData(jobject,APIdata.responseData);
		countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		
		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
	}
	
	public static void DiscountsAPICase2()
	{ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/discounts/?page_no=1&page_size=9","GET",APIdata.discountsAPIdata().get(0), APIdata.discountsAPIdata().get(1));
		countKeysresponse(jobject);
		//validateAPIresponsedatatype(jobject,APIdata.responseDtype);
		//ValidateResponseData(jobject,APIdata.responseData);
		countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
	}
	
	public static void editDiscountsAPICase1()
	{ 
		try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/edit-discount/","POST",APIdata.editDiscountsAPIdata().get(0), APIdata.editDiscountsAPIdata().get(1));
		countKeysresponse(jobject);
		countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat();
		//validateAPIresponsedatatype(jobject,APIdata.responseDtype);
		//ValidateResponseData(jobject,APIdata.responseData); 
		saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
	}
	
	public static void StoreListByBrand1()
	{ 
		try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/store-list-by-brand?brand_id=11","GET",APIdata.StoreListByBrandAPIdata().get(0), APIdata.StoreListByBrandAPIdata().get(1));
		countKeysresponse(jobject);
		countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat();
		//validateAPIresponsedatatype(jobject,APIdata.responseDtype);
		//ValidateResponseData(jobject,APIdata.responseData); 
		saperator();} 		
		catch (Exception e)
		{		
			ReportLogger.WriteLog(e.toString());  

			ReportLogger.WriteLog("Terminating execution..."); saperator();
			}
		}
	
	public static void edit_discount_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/edit-discount/","POST",APIdata.edit_discount_1_data().get(0),APIdata.edit_discount_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void avis_Login_1 (){ try { saperator();
		jobject =execute("http://{{avis_url}}/login?type=store","POST",APIdata.avis_Login_1_data().get(0),APIdata.avis_Login_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void get_category_hierarchy_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/get-category-hierarchy","POST",APIdata.get_category_hierarchy_1_data().get(0),APIdata.get_category_hierarchy_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void upload_brand_images_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/upload-brand-images","POST",APIdata.upload_brand_images_1_data().get(0),APIdata.upload_brand_images_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void orders_1 (){ try { saperator();
		jobject =execute("http://voldemort.gofynd.com/avis/api/v1/oms/orders/","POST",APIdata.orders_1_data().get(0),APIdata.orders_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void fyndr_1 (){ try { saperator();
		jobject =execute("http://voldemort.gofynd.com/avis/api/v1/oms/fyndr/?fyndr_id=FYND00023","GET",APIdata.fyndr_1_data().get(0),APIdata.fyndr_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void get_collection_items_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/get-collection-items?items_list=[3109,3110,3111,3112,3113,3114,3115,3116,3119,3121,3122,3123]&collection_id=63","GET",APIdata.get_collection_items_1_data().get(0),APIdata.get_collection_items_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void search_items_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/search-items?category_id=1&collection_id=63&gender=men&gender=women&page_no=1&page_size=12","GET",APIdata.search_items_1_data().get(0),APIdata.search_items_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void store_list_by_brand_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/store-list-by-brand?brand_id=11","GET",APIdata.store_list_by_brand_1_data().get(0),APIdata.store_list_by_brand_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void get_next_item_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/get-next-item","POST",APIdata.get_next_item_1_data().get(0),APIdata.get_next_item_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void offers_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/offers/?page_no=1&page_size=9","GET",APIdata.offers_1_data().get(0),APIdata.offers_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void get_companies_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/get-companies","GET",APIdata.get_companies_1_data().get(0),APIdata.get_companies_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void login_1 (){ try { saperator();
		jobject =execute("http://obscuro-staging.gofynd.com/api/login","POST",APIdata.login_1_data().get(0),APIdata.login_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}
	public static void fyndr_geography_1 (){ try { saperator();
		jobject =execute("http://voldemort.gofynd.com/avis/api/v1/oms/fyndr-geography/","POST",APIdata.fyndr_geography_1_data().get(0),APIdata.fyndr_geography_1_data().get(1));countKeysresponse(jobject);
		  countHeaders(); checkResponseDataFormat(); checkResponseHeaderFormat(); saperator();} 		catch (Exception e){		ReportLogger.WriteLog(e.toString());  ReportLogger.WriteLog("Terminating execution..."); saperator();}
		}


	
	
	
	//new
	
	public static void edit_discount()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/edit-discount/","POST",APIdata.edit_discount_data().get(0),APIdata.edit_discount_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void avis_login()
	{ 
	  try { saperator();jobject =execute("http://{{avis_url}}/login?type=store","POST",APIdata.avis_login_data().get(0),APIdata.avis_login_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_category_hierarchy()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-category-hierarchy","POST",APIdata.get_category_hierarchy_data().get(0),APIdata.get_category_hierarchy_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void upload_brand_images()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/upload-brand-images","POST",APIdata.upload_brand_images_data().get(0),APIdata.upload_brand_images_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void orders()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/orders/?order_type=buy&state=current","POST",APIdata.orders_data().get(0),APIdata.orders_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void fyndr()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/fyndr/?fyndr_id=FYND00023","GET",APIdata.fyndr_data().get(0),APIdata.fyndr_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_collection_items()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-collection-items?items_list=[3109,3110,3111,3112,3113,3114,3115,3116,3119,3121,3122,3123]&collection_id=63","GET",APIdata.get_collection_items_data().get(0),APIdata.get_collection_items_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void search_items()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/search-items?category_id=1&collection_id=63&gender=men&gender=women&page_no=1&page_size=12","GET",APIdata.search_items_data().get(0),APIdata.search_items_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void store_list_by_brand()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/store-list-by-brand?brand_id=11","GET",APIdata.store_list_by_brand_data().get(0),APIdata.store_list_by_brand_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_next_item()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-next-item","POST",APIdata.get_next_item_data().get(0),APIdata.get_next_item_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void offers()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/offers/?page_no=1&page_size=9","GET",APIdata.offers_data().get(0),APIdata.offers_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_companies()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-companies","GET",APIdata.get_companies_data().get(0),APIdata.get_companies_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void login()
	{ 
	  try { saperator();
	  
	  APIdata.loginAPIdata();
		jobject =execute("http://obscuro-staging.gofynd.com/api/login","POST",APIdata.headers, APIdata.keyval);
		essentialHeaders=jobject;
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void fyndr_geography()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/fyndr-geography/?city_id=1","POST",APIdata.fyndr_geography_data().get(0),APIdata.fyndr_geography_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	
	public static void fyndr_city()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/fyndr-city/","GET",APIdata.fyndr_city_data().get(0),APIdata.fyndr_city_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	
	
	public static void fyndr_mobile()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/fyndr-mobiles/","POST",APIdata.fyndr_city_data().get(0),APIdata.fyndr_city_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	
	public static void store_statistics()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/store-statistics/","GET",APIdata.store_statistics_data().get(0),APIdata.store_statistics_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_items_list_grid()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-items-list-grid?fields=id,name,images,color,code,attributes,share_key&page_no=1&page_size=10","GET",APIdata.get_items_list_grid_data().get(0),APIdata.get_items_list_grid_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void add_store()
	{ 
	  try { saperator();
	  jobject =execute("http://obscuro-staging.gofynd.com/api/add-store","POST",APIdata.add_store_data().get(0),APIdata.add_store_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_brand_category_subcategory()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-brand-category-subcategory","GET",APIdata.get_brand_category_subcategory_data().get(0),APIdata.get_brand_category_subcategory_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void update_all_brands_priority()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/update-all-brands-priority/","POST",APIdata.update_all_brands_priority_data().get(0),APIdata.update_all_brands_priority_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void edit_brand()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/edit-brand","POST",APIdata.edit_brand_data().get(0),APIdata.edit_brand_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	/*public static void fyndr_geography()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/add-collection","POST",APIdata.fyndr_geography_data().get(0),APIdata.fyndr_geography_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}*/
	public static void add_collection()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-collections?page_no=1&page_size=10","GET",APIdata.add_collection_data().get(0),APIdata.add_collection_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_collections()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-collections?page_no=1&page_size=10","GET",APIdata.get_collections_data().get(0),APIdata.get_collections_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void update_item()
	{ 
	  try { saperator();
	  jobject =execute("http://obscuro-staging.gofynd.com/api/update-item","POST",APIdata.update_item_data().get(0),APIdata.update_item_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void fyndr_attendance()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/oms/fyndr-attendance/?date=2016-02-04T06:47:23.685Z&fyndr_id=FYND00023","GET",APIdata.fyndr_attendance_data().get(0),APIdata.fyndr_attendance_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void add_item_to_collection()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/add-item-to-collection/","POST",APIdata.add_item_to_collection_data().get(0),APIdata.add_item_to_collection_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	
	public static void fyndr_list()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/fyndr/?clusterId=&shoppingareaId=","GET",APIdata.fyndr_list_data().get(0),APIdata.fyndr_list_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	
	public static void fyndr_details()
	{ 
	  try { saperator();jobject =execute("http://voldemort.gofynd.com/avis/api/v1/fyndr/fyndr/?fyndr_id=FYND00023","GET",APIdata.fyndr_details_data().get(0),APIdata.fyndr_details_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void unpublish_collection()
	{ 
	  try { saperator();
	  jobject =execute("http://obscuro-staging.gofynd.com/api/unpublish-collection/","POST",APIdata.unpublish_collection_data().get(0),APIdata.unpublish_collection_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void discounts()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/discounts/?page_no=1&page_size=9","GET",APIdata.discounts_data().get(0),APIdata.discounts_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void quarantine_item()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/quarantine-item","POST",APIdata.quarantine_item_data().get(0),APIdata.quarantine_item_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void edit_store()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-filters","GET",APIdata.edit_store_data().get(0),APIdata.edit_store_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void edit_collection()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/edit-collection","POST",APIdata.edit_collection_data().get(0),APIdata.edit_collection_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void add_brand()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/add-brand","POST",APIdata.add_brand_data().get(0),APIdata.add_brand_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void rules()
	{ 
	  try { saperator();jobject =execute("http://interfaces-playground.gofynd.com/interfaces/api/v1/rules/meta","GET",APIdata.rules_data().get(0),APIdata.rules_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_value_by_filter()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-value-by-filter","POST",APIdata.get_value_by_filter_data().get(0),APIdata.get_value_by_filter_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_verification_statistics()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-verification-statistics","GET",APIdata.get_verification_statistics_data().get(0),APIdata.get_verification_statistics_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void help()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/help/","POST",APIdata.help_data().get(0),APIdata.help_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void edit_company()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/edit-company","POST",APIdata.edit_company_data().get(0),APIdata.edit_company_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void update_brand_status()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/update-brand-status/","POST",APIdata.update_brand_status_data().get(0),APIdata.update_brand_status_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_image_requirements()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-image-requirements","POST",APIdata.get_image_requirements_data().get(0),APIdata.get_image_requirements_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void get_activity_logs()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/get-activity-logs","GET",APIdata.get_activity_logs_data().get(0),APIdata.get_activity_logs_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void edit_offer()
	{ 
	  try { saperator();
	  jobject =execute("http://obscuro-staging.gofynd.com/api/edit-offer/","POST",APIdata.edit_offer_data().get(0),APIdata.edit_offer_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void bulk_download_items()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/bulk-download-items","POST",APIdata.bulk_download_items_data().get(0),APIdata.bulk_download_items_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void publish_collection()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/publish-collection/","POST",APIdata.publish_collection_data().get(0),APIdata.publish_collection_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void add_item_pull_to_refresh()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/add-item-pull-to-refresh","POST",APIdata.add_item_pull_to_refresh_data().get(0),APIdata.add_item_pull_to_refresh_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}
	public static void update_item_pull_to_refresh()
	{ 
	  try { saperator();jobject =execute("http://obscuro-staging.gofynd.com/api/update-item-pull-to-refresh","POST",APIdata.update_item_pull_to_refresh_data().get(0),APIdata.update_item_pull_to_refresh_data().get(1));
	countKeysresponse(jobject);
	  countHeaders();
	checkResponseDataFormat(); 
	checkResponseHeaderFormat();
	saperator();}   
	catch (Exception e)
	{  
	ReportLogger.WriteLog(e.toString()); 
	 ReportLogger.WriteLog("Terminating execution..."); saperator();
	   }
	}

	
	}


