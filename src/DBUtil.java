package addr;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;

public class DBUtil {

	// 3306은 포트, addr_prj는 스키마 이름
	//	JDBC 관련 변수
	String url = "jdbc:mariadb://127.0.0.1:3306/addr_prj";
	String user = "root";
	String pass = "12345";
	SqlSessionFactory sqlSessionFactory;
	
	public void init() {
		try {
			//	데이터 처리 영역
			//	접속 성공하면 mybatis-config와 통신 가능
			String resource = "addr/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			//	어디서 문제가 발생했는지 대강 보여줌
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}
	}

			//	SqlSession은 conn + stmt 즉 stmt에 sql을 넘기면 결과를 받아볼 수 있음 즉 JDBC에서 하던 일을 SqlSession이 해줌
	public ArrayList<Addr> getAddresses() {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		ArrayList<Addr> addrList = mapper.getAddresses();
		
		return addrList;
	}
	
	public void insertAddress(String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(name, address, phone);
		mapper.insertAddress(addr);
		
		session.commit(); // update, delete, insert
	}
			//	update에는 수정할 항목이 필요하기에 이름 주소 전화번호 외에 id도 필요함
	public void updateAddress(int id, String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(id, name, address, phone);
		mapper.updateAddress(addr);
		
		session.commit(); // update, delete, insert
	}
			//	delete는 id만으로도 삭제가 가능함
	public void deleteAddress(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		mapper.deleteAddress(id);
		
		session.commit(); // update, delete, insert
	}
	
}
