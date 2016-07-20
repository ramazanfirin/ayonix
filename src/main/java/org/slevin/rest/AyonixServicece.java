package org.slevin.rest;
 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slevin.dao.FaceMatcherPersonDao;
import org.slevin.rest.dto.SearchDTO;
import org.slevin.util.SearchResultDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.jersey.multipart.FormDataParam;
 
@Path("/hello")
public class AyonixServicece {
 
	@Context
	private ServletContext context=null; 
	
	@GET
	@Path("/test/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	
	@POST
	@Path("/enroll") 
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("name") String name,
							   @FormDataParam("surname") String surname,
							   @FormDataParam("image") InputStream is,	
							   @FormDataParam("filename") String fileName) {
 
		
 
		try {
			ServletContext  servletContext =(ServletContext) context;
	    	BeanFactory context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			FaceMatcherPersonDao faceMatcherPersonService= (FaceMatcherPersonDao)context.getBean("faceMatcherPersonService");
	    	
			
			byte[] bytes = getBytes(is);
			int a = bytes.length;
			faceMatcherPersonService.enroll(name, surname, bytes, fileName);
			
			String result = "Successfully File Uploaded on the path ";
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			
		}
 
		
 
	}
	
	@POST
	@Path("/search") 
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchDTO search(@FormDataParam("image") InputStream is) {
 
		
 
		try {
			ServletContext  servletContext =(ServletContext) context;
	    	BeanFactory context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			FaceMatcherPersonDao faceMatcherPersonService= (FaceMatcherPersonDao)context.getBean("faceMatcherPersonService");
	    	
			
			byte[] bytes = getBytes(is);
			SearchResultDTO resultDto= faceMatcherPersonService.search(bytes);
			SearchDTO searchDTO = new SearchDTO();
			searchDTO.setId(resultDto.getPerson().getId());
			searchDTO.setName(resultDto.getPerson().getName());
			searchDTO.setScore(String.valueOf(resultDto.getScore()));
			
			
			return searchDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
 
		
 
	}
	
	
	@POST
	@Path("/compare") 
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchDTO compare(@FormDataParam("image1") InputStream is1,
							 @FormDataParam("image2") InputStream is2) {
 
		
 
		try {
			ServletContext  servletContext =(ServletContext) context;
	    	BeanFactory context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			FaceMatcherPersonDao faceMatcherPersonService= (FaceMatcherPersonDao)context.getBean("faceMatcherPersonService");
	    	
			
			byte[] bytes1 = getBytes(is1);
			byte[] bytes2 = getBytes(is2);
			
			SearchResultDTO resultDto= faceMatcherPersonService.compare(bytes1, bytes2);
			SearchDTO searchDTO = new SearchDTO();
//			searchDTO.setId(resultDto.getPerson().getId());
//			searchDTO.setName(resultDto.getPerson().getName());
			searchDTO.setScore(String.valueOf(resultDto.getScore()));
			
			
			return searchDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
 
		
 
	}
	
	public byte[] getBytes(InputStream is) throws IOException{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}

		buffer.flush();

		return buffer.toByteArray();
	}
 
}