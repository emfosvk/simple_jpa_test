package com.example.jpa.demo;

import com.example.jpa.demo.entity.*;
import com.example.jpa.demo.entity.id.SlipID;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();


		entityTransaction.begin();

		try {
			/* [START] - 1 Week

			Member member = new Member();
			Member member2 = new Member();
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

			 //[END] - 1 Week
			 */

			//[START] - 2Week

			/*
			Player player1 = new Player();
			player1.setPlayerName("Hong Gil Dong");
			player1.setPlayerHistory("History");
			player1.setPlayerPoint(new BigDecimal(3.56));
			player1.setPlayerType(PlayerType.ATTACKER);
			Date nowDate = new Date();
			player1.setEntryDate(nowDate);
			player1.setEntryTime(nowDate);
			player1.setEntryDateTime(nowDate);

			entityManager.persist(player1);

			Player player2 = new Player();
			player2.setPlayerName("Son Heung Min");
			player2.setPlayerHistory("History  2222");
			player2.setPlayerPoint(new BigDecimal(3.56));
			player2.setPlayerType(PlayerType.ATTACKER);
			Date nowDate2 = new Date();
			player2.setEntryDate(nowDate2);
			player2.setEntryTime(nowDate2);
			player2.setEntryDateTime(nowDate2);

			LocalDateTime localDateTime2 = LocalDateTime.now();
			LocalDate localDate2= LocalDate.now();
			LocalTime localTime2 = LocalTime.now();

			player2.setQuitDate(localDate2);
			player2.setQuitTime(localTime2);
			player2.setQuitDateTime(localDateTime2);

			entityManager.persist(player2);

			entityTransaction.commit();
			*/
			//[E N D] - 2Week

			//[START] - 3Week

			/*
			Bill bill = new Bill();
			bill.setBillNo(1L);
			bill.setBillOpenDate(LocalDateTime.now());
			bill.setTotalAmt(50000L);

			entityManager.persist(bill);


			Slip slip = new Slip();
			slip.setBill(bill);
			slip.setBillSeqNo(1L);
			slip.setAmt(30000L);
			slip.setItemName("Beef Stake");

			Slip slip2 = new Slip();
			slip2.setBill(bill);
			slip2.setBillSeqNo(2L);
			slip2.setItemName("Fried Chicken");
			slip2.setAmt(20000L);

			entityManager.persist(slip);
			entityManager.persist(slip2);

			entityTransaction.commit();

			 */


			/*
			Bill selBill = entityManager.find(Bill.class, 1L);

			SlipID slipID = new SlipID();
			slipID.setBill(selBill);
			slipID.setBillSeqNo(1L);
			Slip selSlip = entityManager.find(Slip.class, slipID);
			*/

			JPAQuery<Bill> query1 = new JPAQuery<>(entityManager);
			QBill qBill = QBill.bill;

			List<Bill> billList =
					query1.from(qBill)
							.where(qBill.billNo.eq(1L))
							.fetch();

			JPAQuery<Slip> query2 = new JPAQuery<>(entityManager);
			QSlip qSlip = QSlip.slip;
			List<Slip> slipList = query2.from(qSlip)
					.where(qSlip.bill.billNo.eq(1L))
					.fetch();
			System.out.println("#################### " + String.valueOf(slipList.size()));

			//[E N D] - 3Week


		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		entityManagerFactory.close();

	}

}
