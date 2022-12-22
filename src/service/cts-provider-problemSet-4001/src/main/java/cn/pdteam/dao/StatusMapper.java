package cn.pdteam.dao;

import cn.pdteam.pojo.problemSet.entity.Status;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * status dao
 *
 * @author Armando
 * @version 1.0
 */
@Mapper
public interface StatusMapper {
    /**
     * 通过id查询status
     *
     * @param id status的Id
     * @return status对象
     */
    Status queryStatusById(Integer id);

    /**
     * 查询status
     *
     * @param page     页码
     * @param limit    每页限制数量
     * @param username 用户名
     * @return status集合
     */
    List<Status> queryStatus(Integer page, Integer limit, String username);

    /**
     * 根据contest id查询status
     *
     * @param page      页码
     * @param limit     每页限制数量
     * @param username  用户名
     * @param contestId 竞赛id
     * @return status集合
     */
    List<Status> queryStatusByContestId(Integer page, Integer limit, String username, Integer contestId);

    /**
     * 增加status
     *
     * @param status status对象
     * @return 成功：1，失败：0
     */
    Integer addStatus(Status status);

    /**
     * 更新status
     *
     * @param status status对象
     * @return 成功：1，失败：0
     */
    Integer updateStatus(Status status);
}
