package org.spring.springboot.base.init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.base.support.ApplicationContextSpring;
import org.spring.springboot.domain.Account;
import org.spring.springboot.repository.AccountRepository;
import org.spring.springboot.util.ObjectHelper;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class InitResource {

	Logger logger = LoggerFactory.getLogger(InitResource.class);
	
	AccountRepository accountRepository = ApplicationContextSpring.getBean("accountRepository");
	
	private static InitResource instance = null;
	
	private InitResource(){
		Account acct = accountRepository.findByName("admin");
		if(acct!=null && ObjectHelper.isNotEmpty(acct.getId())){
		}else{
			logger.info(" initResourceConfig loadding... ");
			try {
				String initSql = readFileByLines(System.getProperty("user.dir")+"/src/main/resources/init/initSql.sql");
				String[] initSqls = initSql.split(";");
				if(initSqls.length==0){
					throw new Exception("sql is null");
				}
				Query query;
				for(String sql : initSqls){
//					query = manager.createNativeQuery(sql);
//					query.executeUpdate();
				}
				
			} catch (FileNotFoundException e) {
				logger.error("not find init file");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			logger.info(" resourceConfig init finish... ");
		}
		
	}
	
	public static InitResource getInstance(){
		if(instance == null){
			instance = new InitResource();
		}
		return instance;
	}
	
	 /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    private String readFileByLines(String filePath) throws Exception {
        StringBuffer str = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), "UTF-8"));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                str = str.append(" " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return str.toString();
    }
}
