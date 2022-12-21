package cn.pdteam.pojo.problemSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortProblemInfo implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 题目名称
     */
    private String name;
    /**
     * 难度
     */
    private Integer degreeDifficulty;
    /**
     * 接受数量
     */
    private Integer acceptedQuantity;
    /**
     * 提交数量
     */
    private Integer submissionQuantity;
    /**
     * 是否被隐藏
     */
    private Boolean hide;
    /**
     * 标签
     */
    private List<String> tagsList;
}
