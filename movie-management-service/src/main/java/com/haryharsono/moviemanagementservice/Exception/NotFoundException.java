

package com.haryharsono.moviemanagementservice.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * NotFoundException
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException{

    public  NotFoundException(String message) {
        // TODO Auto-generated method stub
         super(message);
    }


    
}
