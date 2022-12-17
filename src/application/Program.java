package application;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        /*
        Department dp = new Department(3,"Tvs");
        System.out.println(dp);

        Seller seller = new Seller(21,"Bob","bob@gmail.com",new Date(),5500.60,dp);
        System.out.println(seller);

         */

        /*
        // TESTE 2
        Seller seller = sellerDao.findById(3);

        Department dep = new Department(2,null);
        List<Seller> lista = sellerDao.findByDepartment(dep);
        for (Seller obj : lista) {
            System.out.println(obj);
        }
         */

        // TESTE 3
        /*
        List<Seller> lista = sellerDao.findall();
        for (Seller obj : lista) {
            System.out.println(obj);
        }
         */

        /*
        //TESTE 4
        Department dep = new Department(2,null);
        Seller seller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0,dep);
        sellerDao.insert(seller);
        System.out.println("Dados Inseridos, Novo Id="+seller.getId());
         */

        /*
        //TESTE 5
        Seller seller = new Seller();
        seller = sellerDao.findById(1);
        seller.setName("Marcos Wayne");
        sellerDao.update(seller);
        System.out.println("UPDATE COMPLETE");
         */

        //TESTE 6
        System.out.println("Digite o Id do seller para ser deletado");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("DELETE COMPLETE");
        sc.close();




    }
}
