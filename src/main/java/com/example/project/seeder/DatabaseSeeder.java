package com.example.project.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.entity.Student;
import com.example.project.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        
        if (isTableEmpty()) {
            String password = passwordEncoder.encode("password");
            // entityManager.createNativeQuery("INSERT INTO student (full_name, email, password, class_id, phone, status) VALUES (?, ?, ?, ?, ?, ?)")
            //     .setParameter(1, "Trần Tiến Đạt")
            //     .setParameter(2, "trantiendat@gmail.com")
            //     .setParameter(3, password)
            //     .setParameter(4, 1)
            //     .setParameter(5, "0129890423")
            //     .setParameter(6, "Enrolled")
            //     .executeUpdate();
            // System.out.println("password" + password);

            // Student student = new Student();
            // student.setFullName("Trần Tiến Đạt");
            // student.setEmail("trantiendat@gmail.com");
            // student.setPassword(password);
            // student.setClassId(1L);
            // student.setPhone("120302140");
            // student.setStatus("Enrolled");
            // entityManager.persist(student);
            
            // Student student1 = new Student();
            // student1.setFullName("Nguyễn Như Quỳnh");
            // student1.setEmail("nguyennhuquynh@gmail.com");
            // student1.setPassword(password);
            // student1.setClassId(1L);
            // student1.setPhone("121210302140");
            // student1.setStatus("Enrolled");
            // entityManager.persist(student1);
            
            Student student3 = new Student();
            student3.setFullName("Trần Tiến Đạt");
            student3.setEmail("trantiendat@gmail.com");
            student3.setPassword(password);
            student3.setClassId(1L);
            student3.setPhone("120302140");
            student3.setStatus("Enrolled");
            studentRepository.save(student3);
            
            Student student4 = new Student();
            student4.setFullName("Nguyễn Như Quỳnh");
            student4.setEmail("nguyennhuquynh@gmail.com");
            student4.setPassword(password);
            student4.setClassId(1L);
            student4.setPhone("121210302140");
            student4.setStatus("Enrolled");
            studentRepository.save(student4);

        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Student").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
