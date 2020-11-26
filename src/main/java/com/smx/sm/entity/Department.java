package com.smx.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Department
 * @Description 院系实体类
 * @Author moses
 * @Date 2020/11/26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Integer id;
    private String departmentName;
    private String logo;

    @Override
    public String toString() {
        return this.departmentName;
    }
}
