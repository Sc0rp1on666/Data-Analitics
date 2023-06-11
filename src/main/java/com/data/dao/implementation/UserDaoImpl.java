package com.data.dao.implementation;

import com.data.dao.interfaces.UserDao;
import com.data.dao.mappers.UserMapper;
import com.data.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl extends GenericOperationImpl<User> implements UserDao {

    public UserDaoImpl(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public List<User> getListOfRecords(int elementsPerPage, int pageIndex) {
        String query = "SELECT * FROM user LIMIT ? OFFSET ?";
        try {
            List<User> testUsers = getJdbcTemplate().query(query, new UserMapper(),elementsPerPage,(pageIndex-1)*elementsPerPage);
            return getJdbcTemplate().query(query, new UserMapper());
        }catch (NullPointerException ex){
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public User getById(int id) {
        String query =" SELECT * FROM user where user_id=?";
        try {
            return getJdbcTemplate().queryForObject(query, new UserMapper(), id);
        }catch (SQLException | EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email){
        String query ="SELECT * FROM user where email=?";
        try{
            return getJdbcTemplate().queryForObject(query,new UserMapper(), email);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return null;
    }

    @Override
    public User create(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO user VALUES ( default , ? , ? , ? , ? , ? , ? , ? , ? , CURRENT_TIMESTAMP )";
        try{getJdbcTemplate().update( con -> {
            PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepstm.setString(1,user.getIdnp());
            prepstm.setString(2,user.getSeria());
            prepstm.setString(3,user.getFirstName());
            prepstm.setString(4,user.getLastName());
            prepstm.setString(5,user.getEmail());
            prepstm.setString(6,user.getAddress());
            prepstm.setString(7,user.getPassword());
            prepstm.setDate(8,user.getDateOfBirth());
            return prepstm;
        }, keyHolder);
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void update(User user, int id) {
        String query ="UPDATE user SET idnp=? seria=? first_name=? last_name=? email=? address=? password=? WHERE user_id=?";
        try{
            getJdbcTemplate().update(query,
                    user.getIdnp(),
                    user.getSeria(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getPassword(),
                    id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int countAllRecords() {
        return 0;
    }
}
