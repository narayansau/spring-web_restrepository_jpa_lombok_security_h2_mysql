package com.example.web_restrepository_jpa_lombok_security_h2_mysql.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Data
@Table(name="person", schema="dbe", catalog="")
public class Person{
    @Id
    @GeneratedValue(generator= "system-uuid")
    @GenericGenerator( name = "system-uuid", strategy= "uuid" )
    private String id;

    @Column(unique=true)
    private String email;
    private String name;
    private String password;
    private String role = "USER";
    private boolean enabled = true;
    private LocalDate birthdate;

    @Column(insertable= true , updatable= false)
    private LocalDateTime created;
    private LocalDateTime modified;

    public Person() {
    }

    public Person(String email, String name, String password, String birthdate) {
        this.email=email;
        this.name=name;
        this.password=password;
        this.birthdate=LocalDate.parse(  birthdate, DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) ;
    }

    public Person(String email, String name, String password, LocalDate birthdate) {
        this.email=email;
        this.name=name;
        this.password=password;
        this.birthdate=birthdate;
    }

    public Person(String email, String name, String password, String role, boolean enabled, LocalDate birthdate) {
        this.email=email;
        this.name=name;
        this.password=password;
        this.role=role;
        this.enabled=enabled;
        this.birthdate=birthdate;
    }

    @PrePersist
    void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }
    @PreUpdate
    void onUpdate() {
        this.setModified(LocalDateTime.now());
    }

    @Basic
    @Column(name="id", nullable=true, length=30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    @Basic
    @Column(name="email", nullable=true, length=50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    @Basic
    @Column(name="name", nullable=true, length=40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    @Basic
    @Column(name="password", nullable=true, length=12)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    @Basic
    @Column(name="role", nullable=true, length=5)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role=role;
    }

    @Basic
    @Column(name="enabled", nullable=true)
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled=enabled;
    }

    @Basic
    @Column(name="birthdate", nullable=true)
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate=birthdate;
    }

    @Basic
    @Column(name="created", nullable=true)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created=created;
    }

    @Basic
    @Column(name="modified", nullable=true)
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified=modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that=(Person) o;
        return Objects.equals( id, that.id ) &&
                Objects.equals( email, that.email ) &&
                Objects.equals( name, that.name ) &&
                Objects.equals( password, that.password ) &&
                Objects.equals( role, that.role ) &&
                Objects.equals( enabled, that.enabled ) &&
                Objects.equals( birthdate, that.birthdate ) &&
                Objects.equals( created, that.created ) &&
                Objects.equals( modified, that.modified );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, email, name, password, role, enabled, birthdate, created, modified );
    }

}
