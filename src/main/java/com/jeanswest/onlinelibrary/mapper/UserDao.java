package com.jeanswest.onlinelibrary.mapper;
import com.jeanswest.onlinelibrary.entity.LoginVO;
import com.jeanswest.onlinelibrary.entity.UserDTO;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserDao {
    @Insert(value = "INSERT INTO user(id,username,password) VALUES(#{id},#{username},#{password})")
    Integer saveUser(UserDTO user);

    @Delete(value = "DELETE FROM user WHERE id = #{id}")
    Integer deleteById(Integer id);

    @Update(value = "UPDATE user SET username = #{username},password = #{password} WHERE id = #{id}")
    Integer updateUserById(UserDTO user);

    @Select(value = "SELECT * FROM user WHERE id = #{id}")
    UserDTO getUserById(Integer id);

    @Select(value = "SELECT * FROM user")
    List<UserDTO> listUser();

    @Select(value = "SELECT COUNT(`user`.id ) FROM `user` WHERE  `user`.username = #{username}  AND `user`.`password` = #{password}")
    Integer login(LoginVO loginVO);

}
