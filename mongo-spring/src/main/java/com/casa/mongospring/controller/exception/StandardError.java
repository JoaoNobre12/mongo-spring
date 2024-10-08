package com.casa.mongospring.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements java.io.Serializable {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
