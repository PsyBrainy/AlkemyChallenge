package com.psybrainy.alkemychallenge;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityExeption extends EntityNotFoundException {

}
