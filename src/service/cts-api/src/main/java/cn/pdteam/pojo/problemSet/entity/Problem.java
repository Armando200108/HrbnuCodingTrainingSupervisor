package cn.pdteam.pojo.problemSet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Armando
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 题目名称
     */
    private String name;
    /**
     * 题目详情
     */
    private String content;
    /**
     * 困难程度(1~5)
     */
    private Integer degreeDifficulty;
    /**
     * 时间限制(ms)
     */
    private Integer timeLimit;
    /**
     * 空间限制(MB)
     */
    private Integer memoryLimit;
    /**
     * 样例数据个数
     */
    private Integer samplesCount;
    /**
     * 样例数据文件名
     */
    private String sampleFileName;
    /**
     * 测试数据个数
     */
    private Integer testsCount;
    /**
     * 测试数据文件名
     */
    private String testFileName;
    /**
     * 判题模式
     */
    private Integer judgmentMode;
    /**
     * 判官文件名
     */
    private String trainerFilename;
    /**
     * 题目上传人
     */
    private String author;
}
