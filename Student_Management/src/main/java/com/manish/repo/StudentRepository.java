package com.manish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
