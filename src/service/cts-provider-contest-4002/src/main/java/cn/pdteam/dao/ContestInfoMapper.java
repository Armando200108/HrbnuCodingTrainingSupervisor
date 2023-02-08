package cn.pdteam.dao;

import cn.pdteam.pojo.contest.QueryListOptions;
import cn.pdteam.pojo.contest.ShortContestInfo;
import cn.pdteam.pojo.contest.entity.ContestInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContestInfoMapper {
    Integer addContest(ContestInfo contestInfo);

    Integer addContestProblem(String contestId, List<Integer> problemIdList);

    Integer removeContest(String contestId);

    Integer removeContestProblems(String contestId);

    Integer updateContestInfo(ContestInfo contestInfo);

    ContestInfo queryContestInfo(String contestId);

    ShortContestInfo queryShortContestInfo(String contestId);

    List<ShortContestInfo> queryContestList(QueryListOptions options);

    Integer queryContestListCount(QueryListOptions options);

    Boolean checkContestExist(String contestId);

    List<Integer> queryContestProblems(String contestId);
}
