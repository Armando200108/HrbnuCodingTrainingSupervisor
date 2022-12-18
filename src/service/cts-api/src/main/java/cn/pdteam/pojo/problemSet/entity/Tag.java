package cn.pdteam.pojo.problemSet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 标签名
     */
    private String name;
}
