package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.entity.Dept;

public class DBManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
//	public static int insert(Dept b) {
//		int re = -1;
//		SqlSession session = sqlSessionFactory.openSession(true);
//		re = session.insert("book.insert", b);
////		session.commit();		
//		session.close();
//		return re;
//	}
//	
//	public static List<Dept> findAll(HashMap<String, Object> map){
//		List<Dept> list = null;
//		SqlSession session= sqlSessionFactory.openSession();
//		list = session.selectList("book.findAll", map);
//		session.close();
//		return list;
//	}
	
	public static Dept findByDno(int dno) {
		Dept d = null;
		SqlSession session = sqlSessionFactory.openSession();
		d = session.selectOne("dept.findByDno", dno);
		session.close();
		return d;
	}
	
//	public static int update(Dept b) {
//		int re = -1;
//		SqlSession session = sqlSessionFactory.openSession();
//		re = session.update("book.update", b);
//		session.commit();
//		session.close();
//		return re;
//	}
//	
//	public static int delete(int bookid) {
//		int re = -1;
//		SqlSession session = sqlSessionFactory.openSession();
//		re = session.delete("book.delete", bookid);
//		session.commit();
//		session.close();
//		return re;
//	}
}












