package com.itrail.test.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.app.core.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

/**
 *
 * @author barysevich_k
 */
@ApiModel(description = "Предназначен для отображения времени на сервере")
public class ServerTime {

    @ApiModelProperty(value = "Код", name = "code")
    private int code = 0;
    
    @ApiModelProperty(value = " Время и дата на серевере ", name = "time")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time;

    public ServerTime() {
        time = LocalDateTime.now();
    }

    public ServerTime(LocalDateTime time) {
        this.time = time;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ServerTime{" + "code=" + code + ", time=" + time + '}';
    }
}
