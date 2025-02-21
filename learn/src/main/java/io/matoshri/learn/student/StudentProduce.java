package io.matoshri.learn.student;

import org.springframework.stereotype.Component;

@Component
public record StudentProduce(
        Integer studentId,
        String studentName,
        String studentEmail,
        String studentStd,
        String address,
    String college) {

}
