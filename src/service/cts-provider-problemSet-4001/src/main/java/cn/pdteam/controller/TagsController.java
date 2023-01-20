package cn.pdteam.controller;

import cn.pdteam.dao.TagsMapper;
import cn.pdteam.pojo.CommonResult;
import cn.pdteam.pojo.problemSet.entity.Tag;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    TagsMapper tagsMapper;

    @GetMapping("/query")
    public CommonResult<List<Tag>> queryTagList(@RequestParam Map<String, Object> param) {
        int page = 1;
        int limit = 10;
        String search = null;
        if (!StringUtils.isEmpty((String) param.get("page"))) {
            page = Integer.parseInt((String) param.get("page"));
        }
        if (!StringUtils.isEmpty((String) param.get("limit"))) {
            limit = Integer.parseInt((String) param.get("limit"));
        }
        if (!StringUtils.isEmpty((String) param.get("search"))) {
            search = (String) param.get("search");
        }
        return new CommonResult<>(200, "success", tagsMapper.queryTagsList(page, limit, search));
    }

    @PostMapping("/add")
    public CommonResult<Tag> addTag(@RequestParam(value = "name") String name) {
        Tag tag = new Tag(0, name);
        tagsMapper.addTags(tag);
        return new CommonResult<>(200, "success", tag);
    }

    @PutMapping("/update")
    public CommonResult<Tag> updateTag(@RequestBody Tag tag) {
        tagsMapper.changeTag(tag.getId(), tag.getName());
        return new CommonResult<>(200, "success", tag);
    }

    @DeleteMapping("/remove/{id}")
    public CommonResult removeTag(@PathVariable("id") Integer id) {
        if (tagsMapper.removeTagById(id) == 0) {
            throw new IllegalArgumentException("No corresponding tag data found");
        }
        return new CommonResult(200, "success");
    }

}
