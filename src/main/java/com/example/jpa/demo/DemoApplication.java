package com.example.jpa.demo;

import com.example.jpa.demo.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();


		entityTransaction.begin();

		try {

			Member member = new Member();
			member.setMemberId(1L);
			member.setMemberName("산하멤버");

			Member fMember = entityManager.find(Member.class, 1L);
			System.out.println("check Point 1");
			System.out.println(fMember);

			entityManager.persist(member);

			Member fMember2 = entityManager.find(Member.class, 1L);
			System.out.println("check Point 2");
			System.out.println(fMember2);

			System.out.println("check Point 3");
			System.out.println((member == fMember2));

			Thread.sleep(5 * 1000);

			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		entityManagerFactory.close();

	}

}
