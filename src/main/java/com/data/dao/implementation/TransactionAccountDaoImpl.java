package com.data.dao.implementation;

import com.data.dao.interfaces.TransactionAccountDao;
import com.data.dao.mappers.TransactionAccountMapper;
import com.data.entity.TransactionAccount;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class TransactionAccountDaoImpl extends GenericOperationImpl<TransactionAccount> implements TransactionAccountDao {
    public TransactionAccountDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public TransactionAccount getTransactionAccountByCardNumber(long cardNumber){
        String query="SELECT * FROM transaction_account WHERE card_number=?";
        try{
            return getJdbcTemplate().queryForObject(query,new TransactionAccountMapper(), cardNumber);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return null;
    }

    @Override
    public List<TransactionAccount> getListOfRecords(int elementsPerPage, int pageIndex) {
        String query="SELECT * FROM transaction_account LIMIT ? OFFSET ?";
        try{
            return getJdbcTemplate().query(query, new TransactionAccountMapper(), elementsPerPage,(pageIndex - 1) * elementsPerPage);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }


    @Override
    public TransactionAccount getById(int transactionAccountId) {
        String query="SELECT * from transaction_account WHERE transaction_account_id";
        try{
            return getJdbcTemplate().queryForObject(query,new TransactionAccountMapper(), transactionAccountId);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public TransactionAccount create(TransactionAccount transactionAccount) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO transaction_account VALUES(default , ? , ? , ? , ? , ? , ? , ?) ";
            try{
                getJdbcTemplate().update(con -> {
                    PreparedStatement prepstm= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    prepstm.setInt(1,transactionAccount.getAccountId());
                    prepstm.setLong(2,transactionAccount.getCardNumber());
                    prepstm.setString(3,transactionAccount.getCardVendorType());
                    prepstm.setString(4,transactionAccount.getIBAN());
                    prepstm.setString(5,transactionAccount.getBankName());
                    prepstm.setString(6,transactionAccount.getBankAddress());
                    prepstm.setString(7,transactionAccount.getBIC());
                    return prepstm;
                },keyHolder);
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            return null;
    }

    @Override
    public void update(TransactionAccount transactionAccount, int transactionAccountId) {
    String query = "UPDATE transaction_account SET account_id=? card_number=? card_vendor_type=? IBAN=? bank_name=? " +
            "bank_address=? BIC=? WHERE transaction_account_id=?";
        try{
            getJdbcTemplate().update(query,
                    transactionAccount.getAccountId(),
                    transactionAccount.getCardNumber(),
                    transactionAccount.getCardVendorType(),
                    transactionAccount.getIBAN(),
                    transactionAccount.getBankName(),
                    transactionAccount.getBankAddress(),
                    transactionAccount.getBIC(),
                    transactionAccountId);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int countAllRecords() {
        String query="SELECT count(*) FROM transaction_account";
        try{
            getJdbcTemplate().queryForObject(query,Integer.class);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return 0;
    }
}
