package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.ObjectList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Query {
    public static boolean anyMatchOrder(ObjectList.PurchaseOrder order, String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                order.order_id.toLowerCase(),
                order.request_id.toLowerCase(),
                order.item_id.toLowerCase(),
                order.user_id.toLowerCase(),
                order.username.toLowerCase(),
                Integer.toString(order.quantity),
                Double.toString(order.unit_price),
                Double.toString(order.amount),
                order.supplier_id.toLowerCase(),
                order.order_date.toString().toLowerCase(),
                order.order_status.toLowerCase(),
                order.item_name.toLowerCase(),
                order.supplier_name.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
}
