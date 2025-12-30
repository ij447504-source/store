package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Repository = 추상저장 공간
//책임 : Store Table DB 전담반(데이터베이스 접근통로)

public class StoreRepository {

    //int deleteOne(int id)
    public int deleteOne(int id) {
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "delete from store_tb where id=?";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateOne(int id, String name, int price, int qty) {
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "update store_tb set name=?, price=?, qty=? where id=?";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, id);



            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(int id, String name, int price, int qty) {
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "insert into store_tb(id, name, price, qty) values(?,?,?,?)";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, price);
            pstmt.setInt(4, qty);


            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        }


}

