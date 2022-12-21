package cn.pdteam.pojo.problemSet.response;

import cn.pdteam.pojo.Response;

import java.io.Serializable;

public class RemoveProblemResponse extends Response implements Serializable {
    public RemoveProblemResponse(Boolean success) {
        super(success);
    }
}
