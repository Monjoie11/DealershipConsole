package com.reavture.evaluation.dao;

import static com.revature.evaluation.utility.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.Offer.Status;

public class OfferDaoPostGres implements OfferDao {
	
	Offer offer = new Offer();

	private Connection conn = ConnectionFactory.getConnection();

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createOffer(Offer offer) {

		String sql = "insert into offer (username, status, amount, carvin) values(?, ?, ?, ?)";

	
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, offer.getUserName());
			stmt.setString(2, offer.getStatus().toString());
			stmt.setString(3, Double.toString(offer.getAmount()));
			stmt.setString(4, offer.getCarVin());
			stmt.executeUpdate();
			trace("executing insert offer");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public Offer getOffer(int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> getAllOffersPending() {
		
		List<Offer> offerList = new ArrayList<Offer>();
		
		Offer offer = new Offer();
		
		String sql = "select * from offer where status = 'PENDING'";
		 
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				offer.setUserName(rs.getString(1));
				offer.setStatus(Offer.Status.valueOf(rs.getString(2)));
				offer.setAmount(Double.parseDouble(rs.getString(3)));
				offer.setCarVin(rs.getString(4));
				offer.setOfferId(rs.getInt(5));
				trace("get pending offers while");
				offerList.add(offer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offerList;
	}
		
	
	
	@Override
	public void acceptOffer(int offerId) {
		String sql = "update offer set status = ? where offerid = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Offer.Status.ACCEPTED.toString());
			stmt.setInt(2, offerId);
			stmt.executeUpdate();
			trace("executing accept offer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void rejectCompetingOffers(String vin) {
		String sql = "update offer set status = ? where carvin = ? and status = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Offer.Status.REJECTED.toString());
			stmt.setString(2, vin);
			stmt.setString(3, Offer.Status.PENDING.toString());
			stmt.executeUpdate();
			trace("executing reject competing");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOffer(int offerId) {
		// TODO Auto-generated method stub

	}

}
