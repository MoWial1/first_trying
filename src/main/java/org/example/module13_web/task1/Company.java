package org.example.module13_web.task1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
