using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Data.SqlClient;
using _21DemoADO.POCO;

namespace _21DemoADO.PGDACDAL
{
    public class DAL
    {
        public event Action<string> OnSelect;
        public event Action<string> OnInsert;
        public event Action<string> OnUpdate;
        public event Action<string> OnDelete;
        public List<Emp> GetEmployees()
        {
            List<Emp> allEmps = new List<Emp>();

            #region Select Query
            
            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            SqlConnection connection =
                new SqlConnection(connectionDetails);

            connection.Open();

            SqlCommand command =
                new SqlCommand("select * from Emp", connection);

            SqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                Emp emp = new Emp();
                emp.No = Convert.ToInt32(reader["No"]);
                emp.Name = reader["Name"].ToString();
                emp.Address = reader["Address"].ToString();

                allEmps.Add(emp);
            }

            reader.Close();
            connection.Close();
            #endregion

            if (allEmps.Count> 0)
            {
                OnSelect("Select All Records Completed");
            }
            return allEmps;
        }
        public Emp GetEmployeeByID(int id)
        {
            Emp emp = null;

            List<Emp> allEmps = this.GetEmployees();

            emp = (from e in allEmps
                   where e.No == id
                   select e).First();

            return emp;
        }
        public int AddEmployee(Emp emp)
        {
            int rowsAffected = 0;

            #region Insert Query

            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            SqlConnection connection =
                new SqlConnection(connectionDetails);

            connection.Open();

            string queryTextFormat = "insert into Emp(Name, Address) values ('{0}', '{1}')";
            string queryText =
                string.Format(queryTextFormat, emp.Name, emp.Address);

            SqlCommand command =
                new SqlCommand(queryText, connection);

            rowsAffected = command.ExecuteNonQuery();

            connection.Close();

            if (rowsAffected> 0)
            {
                OnInsert("Insert Completed.");
            }

            #endregion

            return rowsAffected;
        }
        public int UpdateEmployee(Emp emp)
        {
            int rowsAffected = 0;

            #region Update Query

            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            SqlConnection connection =
                new SqlConnection(connectionDetails);

            connection.Open();

            string queryTextFormat = "update Emp set Name = '{1}', Address = '{2}' where No = {0}";
            string queryText =
                string.Format(queryTextFormat, emp.No, emp.Name,emp.Address);

            SqlCommand command =
                new SqlCommand(queryText, connection);

            rowsAffected = command.ExecuteNonQuery();
            connection.Close();

            if (rowsAffected > 0)
            {
                OnUpdate("Update Completed.");
            }
            #endregion

            return rowsAffected;
        }
        public int RemoveEmployee(int no)
        {
            int rowsAffected = 0;

            #region Delete Query

            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=PGDAC;Integrated Security=True";

            SqlConnection connection =
                new SqlConnection(connectionDetails);

            connection.Open();

            string queryTextFormat =
                    "delete from Emp where No = {0}";

            string queryText =
                string.Format(queryTextFormat, no);

            SqlCommand command =
                new SqlCommand(queryText, connection);

            rowsAffected = command.ExecuteNonQuery();
            connection.Close();

            #endregion

            if (rowsAffected > 0)
            {
                OnDelete("Delete Completed.");
            }
            return rowsAffected;
        }
    }
}
