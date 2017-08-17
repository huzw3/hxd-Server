package com.hxd.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxd.bean.common.UserDemo;
import com.hxd.busi.service.UserDemoService;
import com.hxd.common.MDA;
import com.hxd.util.CtxUtil;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * RestEasy样例工程
 * Created by Hu on 2017/7/7.
 */
@Path("/message")
public class RestfulDemo {

    static UserDemoService userService;
    Logger logger = Logger.getLogger(UserDemoService.class);


    @GET
    @Path("/getString/{param}")
    public Response printMessage(@PathParam("param") String msg) {

        String result = "Restful example : " + msg;

        return Response.status(MDA.RSP_STATUS_OK).entity(result).build();

    }

    @GET
    @Path("/getMethod/{param}")
    public Response getIssue(@PathParam("param") String msg)
            throws Exception {
        long sTime = System.currentTimeMillis();
        userService= CtxUtil.getBean(UserDemoService.class);
        List<UserDemo> users = userService.getUserByName(msg);
        long tTime = System.currentTimeMillis()-sTime;
        logger.info("总时间="+tTime+"ms");
        for(UserDemo user :users){
            logger.info("Id="+user.getId()+", Name="+user.getName()+", Age="+user.getAge());
        }
        ObjectMapper mapper = new ObjectMapper();
        /*对象转String格式的json报文*/
        String result = mapper.writeValueAsString(users);

        return Response.status(MDA.RSP_STATUS_OK).entity(result).build();
    }

    @POST
    @Path("/postMethod")
    public Response postIssue(String request) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        /*String格式的json报文转对象*/
        UserDemo user = mapper.readValue(request, UserDemo.class);
        /*对象转String格式的json报文*/
        String json = mapper.writeValueAsString(user);
        logger.info("Request="+json);

        long sTime = System.currentTimeMillis();
        userService= CtxUtil.getBean(UserDemoService.class);
        int id = userService.insertUser(user);
        long tTime = System.currentTimeMillis()-sTime;
        logger.info("总时间="+tTime+"ms");
        logger.info("Id="+id);
        return Response.status(MDA.RSP_STATUS_OK).entity(id).build();
    }

    @GET
    @Path("/{param}")
    public String sayHelloToUTF(@PathParam("param") String username,
                                 @QueryParam("phoneNo")String phoneNo) {
        return "Hello " + username + "," + phoneNo;
    }

    @POST
    @Path("/order")
    public String sayHelloToPost(String helloInfo) {
        String response = "{\"Post\":\""+helloInfo+"\"}";
        return response ;
    }

}
