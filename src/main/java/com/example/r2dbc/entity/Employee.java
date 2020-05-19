package com.example.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author rishi
 */
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  @Id
  private Long id;

  private String name;

  private String department;

}
