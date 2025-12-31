package com.mtcoding.store;

import java.util.List;

public class StoreApp {
    public static void main(String[] args) {
            StoreRepository repo = new StoreRepository();
            //(1) 1번 id에 감자생성
            //int result = repo.insert(3,"감자",1000,2);
            //System.out.println("결과: "+result);


            //(2) id값 1번 바나나 ->고구마로 변경
//            int result = repo.updateOne(1,"고구마",2000,100);
//            System.out.println("결과: "+result);


//            // (3) deleteOne 실습
//             int result = repo.deleteOne(2);
//             System.out.println("결과: "+result);

                //Store store = repo.selectOne(3);
                //System.out.println(store); //객체의 레퍼런스 변수를 호출하면 toString()이 자동호출된다.


                List<Store> list = repo.selectAll();//다 줘야하니 인수불필요
                for (Store s : list){
                    System.out.println(s);
                }

        }
    }

