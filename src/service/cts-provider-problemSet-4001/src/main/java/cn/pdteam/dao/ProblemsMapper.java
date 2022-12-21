package cn.pdteam.dao;

import cn.pdteam.pojo.problemSet.ShortProblemInfo;
import cn.pdteam.pojo.problemSet.entity.Problem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProblemsMapper {
    List<ShortProblemInfo> queryNotHiddenShortProblemsInfo(Integer page, Integer limit, String search);

    List<ShortProblemInfo> queryAllShortProblemsInfo(Integer page, Integer limit, String search);

    Problem queryProblemInfoById(Integer id);

    List<String> queryTagsByProblemId(Integer problemId);

    Integer addProblem(Problem problem);

    Integer addPtBind(Integer problemId, List<Integer> tagsId);

    Integer updateProblem(Problem problem);

    Integer removeProblemById(Integer id);

    Integer removeProblemAllTags(Integer problemId);
}
