package com.hillel.hajdych.homeworks.hw22.dao;

import com.hillel.hajdych.homeworks.hw22.db.JdbcUtil;
import com.hillel.hajdych.homeworks.hw22.models.Homework;
import com.hillel.hajdych.homeworks.hw22.models.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonMySqlDao implements LessonDao {

    private Connection connection = null;

    @Override
    public void addLesson(Lesson lesson) {
        try {
            connection = JdbcUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO lesson (name) " +
                    "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, lesson.getName());

            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Unable to add lesson");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                boolean returnedData = statement.execute("SELECT * FROM lesson WHERE id =  " + generatedKeys.getInt(1));
                if (returnedData) {

                    ResultSet resultSet = statement.getResultSet();

                    if (resultSet.next()) {
                        lesson.setId(resultSet.getInt("id"));
                        lesson.setUpdatedAt(resultSet.getDate("updatedAt"));
                        statement.close();
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection);
        }

    }

    @Override
    public void removeLesson(Integer id) {
        removeMethod(id);
    }

    @Override
    public void removeLesson(Lesson lesson) {
        removeMethod(lesson.getId());
    }

    private void removeMethod(Integer id) {
        try {
            connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lesson WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection);
        }
    }

    @Override
    public List<Lesson> allLessons() {
        try {
            connection = JdbcUtil.getConnection();
            Statement statement = connection.createStatement();
            boolean returnedData = statement.execute("SELECT * FROM lesson");

            if (returnedData) {
                ResultSet resultSet = statement.getResultSet();

                Lesson lesson;
                List<Lesson> lessons = new ArrayList<>();

                while (resultSet.next()) {

                    lesson = new Lesson();
                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                    lesson.setUpdatedAt(resultSet.getDate("updatedAt"));

                    lessons.add(lesson);
                }

                statement.close();

                return lessons;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection);
        }
        return null;
    }

    @Override
    public Lesson getLessonByIdWithHomework(Integer id) {
        try {
            connection = JdbcUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT l.*, h.* FROM lesson AS l " +
                    "LEFT JOIN homework AS h " +
                    "ON l.id = h.lesson_id " +
                    "WHERE l.id = ?");
            statement.setInt(1, id);
            boolean returnedData = statement.execute();

            if (returnedData) {
                ResultSet resultSet = statement.getResultSet();

                Lesson lesson = null;
                List<Homework> homeworks = new ArrayList<>();

                while (resultSet.next()) {
                    if (lesson == null) {
                        lesson = new Lesson();
                        lesson.setId(resultSet.getInt("l.id"));
                        lesson.setName(resultSet.getString("l.name"));
                        lesson.setUpdatedAt(resultSet.getDate("l.updatedAt"));
                        lesson.setHomework(homeworks);
                    }

                    Homework homeWork = new Homework();
                    homeWork.setId(resultSet.getInt("h.id"));
                    homeWork.setName(resultSet.getString("h.name"));
                    homeWork.setDescription(resultSet.getString("h.description"));
                    homeWork.setLesson(lesson);

                    homeworks.add(homeWork);
                }

                statement.close();

                return lesson;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection);
        }
        return null;
    }
}
