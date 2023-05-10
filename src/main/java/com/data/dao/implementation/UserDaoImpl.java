package com.data.dao.implementation;

import com.data.dao.interfaces.UserInterface;
import com.data.dao.mappers.UserMapper;
import com.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl implements UserInterface {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImpl(DataSource dataSource){
        jdbcTemplate= new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllRecords() {
        String query = "SELECT * FROM user";
        try {
            System.out.println("Dao");
            List<User> testUsers = jdbcTemplate.query(query, new UserMapper());
            for(User user:testUsers) {
                System.out.println(user.getFirstName());
                if (user.getFirstName() == null) {
                    System.out.println("no jdbc connect");
                }
            }
            return jdbcTemplate.query(query, new UserMapper());
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public void update(User entity, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
