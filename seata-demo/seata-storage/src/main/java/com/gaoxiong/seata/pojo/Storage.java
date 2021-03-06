package com.gaoxiong.seata.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Version;

@Table(name = "storage_tbl")
@Data
@Entity
public class Storage implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "commodity_code")
  private String commodityCode;

  @Column(name = "count")
  private Integer count = 0;


//  @Version
  @Column(name = "version_num")
  private Integer versionNum;

  
}