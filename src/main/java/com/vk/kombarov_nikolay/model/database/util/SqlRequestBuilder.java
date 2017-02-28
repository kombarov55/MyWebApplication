package com.vk.kombarov_nikolay.model.database.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

/**
 * Created by nikolaykombarov on 30.01.17.
 */
public class SqlRequestBuilder {

    public static String buildRequest(String beginning, Set<String> keySet) {
        StringBuilder sb = new StringBuilder(beginning);
        if (keySet == null)
            return sb.append(";").toString();

        sb.append(" WHERE ");
        for (String key : keySet) {
            sb.append(key).append("=? AND ");
        }
        sb.delete(sb.length() - 5, sb.length()).append(";");
        return sb.toString();
    }

    public static void insertParams(PreparedStatement ps, Map<String, String> params) throws SQLException {
        int counter = 1;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            ps.setString(counter, pair.getValue());
            counter++;
        }
    }

    public static String buildUpdate(String beginning, String keyPart, Set<String> keySet) {
        StringBuilder sb = new StringBuilder(beginning);
        sb.append(" SET ");
        for (String key : keySet) {
            sb.append(key).append("=? AND ");
        }

        sb.delete(sb.length() - 5, sb.length()).append(" WHERE ").append(keyPart).append(";");
        return sb.toString();
    }

    public static void insertUpdateParams(PreparedStatement ps,
                                          String primaryKey, Map<String,String> params) throws SQLException  {
        int counter = 1;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            ps.setString(counter, pair.getValue());
            counter++;
        }
        ps.setString(counter, primaryKey);
    }

}
