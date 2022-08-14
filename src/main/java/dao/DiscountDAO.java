package dao;

import model.Discount;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiscountDAO {

    public DiscountDAO() {
    }

    public boolean saveDiscount(Discount inputNewDiscount) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.insertDiscountSQL);
            preparedStatement.setString(1, inputNewDiscount.getTitle());
            preparedStatement.setInt(2, inputNewDiscount.getType());
            preparedStatement.setDouble(3, inputNewDiscount.getDiscount());
            preparedStatement.setDate(4, Date.valueOf(inputNewDiscount.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(inputNewDiscount.getEndDate()));

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public List<Discount> getAllDiscounts() {

        List<Discount> list = new ArrayList<>();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand.getAllDiscountsSQL);
            while (resultSet.next()){
                int discountId = resultSet.getInt(1);
                String title = resultSet.getString(2);
                int type = resultSet.getInt(3);
                double discount = resultSet.getDouble(4);
                LocalDate startDate =resultSet.getDate(5).toLocalDate();
                LocalDate endDate =resultSet.getDate(6).toLocalDate();
                list.add(new Discount(discountId, title, type, discount, startDate, endDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

    public int updateDiscount(Discount inputUpdateDiscount) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateDiscountSQL);
            preparedStatement.setString(1, inputUpdateDiscount.getTitle());
            preparedStatement.setInt(2, inputUpdateDiscount.getType());
            preparedStatement.setDouble(3, inputUpdateDiscount.getDiscount());
            preparedStatement.setDate(4, Date.valueOf(inputUpdateDiscount.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(inputUpdateDiscount.getEndDate()));
            preparedStatement.setInt(6, inputUpdateDiscount.getDiscountId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean removeDiscount(int inputRemoveDiscount) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.removeDiscountSQL);
            preparedStatement.setInt(1, inputRemoveDiscount);
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
