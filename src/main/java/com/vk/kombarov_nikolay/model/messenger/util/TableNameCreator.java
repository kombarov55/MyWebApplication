package com.vk.kombarov_nikolay.model.messenger.util;

/**
 * Created by nikolaykombarov on 11.01.17.
 */
public class TableNameCreator {
    public static String createTableName(String username1, String username2) {

        StringBuilder sb = new StringBuilder();

        if (username1.compareTo(username2) < 0) {
            sb.append(username1);
            sb.append("_");
            sb.append(username2);
        } else {
            sb.append(username1);
            sb.append("_");
            sb.append(username2);
        }


        return sb.toString();
    }
}
