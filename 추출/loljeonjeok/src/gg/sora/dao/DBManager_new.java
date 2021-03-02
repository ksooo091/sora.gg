package gg.sora.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager_new {

	public DBManager_new() {

	}

	public static SqlSession connect() throws IOException {
		String cfgName = "config.xml"; 
		
		InputStream is = Resources.getResourceAsStream(cfgName);

		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(is); 
		SqlSession ss = ssf.openSession();

		return ss;
	}

}
