package cn.pdteam.pojo.contest;

import cn.pdteam.pojo.contest.entity.ContestInfo;
import cn.pdteam.pojo.problemSet.ShortProblemInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContestInfoDetails implements Serializable {
    private ContestInfo contestInfo;

    private List<ShortProblemInfo> problemInfoList;

}
