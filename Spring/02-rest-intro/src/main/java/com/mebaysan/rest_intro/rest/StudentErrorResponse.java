package com.mebaysan.rest_intro.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentErrorResponse {
    int status;
    String message;
    long timestamp;
}
