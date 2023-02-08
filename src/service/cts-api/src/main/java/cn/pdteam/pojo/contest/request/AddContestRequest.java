package cn.pdteam.pojo.contest.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class AddContestRequest implements Serializable {
    /**
     * 比赛logo链接
     */
    private String logo;
    /**
     * 比赛名称
     */
    @NotBlank
    private String name;
    /**
     * 比赛简介
     */
    @NotBlank
    private String introduction;
    /**
     * 报名开始时间
     */
    @Future(message = "报名开始时间必须晚于当前时间！")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contestStartTime;
    /**
     * 比赛结束时间
     */
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contestEndTime;
    /**
     * 比赛须知
     */
    private String notice;
    /**
     * 比赛题目序号集合
     */
    private List<Integer> problems;

    public AddContestRequest(String logo, String name, String introduction, LocalDateTime registrationStartTime, LocalDateTime registrationEndTime, LocalDateTime contestStartTime, LocalDateTime contestEndTime, String notice, List<Integer> problems) {
        if(registrationEndTime.isBefore(registrationStartTime)){
            throw new IllegalArgumentException("报名结束时间必须在报名开始时间之后。");
        }
        if(contestEndTime.isBefore(contestStartTime)){
            throw new IllegalArgumentException("比赛结束时间必须在比赛开始时间之后。");
        }
        if(contestStartTime.isBefore(registrationEndTime)){
            throw new IllegalArgumentException("比赛开始时间必须在报名结束时间之后！");
        }

        this.logo = logo;
        this.name = name;
        this.introduction = introduction;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.contestStartTime = contestStartTime;
        this.contestEndTime = contestEndTime;
        this.notice = notice;
        this.problems = problems;
    }

    public AddContestRequest() {
    }

    public String getLogo() {
        return logo;
    }

    public AddContestRequest setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddContestRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public AddContestRequest setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public LocalDateTime getRegistrationStartTime() {
        if(registrationEndTime.isBefore(registrationStartTime)){
            throw new IllegalArgumentException("报名结束时间必须在报名开始时间之后。");
        }
        return registrationStartTime;
    }

    public AddContestRequest setRegistrationStartTime(LocalDateTime registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
        return this;
    }

    public LocalDateTime getRegistrationEndTime() {
        return registrationEndTime;
    }

    public AddContestRequest setRegistrationEndTime(LocalDateTime registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
        return this;
    }

    public LocalDateTime getContestStartTime() {
        return contestStartTime;
    }

    public AddContestRequest setContestStartTime(LocalDateTime contestStartTime) {
        this.contestStartTime = contestStartTime;
        return this;
    }

    public LocalDateTime getContestEndTime() {
        return contestEndTime;
    }

    public AddContestRequest setContestEndTime(LocalDateTime contestEndTime) {
        this.contestEndTime = contestEndTime;
        return this;
    }

    public String getNotice() {
        return notice;
    }

    public AddContestRequest setNotice(String notice) {
        this.notice = notice;
        return this;
    }

    public List<Integer> getProblems() {
        return problems;
    }

    public AddContestRequest setProblems(List<Integer> problems) {
        this.problems = problems;
        return this;
    }
}
