
package com.itrail.test.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;


/**
 * @author barysevich_k
 */
@ApiModel(description = "Предназначен для отображения запросов")
public class BaseResponse<T> {
    @ApiModelProperty(value = "Код сообщения", name = "code", dataType = "Integer", example = "999")
    private int code = 999;
    @ApiModelProperty(value = "Сообщение", name = "message", dataType = "String", example = "System mallfunction")
    private String message = "System mallfunction";
    
    @ApiModelProperty(value = "Ответ на запрос", name = "data", dataType = "String")
    @JsonInclude(Include.NON_NULL)
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int code,String message) {
        this.code = code;
        this.message = message;
    }
    
    public static BaseResponse success() {
        return new BaseResponse( 0, "success");
    }
    
    public static BaseResponse error( int code, Throwable e ) {
        return new BaseResponse( 0, null == e.getMessage() ?  "System mullfunction " : e.getMessage());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public <T> T getData() {
        return (T)data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.code;
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseResponse<?> other = (BaseResponse<?>) obj;
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
//        if (!Objects.equals(this.data, other.data)) {
//            return false;
//        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "BaseResponce{" + "code=" + code + ", message=" + message + ", data=" + data + '}';
    }

}
