package cn.pdteam.pojo.problemSet.enums;

public enum StatusResult {
    PENDING("PENDING", "等待"),
    JUDGING("JUDGING", "判题中"),
    ACCEPTED("ACCEPTED", "通过"),
    WRONG_ANSWER("WRONG_ANSWER", "答案错误"),
    PRESENTATION_ERROR("PRESENTATION_ERROR", "格式错误"),
    TIME_LIMIT_EXCEEDED("TIME_LIMIT_EXCEEDED", "超时"),
    MEMORY_LIMIT_EXCEEDED("MEMORY_LIMIT_EXCEEDED", "内存超限"),
    OUTPUT_LIMIT_EXCEEDED("OUTPUT_LIMIT_EXCEEDED", "输出超限"),
    RUNTIME_ERROR("RUNTIME_ERROR", "运行错误"),
    COMPILE_ERROR("COMPILE_ERROR", "编译错误"),
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),
    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知错误");
    private String status;
    private String statusNameZh;

    StatusResult(String status, String statusNameZh) {
        this.status = status;
        this.statusNameZh = statusNameZh;
    }
}
