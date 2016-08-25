package org.slevin.util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import ayonix.AynxFace;
import ayonix.AynxImage;
import ayonix.FaceID;


public class AyonixUtil {

	static String key="d80b29ccc96546b2a333edd5641188b6";
	static String keyTagging = "b8a644dd5dc54109b8832fdef2013a8a";
	static String server="http://ec2-52-29-227-237.eu-central-1.compute.amazonaws.com";
	//static String url ="http://"+"ec2-52-59-37-65.eu-central-1.compute.amazonaws.com"+":8080/ayonix/rest/hello";
	static String url =server+":8080/primefaces-spring-jpa-tutorial/rest/hello";
	
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\ETR00529\\Desktop\\ayoniximage\\Lee_cropped_01.jpg");
		//file = new File("c:\\ayonixsdk\\steve jobs_77.jpg.jpg");
		FileInputStream fin = new FileInputStream(file);
		byte fileContent[]= new byte[(int)file.length()];
        fin.read(fileContent);
        fin.close();
       
        File file2 = new File("C:\\Users\\ETR00529\\Desktop\\ramazan_cropped_05.jpg");
       // file2 = new File("E:\\feretdb\\thumbnails_features_deduped_sample\\thumbnails_features_deduped_sample\\aaron carter\\0.jpg");
		FileInputStream fin2 = new FileInputStream(file2);
		byte fileContent2[]= new byte[(int)file2.length()];
        fin2.read(fileContent2);
        fin2.close();
        
        File file3 = new File("C:\\Users\\ETR00529\\Desktop\\ayoniximage\\ramazan_cropped.png");
        //file3 = new File("E:\\ayonix\\salih\\2130837583-1160422452.jpg");
		FileInputStream fin3 = new FileInputStream(file3);
		byte fileContent3[]= new byte[(int)file3.length()];
        fin3.read(fileContent3);
        fin3.close();
        
        File file4 = new File("C:\\Users\\ETR00529\\Desktop\\ramazan_cropped.jpg");
        //file4 = new File("E:\\ayonix\\salih\\20160728_093253_test.jpg");
		FileInputStream fin4 = new FileInputStream(file4);
		byte fileContent4[]= new byte[(int)file4.length()];
        fin4.read(fileContent4);
        fin4.close();
        
        
//       
//    		
//    		fileContent4 = JpegUtil.compress(fileContent4,0.5f);
//    		fileContent4 = JpegUtil.compress(fileContent4,0.5f);
    		
    	
        
        
        Date date1 = new Date();
        System.out.println("client start="+date1);
//         String result = enroll("ali","aydin",fileContent);
      //String result = search(fileContent4);
       // System.out.println(result);
      compate(fileContent3, fileContent3);
     // compateByStatic(fileContent3, fileContent3);
      //  compateById("3", fileContent);
        Date date2 = new Date();
        System.out.println("client end="+date2);
       // ApiResult a =parseResponse(result);
        
       
        
       // String result=searchPerson(fileContent);
        //String result = deletePerson("10019");
        //System.out.println(result);
	
//        String result = compare(fileContent,fileContent);
//        System.out.println(result);
	
//        String result = compateById("17", fileContent);;
        System.out.println((date2.getTime()-date1.getTime()));
	}
	
	 public static String enroll(String name,String surname ,byte[] data) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder("http://"+server+":8080/ayonix/rest/hello/enroll");
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
	        Date startDate = new Date();
	        try
	        {
	            URIBuilder builder = new URIBuilder(url+"/search");
	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);
        
	            ByteArrayBody fileBody = new ByteArrayBody(data,"aa");
	            fileBody.getContentLength();
	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("image", fileBody)
	                     .build();
	            request.setEntity(reqEntity);
	            
	            
	            Date d1= new Date();
	            System.out.println("request gonderildi : "+d1+" "+(d1.getTime()-startDate.getTime()));
	            HttpResponse response = httpclient.execute(request);
	            Date d2= new Date();
	            System.out.println("response geldi : "+d2+" "+"sure:="+(d2.getTime()-d1.getTime()));
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
	
	 
	 public static String search2(byte[] data) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder(url+"/searchByParalel");
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
//               String result = (String)obj.get("result");	
//               if(result.equals("OK")){
//               	String userId = (String)obj.get("userid");
//               	return userId;
//               }else
//               	throw new Exception();
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }
	
	 
	 
	 
	 
	 
	 
	 public static String compate(byte[] _data1,byte[] _data2) throws Exception
	    {
		 Date startDate=new Date();
	        HttpClient httpclient = HttpClients.createDefault();
	        byte[] data1=_data1;
	        byte[] data2=_data2;
	        try
	        {
	        	
	        	
	        	
	          URIBuilder builder = new URIBuilder("http://ec2-52-29-227-237.eu-central-1.compute.amazonaws.com:8080/primefaces-spring-jpa-tutorial/rest/hello/compare");
	          //  URIBuilder builder = new URIBuilder("http://ec2-52-59-37-65.eu-central-1.compute.amazonaws.com:8080/primefaces-spring-jpa-tutorial/rest/hello/compare");
	            									// https://api.projectoxford.ai/vision/v1.0/analyze?visualFeatures=Categories
	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);
	            ByteArrayBody fileBody1 = new ByteArrayBody(data1,"aa");
	            ByteArrayBody fileBody2 = new ByteArrayBody(data2,"aabb");
	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("image1", fileBody1)
	                    .addPart("image2", fileBody2)
	                    .build();

	            request.setEntity(reqEntity);
	            
	            Date d1= new Date();
	            System.out.println("request gonderildi : "+d1+" "+(d1.getTime()-startDate.getTime()));
	            HttpResponse response = httpclient.execute(request);
	            Date d2= new Date();
	            System.out.println("response geldi : "+d2+" "+"sure:="+(d2.getTime()-d1.getTime()));
	           
	            HttpEntity entity = response.getEntity();
int statusCode = response.getStatusLine().getStatusCode();
//	          System.out.println(statusCode); 
	          
Date d3= new Date();
	          if (entity != null) 
	            {
	            	String aa=EntityUtils.toString(entity);
	            	System.out.println(aa);
//	            	System.out.println(d3.getTime()-d2.getTime());
	            	Date endDate = new Date();
	            	System.out.println("toplam method süresi="+(endDate.getTime()-startDate.getTime()));
	            	return "";
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }

	 public static String compateByStatic(byte[] data1,byte[] data2) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder("http://ec2-52-29-227-237.eu-central-1.compute.amazonaws.com:8080/primefaces-spring-jpa-tutorial/rest/hello/compareByStatic");
	           // URIBuilder builder = new URIBuilder("http://ec2-52-59-37-65.eu-central-1.compute.amazonaws.com:8080/ayonix/rest/hello/compare");
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
	            
	            Date d1= new Date();
	            HttpResponse response = httpclient.execute(request);
	            Date d2= new Date();
	            System.out.println("sure:="+(d2.getTime()-d1.getTime())); 
	            HttpEntity entity = response.getEntity();
int statusCode = response.getStatusLine().getStatusCode();
	          System.out.println(statusCode); 
	          
	          if (entity != null) 
	            {
	            	String aa=EntityUtils.toString(entity);
	            	System.out.println(aa);
//	            	JSONParser parser = new JSONParser();
//	       		 	JSONObject obj = (JSONObject)parser.parse(aa);
//               String result = (String)obj.get("result");	
//               if(result.equals("OK")){
//               	String userId = (String)obj.get("userid");
//               	return userId;
//               }else
//               	throw new Exception();
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }

	 
	 public static String compateById(String id,byte[] data2) throws Exception
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	          //  URIBuilder builder = new URIBuilder("http://localhost:8080/primefaces-spring-jpa-tutorial/rest/hello/comparebyid");
	            URIBuilder builder = new URIBuilder("http://ec2-52-29-227-237.eu-central-1.compute.amazonaws.com:8080/primefaces-spring-jpa-tutorial/rest/hello/comparebyid");
	            

	            
	            
	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);

	            ByteArrayBody fileBody2 = new ByteArrayBody(data2,"aabb");
                StringBody idBody = new StringBody(id,ContentType.TEXT_PLAIN);
	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("id", idBody)
	                    .addPart("image2", fileBody2)
	                    .build();
	            request.setEntity(reqEntity);
	            
	            
	            Date d1= new Date();
	            HttpResponse response = httpclient.execute(request);
	            Date d2= new Date();
	            System.out.println("sure:="+(d2.getTime()-d1.getTime()));
	           HttpEntity entity = response.getEntity();
	           int statusCode = response.getStatusLine().getStatusCode();
	          System.out.println(statusCode); 
	          
	          if (entity != null) 
	            {
	            	String aa=EntityUtils.toString(entity);
	            	System.out.println(aa);
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return "";
	    }

	 public static byte[] cropFace(byte[] image) throws IOException{
		 System.out.println("original size = "+image.length);
		 FaceID sdk = new FaceID("C:\\Program Files (x86)\\Ayonix\\FaceID\\data\\engine");
	        
         int[] version = sdk.GetVersion();
         System.out.format("Engine version: %d.%d.%d.%d%n", version[0], version[1], version[2], version[3]);
         
         int nthreads = (int)sdk.GetParam(FaceID.PARAM_NTHREADS);
         System.out.println("NThreads: " + nthreads);
         
         AynxImage img = sdk.LoadImage(image);
         System.out.format("Img: %dx%d, %s image%n", img.getWidth(), img.getHeight(), img.isColor() ? "color" : "gray");
         
         AynxFace[] faces = sdk.DetectFaces(img);
         System.out.println("Number of faces: " + faces.length);
         
         sdk.PreprocessFace(faces[0]);
         
         Rectangle location =faces[0].getLocation();
         
         InputStream in = new ByteArrayInputStream(image);
         BufferedImage bImageFromConvert = ImageIO.read(in);
         
         BufferedImage croppedImage=bImageFromConvert.getSubimage(((int)location.getX()), ((int)location.getY()), ((int)location.getWidth()), ((int)location.getHeight()));
         
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ImageIO.write( croppedImage, "jpg", baos );
         baos.flush();
         byte[] imageInByte = baos.toByteArray();
         baos.close();
         
         System.out.println("cropped size = "+imageInByte.length);
         return imageInByte;
         
	 }
	 
}
