package cn.pdteam.pojo.problemSet;

import cn.pdteam.pojo.problemSet.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemInfoDetails implements Serializable {
    /**
     * 题目数据
     */
    private Problem problem;

    /**
     * 标签
     */
    private List<String> tags;
}
