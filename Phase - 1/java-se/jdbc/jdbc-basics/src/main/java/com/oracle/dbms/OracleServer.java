package com.oracle.dbms;

import com.jdbc.JdbcApi;

public class OracleServer implements JdbcApi {
    public String executeCommand(String msg) {
        return "Oracle Server: " + msg;
    }

    @Override
    public String execute(String msg) {
        return new String(executeCommand(msg));
    }
}
