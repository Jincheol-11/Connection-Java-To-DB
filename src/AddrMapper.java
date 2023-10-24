package addr;

import java.util.ArrayList;

public interface AddrMapper {

//	xml 파일에 있는 SELECT * FROM t_address을 연결해주면 된다.
	public ArrayList<Addr> getAddresses();
	public void insertAddress(Addr addr);
	public void updateAddress(Addr addr);
	public void deleteAddress(int id);
}
