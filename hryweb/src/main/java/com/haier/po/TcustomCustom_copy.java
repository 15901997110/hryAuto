package com.haier.po;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 19:08
 */
@Data
public class TcustomCustom_copy extends Tcustom {
    private String envkey;
    private List<Tservice> tserviceList;
}
