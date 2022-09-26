
package com.itrail.test.app.model;

import io.swagger.annotations.ApiModel;
import java.util.List;

/**
 *
 * @author barysevich_k
 */
@ApiModel(description = "Список логгов")
public class LogResponse {
    private List<LogView> logView;

    public LogResponse() {
    }

    public LogResponse(List<LogView> logView) {
        this.logView = logView;
    }

    public List<LogView> getLogView() {
        return logView;
    }

    public void setLogView(List<LogView> logView) {
        this.logView = logView;
    }
    
    
}
