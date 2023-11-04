import java.sql.*;
public class example1 {
    //MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    //数据库：message  Host Address：localhost  端口：3306
    //请根据实际数据库的信息进行修改
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/message";
    // 数据库的用户名与密码
    //用户名：root  密码：123456
    //请根据实际数据库的信息进行修改
    static final String USER = "root";
    static final String PASS = "123456";
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps=null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM login";//搜索login表
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id  = rs.getInt("id");//得到“id”列的值
                String password = rs.getString("password");//得到“password”列的值
                System.out.print("ID: " + id);
                System.out.print(", 密码: " + password);
                System.out.print("\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.print("搜索完毕\n");
        //开始修改数据
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            //连接数据库
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            //实例化Statement对象
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE login SET password=? WHERE id=?";//向login表里修改数据
            //注：几个问号几个ps.setString，上面的语句中有两个?,所以下面有两个ps.setString
            ps=conn.prepareStatement(sql);//修改数据预处理
            ps.setString(1, "222222");//第1个问号的值"222222"
            ps.setString(2, "123");//第2个问号的值"1"
            ps.executeUpdate();//执行修改数据
            // 完成后关闭
            ps.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("数据修改成功");
        //修改数据结束
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM login";//搜索login表
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id  = rs.getInt("id");//得到“id”列的值
                String password = rs.getString("password");//得到“password”列的值
                System.out.print("ID: " + id);
                System.out.print(", 密码: " + password);
                System.out.print("\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.print("搜索完毕\n");
    }
}
