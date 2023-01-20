package cn.pdteam.pojo.contest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInfo {
    private Integer id;
    /**
     * 竞赛id
     */
    private String contestId;
    /**
     * 报名者用户名
     */
    private String user;
}
