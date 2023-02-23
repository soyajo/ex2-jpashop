package jpabook.jpashop;

import jpabook.jpashop.domain.Address;

public class ValueMain {
    public static void main(String[] args) {

        Address address1 = new Address("city", "street", "100000");
        Address address2 = new Address("city", "street", "100000");

        System.out.println("address1 == address2 : " + (address1 == address2));
        System.out.println("address1 equals address2 : " + (address1.equals(address2)));

    }
}
