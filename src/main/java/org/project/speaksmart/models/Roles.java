package org.project.speaksmart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum name{
        admin,teacher,alumn;

        public static name getAlumn(){
            return alumn;
        }
        public static name getAdmin(){
            return admin;
        }
        public static name getTeacher(){
            return teacher;
        }
    }
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
