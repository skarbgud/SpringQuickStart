package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	static {
		try {
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");	// sql-map-config.xml 파일을 읽기 위해 입력 스트림을 생성
				// SqlSession 객체에 대한 공장 역할을 수행
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);	// 입력 스트림을 통해 sql-map-config.xml 파일 읽어 SqlSessionFactory 객체 생성 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstace() {
		return sessionFactory.openSession();
	}
}
