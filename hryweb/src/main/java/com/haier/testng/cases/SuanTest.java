package com.haier.testng.cases;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/4 11:17
 */
public class SuanTest {
    private Suan suan;
    private Integer a = 10;
    private Integer b = 0;

    private Integer addExpect = 10;
    private Integer subExpect = 10;
    private Integer mulExpect = 0;
    private Integer divExpect = 0;

    @BeforeClass
    public void before() {
        this.suan = new Suan();
    }

    @Test
    public void addTest() {
        Integer add = suan.add(a, b);
        Assert.assertEquals(add, addExpect);
    }

    @Test
    public void subTest() {
        Integer sub = suan.sub(a, b);
        Assert.assertEquals(sub, subExpect);
    }

    @Test
    public void mulTest() {
        Integer mul = suan.mul(a, b);
        Assert.assertEquals(mul, mulExpect);
    }

    @Test
    public void divTest() {
        Integer div = suan.div(a, b);
        Assert.assertEquals(div, divExpect);
    }
}
