package io.matoshri.learn.student;

import java.io.Serializable;

public record StudentProduce(
        Integer studentId,
        String studentName,
        String studentEmail,
        String studentStd,
        String address,
    String college) implements Serializable {}
