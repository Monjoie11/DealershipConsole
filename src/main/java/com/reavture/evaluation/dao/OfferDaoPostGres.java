package com.reavture.evaluation.dao;

import static com.revature.evaluation.utility.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Offer.Status;

public class OfferDaoPostGres implements OfferDao {
	
	Offer offer = new Offer();

	private Connection conn = ConnectionFactory.getConnection();

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createOffer(Offer offer) {

		String sql = "insert into off (username, status, amount, carvin, offerid) " + "values(?, ?, ?, ?, ?)";

	
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, offer.getUserName());
			trace("set name");
			stmt.setString(2, offer.getStatus().toString());
			trace("set status");
			stmt.setString(3, Double.toString(offer.getAmount()));
			trace("set amount");
			stmt.setString(4, offer.getCarVin());
			trace("set vin");
			stmt.setInt(5, offer.getOfferId());
			trace("set offferid" + offer.toString());
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
	public List<Offer> getAllOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptOffer(int offerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOffer(int offerId) {
		// TODO Auto-generated method stub

	}

}
