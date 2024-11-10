package com.mebaysan.quick_start.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mebaysan.quick_start.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student fetchById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public int count() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(id) FROM Student s", Long.class);
        return query.getSingleResult().intValue();
    }

    @Override
    public List<Student> filterLikeEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email LIKE :email",
                Student.class);
        query.setParameter("email", "%" + email + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(fetchById(id));
    }

}
