package maktab74.repositori;

import maktab74.domain.Magazine;

import javax.persistence.EntityManager;
import java.sql.*;

public class MagazineRepository {

    private EntityManager entityManager;

    public MagazineRepository(EntityManager em) {
        this.entityManager = em;
    }


    public Magazine insertMagazine(Magazine magazine) throws SQLException {


        return magazine;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from magazine_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Magazine[] getAllMagazine() throws SQLException {
        int allPrint = countAllMagazine();


        Magazine[] magazines = new Magazine[allPrint];
        int count = 0;
        String query = "select * from magazine_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            magazines[count] = new Magazine(

                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(8),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)

            );


            count++;
        }
        return magazines;
    }


    public int countAllMagazine() throws SQLException {
        String query = "select count(*) from magazine_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Magazine getById(int magazineId) throws SQLException {
        String quri = "select * from magazine_table where id =" + magazineId;
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Magazine(


                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(8),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)

            );
        }
        return null;
    }

    public void douwnProduct(int magazineId) throws SQLException {
        String quri = " update magazine_table set number=number-1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quri);
        preparedStatement.setInt(1, magazineId);
        preparedStatement.executeUpdate();
    }
}

