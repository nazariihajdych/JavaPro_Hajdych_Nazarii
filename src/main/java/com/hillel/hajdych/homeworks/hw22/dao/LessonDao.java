package com.hillel.hajdych.homeworks.hw22.dao;

import com.hillel.hajdych.homeworks.hw22.models.Lesson;

import java.util.Date;
import java.util.List;

public interface LessonDao {
    void addLesson(Lesson lesson);

    void removeLesson(Integer id);

    void removeLesson(Lesson lesson);

    List<Lesson> allLessons();

    Lesson getLessonByIdWithHomework(Integer id);
}
