package cn.pdteam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(200, "成功！", data);
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<>(200, "成功！");
    }
}
