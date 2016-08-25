package org.slevin.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class JpegUtil {
	
	public static void main(String[] args) throws Exception {
		File imageFile = new File("C:\\Users\\ETR00529\\Desktop\\ramazan.png");
		cropTest(imageFile);
		
		
//		File croppedFile = new File("C:\\Users\\ETR00529\\Desktop\\ramazan_cropped.jpg");
//		compressFile(croppedFile,"C:\\Users\\ETR00529\\Desktop\\ramazan_cropped_05.jpg",0.5f);
////		
	}
	
	public static void compressFile(File imageFile,String destFile,float quality) throws Exception{
		
		FileInputStream fileInputStream = new FileInputStream(imageFile);
		
		byte[] bFile = new byte[(int) imageFile.length()];

        try {
            //convert file into array of bytes
	 
	    fileInputStream.read(bFile);
	    fileInputStream.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
       byte[] result= compress(bFile,quality);
       
       FileOutputStream fileOuputStream = new FileOutputStream(destFile);
	    fileOuputStream.write(result);
	    fileOuputStream.close();
	    System.out.println("bitti");
	}

	public static void converFromFile(String[] args) throws IOException {

		File imageFile = new File("C:\\Users\\ETR00529\\Desktop\\Lee.jpg");
		File compressedImageFile = new File("C:\\Users\\ETR00529\\Desktop\\Lee_copm.jpg");

		InputStream is = new FileInputStream(imageFile);
		OutputStream os = new FileOutputStream(compressedImageFile);

		float quality = 0.5f;

		// create a BufferedImage as the result of decoding the supplied InputStream
		BufferedImage image = ImageIO.read(is);

		// get all image writers for JPG format
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");

		ImageWriter writer = (ImageWriter) writers.next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		// compress to a given quality
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);

		// appends a complete image stream containing a single image and
	    //associated stream and image metadata and thumbnails to the output
		writer.write(null, new IIOImage(image, null, null), param);

		// close all streams
		is.close();
		os.close();
		ios.close();
		writer.dispose();

		
	}
	public static byte[] compress(byte[] file1,float quality) throws IOException{
		//float quality = 0.5f;

		InputStream in = new ByteArrayInputStream(file1);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		
		// get all image writers for JPG format1
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");

		ImageWriter writer = (ImageWriter) writers.next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		
		
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		// compress to a given quality
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);

		// appends a complete image stream containing a single image and
	    //associated stream and image metadata and thumbnails to the output
		writer.write(null, new IIOImage(bImageFromConvert, null, null), param);
		
		in.close();
		os.close();
		ios.close();
		writer.dispose();
		
		return os.toByteArray();
	}
	
	public static void cropTest(File imageFile) throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream(imageFile);
		
		byte[] bFile = new byte[(int) imageFile.length()];

        try {
            //convert file into array of bytes
	 
	    fileInputStream.read(bFile);
	    fileInputStream.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
       //byte[] result= compress(bFile);
        byte[] bFileCropped = AyonixUtil.cropFace(bFile);
        
        
       FileOutputStream fileOuputStream = new FileOutputStream("C:\\Users\\ETR00529\\Desktop\\ramazan_cropped.png");
	    fileOuputStream.write(bFileCropped);
	    fileOuputStream.close();
	    System.out.println("bitti");
	}

}
