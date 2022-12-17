package application;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        /*
        Department dp = new Department(3,"Tvs");
        System.out.println(dp);

        Seller seller = new Seller(21,"Bob","bob@gmail.com",new Date(),5500.60,dp);
        System.out.println(seller);

         */

        /*
        // TESTE 2
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);

        Department dep = new Department(2,null);
        List<Seller> lista = sellerDao.findByDepartment(dep);
        for (Seller obj : lista) {
            System.out.println(obj);
        }
         */

        // TESTE 3
        /*
        SellerDao sellerDao = DaoFactory.createSellerDao();
        List<Seller> lista = sellerDao.findall();
        for (Seller obj : lista) {
            System.out.println(obj);
        }
         */

        //TESTE 4
        Department dep = new Department(2,null);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0,dep);
        sellerDao.insert(seller);
        System.out.println("Dados Inseridos, Novo Id="+seller.getId());



    }
}
