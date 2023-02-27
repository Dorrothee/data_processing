package Crud;

import Entities.Watches;
import jdbc.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements LabCRUDInterface<Watches> {

    Connection connection;

    public SqlCRUD(){
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Watches watches) {
        try(
            PreparedStatement st = connection.prepareStatement("INSERT INTO entity (look, model, price) "
                            + "VALUES (?, ?, ?);")){
            st.setString(1, watches.getLook());
            st.setString(2, watches.getModel());
            st.setInt(3, watches.getPrice());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Watches> read() {
        List<Watches> list = new ArrayList<Watches>();
        try (
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM entity;");){
            while(rs.next()){
                list.add(new Watches(rs.getInt(1), rs.getString(2),
                        rs.getString(3),rs.getInt(4) ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, Watches watches) {
        try(
            PreparedStatement st = connection.prepareStatement("UPDATE entity "
                    + "SET \"look\"=?, \"model\"=?, \"price\"=? WHERE id=?;")){
            st.setString(1, watches.getLook());
            st.setString(2, watches.getModel());
            st.setInt(3, watches.getPrice());
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(
            PreparedStatement st = connection.prepareStatement("DELETE FROM entity WHERE id=?;")){
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
