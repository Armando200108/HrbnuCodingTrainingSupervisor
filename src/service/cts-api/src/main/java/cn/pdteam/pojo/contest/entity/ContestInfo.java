package cn.pdteam.pojo.contest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContestInfo implements Serializable {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Future
    private LocalDateTime registrationStartTime;
    /**
     * 报名结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Future
    private LocalDateTime registrationEndTime;
    /**
     * 比赛开始时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Future
    private LocalDateTime contestStartTime;
    /**
     * 比赛结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Future
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
