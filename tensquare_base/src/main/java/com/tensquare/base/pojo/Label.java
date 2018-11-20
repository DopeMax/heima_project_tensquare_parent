package com.tensquare.base.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 标签的实体类
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable {

    @Id
    private String id;
    private String labelname;
    private String state;
    private Integer count;
    private Integer fans;
    private String recommend;

   
}
