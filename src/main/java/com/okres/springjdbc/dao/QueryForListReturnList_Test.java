package com.okres.springjdbc.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class QueryForListReturnList_Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);
        QueryForListReturnListDao dao = context.getBean(QueryForListReturnListDao.class);

        List<String> names = dao.getDeptNames("A");

        for(String iter : names){
            System.out.println("Dept name " + iter);
        }
    }
}
