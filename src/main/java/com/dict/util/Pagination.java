package com.dict.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/1/3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pagination<T extends Serializable> implements Serializable {

    private List<T> list;
    private String selectId;
    private int pageSize;
    private int totalRows;
    private int totalPages;
    private int currentPage;
}
