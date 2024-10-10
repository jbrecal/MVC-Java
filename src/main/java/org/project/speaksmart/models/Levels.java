package org.project.speaksmart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Levels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum name{
        a1,a2,b1,b2,c1,c2;

        public static name getA1(){
            return a1;
        }
        public static name getA2(){
            return a2;
        }
        public static name getB1(){
            return b1;
        }
        public static name getB2(){
            return b2;
        }
        public static name getC1(){
            return c1;
        }
        public static name getC2(){
            return c2;
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
