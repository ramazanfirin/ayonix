package org.slevin.util;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import org.slevin.rest.dto.SearchDTO;

import ayonix.FaceID;
 
public class ForkAyonix extends RecursiveTask<ForkDto> {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private static final int SEQUENTIAL_THRESHOLD = 100;
 
  //private final int[] data;
  private final int start;
  private final int end;
  
  byte[] query=null;
  
  Vector<byte[]> afidList ;
  
  float[] scores ;
  int[] indexes ;
  FaceID sdk;
 
  public ForkAyonix(FaceID _sdk,byte[] _query,Vector<byte[]> _afidList,int _start,int _end) {
	  afidList = _afidList;
	  query = _query;
	  start = _start;
	  end = _end;
  
	  scores = new float[afidList.size()];
      indexes = new int[afidList.size()];
      
      sdk=_sdk;
  }
 
  
 
  @Override
  protected ForkDto compute() {
    final int length = end - start;
    if (length < SEQUENTIAL_THRESHOLD) {
      return computeDirectly();
    }
    final int split = length / 2;
    final ForkAyonix left = new ForkAyonix(sdk,query,afidList, start, start + split);
    left.fork();
    final ForkAyonix right = new ForkAyonix(sdk,query,afidList, start + split, end);
    ForkDto dto1 = right.compute();
    ForkDto dto2 =  left.join();
    if(dto1.getScore()>=dto2.getScore())
    	return dto1;
    else
    	return dto2;

  }
 
  private ForkDto computeDirectly() {
	   System.out.println(Thread.currentThread() + " computing: " + start                       + " to " + end);
	   sdk.MatchAfids(query, afidList, scores, indexes); 
	   int index = Util.sort(scores);
	   float score  = scores[index];
	   byte[] a = afidList.get(index);
   
	   ForkDto dto = new ForkDto();
	   dto.setAfid(a);
	   dto.setScore(score);
	   
	   return dto;
  }
 
  public static void main(String[] args) {
    // create a random data set
    final int[] data = new int[1000];
    final Random random = new Random();
    for (int i = 0; i < data.length; i++) {
      data[i] = random.nextInt(100);
    }
 
    // submit the task to the pool
//    final ForkJoinPool pool = new ForkJoinPool(4);
//    final ForkAyonix finder = new ForkAyonix(data);
//    System.out.println(pool.invoke(finder));
  }
}
