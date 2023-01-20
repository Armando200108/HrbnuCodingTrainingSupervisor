package cn.pdteam.pojo.contest;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * 用于比赛列表的对象
 * @param id
 * @param logo
 * @param name
 * @param introduction
 * @param registrationStartTime
 * @param registrationEndTime
 * @param contestStartTime
 * @param contestEndTime
 * @param createUser
 */
public record ShortContestInfo(String id, String logo,String name, String introduction,
                               LocalDateTime registrationStartTime, LocalDateTime registrationEndTime,
                               LocalDateTime contestStartTime, LocalDateTime contestEndTime,
                               String createUser) {
}
