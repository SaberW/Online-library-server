package com.jeanswest.onlinelibrary.mapper;
import com.jeanswest.onlinelibrary.entity.UserDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户相关操作
 */
public interface UserMapper {
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

    @Select(value = "SELECT `user`.id  FROM `user` WHERE  `user`.username = #{username}  AND `user`.`password` = #{password}")
    Integer login(UserDTO userDTO);

    List<UserDTO> findAll();
}
