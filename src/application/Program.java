package application;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        /*
        Department dp = new Department(3,"Tvs");
        System.out.println(dp);

        Seller seller = new Seller(21,"Bob","bob@gmail.com",new Date(),5500.60,dp);
        System.out.println(seller);

         */

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

    }
}
