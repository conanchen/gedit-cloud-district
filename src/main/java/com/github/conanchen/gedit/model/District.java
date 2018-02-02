package com.github.conanchen.gedit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class District {
    @Id
    @Column(columnDefinition = "char(32)")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(columnDefinition = "varchar(32)")
    private String pid;
    @Column(columnDefinition = "varchar(50)")
    private String name;
    @Column(columnDefinition = "varchar(32)")
    private String citycode;
    @Column(columnDefinition = "varchar(32)")
    private String adcode;
    @Column(columnDefinition = "varchar(32)")
    private String center;
    @Column(columnDefinition = "varchar(10)")
    private String level;




}
