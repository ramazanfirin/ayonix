package org.slevin.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class AyonixUtil {

	static String key="d80b29ccc96546b2a333edd5641188b6";
	static String keyTagging = "b8a644dd5dc54109b8832fdef2013a8a";
	
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\ETR00529\\Desktop\\aliaydin.jpg");
		FileInputStream fin = new FileInputStream(file);
		byte fileContent[]= new byte[(int)file.length()];
        fin.read(fileContent);
        fin.close();
       
        File file2 = new File("C:\\Users\\ETR00529\\Desktop\\erhan.PNG");
		FileInputStream fin2 = new FileInputStream(file2);
		byte fileContent2[]= new byte[(int)file2.length()];
        fin2.read(fileContent2);
        fin2.close();
        
        
        
        // String result = enroll("ali","aydin",fileContent);
        //String result = search(fileContent);
       // ApiResult a =parseResponse(result);
        
        compate(fileContent, fileContent);
        
       // String result=searchPerson(fileContent);
        //String result = deletePerson("10019");
        //System.out.println(result);
	
       // String result = compare(fileContent,fileContent);
       // System.out.println(result);
	}
	
	 public static String enroll(String name,String surname ,byte[] data) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder("http://localhost:8080/primefaces-spring-jpa-tutorial/rest/hello/enroll");
	            									// https://api.projectoxford.ai/vision/v1.0/analyze?visualFeatures=Categories

	            //builder.setParameter("visualFeatures", "All");
	            //builder.setParameter("faceRectangles", "{string}");

	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);
	            
//	            request.setHeader("Content-Type", "application/octet-stream");
//	            request.setHeader("Ocp-Apim-Subscription-Key", keyTagging);


	            // Request body
	            
	            
	           // StringEntity reqEntity = new StringEntity("{body}");
	            
//	            File file = new File(path);
//	            FileInputStream fin = new FileInputStream(file);byte fileContent[]
//	             = new byte[(int)file.length()];
//	            fin.read(fileContent);
//	            fin.close();
	            
	            ByteArrayBody fileBody = new ByteArrayBody(data,"aa");
	            fileBody.getContentLength();
	            
//	            StringBody function = new StringBody("enrollperson",ContentType.TEXT_PLAIN);
//	            StringBody appid = new StringBody("3926BEDE-5E64-0F45-89B7-76504845DDC9",ContentType.TEXT_PLAIN);
//	            StringBody format = new StringBody("json",ContentType.TEXT_PLAIN);
//	            StringBody action = new StringBody("call",ContentType.TEXT_PLAIN);
//	            StringBody nameBody = new StringBody(name,ContentType.TEXT_PLAIN);
	            StringBody nameBody = new StringBody(name,ContentType.TEXT_PLAIN);
	            StringBody surnameBody = new StringBody(surname,ContentType.TEXT_PLAIN);
	            StringBody fileNameBody = new StringBody(name+"_"+surname,ContentType.TEXT_PLAIN);

	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("image", fileBody)
	                    .addPart("name", surnameBody)
	                    .addPart("surname", nameBody)
	                    .addPart("filename", fileNameBody)
	                    .build();

	            
	            
	            
//	            ByteArrayEntity reqEntity = new ByteArrayEntity(data);
//	            request.setEntity(reqEntity);
//	           
	            request.setEntity(reqEntity);
	            
	            
	            HttpResponse response = httpclient.execute(request);
	          //  HttpEntity entity = response.getEntity();
int statusCode = response.getStatusLine().getStatusCode();
	          System.out.println(statusCode); 
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }
	

	 
	 
	 
	 
	 
	 public static String search(byte[] data) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder("http://localhost:8080/primefaces-spring-jpa-tutorial/rest/hello/search");
	            									// https://api.projectoxford.ai/vision/v1.0/analyze?visualFeatures=Categories

	            //builder.setParameter("visualFeatures", "All");
	            //builder.setParameter("faceRectangles", "{string}");

	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);
	            
//	            request.setHeader("Content-Type", "application/octet-stream");
//	            request.setHeader("Ocp-Apim-Subscription-Key", keyTagging);


	            // Request body
	            
	            
	           // StringEntity reqEntity = new StringEntity("{body}");
	            
//	            File file = new File(path);
//	            FileInputStream fin = new FileInputStream(file);byte fileContent[]
//	             = new byte[(int)file.length()];
//	            fin.read(fileContent);
//	            fin.close();
	            
	            ByteArrayBody fileBody = new ByteArrayBody(data,"aa");
	            fileBody.getContentLength();
	            
//	            StringBody function = new StringBody("enrollperson",ContentType.TEXT_PLAIN);
//	            StringBody appid = new StringBody("3926BEDE-5E64-0F45-89B7-76504845DDC9",ContentType.TEXT_PLAIN);
//	            StringBody format = new StringBody("json",ContentType.TEXT_PLAIN);
//	            StringBody action = new StringBody("call",ContentType.TEXT_PLAIN);
//	            StringBody nameBody = new StringBody(name,ContentType.TEXT_PLAIN);
	           

	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("image", fileBody)
	                   
	                    .build();

	            
	            
	            
//	            ByteArrayEntity reqEntity = new ByteArrayEntity(data);
//	            request.setEntity(reqEntity);
//	           
	            request.setEntity(reqEntity);
	            
	            
	            HttpResponse response = httpclient.execute(request);
	           HttpEntity entity = response.getEntity();
int statusCode = response.getStatusLine().getStatusCode();
	          System.out.println(statusCode); 
	          
	          if (entity != null) 
	            {
	            	String aa=EntityUtils.toString(entity);
	            	System.out.println(aa);
//	            	JSONParser parser = new JSONParser();
//	       		 	JSONObject obj = (JSONObject)parser.parse(aa);
//                  String result = (String)obj.get("result");	
//                  if(result.equals("OK")){
//                  	String userId = (String)obj.get("userid");
//                  	return userId;
//                  }else
//                  	throw new Exception();
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }
	
	 
	 
	 
	 
	 
	 public static String compate(byte[] data1,byte[] data2) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder("http://localhost:8080/primefaces-spring-jpa-tutorial/rest/hello/compare");
	            									// https://api.projectoxford.ai/vision/v1.0/analyze?visualFeatures=Categories

	            //builder.setParameter("visualFeatures", "All");
	            //builder.setParameter("faceRectangles", "{string}");

	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);
	            
//	            request.setHeader("Content-Type", "application/octet-stream");
//	            request.setHeader("Ocp-Apim-Subscription-Key", keyTagging);


	            // Request body
	            
	            
	           // StringEntity reqEntity = new StringEntity("{body}");
	            
//	            File file = new File(path);
//	            FileInputStream fin = new FileInputStream(file);byte fileContent[]
//	             = new byte[(int)file.length()];
//	            fin.read(fileContent);
//	            fin.close();
	            
	            ByteArrayBody fileBody1 = new ByteArrayBody(data1,"aa");
	            ByteArrayBody fileBody2 = new ByteArrayBody(data2,"aabb");
	            //fileBody.getContentLength();
	            
//	            StringBody function = new StringBody("enrollperson",ContentType.TEXT_PLAIN);
//	            StringBody appid = new StringBody("3926BEDE-5E64-0F45-89B7-76504845DDC9",ContentType.TEXT_PLAIN);
//	            StringBody format = new StringBody("json",ContentType.TEXT_PLAIN);
//	            StringBody action = new StringBody("call",ContentType.TEXT_PLAIN);
//	            StringBody nameBody = new StringBody(name,ContentType.TEXT_PLAIN);
	           

	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("image1", fileBody1)
	                    .addPart("image2", fileBody2)
	                    .build();

	            
	            
	            
//	            ByteArrayEntity reqEntity = new ByteArrayEntity(data);
//	            request.setEntity(reqEntity);
//	           
	            request.setEntity(reqEntity);
	            
	            
	            HttpResponse response = httpclient.execute(request);
	           HttpEntity entity = response.getEntity();
int statusCode = response.getStatusLine().getStatusCode();
	          System.out.println(statusCode); 
	          
	          if (entity != null) 
	            {
	            	String aa=EntityUtils.toString(entity);
	            	System.out.println(aa);
//	            	JSONParser parser = new JSONParser();
//	       		 	JSONObject obj = (JSONObject)parser.parse(aa);
//                  String result = (String)obj.get("result");	
//                  if(result.equals("OK")){
//                  	String userId = (String)obj.get("userid");
//                  	return userId;
//                  }else
//                  	throw new Exception();
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }

	 
	 
	 
}
