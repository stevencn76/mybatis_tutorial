package onetomany.type;

import onetomany.model.Gender;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderTypeHandler implements TypeHandler<Gender> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int columnIndex, Gender gender, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(columnIndex, gender.ordinal());
    }

    @Override
    public Gender getResult(ResultSet resultSet, String columnName) throws SQLException {
        int code = resultSet.getInt(columnName);
        return Gender.values()[code];
    }

    @Override
    public Gender getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int code = resultSet.getInt(columnIndex);
        return Gender.values()[code];
    }

    @Override
    public Gender getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int code = callableStatement.getInt(columnIndex);
        return Gender.values()[code];
    }
}
