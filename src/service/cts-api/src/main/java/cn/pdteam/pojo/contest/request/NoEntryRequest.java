package cn.pdteam.pojo.contest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoEntryRequest {
    private String contestId;
    private String user;
}
