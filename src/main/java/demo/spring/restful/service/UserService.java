package demo.spring.restful.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.restful.bean.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public User getUserById(int Id) {
		return userMapper.selectById(Id);
	}

	public List<User> getAllUser() {
		return userMapper.selectAll();
	}

	public User addUser(User user) {
		return userMapper.insertUser(user);
	}

	//implicit void or int
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public boolean deleteUserById(int id) {
		return userMapper.deletebyId(id);
	}

	public boolean isUserExist(User user) {
		return userMapper.isUserExit(user);
	}
}

