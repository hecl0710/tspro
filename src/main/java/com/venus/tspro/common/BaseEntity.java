package com.venus.tspro.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BaseEntity {
    private int pageNum = 1;
    private int pageSize = 10;
}
