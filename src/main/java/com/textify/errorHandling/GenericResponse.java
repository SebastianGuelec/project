package com.textify.errorHandling;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class GenericResponse {

    private String message;

    public GenericResponse(String message){
        this.message=message;
    }
}
