package com.wintechs.chitraguptaapp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class FileUtils {
	
	
	public static final String AARTI = "pv_after_pooja_english";
	public static final String BEFORE_PUJA = "pv_before_pooja_english";
	public static final String DURING_PUJA = "pv_during_pooja_english";
	public static final String AFTER_PUJA = "pv_after_pooja_english";
	public static final String PUJA_ITEMS = "pv_pooja_item_english";
	public static final String AARTI_HINDI = "aarti_hindi";
	public static final String CHALISA1_HINDI = "chalisa1_hindi";
	public static final String CHALISA2_HINDI = "chalisa2_hindi";
	public static final String WANSH1_HINDI = "wansh1_hindi";
	public static final String WANSH2_HINDI = "wansh2_hindi";

	
	
	private FileUtils(){
	}
	
	public static String getAssets(final String fileName, final Context context) throws IOException{
		return getStringFromInputStream(context.getResources().getAssets().open(fileName));
	}
	
	
	   /** 
	    * convert InputStream to String
	    * 
	    * @param InputStream
	    * @return String
	    */
		private static String getStringFromInputStream(InputStream is) {
	 
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				//br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), UTF8),BUFFER_SIZE);
				br = new BufferedReader(new InputStreamReader(is, "utf8"), 8192);
				//br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
	            //System.out.println(stringBuffer);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	 
			return sb.toString();
	 
		}

}
