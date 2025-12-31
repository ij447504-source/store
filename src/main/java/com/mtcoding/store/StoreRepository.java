package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Repository = 추상저장 공간
//책임 : Store Table DB 전담반(데이터베이스 접근통로)

public class StoreRepository {


    // (개념)Read = (DB)select = (http)get
    public List<Store> selectAll(){
        Connection conn = DBConnection.getConnection();

        try{
            String sql = "select * from store_tb order by id desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);


            //조회해서 view 응답받기
            ResultSet rs = pstmt.executeQuery();

            //커서 한칸만 내릴 수 없어 while문 작성
            List<Store> list = new ArrayList<>();
            while(rs.next()){
                //Rs-> 자바오브젝트로 파싱
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");
                Store store = new Store(c1, c2, c3, c4);
                list.add(store);
            }
            return list; //오류가 걸리면 오류문구 추출 후 null 값 추출, 오류가 없다면 여기행에서 끝



        }catch (SQLException e) {
            e.printStackTrace();
        }




        return null;

    }
    //(사용자언어) = 백엔드 용어 = 프론트엔더 용어
    //면접질문 DRUD할줄알아요? 이 세파트에서 다 아냐 이말!
    // Read = select = get
    public Store selectOne(int id){
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "select * from store_tb where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            // 조회해서 view로 응답받기
            ResultSet rs = pstmt.executeQuery();

            // 커서 한칸 내리기
            boolean isRow = rs.next();

            // 행이 존재하면 프로젝션(열 선택하기)
            if(isRow){
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");
                Store store = new Store(c1, c2, c3, c4);
                return store;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Delete = delete = delete
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

    // Update = update = put
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

    // Create = insert = post
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

