package org.slevin.tests;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.dao.FaceMatcherPersonDao;
import org.slevin.dao.ItemsDao;
import org.slevin.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;




@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class persistenceTestsAyonix {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Autowired
    OrdersDao orderDao;
	
	@Autowired
	ItemsDao itemDao;
	
	@Autowired
	FaceMatcherPersonDao faceMatcherPersonDao;
	
	
	
	@Test
	@Transactional
	public void testDaoImpl() throws Exception {
		File file = new File("C:\\Users\\ETR00529\\Desktop\\ramazan.png");
		FileInputStream fin = new FileInputStream(file);
		byte fileContent[]= new byte[(int)file.length()];
        fin.read(fileContent);
        fin.close();
		
		
		faceMatcherPersonDao.search(fileContent);
	}
	

	
	
}
