using _21DemoADO.PGDACDAL;
using _21DemoADO.POCO;
using _21DemoADO.Loggers;

namespace _21DemoADO
{
    internal class Program
    {
        static void Main(string[] args)
        {
            DAL dalObj = new DAL();
            dalObj.OnSelect += FileLogger.CurrentLogger.Log;
            dalObj.OnUpdate += FileLogger.CurrentLogger.Log;
            dalObj.OnInsert += FileLogger.CurrentLogger.Log;
            dalObj.OnDelete += FileLogger.CurrentLogger.Log;

            Console.WriteLine("0: Show All Emp,1: Search 2: Add Employee, 3: Update Employee, 4: Remove Employee");

            int choice = Convert.ToInt32(Console.ReadLine());

            switch (choice)
            {
                case 0:
                    var employees = dalObj.GetEmployees();

                    foreach (var e in employees)
                    {
                        Console.WriteLine(e.ToString());
                    }

                    break;

                case 1:
                    Console.WriteLine("Enter the no of Employee to Search For:");
                    int id = Convert.ToInt32(Console.ReadLine());

                    Emp emp = dalObj.GetEmployeeByID(id);
                    if (emp!=null)
                    {
                        Console.WriteLine(emp.ToString());
                    }
                    else
                    {
                        Console.WriteLine("No employee found!");
                    }
                    break;

                case 2:
                    Console.WriteLine("Enter Employee details add the record:");

                    Emp empToBeAdded = new Emp();
                   
                    Console.WriteLine("Enter Name");
                    empToBeAdded.Name = Console.ReadLine();

                    Console.WriteLine("Enter Address");
                    empToBeAdded.Address = Console.ReadLine();

                    int rowsAffected= dalObj.AddEmployee(empToBeAdded);

                    if (rowsAffected > 0)
                    {
                        Console.WriteLine("Record Added.");
                    }
                    else
                    {
                        Console.WriteLine("Something went wrong");
                    }
                    break;

                case 3:
                    Console.WriteLine("Enter Employee details update the record:");

                    Emp empToBeUpdated = new Emp();
                    
                    Console.WriteLine("ENter No ");
                    empToBeUpdated.No = Convert.ToInt32(Console.ReadLine());

                    Console.WriteLine("Enter Name");
                    empToBeUpdated.Name = Console.ReadLine();

                    Console.WriteLine("Enter Address");
                    empToBeUpdated.Address = Console.ReadLine();

                    int updaterowsAffected = dalObj.UpdateEmployee(empToBeUpdated);

                    if (updaterowsAffected > 0)
                    {
                        Console.WriteLine("Record Updated.");
                    }
                    else
                    {
                        Console.WriteLine("Something went wrong");
                    }
                    break;

                case 4:

                    Console.WriteLine("Enter Employee No to delete the record:");

                    Console.WriteLine("ENter No ");
                    int No = Convert.ToInt32(Console.ReadLine());

                    int deletedrowsAffected = dalObj.RemoveEmployee(No);

                    if (deletedrowsAffected > 0)
                    {
                        Console.WriteLine("Record Deleted.");
                    }
                    else
                    {
                        Console.WriteLine("Something went wrong");
                    }
                    break;

                default:
                    Console.WriteLine("Invalid Choice!");
                    break;
            }

            Console.ReadLine();

        }
    }
}
