package com.cong.blog.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class voPage {
    private int page;
    private int limit;
    private String sort;
}
