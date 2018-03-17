## spring boot restful
simple restful service by spring boot &amp; mybatis &amp; maven

## installation

```$ mvn spring-boot:run```

## development

spring Boot / maven / mybatis / h2 db / tomcat

## restful spec

- Add: @RequestMapping(value = "/user", method = RequestMethod.POST)
- Update: @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
- Delete: @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
- List: @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
- List All: @RequestMapping(value = "/users", method = RequestMethod.GET)

## test: postman

- example: adding data

![demo_restful](https://user-images.githubusercontent.com/13846660/37507603-bae40368-2932-11e8-9be0-0f6cdbe01513.PNG)
