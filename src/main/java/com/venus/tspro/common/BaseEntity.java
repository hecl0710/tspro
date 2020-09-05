package com.venus.tspro.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class BaseEntity {
    private int pageNum = 1;
    private int pageSize = 10;
}
