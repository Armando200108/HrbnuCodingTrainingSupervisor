package cn.pdteam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse implements Serializable {
    private Integer code;
    private Boolean success;
    private String message;
}
