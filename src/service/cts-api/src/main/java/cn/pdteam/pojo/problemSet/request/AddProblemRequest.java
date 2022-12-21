package cn.pdteam.pojo.problemSet.request;

import cn.pdteam.pojo.problemSet.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProblemRequest implements Serializable {
    /**
     * 问题数据
     */
    Problem problem;
    /**
     * 标签列表
     */
    List<Integer> tagIdList;
}
