package cn.pdteam.pojo.problemSet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 提交用户名
     */
    private String username;
    /**
     * 题目id
     */
    private Integer problemId;
    /**
     * 比赛id
     */
    private Integer contestId;
    /**
     * 评测结果
     * 1: accept
     * 2: wrong answer
     * 3: time limit exceeded
     * 4: memory limit exceeded
     * 5: runtime error
     * 6: Judge's Unknown Exception
     * 7: Judging
     */
    private Integer result;
    /**
     * 运行时间(ms)
     */
    private Integer time;
    /**
     * 运行空间(KB)
     */
    private Integer memory;
    /**
     * 代码长度
     */
    private Integer length;
    /**
     * 运行语言
     * 1: java 11
     * 2: c++ 11
     */
    private Integer language;
    /**
     * 提交时间
     */
    private LocalDateTime submitDateTime;
}
