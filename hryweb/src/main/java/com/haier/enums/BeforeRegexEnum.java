package com.haier.enums;

/**
 * @Description: 入参匹配正则表达式
 * @Author: luqiwei
 * @Date: 2018/6/19 9:39
 */
public enum BeforeRegexEnum {
    /**
     * <uuid(num)> 随机唯一字符串
     * 参数:num-非必填,指定要截断的长度
     * 例:
     * <uuid>:随机生成32位唯一字符串 结果:599b255f7aaa41768108e77540d1249a
     * <uuid()>:随机生成32位唯一字符串  结果:599b255f7aaa41768108e77540d1249a
     * <uuid(5)>: 随机生成唯一字符串,但是只截取前5位   结果:599b2
     */
    UUID("(?i)<uuid\\(?\\d*\\)?>"),

    /**
     * <longdate>,当前时间戳,以1970-1-1 00:00:00 GMT标准计算出的毫秒数
     */
    LONGDATE("(?i)<longdate>"),

    /**
     * <date(num)> 生成一个日期(默认今天),格式"yyyy-MM-dd"
     * 参数:num-非必填,指定日期按天的偏移量
     * 例:
     * 假设现在是2018-08-08
     * <date()>: 生成今天的日期,结果:2018-08-08
     * <date(-1)>:生成昨天的日期,结果:2018-08-07
     * <date(10)>:生成10天后的日期,结果:2018-08-18
     */
    DATE("(?i)<date\\(-?\\d*\\)>"),

    /**
     * <datetime(num)> 生成一个datetime,格式"yyyy-MM-dd HH:mm:ss"
     * 参数:num-非必填,指定datetime按小时的偏移量
     */
    DATETIME("(?i)<datetime\\(-?\\d*\\)>"),

    /**
     * <time(num)> 生成一个时间,格式"HH:mm:ss"
     * 参数:num-非必填,指定时间按分钟的偏移量
     */
    TIME("(?i)<time\\(-?\\d*\\)>"),

    /**
     * <randomI(min,max)> 在区间[min,max)中随机生成一个整数,注意max必须大于min
     * 参数:min-非必填,指定随机范围的下限(包含)
     * 参数:max-非必填,指定随机范围的上限(不包含)
     * 例:
     * <randomI()> :不填写任何参数,将随机一个[0,100)中的整数
     * <randomI(100,999)>:随机一个整数,范围[100,999)
     */
    RANDOM_I("(?i)<randomI\\(\\d*,?\\d*\\)>"),

    /**
     * <randomF(min,max)> 在区间[min,max)中随机生成一个浮点数,生成浮点数的精度将min的精度保持一致
     * 参数:min-非必填,指定随机范围的下限(包含)
     * 参数:max-非必填,指定随机范围的上限(不包含)
     * 例:
     * <randomF()>:不填写任何参数,将从[0.01,1.00)中随机一个浮点数,结果:0.23
     * <randomF(10.123,20.456)>:将从[10.123,20.456)区间中随机一个浮点数,浮点数的精度为0.001,结果:18.236
     */
    RANDOM_F("(?i)<randomF\\((\\d+\\.\\d+)?,?(\\d+\\.\\d+)?\\)>"),

    /**
     * <sql:xxx> 执行sql并且使用执行结果替换此匹配项
     * 参数:xxx-必填,xxx中不可包含<>,符合语法规范的sql语句,
     * 例:
     * <sql:select id from table>:执行查询语句,并使用查询结果替换此处,结果:1
     * <sql:update table t set t.status=-1 where t.id=1>:执行更新语句,并使用更新返回结果替换此处,结果:1
     */
    SQL("(?i)<sql:[^<>]*>"),

    /**
     * <var(fieldName)>  使用测试类中的字段值替换此匹配项
     * 参数:fieldName-必填,fieldName必须是测试类中维护的字段名
     * 例:
     * <var(requestNo)> 将从当前测试类中,获取可访问的字段名为requestNo的字段的值,替换当前匹配项
     */
    VAR("(?i)<var\\([^<>]+\\)>"),

    /**
     * <$index(xxx)> 将请求参数中此匹配项括号中的内容赋值给<ref(index)>
     * 参数:index-必填,index必须是整数,标记引用源
     * 例:
     * <$1(abc)> 将abc赋值到所有<ref(1)>的位置,并且<$1(abc)>自动替换为abc
     */
    SOURCE("<\\$\\d+\\([^<>]*\\)>"),//匹配<$10(helloWorld)>

    /**
     * <ref(index)> 与<$index(xxx)>配合使用,引用xxx内容
     */
    REF("(?i)<ref\\(\\d+\\)>"),//匹配<ref(10)>

    ;
    private String pattern;

    BeforeRegexEnum(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
