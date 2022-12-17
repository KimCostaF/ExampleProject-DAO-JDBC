package model.impl;



import db.DB;
import db.DbException;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {
    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Seller obj) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select seller.*,department.Name as DepName from seller INNER JOIN" +
                    " department on seller.DepartmentId = department.Id where seller.Id =?");

            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()){
                Department dep = instatiateDepartment(rs);
                Seller obj = instatiateSeller(rs,dep);
                return obj;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultset(rs);

        }


        return null;
    }

    private Seller instatiateSeller(ResultSet rs, Department dep) throws SQLException {
       Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setSalary(rs.getDouble("BaseSalary"));
        obj.setBirthdate(rs.getDate("BirthDate"));
        obj.setDp(dep);

        return obj;
    }

     private Department instatiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));

        return dep;
    }

    @Override
    public List<Seller> findall() {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select seller.*,department.Name as Depname from seller inner join department" +
                    " on seller.DepartmentId=department.Id order by Name");


            rs = st.executeQuery();

            List<Seller> lista = new ArrayList<>();
            Map<Integer,Department> map = new HashMap<>();
            while(rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep==null){
                    dep = instatiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"),dep);
                }
                Seller obj = instatiateSeller(rs,dep);
                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultset(rs);

        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select seller.*,department.Name as Depname from seller inner join department" +
                    " on seller.DepartmentId=department.Id where DepartmentId=? order by Name");

            st.setInt(1,department.getId());
            rs = st.executeQuery();

            List<Seller> lista = new ArrayList<>();
            Map<Integer,Department> map = new HashMap<>();
            while(rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep==null){
                    dep = instatiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"),dep);
                }
                Seller obj = instatiateSeller(rs,dep);
                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultset(rs);

        }


    }
}
