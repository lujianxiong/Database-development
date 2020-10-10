package cn.daxiong.demo4;
//大数据
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import cn.daxiong.jdbcUtils.JdbcUtils;

public class Demo4 {
	public static void main(String[] args) throws Exception{
		//setMP3();
		getMP3();
	}
	
	//一、把mp3保存到数据库中
	public static void setMP3() throws Exception{
		//1、得到Connection
		Connection conn = JdbcUtils.getConnection();
		//2、给出sql模板，创建psmt
		String sql = "INSERT INTO tab_bin VALUES(?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, 1);
		psmt.setString(2,"Shots.mp3");
		//3、想将文件变成字节数组byte[]
		byte[] bytes = IOUtils.toByteArray(new FileInputStream("C:\\Users\\鲁建雄\\Desktop\\计算机学习笔记\\Shots.mp3"));
		//4、用字节数组创建SerialBlob，自动转型为Blob
		Blob blob = new SerialBlob(bytes);
		//5、设置参数
		psmt.setBlob(3,blob);
		psmt.executeUpdate();
	}
	
	
	//二、从数据库中读取mp3
	public static void getMP3() throws Exception{
		//1、创建Connection
		Connection conn = JdbcUtils.getConnection();
		//2、给出sql模板，创建psmt
		String sql = "SELECT * FROM tab_bin";
		PreparedStatement psmt = conn.prepareStatement(sql);
		//3、执行查询，得到ResultSet
		ResultSet rs = psmt.executeQuery();
		//4、获取rs中列为DATA里的数据
		if (rs.next()) {
			Blob blob = rs.getBlob("DATA");
			//把Blob变成硬盘上的文件
			//（1）通过Blob得到输入流对象
			InputStream in = blob.getBinaryStream();
			//（2）自己创建输出流对象
			OutputStream out = new FileOutputStream("C:\\Users\\鲁建雄\\Desktop\\ljx.mp3");
			//（3）把输入流对象写入到输出流中
			IOUtils.copy(in, out);
		}
	}
}
