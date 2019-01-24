package com.dmantz.ecommerceapp.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Order {

    ArrayList<OrderItem> productArrayList = new ArrayList<>();
    //OrderItem productModelObj ;


    public void addProduct(OrderItem orderItemObj) {



       /* Iterator iteratorObj = productArrayList.iterator();

        while (iteratorObj.hasNext()) {

            OrderItem orderItem = (OrderItem) iteratorObj.next();
            if (orderItemObj.getProductId().equals(orderItem.getProductId())) {

                int i = orderItem.getProductQuantity();
                ++i;
                orderItem.setProductQuantity(i);

            }

        }
*/


        productArrayList.add(orderItemObj);
        

    }


}