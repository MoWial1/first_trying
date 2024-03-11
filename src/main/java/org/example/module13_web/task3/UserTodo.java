package org.example.module13_web.task3;

import lombok.*;
import org.example.module13_web.task1.User;

@Data
@ToString
@NoArgsConstructor
public class UserTodo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}

//"userId": 1,
//        "id": 1,
//        "title": "delectus aut autem",
//        "completed": false
