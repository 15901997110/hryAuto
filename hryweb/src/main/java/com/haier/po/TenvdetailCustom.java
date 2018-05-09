package com.haier.po;

import lombok.Data;

@Data
public class TenvdetailCustom extends Tenvdetail {
    private Tservice tservice;
    private Tenv tenv;
}
