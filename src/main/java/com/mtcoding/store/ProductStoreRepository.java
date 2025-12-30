package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Repository = 추상저장 공간
//책임 : Store Table DB 전담반(데이터베이스 접근통로)

public class ProductStoreRepository {


    public int INSERT(int id, String name, String gender, int age) {
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "INSERT INTO product2_tb(id, name, gender, age) values(?,?,?,?)";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setInt(4,age);


            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        }


    //(2) 이지윤 업데이트문 넣기
    public int updateOne(int id, String name, String gender, int age) {
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "update product2_tb set name=?, gender=?, age=? where id=?";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, gender);
            pstmt.setInt(3,age);
            pstmt.setInt(4, id);


            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    }



