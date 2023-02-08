package cn.pdteam.pojo.contest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelSignUpContest2UserRequest implements Serializable {
    private String contestId;
    private String user;
}
