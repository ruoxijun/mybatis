package io.github.ruoxijun.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
