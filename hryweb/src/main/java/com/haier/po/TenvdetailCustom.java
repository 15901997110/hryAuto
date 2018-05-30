package com.haier.po;

import lombok.Data;

@Data
public class TenvdetailCustom extends Tenvdetail {
    private String servicekey;
    private String servicename;
    private String envkey;
    private String envremark;
}
