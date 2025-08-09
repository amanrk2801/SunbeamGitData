using Microsoft.Data.SqlClient;

namespace _20DemoADO
{
    internal class Program
    {
        static void Main(string[] args)
        {

            #region Select Query
            ////string connectionDetails = "server=(LocalDB)\\MSSQLLocalDB;database=PGDAC;Integrated Security=true";

            //string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            //SqlConnection connection = 
            //    new SqlConnection(connectionDetails);

            //connection.Open();

            //SqlCommand command = 
            //    new SqlCommand("select * from Emp", connection);

            //SqlDataReader reader = command.ExecuteReader();

            //while (reader.Read())
            //{
            //    int no = Convert.ToInt32(reader["No"]);
            //    string name = reader["Name"].ToString();
            //    string address = reader["Address"].ToString();

            //    Console.WriteLine("{0} | {1} | {2}", no,name,address);

            //}

            //reader.Close();
            //connection.Close(); 
            #endregion

            #region Insert Query

            //string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            //SqlConnection connection =
            //    new SqlConnection(connectionDetails);

            //connection.Open();

            //Console.WriteLine("Enter Name");
            //string name = Console.ReadLine();

            //Console.WriteLine("Enter Address");
            //string address = Console.ReadLine();

            //string queryTextFormat = "insert into Emp(Name, Address) values ('{0}', '{1}')";
            //string queryText = 
            //    string.Format(queryTextFormat, name, address);

            //SqlCommand command =
            //    new SqlCommand(queryText, connection);

            //int rowsAffected = command.ExecuteNonQuery();

            //Console.WriteLine("No of rows affected = {0}", rowsAffected);

            //connection.Close();

            #endregion

            #region Update Query

            //string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            //SqlConnection connection =
            //    new SqlConnection(connectionDetails);

            //connection.Open();

            //Console.WriteLine("Enter No of the Emp To Update");
            //int no = Convert.ToInt32(Console.ReadLine());

            //Console.WriteLine("Enter New Name");
            //string name = Console.ReadLine();

            //Console.WriteLine("Enter New Address");
            //string address = Console.ReadLine();

            //string queryTextFormat = "update Emp set Name = '{1}', Address = '{2}' where No = {0}";
            //string queryText =
            //    string.Format(queryTextFormat, no,name, address);

            //SqlCommand command =
            //    new SqlCommand(queryText, connection);

            //int rowsAffected = command.ExecuteNonQuery();

            //Console.WriteLine("No of rows affected = {0}", rowsAffected);

            //connection.Close();

            #endregion

            #region Delete Query

            //string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            //SqlConnection connection =
            //    new SqlConnection(connectionDetails);

            //connection.Open();

            //Console.WriteLine("Enter No of the Emp To Delete");
            //int no = Convert.ToInt32(Console.ReadLine());

            //string queryTextFormat = "delete from Emp where No = {0}";
            //string queryText =
            //    string.Format(queryTextFormat, no);

            //SqlCommand command =
            //    new SqlCommand(queryText, connection);

            //int rowsAffected = command.ExecuteNonQuery();

            //Console.WriteLine("No of rows affected = {0}", rowsAffected);

            //connection.Close();

            #endregion

            #region Call Stored Procedure

            //string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            //SqlConnection connection =
            //    new SqlConnection(connectionDetails);

            //connection.Open();

            //Console.WriteLine("Enter Name");
            //string name = Console.ReadLine();

            //Console.WriteLine("Enter Address");
            //string address = Console.ReadLine();

            //string queryText = "SPInsert";

            //SqlCommand command =
            //    new SqlCommand(queryText, connection);

            //command.CommandType = System.Data.CommandType.StoredProcedure;

            //SqlParameter paramater1 = new SqlParameter("@name", System.Data.SqlDbType.VarChar, 50);
            //paramater1.Value = name;

            //SqlParameter paramater2 = new SqlParameter("@address", System.Data.SqlDbType.VarChar, 50);
            //paramater2.Value = address;

            //command.Parameters.Add(paramater1);
            //command.Parameters.Add(paramater2);

            //command.ExecuteNonQuery();

            //connection.Close();


            #endregion

            Console.ReadLine();
        }
    }
}
