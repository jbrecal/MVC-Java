package org.project.speaksmart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum name{
        can_create_categories,can_read_categories,can_update_categories,can_delete_categories,
        can_create_lessons,can_read_lessons,can_update_lessons,can_delete_lessons,
        can_create_levels,can_read_levels,can_update_levels,can_delete_levels,
        can_create_permissions,can_read_permissions,can_update_permissions,can_delete_permissions,
        can_create_users,can_read_users,can_update_users,can_delete_users,
        can_create_roles,can_read_roles,can_update_roles,can_delete_roles;
        public static name getCan_create_categories(){
            return can_create_categories;
        }
        public static name getCan_read_categories(){
            return can_read_categories;
        }
        public static name getCan_update_categories(){
            return can_update_categories;
        }
        public static name getCan_delete_categories(){
            return can_delete_categories;
        }
        public static name getCan_create_lessons(){
            return can_create_lessons;
        }
        public static name getCan_read_lessons(){
            return can_read_lessons;
        }
        public static name getCan_update_lessons(){
            return can_update_lessons;
        }
        public static name getCan_delete_lessons(){
            return can_delete_lessons;
        }
        public static name getCan_create_levels(){
            return can_create_levels;
        }
        public static name getCan_read_levels(){
            return can_read_levels;
        }
        public static name getCan_update_levels(){
            return can_update_levels;
        }
        public static name getCan_delete_levels(){
            return can_delete_levels;
        }
        public static name getCan_create_permissions(){
            return can_create_permissions;
        }
        public static name getCan_read_permissions(){
            return can_read_permissions;
        }
        public static name getCan_update_permissions(){
            return can_update_permissions;
        }
        public static name getCan_delete_permissions(){
            return can_delete_permissions;
        }
        public static name getCan_create_users(){
            return can_create_users;
        }
        public static name getCan_read_users(){
            return can_read_users;
        }
        public static name getCan_update_users(){
            return can_update_users;
        }
        public static name getCan_delete_users(){
            return can_delete_users;
        }
        public static name getCan_create_roles(){
            return can_create_roles;
        }
        public static name getCan_read_roles(){
            return can_read_roles;
        }
        public static name getCan_update_roles(){
            return can_update_roles;
        }
        public static name getCan_delete_roles(){
            return can_delete_roles;
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
