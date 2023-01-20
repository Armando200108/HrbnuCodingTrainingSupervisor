package cn.pdteam.pojo.contest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemContestBind {
    /**
     * 竞赛id
     */
    String contestId;
    /**
     * 题目id
     */
    Integer problenId;
    /**
     * 题目顺序
     */
    Integer order;
}
