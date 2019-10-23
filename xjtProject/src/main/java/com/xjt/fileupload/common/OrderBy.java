package com.xjt.fileupload.common;

/**
 * @Author liuwei
 * @Date Create in 18/5/11 9:00
 * @Description SQL排序对象
 */
public class OrderBy {

    //排序依据字段
    private final String[] fields;
    //排序类型
    private final Order[] orders;

    private OrderBy(String[] fields, Order[] orders) {
        this.fields = fields;
        this.orders = orders;
    }

    public static OrderBy createOrderBy(String[] fields, Order order) {
        Order[] orders = new Order[fields.length];
        for (int i = 0; i < fields.length; i ++) {
            orders[i] = order;
        }
        return createOrderBy(fields, orders);
    }

    public static OrderBy createOrderBy(String[] fields, Order[] orders) {
        return new OrderBy(fields, orders);
    }

    public boolean isValid() {
        return fields.length > 0
                && (fields.length == orders.length);
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "";
        }
        StringBuilder orderBySql = new StringBuilder(" order by");
        for (int i = 0; i < fields.length; i++) {
            orderBySql.append(" " + fields[i] + " " + orders[i].getOrder() + ",");
        }

        orderBySql.delete(orderBySql.length() - 1, orderBySql.length());
        return orderBySql.toString();
    }

    public enum Order {

        //升序
        ASC("asc"),
        //降序
        DESC("desc");

        private final String order;

        Order(String order) {
            this.order = order;
        }

        public String getOrder() {
            return order;
        }
    }
}
