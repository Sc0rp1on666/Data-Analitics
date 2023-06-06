package com.data.dao.implementation;

import com.data.dao.interfaces.RoleDao;
import com.data.dao.mappers.RoleMapper;
import com.data.entity.Role;
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
public class RoleDaoImpl extends GenericOperationImpl<Role> implements RoleDao {

    public RoleDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Role> getAllRecords(int elementsPerPage, int pageIndex) {
        String query ="SELECT * FROM roles LIMIT = ? OFFSET = ?";
        try {
            return getJdbcTemplate().query(query, new RoleMapper(),elementsPerPage,(pageIndex-1)*elementsPerPage);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Role getById(int id) {
        String query ="SELECT * FROM roles where user_role_id=?";
        try{
            return getJdbcTemplate().queryForObject(query, new RoleMapper(), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Role create(Role role) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO role VALUES(default , ? , ?)";
        try {
            getJdbcTemplate().update(con -> {
                PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepstm.setString(1,role.getUserRoleName());
                prepstm.setInt(2,role.getUserId());
                return prepstm;
            },keyHolder);
            return role;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void update(Role role, int id) {
        String query ="UPDATE user SET user_role_name=? user_id=? WHERE user_role_id=?";
        try {
            getJdbcTemplate().update(query,
                    role.getUserRoleName(),
                    role.getUserId(),
                    id
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int countAllRecords() {
        String query = "SELECT count(*) FROM role";
        try {
            return getJdbcTemplate().queryForObject(query, Integer.class);
        } catch (SQLException|EmptyResultDataAccessException ex) {
           ex.printStackTrace();
        }return 0;
    }


    @Override
    public List<Role> getRoles(int userId) {
        String query ="SELECT * FROM user as u inner join user_roles as ur on u.user_id=ur.user_id where u.user_id = ?";
        try{
            getJdbcTemplate().query(query,new RoleMapper(), userId);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
