package demo.spring.restful.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import demo.spring.restful.bean.User;

// Rather than code data access objects (DAOs) manually using
// SqlSessionDaoSupport or SqlSessionTemplate,
// Mybatis-Spring can create a thread safe mapper that you can inject directly into other beans:

// 1. Without Annotation: Interface +  UserMapper.xml & The xml Path should be defined Configuration
//           versus
// 2. With Annotation: UserMapper.xml does not need & @MapperScan(com.demo)

// DESC
//Mapper.xmlに定義したresultMapを使用する場合
//@ResultMap("UserResult")
// annotationで指定する場合
//@Results({
//      @Result(property = "id", column = "id", id = true),
//      @Result(property="loginId", column="LOGIN_ID"),
//      @Result(property="encodedPassword", column="ENCODED_PASSWORD")
//})

@Mapper
public interface UserMapper {

	// @Paramの場合ProviderにはMap<String, Object>の引数として渡される
	// https://github.com/muumin/spring-boot-mybatis
	@Select("select * from UserDemo where id = #{id}")
	public User selectById(@Param("id") int id);

	@Select("select * from UserDemo")
	public List<User> selectAll();

	@Insert("insert into UserDemo(id, name) VALUES(#{id}, #{name})")
	public User insertUser(User user);

	@Update("update UserDemo set id = #{id}, name = #{name} WHERE id = #{id}")
	public int updateUser(User user);

	@Delete("delete UserDemo where id = #{id}")
	public boolean deletebyId(int id);

	// https://stackoverflow.com/questions/35982281/mybatis-how-to-check-if-a-row-exists-and-return-a-boolean
	@Select("select exists(select 1 from UserDemo where id = #{id})")
	public boolean isUserExit(User user);
	
	//DROP TABLE IF EXISTS USERDEMO;

}
