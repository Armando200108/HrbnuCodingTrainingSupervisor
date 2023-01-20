package cn.pdteam.pojo.contest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContestInfo {
    private String id;
    /**
     * 比赛logo链接
     */
    private String logo;
    /**
     * 比赛名称
     */
    private String name;
    /**
     * 比赛简介
     */
    private String introduction;
    /**
     * 报名开始时间
     */
    private LocalDateTime registrationStartTime;
    /**
     * 报名结束时间
     */
    private LocalDateTime registrationEndTime;
    /**
     * 比赛开始时间
     */
    private LocalDateTime contestStartTime;
    /**
     * 比赛结束时间
     */
    private LocalDateTime contestEndTime;
    /**
     * 比赛须知
     */
    private String notice;
    /**
     * 创建用户
     */
    private String createUser;
}
