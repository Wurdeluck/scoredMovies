package com.example.spring_course.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
public class Authority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "role")
  private String role;

  @ManyToMany
  @JoinTable(
          name = "user_authorities",
          joinColumns = @JoinColumn(name = "authority_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> users;

  public Authority() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String authority) {
    this.role = authority;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
