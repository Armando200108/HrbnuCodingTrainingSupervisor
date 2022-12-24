package cn.pdteam.dao;

import cn.pdteam.pojo.problemSet.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagsMapper {
    /**
     * 查询Tags列表
     * @param page 页码
     * @param limit 每页数量
     * @param search 搜索
     * @return Tag对象列表
     */
    List<Tag> queryTagsList(Integer page, Integer limit, String search);

    /**
     * 添加tag
     * @param tag tag对象
     * @return 成功：1，失败：0
     */
    Integer addTags(Tag tag);

    /**
     * 删除tag
     * @param id tag的id
     * @return 成功：1，失败：0
     */
    Integer removeTagById(Integer id);

    /**
     * 修改tag
     * @param id tag id
     * @param tagName 新的tag名称
     * @return 成功：1，失败：0
     */
    Integer changeTag(Integer id, String tagName);
}
