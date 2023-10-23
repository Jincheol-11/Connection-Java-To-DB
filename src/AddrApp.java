import java.util.ArrayList;
import java.util.Scanner;

public class AddrApp {

  public static void main(String[] args) {

//	  db라는 변수로 DBUtil 객체화
		DBUtil db = new DBUtil();
		Scanner scan = new Scanner(System.in);

		db.init();
		
		while(true) {
//			exit을 입력하기 전까지 무한 반복
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();
//			 exit 입력 시 종료
			if(cmd.equals("exit")) {
				break;
				
			} else if(cmd.equals("add")) {
				System.out.println("========= 주소록 등록 =========");
				System.out.print("이름 : ");
				String name = scan.nextLine();
				System.out.print("주소 : ");
				String address = scan.nextLine();
				System.out.print("전화번호 : ");
				String phone = scan.nextLine();
//				db 코드 사용 가능
// 				DBUtil 파일로부터 try catch의 작업이 필요한 시점
				db.insertAddress(name, address, phone);
//				insertAddress가 대신 해주기 때문
				System.out.println("주소록 등록 완료.");
				System.out.println("============================");
				
			} else if(cmd.equals("list")) {
//				주소록을 Addr로부터 받아와  번호, 이름, 주소, 전화번호 순으로 출력
				ArrayList<Addr> addrList = db.getAddresses();
				WebView wv = new WebView();
				wv.printAddr(addrList);
				
				
			} else if(cmd.equals("update")) {
				System.out.print("몇번 주소록을 수정하시겠습니까 : ");
				int id = Integer.parseInt(scan.nextLine()); 
				System.out.println("========= 주소록 수정 =========");
				System.out.print("이름 : ");
				String name = scan.nextLine();
				System.out.print("주소 : ");
				String address = scan.nextLine();
				System.out.print("전화번호 : ");
				String phone = scan.nextLine();
				
				db.updateAddress(id, name, address, phone);
				
				System.out.println("주소록 수정 완료.");
				System.out.println("============================");
				
			} else if(cmd.equals("delete")) {
				System.out.print("몇번 주소록을 삭제하시겠습니까 : ");
				int id = Integer.parseInt(scan.nextLine());
				db.deleteAddress(id);
				System.out.println(id + "번 주소록이 삭제되었습니다.");
				System.out.println("==============================");
			}
		}	
	}
}
