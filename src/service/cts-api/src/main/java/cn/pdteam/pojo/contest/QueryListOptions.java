package cn.pdteam.pojo.contest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * 竞赛列表查询筛选配置项
 *
 * @param page             页码
 * @param limit            每页显示数量
 * @param search           搜索关键字
 * @param allowedToSignUp  已开始报名
 * @param contestStarted   已开始比赛
 * @param resultsAnnounced 已公布成绩
 * @param registered       已报名的
 * @param notRegistered    未报名的
 * @param user             用户名
 */
public record QueryListOptions(Integer page, Integer limit, String search,
                               Boolean allowedToSignUp, Boolean contestStarted, Boolean resultsAnnounced,
                               Boolean registered, Boolean notRegistered,
                               @NotBlank(message = "用户名不能为空") String user) implements Serializable {
}
