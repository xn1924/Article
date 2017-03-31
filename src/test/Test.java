package test;

import util.DataBaseUtils;
import util.TableUtils;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import bean.User;

public class Test {
	public static void main(String[] args){
//		String sql = TableUtils.getCreateTableSQl(User.class);
//		System.out.println(sql);
		
//		Connection conn = DataBaseUtils.getConnection();
//		System.out.println(conn);
		
		String id = UUID.randomUUID() + "";
		String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		DataBaseUtils.update("INSERT INTO t_user(id,username,password,sex,create_time,is_delete,address,telephone) "
		        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", id,"张三",123456,0,createTime,0,"保密","保密");
	}
}
