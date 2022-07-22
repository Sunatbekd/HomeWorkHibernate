package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernate;

public class App {
    public static void main( String[] args ) {

        UserDao userDao = new UserDaoHibernate();

//        userDao.saveUser(new User("Nurbek","Isakov",38));
//        System.out.println(userDao.getById(1L));
//        System.out.println(userDao.getAllUsers());
//        userDao.removeUserById(1L);
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();
        System.out.println();
    }
}
