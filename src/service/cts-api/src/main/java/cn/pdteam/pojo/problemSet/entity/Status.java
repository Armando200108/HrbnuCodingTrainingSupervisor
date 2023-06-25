package cn.pdteam.pojo.problemSet.entity;

import cn.pdteam.pojo.problemSet.enums.CodeLanguage;
import cn.pdteam.pojo.problemSet.enums.StatusResult;
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
    private String contestId;
    /**
     * 评测结果
     */
    private StatusResult result;
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
     */
    private CodeLanguage language;
    /**
     * 提交时间
     */
    private LocalDateTime submitDateTime;
}
