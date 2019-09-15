package org.sakura.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysResult implements Serializable {

    private static final long serialVersionUID = -1843417534226987727L;
    /**状态码*/
    private int state=1;
    /**状态码对应的状态信息*/
    private String message="ok";
    /**正常数据*/
    private Object data;


    public SysResult(String message) {
        this.message=message;
    }
    public SysResult(Object data) {
        this.data=data;
    }
    /**封装异常数据*/
    public SysResult(Throwable e) {
        this.state=0;
        this.message=e.getMessage();
    }


    public static SysResult success() {

        return new SysResult(1,"服务器执行成功!!!", null);
    }
}
