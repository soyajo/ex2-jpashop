package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

//            Order order = new Order();
//            order.addOrderItem(new OrderItem());
//            em.persist(order);

//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);


            // 관계형 디비에 맞춘 설계
//            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();
//            Member member = em.find(Member.class, memberId);
//            Member findMember = order.getMember();


//            Member member = new Member();
//            member.setName("hello");
//            member.setHomeAddress(new Address("ctiy", "street", "zipcode"));
//            member.setWorkPeriod(new Period());
//            em.persist(member);


            Address address = new Address("city", "street", "zipcode");

            Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address newAddress = new Address(address.getCity(),address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);


            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
