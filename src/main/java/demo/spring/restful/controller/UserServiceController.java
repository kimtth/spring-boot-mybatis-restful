package demo.spring.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import demo.spring.restful.bean.User;
import demo.spring.restful.service.UserService;

/* 
 * @ Description #1
 * Controller => Service (For Transaction) => Mapper(SQL Mapping & AutoGenerate DAO)
 * 
 * DAOs are more granular and deal with one specific entity. 
 * Services provide macro level functionalities and can end up using more than one DAO.
 */
/* 
 * @ Description #2
 * https://stackoverflow.com/questions/26549379/when-use-responseentityt-and-restcontroller-for-spring-restful-applications
 * 
 * ResponseEntity is meant to represent the entire HTTP response.
 * You can control anything that goes into it:status code,headers,and body.
 *
 * @ResponseBody is a marker for the HTTP response body and
 * @ResponseStatus declares the status code of the HTTP response.
 * @ResponseStatus isn't very flexible. 

 * Basically, ResponseEntity lets you do more.
*/

//@RestController: shorthand for @Controller and @ResponseBody rolled together

@RestController
@RequestMapping(value = "/api")
public class UserServiceController {

	@Autowired
	private UserService userService;

	// DESC: 
	// http://localhost:port/api/user/id
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> queryUserById(@PathVariable int id) {
		System.out.println("id=" + id);
		User user = userService.getUserById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// http://localhost:port/api/users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> queryUsers() {
		List<User> users = userService.getAllUser();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// Add
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Void>  addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		
		if (userService.isUserExist(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		User new_user = userService.addUser(user);

		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(new_user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	// Update
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		if (userService.isUserExist(user) == false) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		int result = userService.updateUser(user);
		
		if(result > 0) {
			User update_user = userService.getUserById(id);
			return new ResponseEntity<User>(update_user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Delete
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		boolean is_deleted = userService.deleteUserById(id);
		
		if (is_deleted != true) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// TODO
	// http://localhost:port/api/user/name/{name}
	@RequestMapping(value = "/user/name/{name}", method = RequestMethod.GET)
	public void getUserByName(@PathVariable String name) {
		System.out.println("name=" + name);
	}

}
