package cn.pdteam.pojo.problemSet.request;

import cn.pdteam.pojo.problemSet.enums.CodeLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitCodeRequest {
    private String id;
    private String code;
    private CodeLanguage language;
    private Integer problemId;
    private String contestId;
    private String userId;
}
