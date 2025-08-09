namespace _22DemoEF
{
    internal class Program
    {
        static void Main(string[] args)
        {
            EFDBContext context = new EFDBContext();

            #region Select 
            //var emps = context.Emps.ToList();

            //foreach (var item in emps)
            //{
            //    Console.WriteLine("{0} | {1} | {2}", item.No, item.Name, item.Address);
            //}
            #endregion

            #region Insert

            //Emp emp = new Emp() { Name = "Jatin", Address = "Mumbai" };
            //context.Emps.Add(emp);
            //context.SaveChanges();
            #endregion

            #region Update
            //Emp emp = context.Emps.Find(4);
            //emp.Name = "Lalit";
            //emp.Address = "Delhi";
            //context.SaveChanges();
            #endregion

            #region Delete

            //Emp emp = context.Emps.Find(4);
            //context.Emps.Remove(emp);
            //context.SaveChanges();

            #endregion

            #region Work with Subjects
            //foreach (var subject in context.Subjects.ToList())
            //{
            //    Console.WriteLine("{0} | {1}", subject.SubjectID, subject.SubjectName);
            //}
            #endregion

            Console.ReadLine();

        }
    }
}
