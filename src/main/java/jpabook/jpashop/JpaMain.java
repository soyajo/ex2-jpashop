package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

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


//            Address address = new Address("city", "street", "zipcode");
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address newAddress = new Address(address.getCity(),address.getStreet(), address.getZipcode());
//            member.setHomeAddress(newAddress);

            Member member = new Member();
            member.setName("member1");
            member.setAddress(new Address("homeCity", "street", "zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressesHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressesHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("========== START ===========");
            Member findMember = em.find(Member.class, member.getId());

//            List<AddressEntity> addressesHistory = findMember.getAddressesHistory();
//            for (AddressEntity address : addressesHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // homeCity -> newCity
            Address a = findMember.getAddress();
            findMember.setAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
            System.out.println("findMember.getHomeAddress = " + findMember.getAddress().getCity());

            // 치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");
            System.out.println("findMember = " + findMember.getFavoriteFoods());



//            findMember.getAddressesHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressesHistory().add(new Address("new1", "street", "10000"));
//            System.out.println("findMember.getAddressesHistory() = " + findMember.getAddressesHistory());



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
