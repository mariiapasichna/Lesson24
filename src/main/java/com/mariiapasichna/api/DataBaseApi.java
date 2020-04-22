package com.mariiapasichna.api;

import com.mariiapasichna.dao.UserDao;
import com.mariiapasichna.models.User;
import com.mariiapasichna.util.UserUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/database")
public class DataBaseApi {
    private UserDao userDao = new UserDao();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(String json) {
        User user = UserUtil.fromJson(json);
        userDao.addUser(user);
        List<User> users = userDao.getUser(user.getId());
        if (users.size() != 0) {
            String resultJson = "{\"result\": \"add success\"}";
            return Response.status(Response.Status.OK).entity(resultJson).build();
        } else {
            String resultJson = "{\"result\": \"failed to save user\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(resultJson).build();
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(String json) {
        User user = UserUtil.fromJson(json);
        if (userDao.updateUser(user) != 0) {
            String resultJson = UserUtil.toJson(user);
            return Response.status(Response.Status.OK).entity(resultJson).build();
        } else {
            String resultJson = "{\"result\": \"user not found\"}";
            return Response.status(Response.Status.NOT_FOUND).entity(resultJson).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        List<User> users = userDao.getUser(id);
        if (users.size() != 0) {
            String result = UserUtil.toJson(users.get(0));
            return Response.status(Response.Status.OK).entity(result).build();
        } else {
            String result = "{\"result\": \"user not found\"}";
            return Response.status(Response.Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersList() {
        List<User> users = userDao.getUsers();
        String resultJson = UserUtil.toJson(users);
        return Response.status(Response.Status.OK).entity(resultJson).build();
    }

    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(String json) {
        User user = UserUtil.fromJson(json);
        if (userDao.deleteUser(user) != 0) {
            String resultJson = "{\"id\": " + user.getId() + "}";
            return Response.status(Response.Status.OK).entity(resultJson).build();
        } else {
            String resultJson = "{\"result\": \"user not found\"}";
            return Response.status(Response.Status.NOT_FOUND).entity(resultJson).build();
        }
    }

    @DELETE
    @Path("/clear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllUsers() {
        int result = userDao.deleteAllUsers();
        String resultJson = "{\"result\": " + result + "}";
        return Response.status(Response.Status.OK).entity(resultJson).build();
    }
}