package com.hillel.hajdych.homeworks.hw22;

import com.hillel.hajdych.homeworks.hw22.dao.LessonDao;
import com.hillel.hajdych.homeworks.hw22.dao.LessonMySqlDao;
import com.hillel.hajdych.homeworks.hw22.models.Lesson;

public class Main {
    public static void main(String[] args) {
        LessonDao lessonDao = new LessonMySqlDao();

        Lesson lesson = new Lesson();
        lesson.setName("Second Lesson");
        System.out.println(lesson);

        lessonDao.addLesson(lesson);

        System.out.println(lesson);

        System.out.println();
        System.out.println(lessonDao.allLessons());

        lessonDao.removeLesson(lesson);
        lessonDao.removeLesson(24);

        System.out.println(lessonDao.allLessons());

        lessonDao.getLessonByIdWithHomework(2);

    }
}
