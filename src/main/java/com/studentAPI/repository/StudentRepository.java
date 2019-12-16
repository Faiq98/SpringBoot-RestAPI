/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentAPI.repository;

/**
 *
 * @author fhfai
 */

import org.springframework.data.repository.CrudRepository;
import com.studentAPI.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
    
}
