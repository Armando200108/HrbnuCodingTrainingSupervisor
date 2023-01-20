package cn.pdteam.pojo.problemSet.response;

import cn.pdteam.pojo.CommonResponse;

import java.io.Serializable;

public class RemoveProblemResponse extends CommonResponse implements Serializable {
    public RemoveProblemResponse(Integer code, Boolean success, String message) {
        super(code, success, message);
    }
}
