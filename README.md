# Use_Mybatis_With_Java

자바와 DB서버 사이에서 DB를 주고 받을 수 있도록 접속 관리를 담당하는 SQLsession을 이용하여 자바IDE인 IntelliJ에서 출력해보는 프로젝트입니다.
 
## 목차

Ⅰ) **기술 스택**

Ⅱ) **주요 기능**

Ⅲ) **CRUD 기능 구현하기**

Ⅳ) **프로젝트를 마치며 느낀 점**


## Ⅰ) 기술 스택

### 사용 언어

- Java
- MySQL
- MyBatis
- Workbench


## Ⅱ) 주요 기능

1. MyBatis를 이용하여 java와 데이터를 입출력해본다.
2. 자바의 IDE인 Intellij에서 게시판의 기본 기능인 CRUD를 구현해본다.

## Ⅲ) CRUD 기능 구현하기
# Add 기능
![image](https://github.com/Jincheol-11/Use_Mybatis_With_Java/assets/145963704/5f37aaf5-cca4-45ee-a277-c72e6b563acb)

# List 기능
![image](https://github.com/Jincheol-11/Use_Mybatis_With_Java/assets/145963704/807c3419-a540-4958-b5e4-928371e91b10)

# Update 기능
![image](https://github.com/Jincheol-11/Use_Mybatis_With_Java/assets/145963704/be351eec-9e7b-472c-ac36-690eff6eda81)

# Delete 기능
![image](https://github.com/Jincheol-11/Use_Mybatis_With_Java/assets/145963704/29065c0c-89a7-4b27-bf89-5847e6e5cddb)

# SQL문이 담아져 있는 AddrMapper 코드
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="addr.AddrMapper">

	<!-- 해당 sql을 메서드와 연결해서 처리. id는 메서드명, resultType 리턴, parameterType 매개변수 -->
	<!--	public ArrayList<Addr> getAddresses();-->
	<!--	resultType에 들어가는 Addr은 만들어두었던 클래스-->
	<!--	Addr에서 필요한 결과를 꺼내옴-->
    <select id="getAddresses" resultType="addr.Addr">
      SELECT *
      FROM t_address
    </select>

	<!--	public void insertAddress(Addr addr);-->

	<!--	parameterType은 총 한개이므로 클래스 전체를 가져와 사용-->

    <insert id="insertAddress" parameterType="addr.Addr">
    	INSERT INTO t_address
    	SET `name` = #{name},
    	address = #{address},
    	phone = #{phone}
    </insert >

	<!--	public void updateAddress(Addr addr);-->
	<update id="updateAddress" parameterType="addr.Addr">
  		UPDATE t_address
  		SET `name` = #{name},
    	address = #{address},
    	phone = #{phone}
    	WHERE id = #{id}
  	</update>

	<!--	public void deleteAddress(int id); -->
	<!--삭제 명령에는 id만 있으면 된다-->
	<delete id="deleteAddress" parameterType="int">
  		DELETE FROM t_address
  		WHERE id = #{id}
  	</delete>
```
</mapper>

## Ⅳ) 프로젝트를 마치며 느낀 점

데이터베이스에 대한 지식이 하나도 없는 상태에서의 시작이었습니다. 처음에는 이해조차 힘들었지만 강사님의 열강과 동영상 보충강의를 통해 하나하나 알아갔습니다.
자바와 DBMS가 어떻게 자료를 주고받는지 알 수 있는 기회였습니다. 또한 이번 프로젝트를 통해 MyBatis를 세팅하고 데이터 입력하는 방법을 배웠습니다.
간단한 데이터로 시작했지만, '추후 복잡한 데이터를 넣어서도 적용해볼 수 있겠다'라는 생각을 했습니다.

읽어주셔서 감사합니다. 좋은하루되세요!
