package com.mystudy.pd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.db.ConnectionPoolMgr;

public class PdDAO {
	private ConnectionPoolMgr pool;
	
	public PdDAO() {
		pool = new ConnectionPoolMgr();
		
	}
	
	public int insertPd(PdDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "insert into pd\n" + 
					"values(PD_SEQ.nextval,?,?,default)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			
			int n = ps.executeUpdate();
			System.out.println("상품 등록 결과 n=" + n + ", 매개변수 dto" + dto);
			
			return n;
		}finally {
			pool.dbClose(con, ps);
		}
	}
	
	public List<PdDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<PdDTO> list = new ArrayList<PdDTO>();
		try {
			//1,2
			con = pool.getConnection();
			
			String sql = "select * from pd order by no desc";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String pdName = rs.getString(2);
				int price = rs.getInt(3);
				Timestamp regdate = rs.getTimestamp(4);
				
				PdDTO dto = new PdDTO();
				dto.setNo(no);
				dto.setPdName(pdName);
				dto.setPrice(price);
				dto.setRegdate(regdate);
				list.add(dto);
			}
			System.out.println("상품 목록 결과 list.size="+list.size());
			
			return list;
		}finally {
			pool.dbClose(con, ps, rs);;
		}
	}
	
	public PdDTO selectByNo(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PdDTO dto = new PdDTO();
		try {
			con = pool.getConnection();
			
			String sql = "select * from pd where no=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String pdName = rs.getString(2);
				int price = rs.getInt(3);
				Timestamp regdate = rs.getTimestamp(4);
				
				dto.setNo(no);
				dto.setPdName(pdName);
				dto.setPrice(price);
				dto.setRegdate(regdate);
			}
			System.out.println("상세보기 결과 dto="+dto+", 매개변수 no=" + no);
			
			return dto;
		}finally {
			pool.dbClose(con, ps, rs);
		}
	}
	
	public int updatePd(PdDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = pool.getConnection();
			
			String sql = "update pd\n" + 
					"set PDNAME=?, PRICE=?\n" + 
					"where no = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			ps.setInt(3, dto.getNo());
			
			int cnt = ps.executeUpdate();
			System.out.println("수정 결과 dto=" + dto + ", cnt="+cnt);
			return cnt;
		}finally {
			pool.dbClose(con, ps);
		}
	}
	
	public int deletePd(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = pool.getConnection();
			
			String sql = "delete from pd where no=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			int cnt = ps.executeUpdate();
			System.out.println("삭제 결과 cnt="+cnt+", 매개변수 no="+no);
			return cnt;
		}finally {
			
		}
	}
}
